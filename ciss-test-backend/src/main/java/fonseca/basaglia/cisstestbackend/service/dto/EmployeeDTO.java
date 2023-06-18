package fonseca.basaglia.cisstestbackend.service.dto;

import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
    private Long id;

    @Size(min = 2, max = 30)
    private String name;

    @Size(min = 2, max = 50)
    private String lastName;

    private String email;

    @Size(max = 11)
    private String pisNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPisNumber() {
        return pisNumber;
    }

    public void setPisNumber(String pisNumber) {
        this.pisNumber = pisNumber;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", pisNumber='" + pisNumber + '\'' +
                '}';
    }
}
