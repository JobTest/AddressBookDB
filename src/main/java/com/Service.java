package main.java.com;

import main.java.com.dao.SortBy;
import main.java.com.dao.UserRolesDao;
import main.java.com.dao.UserRolesDaoI;
import main.java.com.domain.User;
import main.java.com.domain.UserRole;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.1
 * @date 09/07/2015
 ** {@link http://www.dzone.com/tutorials/java/hibernate/hibernate-example/hibernate-mapping-many-to-one-using-annotations-1.html}
 * {@link http://www.tutorialspoint.com/hibernate/hibernate_many_to_one_mapping.htm}
 * {@link http://j4sq.blogspot.com/2011/09/hibernate-reference-manual.html}
 * **********************************************************************
 * CREATE DATABASE addressbook CHARACTER SET utf8 COLLATE utf8_general_ci
 */
public class Service {

    private static UserRolesDaoI dao = new UserRolesDao();

    private static Random rand = new Random();
    private static int number;


	public static void main(String[] args) throws SQLException {
        /* Создадим двух студентов */
        number = rand.nextInt(100);
        User user1 = new User("user-" + number, "OMR Road " + number, "Chennai " + number, "TN " + number, String.valueOf(number));
        UserRole user_role1 = new UserRole("Ivanov-" + number, number, user1);
        number = rand.nextInt(100);
        User user2 = new User("user-" + number, "OMR Road " + number, "Chennai " + number, "TN " + number, String.valueOf(number));
        UserRole user_role2 = new UserRole("Petrova-" + number, number, user2);
//        add(user_role1);
//        add(user_role2);

        /* Выведем всех студентов из базы данных */
//        print( dao.getUserRoles() );

        /* Выведем только 3-студента из базы данных */
//        print( dao.getUserRoles(3) );

        /* Выведем только одного студента из базы данных */
//        print( dao.getUserRole(3l) );

        /* Выведем найденных студентов из базы данных */
//        print( dao.findUserRolesBy("Ivanov-", 51, 100) );
        print( dao.findUserRolesBy("Ivanov-", 0, 100, SortBy.AGE) );
	}


    public static void add(UserRole user_role1) throws SQLException {
        dao.addUserRole(user_role1);  // Сохраним их в бд, id будут сгенерированы автоматически
    }

    public static void print(List<UserRole> user_roles) throws SQLException {
        String SEPARATOR = "+--------+-------------------+-------+-------------+";
        String TOP_NAME = "|   ID   |        NAME       |  AGE  |  UNIVERSITY |";

        System.out.println(SEPARATOR + "\n" + TOP_NAME + "\n" + SEPARATOR);
        user_roles.forEach(user_role -> System.out.println(user_role + "\n" + SEPARATOR));
    }

    public static void print(UserRole user_role) throws SQLException {
        String SEPARATOR = "+--------+-------------------+-------+-------------+";
        String TOP_NAME = "|   ID   |        NAME       |  AGE  |  UNIVERSITY |";

        System.out.println(SEPARATOR + "\n" + TOP_NAME + "\n" + SEPARATOR);
        System.out.println(user_role.toString() + "\n" + SEPARATOR);
    }
}