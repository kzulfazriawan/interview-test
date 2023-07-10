package com.kzulfazriawan.tests.services;

import com.kzulfazriawan.tests.dtos.InetnumDto;
import com.kzulfazriawan.tests.entities.Inetnum;
import com.kzulfazriawan.tests.repositories.InetnumRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InetnumService implements InetnumServiceInterface {
    private final InetnumRepositoryInterface inetnumRepositoryInterface;

    public InetnumService(InetnumRepositoryInterface inetnumRepositoryInterface) {
        this.inetnumRepositoryInterface = inetnumRepositoryInterface;
    }

    /**
     * insert into object repository
     *
     * @param inetnumDto Data Transfer Object
     * @return Object entity
     */
    @Override
    public void insert(InetnumDto inetnumDto) {
        Inetnum inetnum = new Inetnum();
        inetnum.setNetName(inetnumDto.getNetName());
        inetnum.setInetNum(inetnumDto.getInetNum());
        inetnum.setDescription(inetnumDto.getDescription());

        inetnumRepositoryInterface.save(inetnum);
    }

    /**
     * filter by parameter name
     *
     * @param name String parameter
     * @return Object entity
     */
    @Override
    public List<Inetnum> getByNetName(String name) {
        return inetnumRepositoryInterface.findByNetName(name);
    }

    /**
     * filter by parameter inetnum
     *
     * @param inetNum String parameter
     * @return Object entity
     */
    @Override
    public List<Inetnum> getByInetNum(String inetNum) {
        return inetnumRepositoryInterface.findByInetNum(inetNum);
    }

    /**
     * filter by id
     *
     * @param id Primary key
     * @return Object entity
     */
    @Override
    public Inetnum getById(Long id) {
        return inetnumRepositoryInterface.findById(id).get();
    }

    /**
     * get by parameter only one value
     *
     * @param inetNum String parameter
     * @return Object entity
     */
    @Override
    public Inetnum getOneByInetNum(String inetNum) {
        if(inetnumRepositoryInterface.existsByInetNum(inetNum))
            return inetnumRepositoryInterface.findOneByInetNum(inetNum);
        return null;
    }

    /**
     * @param inetNum
     * @return
     */
    @Override
    public List<Inetnum> getStartWithByInetNum(String inetNum) {
        return inetnumRepositoryInterface.findByInetNumStartingWith(inetNum);
    }

    /**
     * alter object filtered by id
     *
     * @param id         Primary key
     * @param inetnumDto Data Transfer Object
     * @return Object entity
     */
    @Override
    public void alter(Long id, InetnumDto inetnumDto) {
        Inetnum inetnum = getById(id);
        inetnum.setNetName(inetnumDto.getNetName());
        inetnum.setInetNum(inetnumDto.getInetNum());
        inetnum.setDescription(inetnumDto.getDescription());

        inetnumRepositoryInterface.save(inetnum);
    }

    /**
     * show all DTO
     *
     * @return List Data Transfer Object
     */
    @Override
    public List<InetnumDto> all(List<Inetnum> inetnumList) {
        return inetnumList.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    /**
     * converting entity data to data object
     *
     * @param inetnum: user entities data
     * @return user data object
     */
    private InetnumDto convertEntityToDto(Inetnum inetnum) {
        InetnumDto inetnumDto = new InetnumDto();
        inetnumDto.setNetName(inetnum.getNetName());
        inetnumDto.setDescription(inetnum.getDescription());
        inetnumDto.setInetNum(inetnum.getInetNum());
        inetnumDto.setId(inetnum.getId());

        return inetnumDto;
    }

}
