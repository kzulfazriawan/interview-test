package com.kzulfazriawan.tests.repositories;

import com.kzulfazriawan.tests.entities.Inetnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InetnumRepositoryInterface extends JpaRepository<Inetnum, Long> {

    /**
     * find by inetnum
     *
     * @param inetNum String parameter
     * @return Object entity
     */
    List<Inetnum> findByInetNum(String inetNum);

    /**
     * find by name
     *
     * @param netName String parameter
     * @return Object entity
     */
    List<Inetnum> findByNetName(String netName);

    /**
     * @param inetNum String parameter
     * @return Object entity
     */
    Inetnum findOneByInetNum(String inetNum);

    boolean existsByInetNum(String inetNum);

    @Query("SELECT i FROM Inetnum i WHERE i.inetNum LIKE :inetNum%")
    List<Inetnum> findByInetNumStartingWith(String inetNum);
}
