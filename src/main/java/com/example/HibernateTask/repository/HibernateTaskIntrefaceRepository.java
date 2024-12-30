package com.example.HibernateTask.repository;

import com.example.HibernateTask.model.Person;
import com.example.HibernateTask.model.PersonInfo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HibernateTaskIntrefaceRepository  extends JpaRepository<PersonInfo, Person> {
    @Query("select u from PERSONS u where u.cityOfLiving = ?1")
    List<PersonInfo> findByCityofliving(String city);
    @Query("select u from PERSONS u where u.person.age < ?1")
    List<PersonInfo> findByAge(int age);
    @Query("select u from PERSONS u where u.person.name = ?1 and u.person.surname = ?2")
    List<PersonInfo> findByNameAndSurname(String name, String surname );

    @Modifying
    @Transactional
    @Query(value = "insert into PERSONS values " +
            "( " + ":#{#me.age}, " + ":#{#me.name}, "
            + ":#{#me.surname} "+")", nativeQuery = true)
    int setPerson(@Param("me") Person me);
}
