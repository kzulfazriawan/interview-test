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
    Inetnum insert(InetnumDto inetnumDto);

    /**
     * filter by parameter name
     *
     * @param name String parameter
     * @return Object entity
     */
    List<Inetnum> getByNetName(String name);

    /**
     * filter by parameter country
     *
     * @param country String parameter
     * @return Object entity
     */
    List<Inetnum> getByNetCountry(String country);

    /**
     * filter by parameter inetnum
     *
     * @param inetnum String parameter
     * @return Object entity
     */
    List<Inetnum> getByInetNum(String inetnum);

    /**
     * filter by id
     *
     * @param id Primary key
     * @return Object entity
     */
    Inetnum getById(Long id);

    /**
     * alter object filtered by id
     *
     * @param id Primary key
     * @param inetnumDto Data Transfer Object
     * @return Object entity
     */
    Inetnum alter(Long id, InetnumDto inetnumDto);

    /**
     * show all DTO
     *
     * @return List Data Transfer Object
     */
    List<InetnumDto> all(List<Inetnum> inetnumList);

}
