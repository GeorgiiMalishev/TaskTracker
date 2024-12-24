package com.orgmange.tasktracker.exception;

/**
 * Исключение, возникающее при отсутствии задачи
 */
public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Long id) {
        super("Task not found with id: " + id);
    }
}