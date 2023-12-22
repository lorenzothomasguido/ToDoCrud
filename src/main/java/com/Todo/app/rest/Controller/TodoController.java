package com.Todo.app.rest.Controller;

import com.Todo.app.rest.Model.Task;
import com.Todo.app.rest.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "task")
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;


    @GetMapping(value= "/all")
    public List<Task> getTasks(){
        return todoRepository.findAll();
    }

    @PostMapping(value="/savetask")
    public String saveTask(@RequestBody Task task){
        todoRepository.save(task);
        return "Saved task";
    }

    @PutMapping(value="/update/{id}")
    public String updateTask(@PathVariable long id, @RequestBody Task updatedTaskDetails){
        Optional<Task> optionalTask = todoRepository.findById(id);

        if (optionalTask.isPresent()) {
            Task existingTask = optionalTask.get();

            // Actualizar los detalles de la tarea existente con los datos del cuerpo de la solicitud
            existingTask.setTitle(updatedTaskDetails.getTitle());
            existingTask.setDescription(updatedTaskDetails.getDescription());

            // Guardar la tarea actualizada en el repositorio
            todoRepository.save(existingTask);

            return "Tarea actualizada exitosamente";
        } else {
            return "No se encontró la tarea con el ID proporcionado";
        }
    }


    @DeleteMapping(value="delete/{id}")
    public String deleteTask(@PathVariable long id){
        Task deletedTask = todoRepository.findById(id).get();
        todoRepository.delete(deletedTask);
        return "Deleted Task";
    }

}
