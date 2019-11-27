package com.company;

public interface Movable {

        /**The move method moves an object and checks the existing criteria.
         *
         */
        void move();

        /**turnLeft turns an object counter clockwise.
         *
         */
        void turnLeft();

        /**turnRight turns an object clockwise.
         *
         */
        void turnRight();


}



// color --> private då den inte ska kunna ändra färg efter den är skapad
//currentspeed --> private


// ctr alt L -- formaterar koden
//alt shift f6 -- ändar ett ord på flera platser
// java doc på alla publika metoder'
// vid set position använd variabel för att göra det svårare att ändra
//kolla loaded variablen för att se till att en lastad bil inte lastas om på en annan truck
// se till att ta bort den hardcodade 3 och 2 vid lastning av bilar
