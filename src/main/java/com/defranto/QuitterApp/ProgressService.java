package com.defranto.QuitterApp;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class ProgressService {
	
	private final ProgressRepository repo;
	
	@Autowired
	public ProgressService(ProgressRepository repo) {
		this.repo = repo;
	}
	
	public Progress getProgress(){
		return repo.findById(1).orElseThrow(() -> new RuntimeException("entry not found"));
	}
	
	public void resetProgress() {
		try {
			Progress progress = repo.findById(1).orElseThrow(() -> new RuntimeException("entry not found"));
			
			progress.setTimeStarted(LocalDateTime.now());
			
			progress.setTargetTime1(LocalDateTime.now().plusMinutes(1));
			
			progress.setTargetTime2(LocalDateTime.now().plusMinutes(10));
			
			progress.setTargetTime3(LocalDateTime.now().plusHours(1));
			
			progress.setTargetTime4(LocalDateTime.now().plusHours(10));
			
			progress.setTargetTime5(LocalDateTime.now().plusDays(1));
			
			progress.setTargetTime6(LocalDateTime.now().plusDays(10));
			
			progress.setTargetTime7(LocalDateTime.now().plusDays(100));
			
			progress.setStarted(true);
			
			repo.save(progress);
		}
		catch (Exception e){
			System.out.println("Something went wrong");
		}
	}
	
	public void stopProgress() {
		try {
			Progress progress = repo.findById(1).orElseThrow(() -> new RuntimeException("entry not found"));
			
			progress.setStarted(false);
			
			repo.save(progress);
		}
		catch (Exception e){
			System.out.println("Something went wrong");
		}
	}
}
