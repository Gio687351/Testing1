package com.example.mirrorapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MirrorController.class)
public class MirrorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testMirrorEndpoint() throws Exception {
        mockMvc.perform(get("/api/mirror")
                        .param("input", "Hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Mirrored: Hello"));
    }
}
