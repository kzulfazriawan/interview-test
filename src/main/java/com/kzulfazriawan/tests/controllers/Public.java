package com.kzulfazriawan.tests.controllers;

import com.kzulfazriawan.tests.dtos.InetnumDto;
import com.kzulfazriawan.tests.entities.Inetnum;
import com.kzulfazriawan.tests.services.InetnumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Public {
    @Autowired
    private final InetnumService inetnumService;

    public Public(InetnumService inetnumService) {
        this.inetnumService = inetnumService;
    }

    /**
     * index customize homepage API Controller
     *
     * @return string welcome
     */
    @GetMapping("/")
    public String index() {
        return "Welcome!";
    }

    @GetMapping("/whois")
    public String whoIs() {
        return "Who is example usage /whois/?inetnum_value";
    }

    @GetMapping("/whois/{inetnum}")
    public ResponseEntity<List<InetnumDto>> whoIsInetNum(@PathVariable String inetnum) {
        return ResponseEntity.status(HttpStatus.OK).body(inetnumService.all(inetnumService.getByInetNum(inetnum)));
    }
}