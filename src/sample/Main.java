package sample;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("interfaceJavaFx.fxml").openStream());
        primaryStage.setTitle("Hello World");

        primaryStage.setScene(new Scene(root, 400, 350));
        primaryStage.show();
        Reciver.doreciver(loader.getController());
    }



    public static void main(String[] args) {
        launch(args);
    }
}
