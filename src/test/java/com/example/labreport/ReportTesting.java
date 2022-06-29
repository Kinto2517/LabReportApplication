package com.example.labreport;

import com.example.labreport.business.services.ReportService;
import com.example.labreport.business.services.UserService;
import com.example.labreport.dao.ReportRepository;
import com.example.labreport.dao.UserRepository;
import com.example.labreport.model.Report;
import com.example.labreport.model.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;



@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReportTesting {

    @Mock
    private ReportService reportService;

    @Mock
    private ReportRepository reportRepository;

    @Mock
    private UserRepository userRepository;






    @Test
    @Order(2)

    public void testGetAllReports() {
        List<Report> reports = reportRepository.findAll();
        assertThat(reports).isNotNull();
    }


    @Test
    @Order(7)

    public void testDelete() {

        User user = new User();
        user.setName("test");
        user.setSurname("test");
        user.setUsername("test");
        user.setPassword("test");
        user.setRole("test");
        user.setId(1L);
        userRepository.save(user);

        Report report = new Report();
        report.setId(1L);
        report.setTitle("test");
        report.setDescription("test");
        report.setDate(LocalDateTime.now());
        report.setPatient_name("test");
        report.setPatient_surname("test");
        report.setUser(user);


        Long id = 1L;
        reportRepository.delete(report);
        assertThat(reportRepository.findById(id)).isEqualTo(Optional.empty());
    }


    @Test
    @Order(3)
    public void testSearchBy(){
        String test = "test";
        List<Report> reports = reportService.searchBy(test);
        assertThat(reports).isNotNull();
    }


    @Test
    @Order(4)

    public void testGetAllReportsOrderByAsc() {
        List<Report> reports = reportRepository.findByOrderByDateAsc();
        assertThat(reports).isNotNull();
    }

    @Test
    @Order(5)
    public void testGetAllReportsOrderByDesc() {
        List<Report> reports = reportRepository.findByOrderByDateDesc();
        assertThat(reports).isNotNull();
    }

    @Test
    @Order(6)
    public void testGetAllReportsByNameContainingOrSurnameContainingOrUsernameContaining() {
        List<Report> reports = reportRepository.findByNameContainingOrSurnameContainingOrUsernameContaining("test");
        assertThat(reports).isNotNull();
    }



}
