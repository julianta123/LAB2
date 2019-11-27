package Garage;

import com.company.Vehicle;

import java.util.ArrayList;

/** The class Garage describes what type of cars it can handle and how many
 *
 * @param <T> Type of Vehicles the garage can take
 */

public class Garage <T extends Vehicle>{
    private int maxNOfCars;
    public ArrayList<T> carsInGarage = new ArrayList<>();

    /**A garage have a maximum number of cars
     *
     * @param maxNOfCars The maximum number of cars the garage can handle
     */

    public Garage(int maxNOfCars) {
        this.maxNOfCars = maxNOfCars;
    }

    /**Checks if there is space and if its the right type of cars that is loaded into the garage
     *
     * @param car the type of car thar wants to be loaded into the garage
     */

    public void useGarage(T car){
        if(carsInGarage.size() < maxNOfCars){
            carsInGarage.add(car);
            car.notLoaded = false;
        }
    }

    /**Unloads a car from garage if its the right type of car
     *
     * @param car the type of car that wants to be unloaded into the garage
     * @return The car that was unloaded
     */

    public T unloadCarGarage(T car){
        if(!carsInGarage.isEmpty()) {
            for (T c : carsInGarage) {
                if (c == car) {
                    T temp = carsInGarage.get(carsInGarage.indexOf(c));
                    carsInGarage.remove(c);
                    c.notLoaded = true;
                    return temp;
                }
            }
        }
        return null;
    }
}

