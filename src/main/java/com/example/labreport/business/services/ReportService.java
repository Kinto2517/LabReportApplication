package com.example.labreport.business.services;

import com.example.labreport.business.services.impl.ReportServiceImp;
import com.example.labreport.dao.ReportRepository;
import com.example.labreport.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService implements ReportServiceImp {

    @Autowired
    private ReportRepository reportRepository;

    @Override
    public List<Report> findAll() {

        return (List<Report>) reportRepository.findAll();

    }

    @Override
    public List<Report> orderByAsc() {

        return reportRepository.findByOrderByDateAsc();

    }

    @Override
    public List<Report> orderByDesc() {

        return reportRepository.findByOrderByDateDesc();

    }

    @Override
    public Report findById(Long id) {

        return reportRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Report report) {
        reportRepository.save(report);
    }

    @Override
    public void delete(Long id) {
        reportRepository.deleteById(id);
    }

    @Override
    public List<Report> searchBy(String search) {
        List<Report> results = null;

        if (search != null && (search.trim().length() > 0)) {
            results = reportRepository.findByNameContainingOrSurnameContainingOrUsernameContaining(search);
        } else if (search.trim().length() == 0) {
            results = reportRepository.findAll();
        }
        return results;
    }

}

