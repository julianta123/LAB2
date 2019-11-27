package com.company;
import java.awt.*;

/**The Car class describe different cars that can be moved in different directions and speed.
 *
 */

public abstract class Vehicle implements Movable {
    private int nrDoors;
    private double enginePower;
    private Color color;
    private String modelName;
    private double currentSpeed;
    private Position position;
    private direction currentDirection = direction.NORTH;
    private double carLength;
    private double carWidth;
    public boolean notLoaded = true;

    /**
     * Describes what the cars attributes are.
     *
     * @param nrDoors number of doors
     * @param enginePower how strong the motor is
     * @param color the color of the car
     * @param modelName the name of the car model
     * @param position where the cars position is
     * @param notLoaded tells if the car is loaded unto a truck.
     */

    public Vehicle(int nrDoors, double enginePower, Color color, String modelName, Position position, double carLength, double carWidth, boolean notLoaded) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.position = position;
        this.carLength = carLength;
        this.carWidth = carWidth;
        this.notLoaded = notLoaded;
    }



    /** Are the different directions the cars can move in
     *
     */
    enum direction {
        NORTH, SOUTH, WEST, EAST
    }

    public double getCarLength() {
        return carLength;
    }

    public double getCarWidth() {
        return carWidth;
    }

    public void setPosition(Position position) {
        if(!notLoaded) {
            this.position = position;
        }
    }

    private String getModelName() { return modelName; }

    public Position getPosition() { return position; }

    public direction getCurrentDirection() {
        return currentDirection;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    private void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    private Color getColor() {
        return color;
    }

    private void setColor(Color clr) {
        color = clr;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }


    /**
     * The method startEngine makes the car move with a specific speed.
     */

    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * The method stopEngine setts the cars speed to 0 and makes it stop.
     */

    public void stopEngine() {
        currentSpeed = 0;
    }


    /**
     * The move method starts the car and gives it a speed in a specific direction if its not loaded unto a truck or in garage.
     */

    @Override
    public void move() {
        if(notLoaded){
            if (currentDirection == direction.NORTH) {
                position.setY(position.getY() + currentSpeed);
            } else if (currentDirection == direction.SOUTH) {
                position.setY(position.getY() - currentSpeed);
            } else if (currentDirection == direction.WEST) {
                position.setX(position.getX() - currentSpeed);
            } else if (currentDirection == direction.EAST) {
                position.setX(position.getX() + currentSpeed);
            }
        }
    }

    /**
     * The turnLeft method changes the cars direction counter clockwise
     */

    @Override
    public void turnLeft() {
        if (currentDirection == direction.NORTH) {
            currentDirection = direction.WEST;
        } else if (currentDirection == direction.WEST) {
            currentDirection = direction.SOUTH;
        } else if (currentDirection == direction.SOUTH) {
            currentDirection = direction.EAST;
        } else if (currentDirection == direction.EAST) {
            currentDirection = direction.NORTH;
        }
    }

    /**
     * The turnRight method changes the cars direction clockwise.
     */

    @Override
    public void turnRight() {
        if (currentDirection == direction.NORTH) {
            currentDirection = direction.EAST;
        } else if (currentDirection == direction.WEST) {
            currentDirection = direction.NORTH;
        } else if (currentDirection == direction.SOUTH) {
            currentDirection = direction.WEST;
        } else if (currentDirection == direction.EAST) {
            currentDirection = direction.SOUTH;
        }
    }

    /**This method says how fast the car can go
     *
     * @param enginePower how strong the motor is
     * @return returns the cars top speed
     */

    public abstract double speedFactor(double enginePower);

    /** The method gas accelerate the speed. The speed can't go over engine power.
     *
     *
     * @param amount How much we will increase the speed.
     */

    public void gas(double amount) {
        if(currentSpeed < enginePower){
            incrementSpeed(amount);
        }
    }

    /**The method brake slows down the speed. Can't get under 0.
     *
     * @param amount How much we will decrease the speed.
     */

    public void brake(double amount) {
        if(currentSpeed > 0){
            decrementSpeed(amount);
            if(currentSpeed < 0){
                currentSpeed = 0;
            }
        }
    }

    /**incrementSpeed increases the cars speed.
     *
     * @param amount How much we will increase the speed.
     *
     * */

    public void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor(enginePower) * amount,enginePower));
    }

    /** The method decrementSpeed decreases the cars speed.
     *
     * @param amount How much we will decrease the speed.
     */

    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor(enginePower) * amount,0));

    }



}
