package com.example.labreport.controller;

import com.example.labreport.business.services.ReportService;
import com.example.labreport.business.services.UserService;
import com.example.labreport.model.Report;
import com.example.labreport.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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




        @GetMapping("/download")
        public ResponseEntity<?> download(@RequestParam("id") Long id)
        {
            Report report = reportService.findById(id);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=\"" + report.getPatient_name() + "\"." + report.getExtension())
                    .body(new ByteArrayResource(report.getReport_img()));
        }



    @GetMapping("/search")
    public String search(@RequestParam("reportParam") String search, Model model)
    {
        List<Report> reports = reportService.searchBy(search);

        model.addAttribute("reports", reports);

        return "reports";
    }

    @GetMapping("/main")
    public String reports(Model model) {

        List<Report> reports = reportService.findAll();

        model.addAttribute("reports", reports);

        return "reports";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam Long id ) {

        Report report = reportService.findById(id);

        if (report != null) {
            reportService.delete(id);
        }

        return "redirect:/reports/main";

    }


    @GetMapping("/addForm")
    public String addReport(Model model) {

        Report report = new Report();
        List<User> users = userService.getAllUsers();


        model.addAttribute("users",users);
        model.addAttribute("report", report);
        return "addReportForm";

    }


    @GetMapping("/update")
    public String update(@RequestParam("id") Long id, Model model) {

        Report report = reportService.findById(id);
        List<User> users = userService.getAllUsers();

        model.addAttribute("users",users);
        model.addAttribute("report", report);

        return "updateReportForm";
    }



    @PostMapping("/addReport")
    public String addReport(@Valid @ModelAttribute("report") Report report, BindingResult result) {
        if (result.hasErrors()) {
            return "addReportForm";
        }
        reportService.save(report);

        return "redirect:/reports/main";
    }


    boolean orderAsc = true;
    @GetMapping("/order")
    public String order(Model model)
    {

        List<Report> reports;

        if(orderAsc)
        {
            reports = reportService.orderByAsc();
            orderAsc = false;
        }
        else
        {
            reports = reportService.orderByDesc();
            orderAsc = true;
        }

        model.addAttribute("reports", reports);
        return "reports";
    }


}
