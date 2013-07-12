package com.jroadie.tvprogram.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="programs")
public class Program implements Serializable {
	
	private static final long serialVersionUID = 6853244535344848449L;
	
	private Integer id;
	private String code;
	private String title;
	private String description;
	private Integer activeStatus;
	
	private Set<Schedule> scheduleSet;
	
	@Id
	@GeneratedValue
	@Column(name="rid")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name="title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="active_status")
	public Integer getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(Integer activeStatus) {
		this.activeStatus = activeStatus;
	}
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="program")
	public Set<Schedule> getScheduleSet() {
		return scheduleSet;
	}
	public void setScheduleSet(Set<Schedule> scheduleSet) {
		this.scheduleSet = scheduleSet;
	}
	
}
