/* Digital creation of vintage Casio M1 calculator.
Use scan of original calculator as background.
Buttons recreated in JavaFX Scene Builder with button logic, and PNG image as overlay to replicate original look.
Display recreated with new font in FontForge, and layed out in Scene Builder, styled with external CSS file.
 */

package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/calculator.fxml"));
        Scene scene = new Scene(root);

        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    public static void main (String[] args) {

        launch(args);
    }
}
