package com.jroadie.tvprogram.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="categories")
public class Category implements Serializable {
	
	private static final long serialVersionUID = -1776689533889602737L;

	private Integer id;
	private String name;
	private String description;
	
	private Set<Program> programSet;
	
	@Id
	@GeneratedValue
	@Column(name="rid")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy="categorySet")
	public Set<Program> getProgramSet() {
		return programSet;
	}
	public void setProgramSet(Set<Program> programSet) {
		this.programSet = programSet;
	}
	
	@Override
	public int hashCode(){
		return this.getId().hashCode();
	}
	
	@Override
	public boolean equals(Object target) {
		if(target == this) {
			return true;
		}
		if(target == null || target.getClass() != this.getClass()) {
			return false;
		}
		return this.getId() == ((Category) target).getId();
	}
	
}
