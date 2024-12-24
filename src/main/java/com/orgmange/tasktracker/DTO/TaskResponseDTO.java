package com.orgmange.tasktracker.DTO;

import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class TaskResponseDTO {
    /**
     * Идентификатор задачи
     */
    @Id
    private final Long id;

    /**
     * Название задачи
     */
    private final String title;

    /**
     * Описание задачи
     */
    private final String description;

    /**
     * Флаг выполнения задачи
     */
    private final boolean completed;

    /**
     * Дата выполнения задачи
     */
    private final LocalDateTime dueDate;

    public TaskResponseDTO(Long id,
                           String title,
                           String description,
                           boolean completed,
                           LocalDateTime dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.dueDate = dueDate;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }
}
