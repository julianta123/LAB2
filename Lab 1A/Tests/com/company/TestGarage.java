package com.company;

import Garage.Garage;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestGarage {

    private Position startingPosition = new Position(0,0);

    @Test
    public void testUseGarage(){
        Garage <Volvo240> g = new Garage<Volvo240>(3);
        Volvo240 car = new Volvo240(startingPosition);

        g.useGarage(car);
        assertTrue(g.carsInGarage.size() > 0);
    }

    /*@Test
    public void testWrongCarInGarage(){
        Garage <Volvo240> g = new Garage<Volvo240>(3);
        Saab95 car = new Saab95(startingPosition);

        g.useGarage(car);
        assertEquals(0, g.carsInGarage.size());
    }
     */

    @Test
    public void testUnloadCarGarage(){
        Garage<Vehicle> g = new Garage<Vehicle>(5);
        Saab95 car = new Saab95(startingPosition);

        g.useGarage(car);
        g.unloadCarGarage(car);

        assertEquals(0, g.carsInGarage.size());
    }
}
