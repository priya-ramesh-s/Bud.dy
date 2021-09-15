package com.budDy.budDy.User;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    Long id;
    String username;
    String email;
    String password;
    UserExperience userExperience;
    int quizResultID; //foreign key

    public User(){
    }

    public User(Long id, String username, String email, String password, UserExperience userExperience,
                 int quizResultID) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userExperience = userExperience;
        this.quizResultID = quizResultID;
    }

    public User(String username, String email, String password, UserExperience userExperience, int quizResultID) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.userExperience = userExperience;
        this.quizResultID = quizResultID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserExperience getUserExperience() {
        return userExperience;
    }

    public void setUserExperience(UserExperience userExperience) {
        this.userExperience = userExperience;
    }

    public int getQuizResultID() {
        return quizResultID;
    }

    public void setQuizResultID(int quizResultID) {
        this.quizResultID = quizResultID;
    }

    @Override
    public String toString() {
        return "PlantUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userExperience=" + userExperience +
                ", quizResultID=" + quizResultID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return quizResultID == user.quizResultID && Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && userExperience == user.userExperience;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, password, userExperience, quizResultID);
    }
}
