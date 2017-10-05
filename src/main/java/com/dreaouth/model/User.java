package com.dreaouth.model;

public class User {
    private Integer id;

    private String name;

    private String password;

    private String email;

    private String permission;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name, String password, String email, String permission) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.permission = permission;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }
}