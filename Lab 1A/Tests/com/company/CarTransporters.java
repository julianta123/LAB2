package com.company;

import CarTransporter.Truck;
import Scania.Scania;
import org.junit.Test;


import static org.junit.Assert.*;

public class CarTransporters {

    private Position startingPosition = new Position(0,0);
    private Position carPosition = new Position(0, 0.5);

    @Test
    public void testLiftFlatbed() {
        Scania t = new Scania(startingPosition, 15, 20);

        t.liftFlatbed(20);
        assertTrue(t.getAngle() < 15);
    }

    @Test
    public void testLowerFlatbed(){
        Scania t = new Scania(startingPosition, 0, 20);

        t.lowerFlatbed(20);
        assertTrue(t.getAngle() > 0);
    }

    @Test
    public void testMove(){
        Scania t = new Scania(startingPosition, 0, 10);
        t.startEngine();
        t.move();
        assertTrue(t.getCurrentSpeed() > 0);
    }

    @Test
    public void testNotMove(){
        Scania t = new Scania(startingPosition, 10, 10);

        t.move();
        assertEquals(0, t.getCurrentSpeed(), 0.0);
    }

    @Test
    public void testTruckLoadCar(){
        Truck t = new Truck(startingPosition, 3, true);
        Volvo240 v = new Volvo240(startingPosition);

        t.startEngine();
        t.move();
        t.loadCar(v);

        assertTrue(t.carsInTruck.isEmpty());
    }

    @Test
    public void testTruckCanLoadCar(){
        Truck t = new Truck(startingPosition, 3, true);
        Volvo240 v = new Volvo240(carPosition);

        t.loadCar(v);

        assertFalse(t.carsInTruck.isEmpty());
    }

    @Test
    public void testCarMoveInTruck(){
        Truck t = new Truck(startingPosition, 3, true);
        Volvo240 v = new Volvo240(carPosition);

        t.loadCar(v);
        v.move();

        assertSame(v.getPosition(), t.getPosition());
    }

    @Test
    public void testUnloadCarTruck(){
        Truck t = new Truck(startingPosition, 3, true);
        Volvo240 v = new Volvo240(carPosition);

        t.loadCar(v);
        t.unloadCar();

        assertTrue(t.carsInTruck.isEmpty());
    }

    @Test
    public void testUnloadCarTruckMove(){
        Truck t = new Truck(startingPosition, 3, true);
        Volvo240 v = new Volvo240(carPosition);

        t.loadCar(v);
        t.move();
        t.unloadCar();

        assertEquals(1, t.carsInTruck.size());
    }
}
