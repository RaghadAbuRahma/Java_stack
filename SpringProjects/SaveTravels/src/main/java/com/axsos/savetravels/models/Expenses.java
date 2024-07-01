package com.axsos.savetravels.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="expenses")
public class Expenses {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
    @Size(min = 5, max = 200)
    private String expense_att;
	
    @NotNull
    @Size(min = 5, max = 200)
    private String vendor;
    
    @NotNull
    @Min(0)
    private Double amount;
    
    @Column(updatable=false)
    @NotNull
    @Size(min = 20, max = 200)
    private String description;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    
    public Expenses() {
    }
    
//    public Expenses(String expense, String vendor, double amount, String description) {
//        this.expense= expense;
//        this.vendor = vendor;
//        this.amount = amount;
//        this.description = description;
//    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getExpense_att() {
		return expense_att;
	}

	public void setExpense_att(String expense_att) {
		this.expense_att = expense_att;
	}

	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
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
	  public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	
    
    
}

