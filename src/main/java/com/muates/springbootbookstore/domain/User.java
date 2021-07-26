package com.muates.springbootbookstore.domain;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 15)
    private String firstName;

    @NotBlank
    @Size(min = 3, max = 15)
    private String lastName;

    @NotBlank
    @Size(max = 25)
    @NaturalId
    @Column(unique=true)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    @NaturalId
    private String mail;

    @NotBlank
    @Size(min = 11, max = 11)
    private String tcNo;

    @OneToOne(cascade = CascadeType.MERGE)
    private Gender gender;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String username, String mail, String tcNo, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.mail = mail;
        this.tcNo = tcNo;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", mail='" + mail + '\'' +
                ", tcNo='" + tcNo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(username, user.username) && Objects.equals(mail, user.mail) && Objects.equals(tcNo, user.tcNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, username, mail, tcNo);
    }
}
