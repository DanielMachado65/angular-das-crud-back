package ufpr.br.backendcrud.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ufpr.br.backendcrud.model.Enrollment;
import ufpr.br.backendcrud.repository.EnrollmentRepository;

@CrossOrigin
@RestController
public class EnrollmentREST {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @GetMapping("enrollments")
    public ResponseEntity<List<Enrollment>> all() {
        return ResponseEntity.ok(enrollmentRepository.findAll());
    }

    @GetMapping("enrollments/{id}")
    public ResponseEntity<Enrollment> getById(@PathVariable int id) {
        Optional<Enrollment> enrollment = enrollmentRepository.findById(Integer.valueOf(id));
        if (enrollment.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(enrollment.get());
    }

    @PostMapping("enrollments")
    public ResponseEntity<Enrollment> create(@RequestBody Enrollment enrollment) {
        enrollment.setId(-1);
        enrollmentRepository.save(enrollment);
        return ResponseEntity.status(HttpStatus.CREATED).body(enrollment);
    }

    @PutMapping("enrollments/{id}")
    public ResponseEntity<Enrollment> update(@PathVariable int id, @RequestBody Enrollment enrollment) {
        Optional<Enrollment> enrollmentExists = enrollmentRepository.findById(Integer.valueOf(id));
        if (enrollmentExists.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Enrollment existingEnrollment = enrollmentExists.get();
        existingEnrollment.setId(id);
        existingEnrollment.setStudent(enrollment.getStudent());
        existingEnrollment.setCourse(enrollment.getCourse());
        existingEnrollment.setGrade(enrollment.getGrade());
        existingEnrollment.setEnrollmentDate(enrollment.getEnrollmentDate());

        enrollmentRepository.save(existingEnrollment);
        return ResponseEntity.ok(existingEnrollment);
    }

    @DeleteMapping("enrollments/{id}")
    public ResponseEntity<Enrollment> delete(@PathVariable int id) {
        Optional<Enrollment> enrollment = enrollmentRepository.findById(Integer.valueOf(id));
        if (enrollment.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        enrollmentRepository.delete(enrollment.get());
        return ResponseEntity.ok(enrollment.get());
    }
}
