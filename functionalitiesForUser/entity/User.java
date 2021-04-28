package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter

@Entity
@Table(name = "user")

@NamedQueries({

        @NamedQuery(name = "User.updateUsername", query = "UPDATE User u SET u.username = :username WHERE u.id = :id"),
        @NamedQuery(name = "User.updateTelephone", query = "UPDATE User u SET u.telephone = :telephone WHERE u.id = :id"),
        @NamedQuery(name = "User.updateType", query = "UPDATE User u SET u.type = :type WHERE u.id = :id"),
        @NamedQuery(name = "User.updatePassword", query = "UPDATE User u SET u.password = :password WHERE u.id = :id"),
        @NamedQuery(name = "User.updateAddress", query = "UPDATE User u SET u.address = :address WHERE u.id = :id"),
        @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
        @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
        @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
        @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
        @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
        @NamedQuery(name = "User.findByAddress", query = "SELECT u FROM User u WHERE u.address = :address"),
        @NamedQuery(name = "User.findByTelephone", query = "SELECT u FROM User u WHERE u.telephone = :telephone"),
        @NamedQuery(name = "User.findByDate", query = "SELECT u FROM User u WHERE u.date = :date"),
        @NamedQuery(name = "User.findByType", query = "SELECT u FROM User u WHERE u.type = :type"),
        @NamedQuery(name = "User.remove", query = "DELETE FROM User u WHERE u.id = :id")
       })


public  class User {

    @Id

    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "date")
    private String date;

    @Column(name = "type")
    private String type;


    public  User()
    {}

    public  User(int id)
    {this.id = id;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(address, user.address) && Objects.equals(telephone, user.telephone) && Objects.equals(date, user.date) && Objects.equals(type, user.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, firstName, lastName, address, telephone, date, type);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

