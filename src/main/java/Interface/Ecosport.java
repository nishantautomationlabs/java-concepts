package Interface;

/**
 * Created by Nishant on 03-11-2018.
 */
public class Ecosport implements Car {
    @Override
    public void drive() {
        System.out.println("drive");
    }

    @Override
    public void setDestination(String destination) {
        System.out.println("set destination");
    }

    @Override
    public void blowHorn() {
        System.out.println("blow horn");
    }
}
