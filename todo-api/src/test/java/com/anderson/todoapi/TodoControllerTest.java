package com.anderson.todoapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TodoController.class)
public class TodoControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoService todoService;

    @Test
    void getAll_returnsEmptyList() throws Exception {
        when(todoService.getAll()).thenReturn(List.of());

        mockMvc.perform(get("/api/todos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));
    }

    @Test
    void add_returnsCreatedTodo() throws Exception {
        Todo created = new Todo(1L, "buy milk", false);
        when(todoService.add(anyString())).thenReturn(created);

        mockMvc.perform(post("/api/todos")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"text\":\"buy milk\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.text").value("buy milk"))
                .andExpect(jsonPath("$.id").value(1));
    }
}
