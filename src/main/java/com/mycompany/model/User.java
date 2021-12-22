package com.mycompany.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class User {
    private String surname;
    private String name;
    private String otchestvo;
    private int age;
    private int salary;
    private String email;
    private String job;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOtchestvo() {
        return otchestvo;
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
    public void writingUser(){

        try
        {
            Files.write(Paths.get("users.txt"), (this.surname+" "+this.name +" "+this.otchestvo +" "+this.age +" "+this.salary +" "+this.email +" "+this.job+"\n").getBytes(), StandardOpenOption.APPEND);
            //writer.write(this.surname+" "+this.name +" "+this.otchestvo +" "+this.age +" "+this.salary +" "+this.email +" "+this.job);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", otchestvo='" + otchestvo + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", email='" + email + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}

