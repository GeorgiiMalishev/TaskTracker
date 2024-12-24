package com.orgmange.tasktracker.mapper;

import com.orgmange.tasktracker.DTO.TaskRequestDTO;
import com.orgmange.tasktracker.DTO.TaskResponseDTO;
import com.orgmange.tasktracker.entity.Task;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * Маппер для преобразования сущности задачи в ДТО и наоборот
 */
@Component
public class TaskMapper {

    /**
     * Преобразовать сущность задачи в ДТО
     * @param task сущность задачи
     * @return ДТО задачи
     */
    public TaskResponseDTO toDto(Task task){
        return new TaskResponseDTO(task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted(),
                task.getDueDate());
    }

    /**
     * Преобразовать список сущностей задачи в список ДТО
     * @param tasks список сущностей задачи
     * @return список ДТО задачи
     */
    public List<TaskResponseDTO> toDtoList(List<Task> tasks){
        return tasks.stream().map(this::toDto).toList();
    }

    /**
     * Преобразовать ДТО задачи в сущность задачи
     * @param dto ДТО задачи
     * @return сущность задачи
     */
    public Task toEntity(TaskRequestDTO dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setDueDate(dto.getDueDate());
        task.setCompleted(false);
        return task;
    }

    /**
     * Обновить сущность задачи на основе ДТО
     * @param task сущность задачи
     * @param dto ДТО задачи
     */
    public void updateEntity(Task task, TaskRequestDTO dto) {
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setDueDate(dto.getDueDate());
    }
}
