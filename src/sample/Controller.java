package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.cell.CheckBoxListCell;


import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
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
    @FXML
    private  Button upload;
    @FXML
    private  Button save;
    @FXML
    private Label msg;



String playerDefault = " ";

Players play = new Players();
Fields  field = new Fields();

    Map<Integer, String> move = new HashMap<Integer, String>();






    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }





    public void setMove1(ActionEvent event){

        field.setFieldId(1);
        v1h1.setText(play.getPleyer());
        move.put( field.getFieldId(),play.getPleyer());

        System.out.println(move);

        isAWinner();

    }
    public void setMove2(ActionEvent event){

        field.setFieldId(2);
        v1h2.setText(play.getPleyer());
        move.put(field.getFieldId(), play.getPleyer());
        System.out.println(move);
        isAWinner();


    }
    public void setMove3(ActionEvent event){
        field.setFieldId(3);
        v1h3.setText(play.getPleyer());
        move.put(field.getFieldId(), play.getPleyer());
        isAWinner();

    }
    public void setMove4(ActionEvent event){
        field.setFieldId(4);
        v2h1.setText(play.getPleyer());
        move.put(field.getFieldId(), play.getPleyer());
        isAWinner();

    }
    public void setMove5(ActionEvent event){
        field.setFieldId(5);
        v2h2.setText(play.getPleyer());
        move.put(field.getFieldId(), play.getPleyer());
        isAWinner();

    }
    public void setMove6(ActionEvent event){
        field.setFieldId(6);
        v2h3.setText(play.getPleyer());
        move.put(field.getFieldId(), play.getPleyer());
        isAWinner();

    }
    public void setMove7(ActionEvent event){
        field.setFieldId(7);
        v3h1.setText(play.getPleyer());
        move.put(field.getFieldId(), play.getPleyer());
        isAWinner();

    }
    public void setMove8(ActionEvent event){
        field.setFieldId(8);
        v3h2.setText(play.getPleyer());
        move.put(field.getFieldId(), play.getPleyer());
        isAWinner();

    }
    public void setMove9(ActionEvent event){
        field.setFieldId(9);
        v3h3.setText(play.getPleyer());
        move.put(field.getFieldId(), play.getPleyer());
        isAWinner();

    }
    public void setPlayer1(ActionEvent event) {


        play.setPleyer("X");

    }

    public void setPlayer2(ActionEvent event){

        play.setPleyer("O");

    }
    public void uploadgame(ActionEvent event) {

        HashMap<Integer, String> move = null;
        try {
            FileInputStream loadGame = new FileInputStream("hashMapFile.txt");
            ObjectInputStream readGame = new ObjectInputStream(loadGame);
            move = (HashMap) readGame.readObject();
            readGame.close();
            loadGame.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

            v1h1.setText(move.get(1));
            v1h2.setText(move.get(2));
            v1h3.setText(move.get(3));
            v2h1.setText(move.get(4));
            v2h2.setText(move.get(5));
            v2h3.setText(move.get(6));
            v3h1.setText(move.get(7));
            v3h2.setText(move.get(8));
            v3h3.setText(move.get(9));
        System.out.println("Load game from file");


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
        move.clear();
        msg.setText("");
        
    }
    public void saveToFile(ActionEvent event) {
        try
        {
            FileOutputStream moveReg = new FileOutputStream("hashMapFile.txt");
            ObjectOutputStream saveGame = new ObjectOutputStream(moveReg);
            saveGame.writeObject(move);
            saveGame.close();
            moveReg.close();
            System.out.println(" Data is saved in file");
        }catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    public void isAWinner() {
        if (move.containsKey(1) && move.containsKey(2) && move.containsKey(3)) {

            if (move.get(1).equals(move.get(2)) && move.get(1).equals(move.get(3))) {

            msg.setText("We Got a Winner Player " + move.get(1) + " Won");

            }
        }
        if (move.containsKey(4) && move.containsKey(5) && move.containsKey(6)) {

            if (move.get(4).equals(move.get(5)) && move.get(4).equals(move.get(6))) {

                msg.setText("We Got a Winner Player " + move.get(5)+" Won");

            }
            
        }

        if (move.containsKey(7) && move.containsKey(8) && move.containsKey(9)) {

            if (move.get(7).equals(move.get(8)) && move.get(7).equals(move.get(9))) {

                msg.setText("We Got a Winner Player " + move.get(7) + " Won");
            }
        }
        if (move.containsKey(1) && move.containsKey(5) && move.containsKey(9)) {

            if (move.get(1).equals(move.get(5)) && move.get(1).equals(move.get(9))) {

                msg.setText("We Got a Winner Player " + move.get(1)+" Won");
            }
        }
        if (move.containsKey(3) && move.containsKey(5) && move.containsKey(7)) {

            if (move.get(7).equals(move.get(3)) && move.get(7).equals(move.get(5))) {

                msg.setText("We Got a Winner Player " + move.get(3)+" Won");
            }
        }
        if (move.containsKey(1) && move.containsKey(4) && move.containsKey(7)) {

            if (move.get(7).equals(move.get(4)) && move.get(7).equals(move.get(1))) {

                msg.setText("We Got a Winner Player " + move.get(1)+" Won");
            }
        }
        if (move.containsKey(2) && move.containsKey(5) && move.containsKey(8)) {

            if (move.get(2).equals(move.get(8)) && move.get(8).equals(move.get(5))) {

                msg.setText("We Got a Winner Player " + move.get(2)+" Won");
            }
        }
        if (move.containsKey(3) && move.containsKey(6) && move.containsKey(9)) {

            if (move.get(3).equals(move.get(6)) && move.get(3).equals(move.get(9))) {

                msg.setText("We Got a Winner Player " + move.get(3)+" Won");
            }
        }
    }
}