package com.raihanorium.controller;

import com.raihanorium.persistence.model.Job;
import com.raihanorium.persistence.repository.JobRepository;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

import java.util.List;

@Controller("/jobs")
public class JobController {

    @Inject
    private JobRepository jobRepository;

    @Get(produces = "application/json")
    public List<Job> list() {
        return jobRepository.findAll();
    }

    @Post(produces = "application/json")
    public Job save(Job job) {
        return jobRepository.save(job);
    }

    @Get(value = "/{id}", produces = "application/json")
    public Job get(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Delete(value = "/{id}", produces = "application/json")
    public Job delete(Long id) {
        Job job = jobRepository.findById(id).orElse(null);
        if (job != null) {
            jobRepository.delete(job);
        }
        return job;
    }
}
