package com.orgmange.tasktracker.DTO;

import java.time.LocalDateTime;

/**
 * DTO для создания задачи
 */
public class TaskRequestDTO {
    /**
     * Название задачи
     */
    private String title;

    /**
     * Описание задачи
     */
    private String description;

    /**
     * Дата выполнения задачи
     */
    private LocalDateTime dueDate;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }
}