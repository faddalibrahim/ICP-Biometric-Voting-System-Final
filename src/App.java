import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * @author Faddal Ibrahim
 * @author Excel Chukwu
 * class:App
 * Accessibility Modifier:public
 *
 * serves as launching pad for JavaFXApp
 */
public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("./view/login.fxml"));
            Scene scene = new Scene(root);
            //scene.getStylesheets().add("styles.css");

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}