package com.example.AutoKolcsonzo.Rent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Set;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {

    @Query("""
            SELECT r.car.id FROM Rent r WHERE ( :start <= r.startDate AND r.endDate <= :end ) OR
            ( :start <= r.endDate AND r.endDate <= :end ) OR
            ( r.startDate <= :start AND :end <= r.endDate ) 
            """)
    Set<Long> getRentsByInterval(@Param("start") Date startDate, @Param("end") Date endDate);

}
