package Interface;

/**
 * Created by Nishant on 03-11-2018.
 */
public interface Car {

    void drive();
    void setDestination(String destination);
    void blowHorn();

    default void navigate() //default method which implementing class may or may not define to support backward compatibility when a new method is added in the interface
    {
        System.out.println("navigate to destination");
        drive(); // can call other interface method
    }

}
