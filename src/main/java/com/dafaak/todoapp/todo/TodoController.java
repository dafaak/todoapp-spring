package com.dafaak.todoapp.todo;

import jakarta.validation.Valid;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Controller
//@SessionAttributes("name")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = todoService.findByUsername("Israel");
        model.put("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {

        if (model.get("todo") !=null && (Objects.equals(model.get("todo").toString(), ""))) {
            Todo todo = new Todo(0, (String) model.get("name"), "", LocalDate.now().plusYears(1), false);
            model.put("todo", todo);
        }else{
            Todo todo = new Todo(0, "", "", LocalDate.now().plusYears(1), false);
            model.put("todo", todo);
        }

        return "addTodo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "addTodo";
        }

        todoService.addTodo((String) model.get("name"), todo.getDescription(), todo.getTargetDate(), false);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteTodoById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = todoService.findById(id);
        System.out.println(todo.toString());
        model.put("todo", todo);
        return "addTodo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        System.out.println(todo.toString());

        String userName = (String) model.get("name");
        todo.setUsername(userName);

        if (result.hasErrors()) {
            return "addTodo";
        }

        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }
}
