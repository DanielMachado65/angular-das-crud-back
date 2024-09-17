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

import ufpr.br.backendcrud.model.Course;
import ufpr.br.backendcrud.repository.CourseRepository;
import ufpr.br.backendcrud.utils.ParamsUtils;

@CrossOrigin
@RestController
public class CourseREST {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("courses")
    public ResponseEntity<List<Course>> all() {
        return ResponseEntity.ok(courseRepository.findAll());
    }

    @GetMapping("courses/{id}")
    public ResponseEntity<Course> getById(@PathVariable int id) {
        Optional<Course> course = courseRepository.findById(Integer.valueOf(id));
        if (course.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(course.get());
    }

    @PostMapping("courses")
    public ResponseEntity<Course> create(@RequestBody Course course) {
        Optional<Course> courseExists = courseRepository.findByName(course.getName());
        if (courseExists.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        course.setId(-1);
        courseRepository.save(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }

    @PutMapping("courses/{id}")
    public ResponseEntity<Course> update(@PathVariable int id, @RequestBody Course course) {
        Optional<Course> courseExists = courseRepository.findById(Integer.valueOf(id));
        if (courseExists.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Course existingCourse = courseExists.get();
        existingCourse.setId(id);
        ParamsUtils.copyNonNullProperties(course, existingCourse);

        courseRepository.save(existingCourse);
        return ResponseEntity.ok(existingCourse);
    }

    @DeleteMapping("courses/{id}")
    public ResponseEntity<Course> delete(@PathVariable int id) {
        Optional<Course> course = courseRepository.findById(Integer.valueOf(id));
        if (course.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        courseRepository.delete(course.get());
        return ResponseEntity.ok(course.get());
    }
}
