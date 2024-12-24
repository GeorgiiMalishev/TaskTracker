package com.orgmange.tasktracker.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Сущность задачи
 */
@Entity
@Table(name = "tasks")
public class Task {
    /**
     * Идентификатор задачи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Название задачи
     */
    private String title;

    /**
     * Описание задачи
     */
    private String description;

    /**
     * Флаг выполнения задачи
     */
    private boolean completed;

    /**
     * Дата выполнения задачи
     */
    private LocalDateTime dueDate;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
