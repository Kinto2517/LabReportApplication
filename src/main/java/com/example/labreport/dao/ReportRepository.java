package com.example.labreport.dao;

import com.example.labreport.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {


    List<Report> findByOrderByDateDesc();
    List<Report> findByOrderByDateAsc();


    @Query("SELECT r FROM Report r WHERE lower(r.patient_name) like lower(concat('%',:search,'%')) "
        + "or lower(r.patient_surname) like lower(concat('%',:search,'%')) "+
        "or lower(r.user.name) like lower(concat('%',:search,'%')) "+
        "or lower(r.user.surname) like lower(concat('%',:search,'%'))")
    List<Report> findByNameContainingOrSurnameContainingOrUsernameContaining(@Param("search") String search);

}
