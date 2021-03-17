package com.example.demo;


import java.io.Serializable;

public class User implements Cloneable, Serializable {
    private static final long serialVersionUID = -7745354494726641251L;
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {

    }
    protected User(String username){
        this.username=username;
    }
    private User(Integer i){
       System.out.println(i);
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void print(){
        System.out.println("name:"+this.getUsername()+"   pass:"+this.getPassword());
    }
    private int print(String username){
        this.username=username;
        System.out.println("name:"+this.getUsername()+"   pass:"+this.getPassword());
        return 1;
    }
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
