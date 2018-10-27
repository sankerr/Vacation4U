package View;

import Controller.Controller;
import Model.IModel;
import Model.Model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import Controller.IController;

public class Main extends Application implements Initializable {

    private IController controller;

    // images
    //public javafx.scene.image.ImageView img_logo;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Model model = new Model();
        //--------------
        primaryStage.setTitle("Vication4U");
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("sample.fxml").openStream());
        Scene scene = new Scene(root, 600, 450);
        primaryStage.setScene(scene);
        root.setStyle("-fx-background-color: white");
        //-------
        Controller controller = fxmlLoader.getController();
        controller.setModel(model);
        model.addObserver(controller);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void initialize(URL location, ResourceBundle resources) {
        Image logo = new Image(Main.class.getClassLoader().getResourceAsStream("logo.jpeg"));
        //img_logo.setImage(logo);
    }
}