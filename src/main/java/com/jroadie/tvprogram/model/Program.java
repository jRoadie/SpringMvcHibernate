package com.jroadie.tvprogram.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="programs")
public class Program {
	
	@Id
	@GeneratedValue
	@Column(name="rid")
	private Integer id;
	
	@NotNull @Size(max=20, min=1) 
	@Pattern(regexp="^[a-zA-Z0-9]*$")
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
	
	@NotNull @Min((long) Float.MIN_VALUE) @Max((long) Float.MAX_VALUE)
	@Column(name="duration")
	private Float duration;
	
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
	public Float getDuration() {
		return duration;
	}
	public void setDuration(Float duration) {
		this.duration = duration;
	}
	public Integer getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(Integer activeStatus) {
		this.activeStatus = activeStatus;
	}
	
}
