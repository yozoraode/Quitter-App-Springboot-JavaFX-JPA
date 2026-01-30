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
	private LocalDateTime TargetTime1;//1 minute
	private LocalDateTime TargetTime2;//10 minutes
	private LocalDateTime TargetTime3;//1 hours
	private LocalDateTime TargetTime4;//10 hours
	private LocalDateTime TargetTime5;//1 day
	private LocalDateTime TargetTime6;//10 days
	private LocalDateTime TargetTime7;//100 days
	private boolean started;
	
	Progress(){}
	
	public Progress(Integer id, LocalDateTime timeStarted, LocalDateTime targetTime1, LocalDateTime targetTime2,
			LocalDateTime targetTime3, LocalDateTime targetTime4, LocalDateTime targetTime5, LocalDateTime targetTime6,
			LocalDateTime targetTime7, boolean started) {
		super();
		Id = id;
		TimeStarted = timeStarted;
		TargetTime1 = targetTime1;
		TargetTime2 = targetTime2;
		TargetTime3 = targetTime3;
		TargetTime4 = targetTime4;
		TargetTime5 = targetTime5;
		TargetTime6 = targetTime6;
		TargetTime7 = targetTime7;
		this.started = started;
	}
	
	public LocalDateTime getTargetTime2() {
		return TargetTime2;
	}

	public void setTargetTime2(LocalDateTime targetTime2) {
		this.TargetTime2 = targetTime2;
	}

	public boolean isStarted() {
		return started;
	}

	public LocalDateTime getTargetTime3() {
		return TargetTime3;
	}

	public void setTargetTime3(LocalDateTime targetTime3) {
		this.TargetTime3 = targetTime3;
	}

	public LocalDateTime getTargetTime4() {
		return TargetTime4;
	}

	public void setTargetTime4(LocalDateTime targetTime4) {
		this.TargetTime4 = targetTime4;
	}

	public LocalDateTime getTargetTime5() {
		return TargetTime5;
	}

	public void setTargetTime5(LocalDateTime targetTime5) {
		this.TargetTime5 = targetTime5;
	}

	public LocalDateTime getTargetTime6() {
		return TargetTime6;
	}

	public void setTargetTime6(LocalDateTime targetTime6) {
		this.TargetTime6 = targetTime6;
	}

	public LocalDateTime getTargetTime7() {
		return TargetTime7;
	}

	public void setTargetTime7(LocalDateTime targetTime7) {
		this.TargetTime7 = targetTime7;
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
		this.Id = id;
	}

	public LocalDateTime getTimeStarted() {
		return TimeStarted;
	}

	public void setTimeStarted(LocalDateTime timeStarted) {
		this.TimeStarted = timeStarted;
	}
	
	
	
}
