package com.defranto.QuitterApp;

import java.time.LocalDateTime;
import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Progress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private LocalDateTime TimeStarted;
	private LocalDateTime TargetTime1;
	private boolean started;
	
	Progress(){}

	public Progress(Integer id, LocalDateTime timeStarted, LocalDateTime targetTime1, boolean started) {
		super();
		this.Id = id;
		this.TimeStarted = timeStarted;
		this.TargetTime1 = targetTime1;
		this.started = started;
	}
	
	public boolean isStarted() {
		return started;
	}
	
	public void setStarted(boolean started) {
		this.started = started;
	}
	
	public LocalDateTime getTargetTime1() {
		return TargetTime1;
	}

	public void setTargetTime1(LocalDateTime targetTime1) {
		this.TargetTime1 = targetTime1;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public LocalDateTime getTimeStarted() {
		return TimeStarted;
	}

	public void setTimeStarted(LocalDateTime timeStarted) {
		this.TimeStarted = timeStarted;
	}
	
	
	
}
