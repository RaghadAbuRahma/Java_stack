package com.axsos.beltreview.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
	@Table(name="projects")
	public class Project {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotNull
	    @Size(min = 5, max = 200)
	    private String name;
	   
	    @NotNull
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    @Future(message = "The due date must be in the future")

	    private Date  dueDate;
	    
		@Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
		
		
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
	    
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="project_id")
	    private User lead;
	    
	    @ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(
				name = "users_projects",
				joinColumns = @JoinColumn(name = "project_id"),
				inverseJoinColumns = @JoinColumn(name = "user_id")
)
	    private List<User> users;
	    
	    public Project() {}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Date getDueDate() {
			return dueDate;
		}

		public void setDueDate(Date dueDate) {
			this.dueDate = dueDate;
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

		public User getLead() {
			return lead;
		}

		public void setLead(User lead) {
			this.lead = lead;
		}

		public List<User> getUsers() {
			return users;
		}

		public void setUsers(List<User> users) {
			this.users = users;
		}

	    
	    
	    
	    
	    
		
}
