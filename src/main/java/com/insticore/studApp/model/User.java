package com.insticore.studApp.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public enum Role {ADMIN, USER};

    @Enumerated(EnumType.ORDINAL)
    private Role role;

    @OneToMany(mappedBy = "author")
    private List<Product> products;

    public User() { }

    public User(String name, Role role) {
        this.name = name;
        this.role = role;
    }
}
