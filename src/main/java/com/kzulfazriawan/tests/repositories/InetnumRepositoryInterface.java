package com.kzulfazriawan.tests.repositories;

import com.kzulfazriawan.tests.entities.Inetnum;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface InetnumRepositoryInterface extends JpaRepository<Inetnum, Long> {

    /**
     * find by inetnum
     *
     * @param inetnum String parameter
     * @return Object entity
     */
    List<Inetnum> findByInetnum(String inetnum);

    /**
     * find by name
     *
     * @param netName String parameter
     * @return Object entity
     */
    List<Inetnum> findByNetName(String netName);


    /**
     * find by country
     *
     * @param country String parameter
     * @return Object entity
     */
    List<Inetnum> findByCountry(String country);

}
