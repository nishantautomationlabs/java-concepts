package Interface;

/**
 * Created by Nishant on 03-11-2018.
 */
public interface FordCar extends Car {

    void playMusic();
    void startCamera();

    default void navigateToHome()
    {
        setDestination("Home");
        Car.super.navigate(); //Can call super interface default method
    }
}
