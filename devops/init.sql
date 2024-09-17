-- init.sql

CREATE TABLE IF NOT EXISTS tb_student (
    col_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    col_nome VARCHAR(50) NOT NULL,
    col_cpf VARCHAR(11) NOT NULL,
    col_email VARCHAR(50) NOT NULL,
    col_birth_date DATE
);

CREATE TABLE IF NOT EXISTS tb_course (
    col_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    col_name VARCHAR(50) NOT NULL,
    col_link VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS tb_student_course (
    col_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    col_student_id INTEGER NOT NULL,
    col_course_id INTEGER NOT NULL,
    col_grade INTEGER NOT NULL,
    col_date DATE NOT NULL,
    FOREIGN KEY (col_student_id) REFERENCES tb_student(col_id),
    FOREIGN KEY (col_course_id) REFERENCES tb_course(col_id)
);
