package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.cell.CheckBoxListCell;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label playerMark1;
    @FXML
    private Button v1h1;
    @FXML
    private Button v1h2;
    @FXML
    private Button v1h3;
    @FXML
    private Button v2h1;
    @FXML
    private Button v2h2;
    @FXML
    private Button v2h3;
    @FXML
    private Button v3h1;
    @FXML
    private Button v3h2;
    @FXML
    private Button v3h3;
    @FXML
    private CheckBox player1CL;
    @FXML
    private CheckBox player2CL;
    @FXML
    private Button resetBtn;



String playerDefault = " ";





    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
    private String player1(){

        return "x";
    }

    public void setMove1(ActionEvent event){


        System.out.println("Hello");
        v1h1.setText(playerDefault);

    }
    public void setMove2(ActionEvent event){

        v1h2.setText(playerDefault);

    }
    public void setMove3(ActionEvent event){

        v1h3.setText(playerDefault);

    }
    public void setMove4(ActionEvent event){

        v2h1.setText(playerDefault);

    }
    public void setMove5(ActionEvent event){

        v2h2.setText(playerDefault);

    }
    public void setMove6(ActionEvent event){

        v2h3.setText(playerDefault);

    }
    public void setMove7(ActionEvent event){

        v3h1.setText(playerDefault);

    }
    public void setMove8(ActionEvent event){

        v3h2.setText(playerDefault);

    }
    public void setMove9(ActionEvent event){

        v3h3.setText(playerDefault);

    }
    public void setPlayer1(ActionEvent event) {


        playerDefault = "X";

          
    }

    public void setPlayer2(ActionEvent event){


        playerDefault = "O";

    }

    public void resetGame(ActionEvent event){

        v1h1.setText("");
        v1h2.setText("");
        v1h3.setText("");
        v2h1.setText("");
        v2h2.setText("");
        v2h3.setText("");
        v3h1.setText("");
        v3h2.setText("");
        v3h3.setText("");
        
    }
}
