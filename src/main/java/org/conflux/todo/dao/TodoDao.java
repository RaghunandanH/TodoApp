package org.conflux.todo.dao;

import java.util.List;

import org.conflux.todo.model.Todo;

public interface TodoDao {
	public List<Todo> getAllTodos() ;

	public Todo getTodo(int id) ;

	public Todo addTodo(Todo todo);

	public void updateTodo(Todo todo) ;

	public void deleteTodo(int id) ;
	
	public void taskStatus(int id, boolean Status) ;
}
