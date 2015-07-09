package main.java.com.dao;

import main.java.com.domain.UserRole;
import main.java.com.util.DataFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 30/01/2015
 */
public class UserRolesDao implements UserRolesDaoI {

    private Session session;
    UserRole user_role;
    private List<UserRole> user_roles;

    public UserRolesDao(){
        session = null;
        user_role = null;
        user_roles = new ArrayList<>();
    }

    @Override
    public List<UserRole> getUserRoles() {
        try {
            session = DataFactory.getInstance().openSession();
            user_roles = session.createCriteria(UserRole.class).list();
        } catch (ExceptionInInitializerError e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return user_roles;
    }

    @Override
    public List<UserRole> getUserRoles(int limit) {
        try {
            session = DataFactory.getInstance().openSession();
            Criteria criteria = session.createCriteria(UserRole.class); // создаем критерий запроса
            user_roles = criteria.setMaxResults(limit)                  // ограничиваем число результатов
                    .list();
        } catch (ExceptionInInitializerError e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return user_roles;
    }

    @Override
    public UserRole getUserRole(Long id) {
        try {
            session = DataFactory.getInstance().openSession();
            user_role = (UserRole) session.get(UserRole.class, id);
        } catch (ExceptionInInitializerError e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return user_role;
    }

    @Override
    public List<UserRole> findUserRolesBy(String name, int minAge, int maxAge) {
        List<UserRole> user_roles = new ArrayList<>();
        try {
            session = DataFactory.getInstance().openSession();
            user_roles = session.createCriteria(UserRole.class)             // создаем критерий запроса
                    .add(Expression.like("name", name + "%"))
                    .add(Expression.between("age", minAge, maxAge))
                    .list();
        } catch (ExceptionInInitializerError e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return user_roles;
    }

    @Override
    public List<UserRole> findUserRolesBy(String name, int minAge, int maxAge, SortBy sortByField) {
        try {
            session = DataFactory.getInstance().openSession();
            switch(sortByField){
                case ID:
                    user_roles = session.createCriteria(UserRole.class)
                            .add(Expression.like("name", name + "%"))
                            .add(Expression.between("age", minAge, maxAge))
                            .addOrder(Order.asc("id"))
                            .list();
                    break;
                case NAME:
                    user_roles = session.createCriteria(UserRole.class)
                            .add(Expression.like("name", name + "%"))
                            .add(Expression.between("age", minAge, maxAge))
                            .addOrder(Order.asc("name"))
                            .list();
                    break;
                case AGE:
                    user_roles = session.createCriteria(UserRole.class)
                            .add(Expression.like("name", name + "%"))
                            .add(Expression.between("age", minAge, maxAge))
                            .addOrder(Order.asc("age"))
                            .list();
                    break;
                case USER:
                    user_roles = session.createCriteria(UserRole.class)
                            .add(Expression.like("name", name + "%"))
                            .add(Expression.between("age", minAge, maxAge))
                            .addOrder(Order.asc("university"))
                            .list();
                    break;
                default:
                    user_roles = session.createCriteria(UserRole.class)
                            .add(Expression.like("name", name + "%"))
                            .add(Expression.between("age", minAge, maxAge))
                            .list();
                    break;
            }
        } catch (ExceptionInInitializerError e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return user_roles;
    }

    @Override
    public void addUserRole(UserRole user_roles) {
        Session session = null;
        try {
            session = DataFactory.getInstance().openSession();
            session.beginTransaction();
            session.save(user_roles);
            session.getTransaction().commit();
        } catch (ExceptionInInitializerError e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateUserRole(UserRole user_roles) {
        Session session = null;
        try {
            session = DataFactory.getInstance().openSession();
            session.beginTransaction();
            session.update(user_roles);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void deleteUserRole(UserRole user_roles) {
        try {
            session = DataFactory.getInstance().openSession();
            session.beginTransaction();
            session.delete(user_roles);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}