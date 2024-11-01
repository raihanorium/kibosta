package com.raihanorium.persistence.repository;

import com.raihanorium.persistence.model.Job;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.H2)
public interface JobRepository extends CrudRepository<Job, Long> {

}
