package com.xyz.xyz.entity;

import jakarta.persistence.*;

@Entity

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // This will auto-generate the ID
    private Long id;
    @Column(name="name",unique = true,nullable = false)
    private String name;
    @Column(name="email",unique = true,nullable = false)
    private String email;
    @Column(name="mobile",length = 10)
    private String mobile;

    // Getters and setters (or use Lombok annotations like @Data if available)

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
