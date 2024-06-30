package com.axsos.burgertracker.models;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;



@Entity
@Table(name="Burger")
public class Burger {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotBlank
    @Size(min = 5, max = 200)
    private String burger_name;
	@NotBlank
    @Size(min = 5, max = 200)
    private String resturant_name;
	@NotNull
	@Min(1)
    @Max(5)
    private Integer rating;
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    
    
    public Burger() {
    }
    
    public Burger(Long id, String burger_name, String resturant_name, Integer rating ) {
    	this.burger_name = burger_name;
    	this.resturant_name = resturant_name;
    	this.rating = rating;
    	
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBurger_name() {
		return burger_name;
	}
	public void setBurger_name(String burger_name) {
		this.burger_name = burger_name;
	}
	public String getResturant_name() {
		return resturant_name;
	}
	public void setResturant_name(String resturant_name) {
		this.resturant_name = resturant_name;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    
}

