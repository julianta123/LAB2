package Scania;

import com.company.Vehicle;
import com.company.Position;

import java.awt.*;



public class Scania extends Vehicle {

    private double angle;
    private double amount;

    /** Describes the attributes of a truck.
     *
     * @param position the trucks position
     * @param angle the angle of the flatbed
     * @param amount how much you want do lift or lower the flatbed
     */

    public Scania(Position position, double angle, double amount) {
        super(2, 125, Color.BLACK, "Scania", position, 5, 2, true);
        this.angle = angle;
        this.amount = amount;
    }

    public double getAngle() {
        return angle;
    }

    public double getAmount() {
        return amount;
    }

    /**Lifts the flatbed
     *
     * @param amount how much you want to lift the flatbed
     */
    public void liftFlatbed(double amount){
        if (getCurrentSpeed() == 0 && angle > 0){
            decrementAngle(amount);
        }
    }

    /**Lowers the flatbed
     *
     * @param amount how much you want to lower the flatbed
     */

    public void lowerFlatbed(double amount){
        if(getCurrentSpeed() == 0 && angle == 0){
            incrementAngle(amount);
        }
    }

    /**Decreases the angle
     *
     * @param amount how much you want to lower the flatbed
     */

    private void decrementAngle(double amount) {
        angle = Math.max(0, angle - amount);
    }

    /**Increases the angle
     *
     * @param amount how much you want to lift the flatbed
     */

    private void incrementAngle(double amount){
        angle = Math.min(70, amount + angle);
    }

    /**Checks if the truck's flatbed is down or not. If it's down the truck can't move
     *
     * @return says if the truck can move or not
     */

    private boolean canTruckMove(){
        return angle == 0;
    }

    /**Check if the truck can move before it moves
     *
     */

    @Override
    public void move(){
        if(canTruckMove()){
            super.move();
        }
    }


    @Override
    public double speedFactor(double enginePower) {
        return enginePower;
    }

}
