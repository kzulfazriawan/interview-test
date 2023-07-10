package com.kzulfazriawan.tests.services;

import com.kzulfazriawan.tests.dtos.InetnumDto;
import com.kzulfazriawan.tests.entities.Inetnum;

import java.util.List;

public interface InetnumServiceInterface {
    /**
     * insert into object repository
     *
     * @param inetnumDto Data Transfer Object
     * @return Object entity
     */
    void insert(InetnumDto inetnumDto);

    /**
     * filter by parameter name
     *
     * @param name String parameter
     * @return Object entity
     */
    List<Inetnum> getByNetName(String name);

    /**
     * filter by parameter inetnum
     *
     * @param inetNum String parameter
     * @return Object entity
     */
    List<Inetnum> getByInetNum(String inetNum);

    /**
     * filter by id
     *
     * @param id Primary key
     * @return Object entity
     */
    Inetnum getById(Long id);

    /**
     * get by parameter only one value
     *
     * @param inetNum String parameter
     * @return Object entity
     */
    Inetnum getOneByInetNum(String inetNum);

    List<Inetnum> getStartWithByInetNum(String inetNum);

    /**
     * alter object filtered by id
     *
     * @param id         Primary key
     * @param inetnumDto Data Transfer Object
     * @return Object entity
     */
    void alter(Long id, InetnumDto inetnumDto);

    /**
     * show all DTO
     *
     * @return List Data Transfer Object
     */
    List<InetnumDto> all(List<Inetnum> inetnumList);

}
