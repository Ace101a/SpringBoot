package com.aman.springbootweb.repository;

import com.aman.springbootweb.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
/*
    Spring Data JPA
 └── JpaRepository

    JPA (jakarta.persistence)
 ├── @Entity
 ├── @Id
 ├── @Column
 ├── EntityManager
 └── JPQL

            Hibernate
 └── Implements JPA and executes SQL
*/

}
