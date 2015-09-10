package sample;

/**
 * Created by nirbelelti on 02/09/15.
 */
public class Players {

   private String player = "";


    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Players{" +
                "player='" + player + '\'' +
                '}';
    }
}
