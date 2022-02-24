package com.showroom.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User extends BaseEntity{
    @Id
    @Column(length = 50)
    private String id;
    @Column(length = 50, unique = true)
    private String username;
    @Column(length = 9)
    private String password;
    @Column(length = 200)
    private String bio;
    private String address;
    @Email
    @Column(unique = true)
    private String email;
    private String telNo;
    private boolean isActive;
    private boolean isApproved;

    @ManyToMany(mappedBy = "users")
    private List<Role> roles;

    @ManyToMany(mappedBy = "users")
    private List<Product> products;

    @OneToMany(mappedBy = "user")
    private List<Category> categories;
}
