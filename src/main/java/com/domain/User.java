package main.java.com.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users2")
public class User {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "street", nullable = false, length=250)
	private String street;

    @Column(name = "city", nullable = false, length=50)
	private String city;

    @Column(name = "state", nullable = false, length=50)
	private String state;

    @Column(name = "zipcode", nullable = false, length=10)
	private String zipcode;

	public User() {
	}

	public User(String username, String street, String city, String state, String zipcode) {
        this.username = username;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

    public String getUsername(){
        return username;
    }
    public String getStreet() {
        return street;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getZipcode() {
        return zipcode;
    }

    public void setUsername(String username){
        this.username = username;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}