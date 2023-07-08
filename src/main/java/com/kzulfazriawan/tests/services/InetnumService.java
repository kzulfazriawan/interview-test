package com.kzulfazriawan.tests.services;

import com.kzulfazriawan.tests.dtos.InetnumDto;
import com.kzulfazriawan.tests.entities.Inetnum;
import com.kzulfazriawan.tests.repositories.InetnumRepositoryInterface;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class InetnumService implements InetnumServiceInterface{
    private final InetnumRepositoryInterface inetnumRepositoryInterface;

    private final EntityManager entityManager;

    public InetnumService(InetnumRepositoryInterface inetnumRepositoryInterface, EntityManager entityManager) {
        this.inetnumRepositoryInterface = inetnumRepositoryInterface;
        this.entityManager = entityManager;
    }

    /**
     * insert into object repository
     *
     * @param inetnumDto Data Transfer Object
     * @return Object entity
     */
    @Override
    public Inetnum insert(InetnumDto inetnumDto) {
        Inetnum inetnum = new Inetnum();
        inetnum.setNetName(inetnumDto.getNetName());
        inetnum.setInetNum(inetnumDto.getInetNum());
        inetnum.setCountry(inetnumDto.getCountry());
        inetnum.setDescription(inetnumDto.getDescription());
        inetnum.setStatus(inetnumDto.getStatus());
        inetnum.setLastModified(inetnumDto.getLastModified());

        inetnumRepositoryInterface.save(inetnum);
        entityManager.refresh(inetnum);
        return inetnum;
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
     * filter by parameter country
     *
     * @param country String parameter
     * @return Object entity
     */
    @Override
    public List<Inetnum> getByNetCountry(String country) {
        return inetnumRepositoryInterface.findByCountry(country);
    }

    /**
     * filter by parameter inetnum
     *
     * @param inetnum String parameter
     * @return Object entity
     */
    @Override
    public List<Inetnum> getByInetNum(String inetnum) {
        return inetnumRepositoryInterface.findByInetnum(inetnum);
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
     * alter object filtered by id
     *
     * @param id         Primary key
     * @param inetnumDto Data Transfer Object
     * @return Object entity
     */
    @Override
    public Inetnum alter(Long id, InetnumDto inetnumDto) {
        Inetnum inetnum = getById(id);
        inetnum.setNetName(inetnumDto.getNetName());
        inetnum.setInetNum(inetnumDto.getInetNum());
        inetnum.setCountry(inetnumDto.getCountry());
        inetnum.setDescription(inetnumDto.getDescription());
        inetnum.setStatus(inetnumDto.getStatus());
        inetnum.setLastModified(inetnumDto.getLastModified());

        inetnumRepositoryInterface.save(inetnum);
        entityManager.refresh(inetnum);
        return inetnum;
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
    private InetnumDto convertEntityToDto(Inetnum inetnum){
        InetnumDto inetnumDto = new InetnumDto();
        inetnumDto.setNetName(inetnum.getNetName());
        inetnumDto.setStatus(inetnumDto.getStatus());
        inetnumDto.setDescription(inetnumDto.getDescription());
        inetnumDto.setInetNum(inetnumDto.getInetNum());
        inetnumDto.setLastModified(inetnum.getLastModified());

        return inetnumDto;
    }
    
}
