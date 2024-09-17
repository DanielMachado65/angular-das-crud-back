package ufpr.br.backendcrud.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_student")
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "col_id")
    @Setter
    @Getter
    private int id;

    @Column(name = "col_name")
    @Setter
    @Getter
    private String name;

    @Column(name = "col_cpf")
    @Setter
    @Getter
    private String cpf;

    @Column(name = "col_email")
    @Setter
    @Getter
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "col_birth_date")
    @Setter
    @Getter
    private LocalDate birDate; // precisa receber AAAA-MM-DD

}
