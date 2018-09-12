package com.yash.todolist.daoimpl;

import com.yash.todolist.dao.UserDao;
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

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void insert(User user) {
        sessionFactory.getCurrentSession().save(user);
    }


    public User getUserByCredentials(User user){
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root).where(cb.and(cb.equal(root.get("username"), user.getUsername())), cb.equal(root.get("password"), user.getPassword()));
        Query<User> query = session.createQuery(cq);
        User newUser = query.getSingleResult();
        return newUser;
    }

    public User getUserById(int id){
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        return user;
    }

    @Override
    public List<User> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);
        Query<User> query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.getCurrentSession();
        User user2 = session.byId(User.class).load(user.getId());
        user2.setId(user.getId());
        user2.setPassword(user.getPassword());
        session.flush();

    }

    @Override
    public void deleteUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        User user2 = session.byId(User.class).load(user.getId());
        session.delete(user2);
    }
}
