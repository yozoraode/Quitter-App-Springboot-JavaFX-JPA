package com.defranto.QuitterApp;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@SpringBootApplication
public class QuitterAppApplication extends Application {

	static boolean isRunning = true;
	
	@Override
	public void init() throws Exception {
		SpringApplication.run(QuitterAppApplication.class);
	}
	
	@Override
	public void start(Stage stage) { 
		
		AtomicInteger secondsSober = new AtomicInteger(0);
		
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

		
		Button quitButton = new Button("Quit Smoking Now");
		
		Button relapseButton = new Button("Relapse");
		
		HBox buttonRow = new HBox(10);
		
		buttonRow.getChildren().add(quitButton);
		
		HBox barRow1 = new HBox();
		HBox barRow2 = new HBox();
		HBox barRow3 = new HBox();
		HBox barRow4 = new HBox();
		HBox barRow5 = new HBox();
		HBox barRow6 = new HBox();
		HBox barRow7 = new HBox();
		HBox barRow8 = new HBox();
		HBox barRow9 = new HBox();
		HBox barRow10 = new HBox();
		
		VBox barRows = new VBox();
		
		ProgressBar bar1 = new ProgressBar();//1 minute
		ProgressBar bar2 = new ProgressBar();//10 minutes
		ProgressBar bar3 = new ProgressBar();//20 minutes
		ProgressBar bar4 = new ProgressBar();//2 hours
		ProgressBar bar5 = new ProgressBar();//12 hours
		ProgressBar bar6 = new ProgressBar();//1 day
		ProgressBar bar7 = new ProgressBar();//2 weeks
		ProgressBar bar8 = new ProgressBar();//1 month
		ProgressBar bar9 = new ProgressBar();//3 months
		ProgressBar bar10 = new ProgressBar();//1 year
		
		LocalDateTime currentTime = LocalDateTime.now();
		
		//Targets
        LocalDateTime targetTime1 = currentTime.plusMinutes(1);
        
        long oneMinutesInSeconds = Duration.between(currentTime, targetTime1).getSeconds();
		
		//The quit button creates a progress bar. The relapse button makes it go away and resets it
		quitButton.setOnAction(e -> {
			
			buttonRow.getChildren().clear();
			
			//ProgressBar #1 (1 minute)
			Task barTask1 = new Task<Void>() {
			    @Override 
			    public Void call() {
			        
			        while (secondsSober.get() < oneMinutesInSeconds && !isCancelled()) {
			        	
			        	LocalDateTime progress = currentTime;
			        	
			            if (!isRunning) {
			               break;
			            }
			            updateProgress(secondsSober.get(), oneMinutesInSeconds);
			        	try {
			        		System.out.println("Running");
			        		secondsSober.addAndGet(1);
			        		Thread.sleep(1000);
			        	}
			        	catch (InterruptedException e) {
			        		//System.out.println("Interrupted");
			        	}
			        }
			        return null;
			    }
			};
			
			System.out.println("Running");
			
			bar1.progressProperty().bind(barTask1.progressProperty());
			Thread barThread1 = new Thread(barTask1);
			barThread1.setDaemon(true);
			barThread1.start();
			
			//bar 2
			
			
			buttonRow.getChildren().add(relapseButton);
			
			//Bar row1 (bar + message)
			Label statusLabel1 = new Label("	1 minute without smoking");
			
			barRow1.getChildren().addAll(bar1, statusLabel1);
			
			barTask1.setOnSucceeded(g -> {
			    statusLabel1.setText("	1 minute smoke-free! Good Job! Take a deep breath...");
			});
			
			//Bar rows
			barRows.getChildren().addAll(barRow1);
			
			relapseButton.setOnAction(f -> {
				
				//reset bar 1
				barTask1.cancel();
				bar1.progressProperty().unbind();
				bar1.setProgress(0);
				secondsSober.set(0);
				barRow1.getChildren().clear();
				
				//reset bar 2
				
				barRows.getChildren().clear();
				buttonRow.getChildren().clear();
				buttonRow.getChildren().add(quitButton);
				
			});
			
		});
		
		var root = new VBox(10);
		root.getChildren().addAll(clockLabel, buttonRow, barRows);
		root.setPadding(new Insets(20, 20, 20, 20));
		
		var scene = new Scene(root, 400, 400);
		stage.setTitle("Springboot + JavaFX + JPA Quitter App");
		stage.setScene(scene);
		stage.show();
		
	}
	
	@Override
	public void stop() {
	    isRunning = false;
	}
	
	public static void main(String[] args) {
		Application.launch(QuitterAppApplication.class,args);
	}

}
