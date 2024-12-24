package com.orgmange.tasktracker.repository;

import com.orgmange.tasktracker.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Репозиторий для работы с задачами
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    /**
     * Найти задачи по статусу выполнения и дате выполнения в интервале
     * @param completed статус выполнения
     * @param startDate начальная дата выполнения
     * @param endDate конечная дата выполнения
     * @return список задач
     */
    List<Task> findByCompletedAndDueDateBetween(Boolean completed,
                                                LocalDateTime startDate,
                                                LocalDateTime endDate);
}
