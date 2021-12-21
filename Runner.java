package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        // create ArrayLists for anions and cations
        Coordinate.createAnionCationArrayLists();

        // creates coordinates
        Coordinate[][] coordinates = new Coordinate[15][15];
        for (int yLoc = 0; yLoc < 15; yLoc++)
            for (int xLoc = 0; xLoc < 15; xLoc++)
                coordinates[yLoc][xLoc] = new Coordinate(xLoc, yLoc);

        // creates ships
        for (int i = 1; i <= 5; i++)
            coordinates = Ship.createShip(i, coordinates);

        Printing.printNames(coordinates);
        Printing.printStatuses(coordinates);

        int numMoves = 0;
        boolean gameOver = false;

        Scanner scan = new Scanner(System.in);

        // MAKE MOVE STUFF
        while (!gameOver) {
            int inputxLoc, inputyLoc;

            String input = MakeMove.getInput(scan);
            String xyLoc = MakeMove.checkCorrect(input, coordinates);

            // if input is not valid
            if (xyLoc.equals("")) {
                System.out.println("Not a valid response, try again.");
            }
            else {
                inputxLoc = Integer.parseInt(xyLoc.substring(0, xyLoc.indexOf(".")));
                inputyLoc = Integer.parseInt(xyLoc.substring(xyLoc.indexOf(".") + 1));

                if (MakeMove.checkAvailability(inputxLoc, inputyLoc, coordinates)) {
                    coordinates = MakeMove.makeActualMove(inputxLoc, inputyLoc, coordinates);

                    Printing.printStatuses(coordinates);
                }
                else {
                    System.out.println("This area has already been hit.");
                    numMoves--;
                }
            }

            numMoves++;
            System.out.println("Moves:  " + numMoves);

            //for each ship -> check if it sank -> if it did, update the coordnate grid
            for (int shipNum = 1; shipNum <= 5; shipNum++) {
                if (Checker.checkShipSunk(coordinates, shipNum))
                    coordinates = Checker.updateCoordShipSunk(coordinates, shipNum);
            }

            if (Checker.checkGameOver(coordinates))
                gameOver = true;
        }

        System.out.println("Congrats! You won!");
        System.out.println("Moves:  " + numMoves);

        scan.close();
    }
}
