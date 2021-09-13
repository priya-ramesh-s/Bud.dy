package com.budDy.budDy.User;

import java.util.List;
import java.util.Objects;

public class User {
    private String userName;
    private String email;
    private String password;
    private UserExperience userExperience;
    private int quizResultId;

    public User(String userName, String email, String password, UserExperience userExperience, int quizResultId) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.userExperience = userExperience;
        this.quizResultId = quizResultId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public int getQuizResultId() {
        return quizResultId;
    }

    public void setQuizResultId(int quizResultId) {
        this.quizResultId = quizResultId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return quizResultId == user.quizResultId && Objects.equals(userName, user.userName) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && userExperience == user.userExperience;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, email, password, userExperience, quizResultId);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userExperience=" + userExperience +
                ", quizResultId=" + quizResultId +
                '}';
    }
}
