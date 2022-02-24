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
public class Category extends BaseEntity{
    @Id
    private String id;
    private String name;
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_category",
    joinColumns = @JoinColumn(name = "productId", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "categoryId", referencedColumnName = "id"))
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
