package com.example.labreport.business.services.impl;

import com.example.labreport.model.Report;

import java.util.List;

public interface ReportServiceImp {

    List<Report> findAll();

    Report findById(Long id);

    void save(Report report);

    void delete(Long id);

    List<Report> searchBy(String search);


}
