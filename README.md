# Quitter-App-JavaFX-SpringBoot

I made a Quitter App using javaFX and springboot. This is my second springboot project.
I made this to explore concurrency(Threading), spring data, Jakarta persistence API (JPA) and H2 databases.
I didn't use the "var" data type as much as my last project for better clarity.

Steps to run:
- Open Eclipse IDE
- Install the Spring dev tools extension in Eclipse
- Import the project into your workspace (Import existing maven project)
- Right-cick on the project and go to Run as -> Run configurations.
  in the arguments tab, add the VM argument
  --module-path "C:\path\to\javafx25\lib" --add-modules javafx.controls,javafx.graphics,javafx.fxml
- Apply and close
- Right-click on the project and run as Spring Boot App
