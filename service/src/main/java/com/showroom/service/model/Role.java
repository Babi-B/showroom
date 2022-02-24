package com.showroom.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role {
    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private ERole role;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "user_role",
    joinColumns = @JoinColumn(name = "userId", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "roleId", referencedColumnName = "id"))
    private List<User> users;
}
