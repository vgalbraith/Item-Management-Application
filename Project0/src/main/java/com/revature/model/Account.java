package com.revature.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer account_id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public Account() {
    }

    public Account(Integer account_id, String username, String password) {
        this.account_id = account_id;
        this.username = username;
        this.password = password;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(account_id, account.account_id) && Objects.equals(username, account.username) && Objects.equals(password, account.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account_id, username, password);
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_id=" + account_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}