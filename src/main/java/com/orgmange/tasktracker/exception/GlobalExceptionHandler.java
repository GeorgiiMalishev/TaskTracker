package com.orgmange.tasktracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Глобальный обработчик исключений
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Обработка исключения TaskNotFoundException
     * @param ex исключение
     * @return сообщение об ошибке
     */
    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleTaskNotFound(TaskNotFoundException ex) {
        return ex.getMessage();
    }
}