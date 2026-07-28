package com.apiframework.pojo;

public class CreateUserRequest {

    private String name;
    private String job;

    // Default Constructor
    public CreateUserRequest() {
    }

    // Parameterized Constructor
    public CreateUserRequest(String name, String job) {
        this.name = name;
        this.job = job;
    }

    // Getter for Name
    public String getName() {
        return name;
    }

    // Setter for Name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for Job
    public String getJob() {
        return job;
    }

    // Setter for Job
    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "CreateUserRequest{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}