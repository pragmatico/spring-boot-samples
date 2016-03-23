package com.example.domain;

import javax.validation.Valid;
import java.util.List;

public class Tasks {

    @Valid
    private List<Task> tasks;

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
