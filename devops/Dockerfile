FROM postgres:latest

ENV POSTGRES_USER=admin
ENV POSTGRES_PASSWORD=admin

COPY init.sql /docker-entrypoint-initdb.d/

# docker build -t angular_das .
# docker run -d -p 5432:5432 --name angular_das_crud -v database:/var/lib/postgresql/data angular_das