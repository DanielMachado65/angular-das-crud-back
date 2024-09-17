create table tb_student (
    col_id integer primary key generated always as identity,
    col_nome varchar(50) not null,
    col_cpf varchar(11) not null,
    col_email varchar(50) not null,
    col_birth_date date
);

create table tb_course (
    col_id integer primary key generated always as identity,
    col_name varchar(50) not null,
    col_link varchar(100),
);

create table tb_student_course (
    col_id integer primary key generated always as identity,
    col_student_id integer not null,
    col_course_id integer not null,
    col_grade integer not null,
    col_date date not null,
    foreign key (col_student_id) references tb_student(col_id),
    foreign key (col_course_id) references tb_course(col_id)
);