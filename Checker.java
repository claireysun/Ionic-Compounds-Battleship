package src;

public class Checker {

    public static boolean checkShipSunk(Coordinate[][] coordinates, int shipNum) {
        int spotsHit = 0;

        for (int yLoc = 0; yLoc < 15; yLoc++) {
            for (int xLoc = 0; xLoc < 15; xLoc++) {
                if ((coordinates[yLoc][xLoc].shipStatus == shipNum) && (coordinates[yLoc][xLoc].status == 'H'))
                    spotsHit++;
            }
        }

        if (spotsHit == shipNum)
            return true;

        return false;
    }

    public static Coordinate[][] updateCoordShipSunk (Coordinate[][] coordinates, int shipNum) {
        for (int yLoc = 0; yLoc < 15; yLoc++) {
            for (int xLoc = 0; xLoc < 15; xLoc++) {
                if (coordinates[yLoc][xLoc].shipStatus == shipNum)
                    coordinates[yLoc][xLoc].shipStatus = -shipNum; //set to negative -> ship sunk!
            }
        }

        return coordinates;
    }

    public static boolean checkGameOver(Coordinate[][] coordinates) {
        for (int yLoc = 0; yLoc < 15; yLoc++) {
            for (int xLoc = 0; xLoc < 15; xLoc++) {
                if (coordinates[yLoc][xLoc].status == 'S')
                    return false;
            }
        }

        return true;
    }
}
