package com.manning.liveproject.dg.liveproject.pastries;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PastriesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Open application home page")
    void openDefaultPage() throws Exception {

        var result = this.mockMvc.perform(get("/").accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertAll(
                () -> assertTrue(result.contains("All Butter Croissant")),
                () -> assertTrue(result.contains("Chocolate Croissant")),
                () -> assertTrue(result.contains("Fresh Baguette")),
                () -> assertTrue(result.contains("Red Velvet")),
                () -> assertTrue(result.contains("Victoria Sponge")),
                () -> assertTrue(result.contains("Carrot Cake"))
        );
    }
}