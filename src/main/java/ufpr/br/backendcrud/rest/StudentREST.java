package ufpr.br.backendcrud.rest;

import java.util.Optional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ufpr.br.backendcrud.model.Student;
import ufpr.br.backendcrud.repository.StudentRepository;
import ufpr.br.backendcrud.utils.ParamsUtils;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
public class StudentREST {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("students")
    public ResponseEntity<List<Student>> all() {
        return ResponseEntity.ok(studentRepository.findAll());
    }

    @GetMapping("students/{id}")
    public ResponseEntity<Student> getById(@PathVariable int id) {
        Optional<Student> student = studentRepository.findById(Integer.valueOf(id));
        if (student.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student.get());
    }

    @PostMapping("students")
    public ResponseEntity<Student> create(@RequestBody Student student) {
        student.setCpf(student.getCpf().replaceAll("[^\\d]", ""));

        Optional<Student> studentExists = studentRepository.findByCpf(student.getCpf());
        if (studentExists.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        student.setId(-1);
        studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @PutMapping("students/{id}")
    public ResponseEntity<Student> update(@PathVariable int id, @RequestBody Student student) {
        Optional<Student> studentExists = studentRepository.findById(Integer.valueOf(id));
        if (studentExists.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Student existingStudent = studentExists.get();
        existingStudent.setId(id);
        ParamsUtils.copyNonNullProperties(student, existingStudent);

        studentRepository.save(existingStudent);
        return ResponseEntity.ok(existingStudent);
    }

    @DeleteMapping("students/{id}")
    public ResponseEntity<Student> delete(@PathVariable int id) {
        Optional<Student> student = studentRepository.findById(Integer.valueOf(id));
        if (student.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        studentRepository.delete(student.get());
        return ResponseEntity.ok(student.get());
    }

}
