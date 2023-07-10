package com.kzulfazriawan.tests.components;

import com.kzulfazriawan.tests.dtos.InetnumDto;
import com.kzulfazriawan.tests.entities.Inetnum;
import com.kzulfazriawan.tests.services.InetnumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.GZIPInputStream;

@Component
public class SchedulerJobs {
    @Autowired
    private InetnumService inetnumService;
    private final String filename = "apnic.db.inetnum.gz";
    private final String target = "https://github.com/kzulfazriawan/assets-writing/raw/master/";

    private final SimpleDateFormat simpleDateFormat;

    private final List<String> listOfString;

    public SchedulerJobs() {
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        listOfString = new ArrayList<>();
        listOfString.add("inetnum");
        listOfString.add("netname");
        listOfString.add("descr");
        listOfString.add("country");
        listOfString.add("status");

    }


    @Scheduled(cron = "0 */3 * * * ?")
    public void ingestJob() {
        String now = simpleDateFormat.format(new Date());
        System.out.println("Java cron job expression:: " + now);

//        try {
//            //downloadFile(target, filename);
//            //deCompressFile("./downloaded/" + filename, "./downloaded/apnic.db.inetnum");
//            fileRead();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    private void downloadFile(String targetUrl, String targetFile) throws IOException {
        String start = simpleDateFormat.format(new Date());
        System.out.println("Java download start:: " + start);
        URL url = new URL(targetUrl + targetFile);
        InputStream inputStream = url.openStream();
        Files.copy(inputStream, Paths.get("./downloaded/" + targetFile));
        String finish = simpleDateFormat.format(new Date());
        System.out.println("Java download finished:: " + finish);
    }

    private void deCompressFile(String archiveFile, String targetFile) throws IOException {
        String start = simpleDateFormat.format(new Date());
        System.out.println("Java decompress start:: " + start);
        FileInputStream fileInputStream = new FileInputStream(archiveFile);
        GZIPInputStream gzipInputStream = new GZIPInputStream(fileInputStream);
        FileOutputStream fileOutputStream = new FileOutputStream(targetFile);
        byte[] buffer = new byte[1024];
        int len;
        while ((len = gzipInputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, len);
        }
        fileOutputStream.close();
        gzipInputStream.close();
        String finish = simpleDateFormat.format(new Date());
        System.out.println("Java decompress finish:: " + finish);
    }

    private void fileRead() throws IOException {
        String start = simpleDateFormat.format(new Date());
        System.out.println("Java reading file start:: " + start);
        BufferedReader reader = new BufferedReader(new FileReader("./downloaded/apnic.db.inetnum"));
        String line = reader.readLine();
        InetnumDto inetnumDto = new InetnumDto();
        int data = 0;

        while (line != null) {
            if (line.length() > 0) {
                if (line.charAt(0) != '#') {
                    String[] lists = line.split(":", -1);
                    if (listOfString.contains(lists[0])) {
                        String values = lists[1].trim();

                        switch (lists[0]) {
                            case "inetnum":
                                inetnumDto.setInetNum(values);
                                break;
                            case "netname":
                                inetnumDto.setNetName(values);
                                break;
                            case "descr":
                                inetnumDto.setDescription((inetnumDto.getDescription() != null) ? inetnumDto.getDescription() + values : values);
                                break;
                        }
                    }
                }
            } else {
                if (inetnumDto.getInetNum() != null && inetnumDto.getInetNum().length() > 1) {
                    Inetnum inetNumData = inetnumService.getOneByInetNum(inetnumDto.getInetNum());
                    if(inetNumData != null){
                        inetnumService.alter(inetNumData.getId(), inetnumDto);
                    } else {
                        inetnumService.insert(inetnumDto);
                    }
                    inetnumDto = new InetnumDto();
                    data++;
                }
            }
            line = reader.readLine();
        }

        reader.close();
        String finish = simpleDateFormat.format(new Date());
        System.out.println("Java reading file finish:: " + finish + " with:: " + data + " data");
    }
}
