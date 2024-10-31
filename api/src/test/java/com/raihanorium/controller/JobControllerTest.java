package com.raihanorium.controller;

import com.raihanorium.persistence.model.Job;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@MicronautTest
public class JobControllerTest {

    @Inject
    JobController jobController;


    @Test
    void testSave() {
        Job job = Job.builder()
                .title("Software Engineer")
                .description("Develop software applications")
                .build();
        Job savedJob = jobController.save(job);
        assert savedJob.getId() != null;
        assert savedJob.getTitle().equals(job.getTitle());
        assert savedJob.getDescription().equals(job.getDescription());
    }

    @Test
    void testList() {
        assert jobController.list().isEmpty();
        testSave();
        assert jobController.list().size() == 1;
    }

    @Test
    void testGet() {
        Job job = Job.builder()
                .title("Software Engineer")
                .description("Develop software applications")
                .build();
        Job savedJob = jobController.save(job);
        Job retrievedJob = jobController.get(savedJob.getId());
        assert retrievedJob != null;
        assert retrievedJob.getId().equals(savedJob.getId());
        assert retrievedJob.getTitle().equals(savedJob.getTitle());
        assert retrievedJob.getDescription().equals(savedJob.getDescription());

        assert jobController.get(0L) == null;
    }
}
