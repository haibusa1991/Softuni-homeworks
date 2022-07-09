package com.entities.product;

import com.entities.category.Category;
import com.entities.user.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private BigDecimal price;

    @ManyToMany
    private Set<Category> categories;

    @ManyToOne
    private User seller;

    @ManyToOne
    private User buyer;

    public Product() {
    }

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public User getSeller() {
        return seller;
    }

    public User getBuyer() {
        return buyer;
    }
}
