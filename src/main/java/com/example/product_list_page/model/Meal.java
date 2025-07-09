package com.example.product_list_page.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity(name = "tb_meals")
public class Meal {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "id")
	private Long id;
    @Column(name = "image")
    private String image;
    @Column(unique = true, name = "name")
    private String name;
    @Column(unique = true, name = "category")
    private String category;
    @Column(name = "price")
    private Double price;
    
    public Meal() {
    }

    public String getImage() {
        return image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Meal [id=" + id + ", image=" + image + ", name=" + name + ", category=" + category + ", price=" + price
                + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
