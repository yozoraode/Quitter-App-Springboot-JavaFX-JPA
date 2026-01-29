package com.defranto.QuitterApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProgressController {

	private final ProgressService service;
	
	@Autowired
	public ProgressController(ProgressService service) {
		this.service = service;
	}
	
	@GetMapping("/progress")
	public Progress getProgress() {
		return service.getProgress();
	}
	
	@PutMapping("/progress")
	public void resetProgress() {
		service.resetProgress();
	}
	
	@PutMapping("/progress/stop")
	public void stopProgress() {
		service.stopProgress();
	}
}
