package com.jroadie.tvprogram.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name="programs")
public class Program {
	
	@Id
	@Column(name="rid")
	@GeneratedValue
	private Integer id;
	
	@NotBlank @Pattern(regexp="^[a-zA-Z\\s]*$")
	@Column(name="code")
	private String code;
	
	@NotBlank
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
	@Column(name="start_date_time")
	private Date startDateTime;
	
	@NotNull @NumberFormat
	@Column(name="duration")
	private float duration;
	
	@NotNull
	@Column(name="active_status")
	private Integer activeStatus;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}
	public float getDuration() {
		return duration;
	}
	public void setDuration(float duration) {
		this.duration = duration;
	}
	public Integer getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(Integer activeStatus) {
		this.activeStatus = activeStatus;
	}
	
}
