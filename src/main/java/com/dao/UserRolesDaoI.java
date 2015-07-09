package main.java.com.dao;

import main.java.com.domain.UserRole;

import java.util.List;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.1
 * @date 09/07/2015
 */
public interface UserRolesDaoI {

    UserRole       getUserRole(Long id);                                                     // получить стедента по id
    List<UserRole> getUserRoles();                                                           // получить всех студентов
    List<UserRole> getUserRoles(int limit);                                                  // ограничиваем число результатов
    List<UserRole> findUserRolesBy(String name, int minAge, int maxAge);                     // ограничить поиск стедента по имени и возрасту
    List<UserRole> findUserRolesBy(String name, int minAge, int maxAge, SortBy sortByField); // ограничить поиск стедента по имени и возрасту
    void           addUserRole(UserRole user_roles);                                         // добавить студента
    void           updateUserRole(UserRole user_roles);                                      // обновить студента
    void           deleteUserRole(UserRole user_roles);                                      // удалить студента

}