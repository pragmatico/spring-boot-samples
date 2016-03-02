package com.example.rest;

import com.example.DemoApplicationTests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.server.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.server.setup.MockMvcBuilders.webApplicationContextSetup;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;


public class TaskControllerTest extends DemoApplicationTests {

    private static final Logger LOGGER = LogManager.getLogger(TaskControllerTest.class);

    @Autowired
    protected WebApplicationContext wac; // cached

    protected MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webApplicationContextSetup(this.wac).build();
    }

    @Test
    public void getTasks() throws Exception {
        MvcResult result = mockMvc.perform(get("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().mimeType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.task1").value("Build project"))
                .andReturn();

        LOGGER.info("\n\nRESPONSE = " + result.getResponse().getContentAsString() + "\n");
    }

}
