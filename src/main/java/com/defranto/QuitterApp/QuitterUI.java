package com.defranto.QuitterApp;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@Component
public class QuitterUI {
	
	private static ProgressController controller;
	private static boolean isRunning = true;
	
	private static long progress;
	private static AtomicInteger secondsSober;
	
	private static long target1;
	private static AtomicInteger secondsTarget1;
	
	//ProgressBar #1 (1 minute)
	
	private static Service<Void> barTask1 = new Service<>() {
				@Override
				protected Task<Void> createTask(){
					return new Task<>() {
						@Override 
					    public Void call() {
					        if(secondsSober.get() < secondsTarget1.get()) {
					        	while (secondsSober.get() < secondsTarget1.get() && !isCancelled()) {
						        	
						            if (!isRunning) {
						               break;
						            }
						            updateProgress(secondsSober.get(), secondsTarget1.get());
						        	try {
						        		//System.out.println("Running");
						        		secondsSober.addAndGet(1);
						        		Thread.sleep(1000);
						        	}
						        	catch (InterruptedException e) {
						        		//System.out.println("Interrupted");
						        	}
						        }
					        }
					        else {
					        	updateProgress(100, 100);
					        }
					        return null;
						}
					};
			    
			    }
			};
	
	@Autowired
	public QuitterUI (ProgressController controlla) {
		controller = controlla;
	}
	
	public static void stopRunning() {
		isRunning = false;
	}
	
	public static void setupProgress() {
		progress = Duration.between(controller.getProgress().getTimeStarted(),LocalDateTime.now()).getSeconds();
		secondsSober = new AtomicInteger((int) progress);
	}
	
	public static void setupProgressBar1() {
		target1 = Duration.between(controller.getProgress().getTimeStarted(), controller.getProgress().getTargetTime1()).getSeconds();
		secondsTarget1 = new AtomicInteger((int) target1);
	}
	
	public static void uiRun(Stage stage) {
		
		//Clock
		Task clock = new Task<Void>() {
		    @Override 
		    public Void call(){
		        while(isRunning) {
		        	
		        	updateMessage(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd\n\nHH:mm:ss")));

		        	try {
		        		Thread.sleep(1000);
		        	}
		        	catch (InterruptedException e) {
		        		
		        	}
		        }
		        return null;
		    }
		};
		
		Label clockLabel = new Label();
		clockLabel.textProperty().bind(clock.messageProperty());
		Thread clockThread = new Thread(clock);
		clockThread.setDaemon(true);
		clockThread.start();

		//Main Menu (kind of)
		Button quitButton = new Button("Quit Smoking Now");
		
		Button relapseButton = new Button("Relapse");
		
		HBox buttonRow = new HBox(10);
		
		//the individual progress bars
		HBox barRow1 = new HBox();
		
		ProgressBar bar1 = new ProgressBar();
		
		//Bar row1 (bar + message)
		Label statusLabel1 = new Label("	1 minute without smoking");
		
		barRow1.getChildren().addAll(bar1, statusLabel1);
		
		//all progress bars
		VBox barRows = new VBox();
		
		//Bar rows
		barRows.getChildren().addAll(barRow1);
		
		//Start State 1 (Hasn't started quitting)
		if(!controller.getProgress().isStarted()) {
			buttonRow.getChildren().add(quitButton);
		}
		else {//Start State 2 (Has started quitting)
			buttonRow.getChildren().add(relapseButton);
			QuitterUI.setupProgress();
			QuitterUI.setupProgressBar1();
			barTask1.restart();
			bar1.progressProperty().bind(barTask1.progressProperty());
		}
		
		//The quit button creates a progress bar. The relapse button makes it go away and resets the tasks
		quitButton.setOnAction(e -> {
			
			buttonRow.getChildren().clear();
			
			controller.resetProgress();
			
			QuitterUI.setupProgress();
			QuitterUI.setupProgressBar1();
			
			barTask1.restart();
			
			bar1.progressProperty().bind(barTask1.progressProperty());
//			Thread barThread1 = new Thread(barTask1);
//			barThread1.setDaemon(true);
//			barThread1.start();
			
			barTask1.setOnSucceeded(g -> {
			    statusLabel1.setText("	1 minute smoke-free! Good Job! Take a deep breath...");
			});
			
			buttonRow.getChildren().add(relapseButton);
		});
		
		relapseButton.setOnAction(f -> {
			
			controller.stopProgress();
			//reset bar 1
			barTask1.cancel();
			bar1.progressProperty().unbind();
			bar1.setProgress(0);
			secondsSober.set(0);
			
			buttonRow.getChildren().clear();
			buttonRow.getChildren().add(quitButton);
			
		});
		
		var root = new VBox(10);
		root.getChildren().addAll(clockLabel, buttonRow, barRows);
		root.setPadding(new Insets(20, 20, 20, 20));
		
		var scene = new Scene(root, 600, 400);
		stage.setTitle("Springboot + JavaFX + JPA Quitter App");
		stage.setScene(scene);
		stage.show();
	}
}
