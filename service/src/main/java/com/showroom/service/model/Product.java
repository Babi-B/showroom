package com.showroom.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product extends BaseEntity{
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private String image;

    @ManyToMany(mappedBy = "products")
    private List<Category> categories;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "user_product",
            joinColumns = @JoinColumn(name = "userId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "productId", referencedColumnName = "id"))
    private List<User> users;
}
