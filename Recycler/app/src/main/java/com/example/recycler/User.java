package com.example.recycler;

/**
 * Created by jb on 06/12/2018.
 */

public class User {
    int id;
    String Name,email;
    byte[] img;
    String phone;

    public User(String name,String email,String phone, byte[] img) {
        Name = name;
        this.phone = phone;
        this.email = email;
        this.img = img;
    }

    public User(String name, byte[] img) {
        Name = name;
        this.img = img;
    }

    public User(int id, String name) {
        this.id = id;
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public User(String Name){
        this.Name=Name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
