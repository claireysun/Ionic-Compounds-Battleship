package src;

public class Ship {

    /**
     * Creates a ship of random orientation + location of any given size.
     *
     * @param size          the size of the ship to be created.
     * @param coordinates   array of Coordinates to be modified.
     * @return the modified array of Coordinates.
     */
    public static Coordinate[][] createShip(int size, Coordinate[][] coordinates) {

        boolean foundOverlappingShip = true;
        int direction = 0, startingX = 0, startingY = 0; //will be overridden later!

        //keep creating random ship arrangement until one of them work
        while (foundOverlappingShip) {
            //generate random orientation + location of ship
            direction = (int)(Math.random() * 4) + 1; //1-4 (from 1-4, it's top, right, bottom, left)
            startingX = (int)(Math.random() * (15 - (size - 1) * 2)) + size - 1;
            startingY = (int)(Math.random() * (15 - (size - 1) * 2)) + size - 1;

            //test if there's already ship there
            foundOverlappingShip = Ship.checkOverlappingShip(size, coordinates, direction, startingX, startingY);
        }

            //Printing.printShip(startingX, startingY, direction, size);

            coordinates[startingY][startingX].status = 'S';
            coordinates[startingY][startingX].shipStatus = size;
            for (int i = 1; i < size; i++) {

                //if direction is up, update status + shipStatus
                if (direction == 1) {
                    coordinates[startingY - i][startingX].status = 'S';
                    coordinates[startingY - i][startingX].shipStatus = size;
                }
                //if direction is down
                if (direction == 3) {
                    coordinates[startingY + i][startingX].status = 'S';
                    coordinates[startingY + i][startingX].shipStatus = size;
                }
                //if direction is right
                if (direction == 2) {
                    coordinates[startingY][startingX + i].status = 'S';
                    coordinates[startingY][startingX + i].shipStatus = size;
                }
                //if direction is left
                if (direction == 4) {
                    coordinates[startingY][startingX - i].status = 'S';
                    coordinates[startingY][startingX - i].shipStatus = size;
                }
            }

        return coordinates;
    }

    /**
     * Checks if the randomly generated ship would overlap with any preexisting ships.
     *
     * @param size          the size of the ship to be added.
     * @param coordinates   array of Coordinates to be tested.
     * @param direction     the direction the ship will go in.
     * @param startingX     the starting x location of the ship.
     * @param startingY     the starting y location of the ship.
     * @return boolean if an overlapping ship was found.
     */
    public static boolean checkOverlappingShip(int size, Coordinate[][] coordinates, int direction, int startingX, int startingY) {

        //if main coordinate has ship -> return true
        if (coordinates[startingY][startingX].status == 'S')
            return true;

        //if each successive space has ship -> return true
        for (int i = 1; i < size; i++) {
            //if direction is up
            if (direction == 1)
                if (coordinates[startingY - i][startingX].status == 'S')
                    return true;
            //if direction is down
            if (direction == 3)
                if (coordinates[startingY + i][startingX].status == 'S')
                    return true;
            //if direction is right
            if (direction == 2)
                if (coordinates[startingY][startingX + i].status == 'S')
                    return true;
            //if direction is left
            if (direction == 4)
                if (coordinates[startingY][startingX - i].status == 'S')
                    return true;
        }
        return false;
    }
}
