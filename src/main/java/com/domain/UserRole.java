package main.java.com.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "user_roles2")
public class UserRole {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
	private long id;

    @Column(name = "name", nullable = false, length = 100)
	private String name;

    @Column(name="age")
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
	private User user;

    public UserRole(){}
    public UserRole(String name, int age, User user){
        this.name = name;
        this.age = age;
        this.user = user;
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public long getAge() {
        return age;
    }
    public User getUser() {
        return user;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
            String str_out = "|   " + id + "      ";
            str_out = str_out.substring(0,9);
            str_out += "|   " + name + "         ";
            str_out = str_out.substring(0,29);
            str_out += "|   " + age + "         ";
            str_out = str_out.substring(0,37);
            str_out += "| " + user.getCity() + "         ";
            str_out = str_out.substring(0,50) + " |";
        return str_out;
    }
}