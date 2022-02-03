/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashcard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
public class CreateController implements Initializable {

    @FXML
    private Button NextCard;
    @FXML
    private TextField QuestionCard;
    @FXML
    private TextField AnswerCard;
    @FXML
    private MenuItem Save;
    @FXML
    private MenuItem Home;
    @FXML
    Button BackToHome;
    @FXML
    private MenuItem ExitCard;

    Stack<String> question_list = new Stack<String>();
    Stack<String> answer_list = new Stack<String>();

    FileChooser fileChooser = new FileChooser();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void NextAction(ActionEvent event) {
        question_list.push(QuestionCard.getText());
        answer_list.push(AnswerCard.getText());
        AnswerCard.setText("");
        QuestionCard.setText("");
    }

    @FXML
    void SaveAction(ActionEvent event) {
        File file = fileChooser.showSaveDialog(new Stage());

        if (file != null) {
            Object[] val1 = question_list.toArray();
            Object[] val2 = answer_list.toArray();

            try {
                PrintWriter printWriter = new PrintWriter(file);
                for (int i = 0; i < val1.length; i++) {
                    printWriter.write(val1[i].toString() + "\n");
                    printWriter.write(val2[i].toString() + "\n");
                }
                printWriter.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

    }

    @FXML
    void HomeAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FlashCardInterface.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) BackToHome.getScene().getWindow();
        stage.setTitle("Flash card");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void ExitAction(ActionEvent event) {
        Platform.exit();
        System.exit(0);

    }

    @FXML
    private void QuestionAction(ActionEvent event) {
    }

    @FXML
    private void AnswerAction(ActionEvent event) {
    }

}
