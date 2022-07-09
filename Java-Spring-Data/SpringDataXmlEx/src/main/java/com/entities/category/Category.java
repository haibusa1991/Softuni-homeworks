package com.entities.category;

import com.entities.product.Product;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany (mappedBy = "categories")
    private Set<Product> productsInCategory;

    public Category() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Product> getProductsInCategory() {
        return Collections.unmodifiableSet(productsInCategory);
    }

    public void setProductsInCategory(Set<Product> productsInCategory) {
        this.productsInCategory = productsInCategory;
    }

    public Category(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != category.id) return false;
        return name.equals(category.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }
}
