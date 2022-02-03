/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashcard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PlayController implements Initializable {

    @FXML
    private Button BackToHome;
    @FXML
    private MenuItem Open;
    @FXML
    private MenuItem Home;
    @FXML
//    Button BackToHome;
//    @FXML
    private MenuItem ExitCard;
    @FXML
    private TextField QuestionCard;
    @FXML
    private Button AnswerCard;
    FileChooser fileChooser = new FileChooser();
    Scanner sc;
    Boolean show;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void OpenAction(ActionEvent event) throws FileNotFoundException {
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {

            sc = new Scanner(file);
            QuestionCard.setText(sc.nextLine());
            show = false;
            AnswerCard.setText("Show Answer");
            AnswerCard.setStyle("-fx-background-color: green");
        }
    }

    @FXML
    private void HomeAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FlashCardInterface.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) BackToHome.getScene().getWindow();
        stage.setTitle("Flash card");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void ExitAction(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    private void QuestionAction(ActionEvent event) {
        
    }

    @FXML
    private void AnswerAction(ActionEvent event) {
        QuestionCard.setText(sc.nextLine());
        show = !show;
        if (show) {
            AnswerCard.setStyle("-fx-background-color: orange");
            AnswerCard.setText("Next");
        } else {
            AnswerCard.setStyle("-fx-background-color: green");
            AnswerCard.setText("Show Answer");
        }
    }

}
