package com.orgmange.tasktracker.controller;

import com.orgmange.tasktracker.DTO.TaskRequestDTO;
import com.orgmange.tasktracker.DTO.TaskResponseDTO;
import com.orgmange.tasktracker.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для управления задачами.
 * Обрабатывает HTTP запросы для создания, чтения, обновления и удаления задач.
 * Предоставляет endpoints для получения задач за различные периоды времени (день, неделя, месяц).
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Получить задачи на сегодня
     * @param completed показывать выполненные или невыполненные задачи
     * @return список задач в виде ДТО
     */
    @GetMapping("/today")
    public List<TaskResponseDTO> getTodayTasks(@RequestParam(required = false) Boolean completed) {
        return taskService.getTasksForPeriod(1, completed);
    }

    /**
     * Получить задачи на неделю
     * @param completed показывать выполненные или невыполненные задачи
     * @return список задач в виде ДТО
     */
    @GetMapping("/week")
    public List<TaskResponseDTO> getWeekTasks(@RequestParam(required = false) Boolean completed) {
        return taskService.getTasksForPeriod(7, completed);
    }

    /**
     * Получить задачи на месяц
     * @param completed показывать выполненные или невыполненные задачи
     * @return список задач в виде ДТО
     */
    @GetMapping("/month")
    public List<TaskResponseDTO> getMonthTasks(@RequestParam(required = false) Boolean completed) {
        return taskService.getTasksForPeriod(31, completed);
    }

    /**
     * Создать новую задачу
     * @param taskDTO ДТО с данными задачи
     * @return созданная задача в виде ДТО
     */
    @PostMapping
    public TaskResponseDTO createTask(@RequestBody TaskRequestDTO taskDTO) {
        return taskService.createTask(taskDTO);
    }

    /**
     * Обновить существующую задачу
     * @param id идентификатор задачи
     * @param taskDTO ДТО с обновленными данными задачи
     * @return обновленная задача в виде ДТО
     */
    @PutMapping("/{id}")
    public TaskResponseDTO updateTask(@PathVariable Long id, @RequestBody TaskRequestDTO taskDTO) {
        return taskService.updateTask(id, taskDTO);
    }

    /**
     * Переключить статус выполнения задачи
     * @param id идентификатор задачи
     * @return обновленная задача в виде ДТО
     */
    @PatchMapping("/{id}/toggle")
    public TaskResponseDTO toggleComplete(@PathVariable Long id) {
        return taskService.toggleComplete(id);
    }

    /**
     * Удалить задачу
     * @param id идентификатор задачи
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
