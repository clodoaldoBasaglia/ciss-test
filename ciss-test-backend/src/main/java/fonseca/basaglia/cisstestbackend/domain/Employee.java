package fonseca.basaglia.cisstestbackend.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.UniqueElements;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator", allocationSize = 1)
    @Column(name = "id")
    private Long id;
    @Size(min = 2, max = 30)
    @Column(name = "name", length = 30)
    private String name;

    @Size(min = 2, max = 50)
    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Size(max = 11)
    @Column(name = "pis_number", length = 11)
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(lastName, employee.lastName) && Objects.equals(email, employee.email) && Objects.equals(pisNumber, employee.pisNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, email, pisNumber);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", pisNumber='" + pisNumber + '\'' +
                '}';
    }
}
