package com.example.labreport.controller;

import com.example.labreport.business.services.ReportService;
import com.example.labreport.business.services.UserService;
import com.example.labreport.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/reports")
public class ReportController {

    private ReportService reportService;
    private UserService userService;


    @Autowired
    public ReportController(ReportService reportService, UserService userService) {
        this.reportService = reportService;
        this.userService = userService;
    }



    @GetMapping("/search")
    public String delete(@RequestParam("reportParam") String search, Model theModel)
    {
        List<Report> reports = reportService.searchBy(search);

        theModel.addAttribute("reports", reports);

        return "reports";
    }

    @GetMapping("/")
    public String reports(Model model) {

        List<Report> reports = reportService.findAll();

        model.addAttribute("reports", reports);

        return "reports";
    }








}
