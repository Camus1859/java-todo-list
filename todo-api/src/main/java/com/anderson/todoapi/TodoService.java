package com.anderson.todoapi;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TodoService {
    private final List<Todo> todos = new ArrayList<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public List<Todo> getAll() {
        return todos;
    }

    public Todo add(String text) {
        Todo todo = new Todo(nextId.getAndIncrement(), text, false);
        todos.add(todo);
        return todo;
    }

    public boolean delete(long id) {
        return todos.removeIf( t -> t.getId() == id);
    }

}