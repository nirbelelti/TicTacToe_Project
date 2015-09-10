package sample;

/**
 * Created by nirbelelti on 02/09/15.
 */
public class Players {

   private String pleyer = "";


    public String getPleyer() {
        return pleyer;
    }

    public void setPleyer(String pleyer) {
        this.pleyer = pleyer;
    }

    @Override
    public String toString() {
        return "Players{" +
                "pleyer='" + pleyer + '\'' +
                '}';
    }
}
