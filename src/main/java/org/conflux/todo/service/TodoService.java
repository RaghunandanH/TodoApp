package org.conflux.todo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.conflux.todo.dao.TodoDao;
import org.conflux.todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("todoService")
public class TodoService {

	@Autowired
	TodoDao todoDao;

	@Transactional
	public List<Todo> getAllTodos() {
		return todoDao.getAllTodos();
	}

	@Transactional
	public Todo getTodo(int id) {
		return todoDao.getTodo(id);
	}

	@Transactional
	public Todo addTodo(Todo todo) {
		todoDao.addTodo(todo);
		return todo;
	}

	@Transactional
	public Todo updateTodo(Todo todo) {
		todoDao.updateTodo(todo);
		return todo;
	}

	@Transactional
        public void deleteTodo(int id) {
                todoDao.deleteTodo(id);
        }
	
	@Transactional
        public void taskStatus(int id, boolean Status) {
                todoDao.taskStatus(id, Status);
        }
}
