package com.erf.task_manager.controller;

import com.erf.task_manager.entities.Task;
import com.erf.task_manager.requests.CreateTaskRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {

    List<Task> tasks = new ArrayList<>();

    @GetMapping("/listar-tarefas")
    public String listarTarefas(Model model)  {
        model.addAttribute("tasks", tasks);
        return "listar-tarefas";
    }

    @GetMapping("/criar-tarefa")
    public String criarTarefa(Model model) {
        CreateTaskRequest request = new CreateTaskRequest();
        model.addAttribute("request", request);
        return "criar-tarefa";
    }

    @PostMapping("/do-create")
    public String doCreate(Model model, @ModelAttribute CreateTaskRequest request) {
        tasks.add(new Task(tasks.size() + 1, request.getDescription(), false));
        return "redirect:/listar-tarefas";
    }

    @PostMapping("/delete-task/{id}")
    public String deleteTask(@PathVariable int id) {
        tasks.removeIf(task -> task.getId() == id);
        return "redirect:/listar-tarefas";
    }

    @PostMapping("/complete-task/{id}")
    public String completeTask(@PathVariable int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setIsCompleted(true);
                break;
            }
        }
        return "redirect:/listar-tarefas";
    }
}
