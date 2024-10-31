package com.raihanorium.controller;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@MicronautTest
public class HomeControllerTest {

    @Inject
    HomeController homeController;

    @Test
    void testIndex() {
        String index = homeController.index();
        assert index.equals("Hello, Micronaut!");
    }
}
