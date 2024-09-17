package ufpr.br.backendcrud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ufpr.br.backendcrud.model.Course;
import ufpr.br.backendcrud.repository.CourseRepository;

@CrossOrigin
@RestController
public class CourseREST {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("courses")
    public ResponseEntity<List<Course>> listar() {
        return ResponseEntity.ok(courseRepository.findAll());
    }

    @GetMapping("courses/{id}")
    public ResponseEntity<Course> getById(@PathVariable int id) {
        return ResponseEntity.ok(courseRepository.findById(id).orElse(null));
    }
}
