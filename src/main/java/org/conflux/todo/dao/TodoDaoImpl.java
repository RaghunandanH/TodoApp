package org.conflux.todo.dao;

import java.util.List;

import org.conflux.todo.model.Todo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/* This is the implementation class for the interface TodoDAO */
/* This class file forms the DAO interacting with the database */

@Repository
public class TodoDaoImpl implements TodoDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
        public List<Todo> getAllTodos() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Todo>  todoList = session.createQuery("from Todo").list();
		return todoList;
	}

	@Override
        public Todo getTodo(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Todo todo = session.get(Todo.class, id);
		return todo;
	}

	@Override
        public Todo addTodo(Todo todo) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(todo);
		return todo;
	}

	@Override
        public void updateTodo(Todo todo) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(todo);
	}

	@Override
        public void deleteTodo(int id) {
            Session session = this.sessionFactory.getCurrentSession();
            Todo p = session.get(Todo.class, id);
            p.setDel(true);                                  
        } 
		
        @Override
        public void taskStatus(int id, boolean Status) {            
            Session session = this.sessionFactory.getCurrentSession();
            Todo p =  session.get(Todo.class, id);
            p.setStatus(Status);                                      
        } 
}
