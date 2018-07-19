package org.conflux.todo.controller;

import java.util.List;

import org.conflux.todo.model.Todo;
import org.conflux.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;


/* This is the Todo Controller Class */


@RestController
@RequestMapping("/todo")
@Api(value = "TodoControllerApi", produces = MediaType.APPLICATION_JSON_VALUE)
public class TodoController {

	@Autowired
	TodoService todoService;
        
	/* Responsible for returning all the tasks */
	@RequestMapping(value = "/tasks", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Todo> getAllTodos() {
		List<Todo> listOfTodos = todoService.getAllTodos();
		return listOfTodos;
	}
		
	/* Responsible for returning a task with a specific ID */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	    public void getTodoById(@PathVariable int id) {
	        todoService.getTodo(id);
	}

	/* Responsible for returning all the tasks if no specifc request is made */
	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public String goToHomePage() {
		return "redirect:/tasks";
	}
        
	/* Responsible for creating the task */
	@RequestMapping(value = "/task", method = RequestMethod.POST, headers = "Accept=application/json")
	public Todo addTodo(@RequestBody Todo todo) {
		return todoService.addTodo(todo);

	}

	/* Responsible for Editing the task */	
	@RequestMapping(value = "/task", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Todo updateTodo(@RequestBody Todo todo) {
		return todoService.updateTodo(todo);

	}
	
	/* Responsible for deleting the task with the specific ID */	
	@RequestMapping(value = "/task/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
        public void deleteTodo(@PathVariable("id") int id) {
                todoService.deleteTodo(id);
       }
	
	/* Responsible for updating the task status */
	@RequestMapping(value = "/taskStatus/{id}/{Status}", method = RequestMethod.PUT)
        public void taskStatus(@PathVariable("id") int id, @PathVariable("Status") boolean Status) {	    
         todoService.taskStatus(id, Status);

        }
}
