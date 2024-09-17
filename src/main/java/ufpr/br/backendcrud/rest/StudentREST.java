package ufpr.br.backendcrud.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ufpr.br.backendcrud.model.Student;
import ufpr.br.backendcrud.repository.StudentRepository;

@CrossOrigin
@RestController
public class StudentREST {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("students")
    public ResponseEntity<List<Student>> listar() {
        return ResponseEntity.ok(studentRepository.findAll());
    }
}
