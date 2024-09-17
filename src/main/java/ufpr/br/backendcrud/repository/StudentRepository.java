package ufpr.br.backendcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ufpr.br.backendcrud.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
