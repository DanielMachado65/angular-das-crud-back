package ufpr.br.backendcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import ufpr.br.backendcrud.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findByName(String name);

    Optional<Student> findByCpf(String cpf);
}
