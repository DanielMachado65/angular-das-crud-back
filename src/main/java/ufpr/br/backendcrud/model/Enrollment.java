package ufpr.br.backendcrud.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_student_course")
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "col_id")
    @Setter
    @Getter
    private int id;

    @ManyToOne
    @JoinColumn(name = "col_student_id", nullable = false)
    @Setter
    @Getter
    private Student student;

    @ManyToOne
    @JoinColumn(name = "col_course_id", nullable = false)
    @Setter
    @Getter
    private Course course;

    @Column(name = "col_grade")
    @Setter
    @Getter
    private int grade;

    @Column(name = "col_date")
    @Setter
    @Getter
    private LocalDate enrollmentDate;
}
