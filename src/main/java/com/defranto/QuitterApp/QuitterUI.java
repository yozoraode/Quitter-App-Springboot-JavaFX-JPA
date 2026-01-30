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

	// Targets
	private static long target1;
	private static AtomicInteger secondsTarget1;

	private static long target2;
	private static AtomicInteger secondsTarget2;

	private static long target3;
	private static AtomicInteger secondsTarget3;

	private static long target4;
	private static AtomicInteger secondsTarget4;

	private static long target5;
	private static AtomicInteger secondsTarget5;

	private static long target6;
	private static AtomicInteger secondsTarget6;

	private static long target7;
	private static AtomicInteger secondsTarget7;

	// ProgressBar task #1 (1 minute)

	private static Service<Void> barTask1 = new Service<>() {
		@Override
		protected Task<Void> createTask() {
			return new Task<>() {
				@Override
				public Void call() {
					if (secondsSober.get() < secondsTarget1.get()) {
						while (secondsSober.get() < secondsTarget1.get() && !isCancelled()) {

							if (!isRunning) {
								break;
							}
							updateProgress(secondsSober.get(), secondsTarget1.get());
							try {
								// System.out.println("Running");
								// secondsSober.addAndGet(1);
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// System.out.println("Interrupted");
							}
						}
					} else {
						updateProgress(100, 100);
					}
					return null;
				}
			};

		}
	};
	// ProgressBar task #2 (10 minute)

	private static Service<Void> barTask2 = new Service<>() {
		@Override
		protected Task<Void> createTask() {
			return new Task<>() {
				@Override
				public Void call() {
					if (secondsSober.get() < secondsTarget2.get()) {
						while (secondsSober.get() < secondsTarget2.get() && !isCancelled()) {

							if (!isRunning) {
								break;
							}
							updateProgress(secondsSober.get(), secondsTarget2.get());
							try {
								// System.out.println("Running");
								// secondsSober.addAndGet(1);
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// System.out.println("Interrupted");
							}
						}
					} else {
						updateProgress(100, 100);
					}
					return null;
				}
			};

		}
	};

	// ProgressBar task #3 (1 hour)

	private static Service<Void> barTask3 = new Service<>() {
		@Override
		protected Task<Void> createTask() {
			return new Task<>() {
				@Override
				public Void call() {
					if (secondsSober.get() < secondsTarget3.get()) {
						while (secondsSober.get() < secondsTarget3.get() && !isCancelled()) {

							if (!isRunning) {
								break;
							}
							updateProgress(secondsSober.get(), secondsTarget3.get());
							try {
								// System.out.println("Running");
								// secondsSober.addAndGet(1);
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// System.out.println("Interrupted");
							}
						}
					} else {
						updateProgress(100, 100);
					}
					return null;
				}
			};

		}
	};

	// ProgressBar task #4 (10 hours)

	private static Service<Void> barTask4 = new Service<>() {
		@Override
		protected Task<Void> createTask() {
			return new Task<>() {
				@Override
				public Void call() {
					if (secondsSober.get() < secondsTarget4.get()) {
						while (secondsSober.get() < secondsTarget4.get() && !isCancelled()) {

							if (!isRunning) {
								break;
							}
							updateProgress(secondsSober.get(), secondsTarget4.get());
							try {
								// System.out.println("Running");
								// secondsSober.addAndGet(1);
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// System.out.println("Interrupted");
							}
						}
					} else {
						updateProgress(100, 100);
					}
					return null;
				}
			};

		}
	};

	// ProgressBar task #5 (1 day)

	private static Service<Void> barTask5 = new Service<>() {
		@Override
		protected Task<Void> createTask() {
			return new Task<>() {
				@Override
				public Void call() {
					if (secondsSober.get() < secondsTarget5.get()) {
						while (secondsSober.get() < secondsTarget5.get() && !isCancelled()) {

							if (!isRunning) {
								break;
							}
							updateProgress(secondsSober.get(), secondsTarget5.get());
							try {
								// System.out.println("Running");
								// secondsSober.addAndGet(1);
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// System.out.println("Interrupted");
							}
						}
					} else {
						updateProgress(100, 100);
					}
					return null;
				}
			};

		}
	};

	// ProgressBar task #6 (10 days)

	private static Service<Void> barTask6 = new Service<>() {
		@Override
		protected Task<Void> createTask() {
			return new Task<>() {
				@Override
				public Void call() {
					if (secondsSober.get() < secondsTarget6.get()) {
						while (secondsSober.get() < secondsTarget6.get() && !isCancelled()) {

							if (!isRunning) {
								break;
							}
							updateProgress(secondsSober.get(), secondsTarget6.get());
							try {
								// System.out.println("Running");
								// secondsSober.addAndGet(1);
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// System.out.println("Interrupted");
							}
						}
					} else {
						updateProgress(100, 100);
					}
					return null;
				}
			};

		}
	};

	// ProgressBar task #7 (100 days)

	private static Service<Void> barTask7 = new Service<>() {
		@Override
		protected Task<Void> createTask() {
			return new Task<>() {
				@Override
				public Void call() {
					if (secondsSober.get() < secondsTarget7.get()) {
						while (secondsSober.get() < secondsTarget7.get() && !isCancelled()) {

							if (!isRunning) {
								break;
							}
							updateProgress(secondsSober.get(), secondsTarget7.get());
							try {
								// System.out.println("Running");
								secondsSober.addAndGet(1);
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// System.out.println("Interrupted");
							}
						}
					} else {
						updateProgress(100, 100);
					}
					return null;
				}
			};

		}
	};

	@Autowired
	public QuitterUI(ProgressController controlla) {
		controller = controlla;
	}

	public static void stopRunning() {
		isRunning = false;
	}

	public static void setupProgress() {
		progress = Duration.between(controller.getProgress().getTimeStarted(), LocalDateTime.now()).getSeconds();
		secondsSober = new AtomicInteger((int) progress);
	}

	// For setting up the progress bars

	public static void setupProgressBar1() {
		target1 = Duration.between(controller.getProgress().getTimeStarted(), controller.getProgress().getTargetTime1())
				.getSeconds();
		secondsTarget1 = new AtomicInteger((int) target1);
	}

	public static void setupProgressBar2() {
		target2 = Duration.between(controller.getProgress().getTimeStarted(), controller.getProgress().getTargetTime2())
				.getSeconds();
		secondsTarget2 = new AtomicInteger((int) target2);
	}

	public static void setupProgressBar3() {
		target3 = Duration.between(controller.getProgress().getTimeStarted(), controller.getProgress().getTargetTime3())
				.getSeconds();
		secondsTarget3 = new AtomicInteger((int) target3);
	}

	public static void setupProgressBar4() {
		target4 = Duration.between(controller.getProgress().getTimeStarted(), controller.getProgress().getTargetTime4())
				.getSeconds();
		secondsTarget4 = new AtomicInteger((int) target4);
	}

	public static void setupProgressBar5() {
		target5 = Duration.between(controller.getProgress().getTimeStarted(), controller.getProgress().getTargetTime5())
				.getSeconds();
		secondsTarget5 = new AtomicInteger((int) target5);
	}

	public static void setupProgressBar6() {
		target6 = Duration.between(controller.getProgress().getTimeStarted(), controller.getProgress().getTargetTime6())
				.getSeconds();
		secondsTarget6 = new AtomicInteger((int) target6);
	}

	public static void setupProgressBar7() {
		target7 = Duration.between(controller.getProgress().getTimeStarted(), controller.getProgress().getTargetTime7())
				.getSeconds();
		secondsTarget7 = new AtomicInteger((int) target7);
	}

	public static void uiRun(Stage stage) {

		// Clock
		Task clock = new Task<Void>() {
			@Override
			public Void call() {
				while (isRunning) {

					updateMessage(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd\n\nHH:mm:ss")));

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {

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

		// Main Menu (kind of)
		Button quitButton = new Button("Quit Smoking Now");

		Button relapseButton = new Button("Relapse");

		HBox buttonRow = new HBox(10);

		// the individual progress bars
		HBox barRow1 = new HBox();
		HBox barRow2 = new HBox();
		HBox barRow3 = new HBox();
		HBox barRow4 = new HBox();
		HBox barRow5 = new HBox();
		HBox barRow6 = new HBox();
		HBox barRow7 = new HBox();

		ProgressBar bar1 = new ProgressBar();
		ProgressBar bar2 = new ProgressBar();
		ProgressBar bar3 = new ProgressBar();
		ProgressBar bar4 = new ProgressBar();
		ProgressBar bar5 = new ProgressBar();
		ProgressBar bar6 = new ProgressBar();
		ProgressBar bar7 = new ProgressBar();

		// Bar row1 (bar + message)
		Label statusLabel1 = new Label("	1 minute without smoking");
		Label statusLabel2 = new Label("	10 minutes without smoking");
		Label statusLabel3 = new Label("	1 hour without smoking");
		Label statusLabel4 = new Label("	10 hours without smoking");
		Label statusLabel5 = new Label("	1 day without smoking");
		Label statusLabel6 = new Label("	10 days without smoking");
		Label statusLabel7 = new Label("	100 days without smoking");

		barRow1.getChildren().addAll(bar1, statusLabel1);
		barRow2.getChildren().addAll(bar2, statusLabel2);
		barRow3.getChildren().addAll(bar3, statusLabel3);
		barRow4.getChildren().addAll(bar4, statusLabel4);
		barRow5.getChildren().addAll(bar5, statusLabel5);
		barRow6.getChildren().addAll(bar6, statusLabel6);
		barRow7.getChildren().addAll(bar7, statusLabel7);

		// all progress bars
		VBox barRows = new VBox();
		barRows.setPadding(new Insets(20, 20, 20, 20));

		// Bar rows
		barRows.getChildren().addAll(barRow1);
		barRows.getChildren().addAll(barRow2);
		barRows.getChildren().addAll(barRow3);
		barRows.getChildren().addAll(barRow4);
		barRows.getChildren().addAll(barRow5);
		barRows.getChildren().addAll(barRow6);
		barRows.getChildren().addAll(barRow7);

		// Start State 1 (Hasn't started quitting)
		if (!controller.getProgress().isStarted()) {
			buttonRow.getChildren().add(quitButton);
		} else {// Start State 2 (Has started quitting)
			buttonRow.getChildren().add(relapseButton);

			QuitterUI.setupProgress();
			QuitterUI.setupProgressBar1();
			QuitterUI.setupProgressBar2();
			QuitterUI.setupProgressBar3();
			QuitterUI.setupProgressBar4();
			QuitterUI.setupProgressBar5();
			QuitterUI.setupProgressBar6();
			QuitterUI.setupProgressBar7();

			barTask1.restart();
			barTask2.restart();
			barTask3.restart();
			barTask4.restart();
			barTask5.restart();
			barTask6.restart();
			barTask7.restart();

			bar1.progressProperty().bind(barTask1.progressProperty());
			bar2.progressProperty().bind(barTask2.progressProperty());
			bar3.progressProperty().bind(barTask3.progressProperty());
			bar4.progressProperty().bind(barTask4.progressProperty());
			bar5.progressProperty().bind(barTask5.progressProperty());
			bar6.progressProperty().bind(barTask6.progressProperty());
			bar7.progressProperty().bind(barTask7.progressProperty());
		}

		// The quit button creates a progress bar. The relapse button makes it go away
		// and resets the tasks
		quitButton.setOnAction(e -> {

			buttonRow.getChildren().clear();

			controller.resetProgress();

			QuitterUI.setupProgress();
			QuitterUI.setupProgressBar1();
			QuitterUI.setupProgressBar2();
			QuitterUI.setupProgressBar3();
			QuitterUI.setupProgressBar4();
			QuitterUI.setupProgressBar5();
			QuitterUI.setupProgressBar6();
			QuitterUI.setupProgressBar7();

			barTask1.restart();
			barTask2.restart();
			barTask3.restart();
			barTask4.restart();
			barTask5.restart();
			barTask6.restart();
			barTask7.restart();

			bar1.progressProperty().bind(barTask1.progressProperty());
			bar2.progressProperty().bind(barTask2.progressProperty());
			bar3.progressProperty().bind(barTask3.progressProperty());
			bar4.progressProperty().bind(barTask4.progressProperty());
			bar5.progressProperty().bind(barTask5.progressProperty());
			bar6.progressProperty().bind(barTask6.progressProperty());
			bar7.progressProperty().bind(barTask7.progressProperty());
//			Thread barThread1 = new Thread(barTask1);
//			barThread1.setDaemon(true);
//			barThread1.start();

			buttonRow.getChildren().add(relapseButton);
		});

		relapseButton.setOnAction(f -> {

			controller.stopProgress();

			// reset bar 1
			barTask1.cancel();
			bar1.progressProperty().unbind();
			bar1.setProgress(0);
			// secondsSober.set(0);

			// reset bar 2
			barTask2.cancel();
			bar2.progressProperty().unbind();
			bar2.setProgress(0);
			// secondsSober.set(0);

			// reset bar 3
			barTask3.cancel();
			bar3.progressProperty().unbind();
			bar3.setProgress(0);
			// secondsSober.set(0);

			// reset bar 4
			barTask4.cancel();
			bar4.progressProperty().unbind();
			bar4.setProgress(0);
			// secondsSober.set(0);

			// reset bar 5
			barTask5.cancel();
			bar5.progressProperty().unbind();
			bar5.setProgress(0);
			// secondsSober.set(0);

			// reset bar 6
			barTask6.cancel();
			bar6.progressProperty().unbind();
			bar6.setProgress(0);
			// secondsSober.set(0);

			// reset bar 7
			barTask7.cancel();
			bar7.progressProperty().unbind();
			bar7.setProgress(0);
			secondsSober.set(0);
			
			buttonRow.getChildren().clear();
			buttonRow.getChildren().add(quitButton);

		});

		barTask1.setOnSucceeded(g -> {
			statusLabel1.setText("	1 minute smoke-free! Good Job! Take a deep breath...");
		});

		barTask2.setOnSucceeded(h -> {
			statusLabel2.setText("	10 minute smoke-free! Heart Rate improves...");
		});

		barTask3.setOnSucceeded(i -> {
			statusLabel3.setText("	1 hour smoke-free! Good Job!");
		});

		barTask4.setOnSucceeded(j -> {
			statusLabel4.setText("	10 hour smoke-free! Carbon Monoxide in your bloodstream has been reduced by half!");
		});

		barTask5.setOnSucceeded(k -> {
			statusLabel5.setText("	1 day smoke-free! More Oxygen in your lungs and tissues!");
		});

		barTask6.setOnSucceeded(l -> {
			statusLabel6.setText("	10 days smoke-free! Your body no longer craves nicotine! Keep it up!");
		});

		barTask7.setOnSucceeded(m -> {
			statusLabel7.setText("	100 DAYS SMOKE-FREE!");
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
