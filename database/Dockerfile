# DOCKERFILE to postgres
FROM postgres:16

# Copy the sql script to the container
COPY script.sql /docker-entrypoint-initdb.d/

# Expose the port
EXPOSE 5432

# Set the default command to run when starting the container
CMD ["postgres", "-c", "log_statement=all"]
