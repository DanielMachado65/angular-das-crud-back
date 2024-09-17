package ufpr.br.backendcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import ufpr.br.backendcrud.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    Optional<Course> findByName(String name);
}
