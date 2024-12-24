package com.orgmange.tasktracker.service;

import com.orgmange.tasktracker.DTO.TaskRequestDTO;
import com.orgmange.tasktracker.DTO.TaskResponseDTO;
import com.orgmange.tasktracker.entity.Task;
import com.orgmange.tasktracker.exception.TaskNotFoundException;
import com.orgmange.tasktracker.mapper.TaskMapper;
import com.orgmange.tasktracker.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Сервис для работы с задачами
 */
@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    /**
     * Получить задачи за период
     * @param days количество дней
     * @param completed показывать выполненные или невыполненные задачи
     * @return список задач в виде ДТО
     */
    public List<TaskResponseDTO> getTasksForPeriod(int days, Boolean completed) {
        LocalDateTime startDate = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        LocalDateTime endDate = startDate.plusDays(days).minusSeconds(1);

        List<Task> tasks = taskRepository.findByCompletedAndDueDateBetween(
                completed,
                startDate,
                endDate
        );

        return taskMapper.toDtoList(tasks);
    }

    /**
     * Создать новую задачу
     * @param taskDTO ДТО с данными задачи
     * @return созданная задача в виде ДТО
     */
    public TaskResponseDTO createTask(TaskRequestDTO taskDTO) {
        Task task = taskMapper.toEntity(taskDTO);
        task = taskRepository.save(task);
        return taskMapper.toDto(task);
    }

    /**
     * Обновить задачу
     * @param id идентификатор задачи
     * @param taskDTO ДТО с данными задачи
     * @return обновленная задача в виде ДТО
     */
    public TaskResponseDTO updateTask(Long id, TaskRequestDTO taskDTO) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        taskMapper.updateEntity(task, taskDTO);
        task = taskRepository.save(task);
        return taskMapper.toDto(task);
    }

    /**
     * Переключить статус выполнения задачи
     * @param id идентификатор задачи
     * @return задача с обновленным статусом выполнения в виде ДТО
     */
    public TaskResponseDTO toggleComplete(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        task.setCompleted(!task.isCompleted());
        task = taskRepository.save(task);
        return taskMapper.toDto(task);
    }

    /**
     * Удалить задачу
     * @param id идентификатор задачи
     */
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
