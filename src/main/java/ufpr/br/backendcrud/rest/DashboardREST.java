package ufpr.br.backendcrud.rest;

import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import ufpr.br.backendcrud.repository.CourseRepository;
import ufpr.br.backendcrud.repository.EnrollmentRepository;
import ufpr.br.backendcrud.repository.StudentRepository;

import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@RestController
public class DashboardREST {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @GetMapping("dashboard")
    public ResponseEntity<List<Map<String, Object>>> metrics() {
        long totalStudents = studentRepository.count();
        long totalCourses = courseRepository.count();
        long totalEnrollments = enrollmentRepository.count();

        return ResponseEntity.ok(List.of(
                Map.of("name", "students", "value", totalStudents),
                Map.of("name", "courses", "value", totalCourses),
                Map.of("name", "enrollments", "value", totalEnrollments)));
    }

}
