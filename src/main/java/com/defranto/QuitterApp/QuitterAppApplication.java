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
	
	@Override
	public void init() throws Exception {
		SpringApplication.run(QuitterAppApplication.class);
	}
	
	@Override
	public void start(Stage stage) { 
		QuitterUI.uiRun(stage);
	}
	
	@Override
	public void stop() {
	    QuitterUI.stopRunning();
	}
	
	public static void main(String[] args) {
		Application.launch(QuitterAppApplication.class,args);
	}

}
