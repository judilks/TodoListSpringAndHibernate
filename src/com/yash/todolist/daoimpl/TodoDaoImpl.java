package com.yash.todolist.daoimpl;

import com.yash.todolist.dao.TodoDao;
import com.yash.todolist.model.Todo;
import com.yash.todolist.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
@Transactional
@Repository
public class TodoDaoImpl implements TodoDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void insert(Todo todo) {
        sessionFactory.getCurrentSession().save(todo);
    }

    @Override
    public Todo getTodoById(int id) {
        return sessionFactory.getCurrentSession().get(Todo.class, id);
    }

    @Override
    public List<Todo> list(User user) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Todo> cq = cb.createQuery(Todo.class);
        Root<Todo> root = cq.from(Todo.class);
        cq.select(root).where(cb.equal(root.get("user_Id"), user.getId()));
        Query<Todo> query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void update(Todo todo) {
        Session session = sessionFactory.getCurrentSession();
        Todo todo2 = session.byId(Todo.class).load(todo.getId());
        todo2.setMessage(todo.getMessage());
        todo2.setCompletedStatus(todo.isCompletedStatus());
        session.flush();
    }

    @Override
    public void deleteTodo(Todo todo) {
        Session session = sessionFactory.getCurrentSession();
        Todo todo2 = session.byId(Todo.class).load(todo.getId());
        session.delete(todo2);
    }
}
