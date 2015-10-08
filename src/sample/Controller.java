package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Controller implements Initializable {


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
    private RadioButton player1CL;
    @FXML
    private RadioButton player2CL;
    @FXML
    private Button resetBtn;
    @FXML
    private Button upload;
    @FXML
    private Button save;
    @FXML
    private Label msg;


    String playerDefault = " ";

    Players play = new Players();
    Fields field = new Fields();
    Sender snt = new Sender();
    // Reciver rcv = new Reciver();

    Map<Integer, String> move = new HashMap<Integer, String>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }


    public void setMove1(ActionEvent event) {

        field.setFieldId(1);
        v1h1.setText(play.getPlayer());
        move.put(field.getFieldId(), play.getPlayer());

        System.out.println(move);


        try {
            snt.sent(field.getFieldId(), play.getPlayer());
        } catch (Exception e) {
            e.printStackTrace();
        }

        refresh();
        isAWinner();
        switchPlayers();

    }

    public void setMove2(ActionEvent event) {

        field.setFieldId(2);
        v1h2.setText(play.getPlayer());
        move.put(field.getFieldId(), play.getPlayer());
        System.out.println(move);

        try {
            snt.sent(field.getFieldId(), play.getPlayer());
        } catch (Exception e) {
            e.printStackTrace();
        }

        refresh();
        isAWinner();
        switchPlayers();


    }

    public void setMove3(ActionEvent event) {
        field.setFieldId(3);
        v1h3.setText(play.getPlayer());
        move.put(field.getFieldId(), play.getPlayer());
        try {
            snt.sent(field.getFieldId(), play.getPlayer());
        } catch (Exception e) {
            e.printStackTrace();
        }

        refresh();
        isAWinner();
        switchPlayers();

    }

    public void setMove4(ActionEvent event) {
        field.setFieldId(4);
        v2h1.setText(play.getPlayer());
        move.put(field.getFieldId(), play.getPlayer());
        try {
            snt.sent(field.getFieldId(), play.getPlayer());
        } catch (Exception e) {
            e.printStackTrace();
        }

        refresh();
        isAWinner();
        switchPlayers();
    }

    public void setMove5(ActionEvent event) {
        field.setFieldId(5);
        v2h2.setText(play.getPlayer());
        move.put(field.getFieldId(), play.getPlayer());
        try {
            snt.sent(field.getFieldId(), play.getPlayer());
        } catch (Exception e) {
            e.printStackTrace();
        }

        refresh();
        isAWinner();
        switchPlayers();

    }

    public void setMove6(ActionEvent event) {
        field.setFieldId(6);
        v2h3.setText(play.getPlayer());
        move.put(field.getFieldId(), play.getPlayer());
        try {
            snt.sent(field.getFieldId(), play.getPlayer());
        } catch (Exception e) {
            e.printStackTrace();
        }

        refresh();
        isAWinner();
        switchPlayers();
    }

    public void setMove7(ActionEvent event) {
        field.setFieldId(7);
        v3h1.setText(play.getPlayer());
        move.put(field.getFieldId(), play.getPlayer());
        try {
            snt.sent(field.getFieldId(), play.getPlayer());
        } catch (Exception e) {
            e.printStackTrace();
        }

        refresh();
        isAWinner();
        switchPlayers();
    }

    public void setMove8(ActionEvent event) {
        field.setFieldId(8);
        v3h2.setText(play.getPlayer());
        move.put(field.getFieldId(), play.getPlayer());
        try {
            snt.sent(field.getFieldId(), play.getPlayer());
        } catch (Exception e) {
            e.printStackTrace();
        }

        refresh();
        isAWinner();
        switchPlayers();
    }

    public void setMove9(ActionEvent event) {
        field.setFieldId(9);
        v3h3.setText(play.getPlayer());
        move.put(field.getFieldId(), play.getPlayer());
        try {
            snt.sent(field.getFieldId(), play.getPlayer());
        } catch (Exception e) {
            e.printStackTrace();
        }

        refresh();
        isAWinner();
        switchPlayers();


    }

    public void setPlayer1(ActionEvent event) {


        play.setPlayer("X");


    }

    public void setPlayer2(ActionEvent event) {

        play.setPlayer("O");

    }

    public void switchPlayers() {
        if (play.getPlayer().equals("X")) {


            player2CL.setSelected(true);

        } else if (play.getPlayer().equals("O")) {


            player1CL.setSelected(true);

        }

        if (player1CL.isSelected() == true) {
            play.setPlayer("X");
        } else if (player2CL.isSelected() == true) {
            play.setPlayer("O");
        }


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

        move.put(field.getFieldId(), play.getPlayer());

        try {
            snt.sent(10, play.getPlayer());
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(move);

        System.out.println("Load game from file");


    }

    public void uploadgame(String nextmove) {

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

        move.put(field.getFieldId(), play.getPlayer());

        // get the value at key 0 = X or O
        // set the radio button and player to oposite

        System.out.println(move);

        if (nextmove.equals("X")) {
            player1CL.setSelected(true);
            play.setPlayer("X");
        }

        if (nextmove.equals("O")) {
            player2CL.setSelected(true);
            play.setPlayer("O");
        }


        System.out.println("Load game from file");


    }


    public void resetGame(ActionEvent event) {
        if (move.containsValue("X") || move.containsValue("O")) {
            {
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
                try {
                    snt.sent(11, play.getPlayer());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void resetGame() {
        if (move.containsValue("X") || move.containsValue("O")) {
            {
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
        }

    }


    public void saveToFile(ActionEvent event) {
        move.put(0, play.getPlayer());   // next move to be made after upload

        try {
            FileOutputStream moveReg = new FileOutputStream("hashMapFile.txt");
            ObjectOutputStream saveGame = new ObjectOutputStream(moveReg);
            saveGame.writeObject(move);
            saveGame.close();
            moveReg.close();
            System.out.println(" Data is saved in file");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            snt.sent(12, move.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveToFile() {
            move.put(0, play.getPlayer());   // next move to be made after upload

        try {
            FileOutputStream moveReg = new FileOutputStream("hashMapFile.txt");
            ObjectOutputStream saveGame = new ObjectOutputStream(moveReg);
            saveGame.writeObject(move);
            saveGame.close();
            moveReg.close();
            System.out.println(" Data is saved in file");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

     /*   if (move.get(0).equals("X")) {
            player2CL.setSelected(true);
            play.setPlayer("O");
        }

        if (move.get(0).equals("O")) {
            player1CL.setSelected(true);
            play.setPlayer("X");
        }   */

    }

    public void isAWinner() {

        if (!move.get(1).equals("")) {
            if (move.get(1).equals(move.get(2)) && move.get(1).equals(move.get(3))) {


                msg.setText("We Got a Winner Player " + move.get(1) + " Won");
            }
        }
        if (!move.get(4).equals("")) {
            if (move.get(4).equals(move.get(5)) && move.get(4).equals(move.get(6))) {


                msg.setText("We Got a Winner Player " + move.get(4) + " Won");
            }
        }
        if (!move.get(7).equals("")) {
            if (move.get(7).equals(move.get(8)) && move.get(7).equals(move.get(9))) {


                msg.setText("We Got a Winner Player " + move.get(7) + " Won");
            }
        }
        if (!move.get(1).equals("")) {
            if (move.get(1).equals(move.get(5)) && move.get(5).equals(move.get(9))) {


                msg.setText("We Got a Winner Player " + move.get(1) + " Won");
            }
        }
        if (!move.get(3).equals("")) {
            if (move.get(3).equals(move.get(5)) && move.get(5).equals(move.get(7))) {


                msg.setText("We Got a Winner Player " + move.get(3) + " Won");
            }
        }
        if (!move.get(1).equals("")) {
            if (move.get(1).equals(move.get(4)) && move.get(4).equals(move.get(7))) {


                msg.setText("We Got a Winner Player " + move.get(4) + " Won");
            }
        }
        if (!move.get(2).equals("")) {
            if (move.get(2).equals(move.get(5)) && move.get(5).equals(move.get(8))) {


                msg.setText("We Got a Winner Player " + move.get(2) + " Won");
            }
        }
        if (!move.get(3).equals("")) {
            if (move.get(3).equals(move.get(6)) && move.get(6).equals(move.get(9))) {


                msg.setText("We Got a Winner Player " + move.get(3) + " Won");
            }
        }
    }


    public void refresh() {


        move.put(1, v1h1.getText());
        move.put(2, v1h2.getText());
        move.put(3, v1h3.getText());
        move.put(4, v2h1.getText());
        move.put(5, v2h2.getText());
        move.put(6, v2h3.getText());
        move.put(7, v3h1.getText());
        move.put(8, v3h2.getText());
        move.put(9, v3h3.getText());
        System.out.println("rrrr" + move);


    }

    public void updateBoard(String message) {


        String player = message;
        String[] divide = player.split(",");
        String v1 = divide[0];
        String p = divide[1];

        int v = Integer.parseInt(v1);

        char c = p.charAt(0); // chang

        p = Character.toString(c);


        //   String v = Character.toString(a);
        //   String p = Character.toString(c);
        field.setFieldId(v);
        play.setPlayer(p);

        System.out.println("printing objects: " + field.getFieldId() + " , " + play.getPlayer());

        move.put(field.getFieldId(), play.getPlayer());

        switch (v) {
            case 1:
                v1h1.setText(move.get(1));
                break;
            case 2:
                v1h2.setText(move.get(2));
                break;
            case 3:
                v1h3.setText(move.get(3));
                break;
            case 4:
                v2h1.setText(move.get(4));
                break;
            case 5:
                v2h2.setText(move.get(5));
                break;
            case 6:
                v2h3.setText(move.get(6));
                break;
            case 7:
                v3h1.setText(move.get(7));
                break;
            case 8:
                v3h2.setText(move.get(8));
                break;
            case 9:
                v3h3.setText(move.get(9));
                break;
            case 10:
                uploadgame(p);
                break;
            case 11:
                resetGame();
                break;
            case 12:
                saveToFile();
                break;

        }
        refresh();
        isAWinner();
        if (v != 10 || v != 11 || v != 12) {
            if (c == 'X') {
                player2CL.setSelected(true);
                play.setPlayer("O");
            }

            if (c == 'O') {
                player1CL.setSelected(true);
                play.setPlayer("X");
            }
        }


    }


}











