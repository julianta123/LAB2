package CarTransporter;

import com.company.Position;
import com.company.Vehicle;

import java.awt.*;
import java.util.Stack;

/**The Truck class describes what the trucks methods are.
 * As it also extends Vehicle, the truck class has the same method as found in Vehicle
 */

public class Truck extends Vehicle {

    private int maxNCars;
    private boolean rampIsUp = true;
    private double maxCarLength;
    private double maxCarWidth;
    public Stack<Vehicle> carsInTruck = new Stack<>();

    /**Describes the trucks attributes
     *
     * @param position the trucks positions
     * @param maxNCars max number of cars the truck can load
     * @param rampIsUp says if the trucks ramp is up
     */

    public Truck(Position position, int maxNCars, boolean rampIsUp) {
        super(2, 125, Color.BLACK, "ToyotaX100", position, 9, 2, true);
        this.maxNCars = 3;
        this.rampIsUp = rampIsUp;
        this.maxCarLength = 3;
        this.maxCarWidth = 2;
    }

    /**If the truck is not moving then it raises the ramp
     *
     */

    public void raiseRamp(){
        if(getCurrentSpeed() == 0){
            rampIsUp = true;
        }
    }

    /**If the truck is not moving then it lowers the ramp
     *
     */

    private void lowerRamp(){
        if(getCurrentSpeed() == 0){
            rampIsUp = false;
        }
    }

    /**Check if the car is close enough to load.
     *
     * @param car the vehicle we want the truck to load
     * @return if the car is close to the truck or not
     */

    private boolean carIsClose(Vehicle car){
        Position posCar = car.getPosition();
        Position posTruck = this.getPosition();

        if(posCar.getY() > posTruck.getY() -1 && posCar.getY() < posTruck.getY() +1 && car.notLoaded &&
                posCar.getX() > posTruck.getX() -1 && posCar.getX() < posTruck.getX() +1){
            return true;
        }
        return false;
    }

    /** Loads the car unto the truck
     *
     * @param car the vehicle we want the truck to load
     */

    public void loadCar(Vehicle car){
        lowerRamp();
        if(carIsClose(car) && !rampIsUp && carsInTruck.size() < maxNCars && car.getCarLength() < this.maxCarLength &&
                car.getCarWidth() < this.maxCarWidth){
            carsInTruck.push(car);
            car.notLoaded = false;
            car.setPosition(this.getPosition());

        }
    }

    /**Unloads the last car that was loaded unto the truck
     *
     */

    public void unloadCar(){
        if(!rampIsUp && carsInTruck.size() > 0){
            Vehicle v = carsInTruck.pop();
            double n = 0.9;
            Position pos = new Position(n, this.getPosition().getY() - 0.2);
            v.setPosition(pos);
            n = n - 0.1;
            v.notLoaded = true;
        }
    }

    /**When the truck wants to move the method raises the ramp and update the cars on the trucks position
     *
     */

    @Override
    public void move(){
        raiseRamp();
        super.move();
        for(Vehicle c : carsInTruck){
            c.setPosition(this.getPosition());
        }
    }

    @Override
    public double speedFactor(double enginePower) {
        return 0;
    }
}
