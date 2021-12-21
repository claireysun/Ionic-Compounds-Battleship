package src;

public class Printing {

    static void printNames(Coordinate[][] coordinates) {
        for (int yLoc = 0; yLoc < 15; yLoc++) {
            for (int xLoc = 0; xLoc < 15; xLoc++)
                System.out.print(coordinates[yLoc][xLoc].name + " ");
            System.out.println();
        }
    }

    static void printStatuses(Coordinate[][] coordinates) {
        for (int yLoc = 0; yLoc < 15; yLoc++) {
            for (int xLoc = 0; xLoc < 15; xLoc++)
                System.out.print(coordinates[yLoc][xLoc].status + " ");
            System.out.println();
        }
    }

    static void printCoordinates(Coordinate c) {
        System.out.println("xLoc: " + c.xLoc);
        System.out.println("yLoc: " + c.yLoc);
    }

    static void printShip(int startingX, int startingY, int direction, int size) {
        System.out.println("startingX: " + startingX);
        System.out.println("startingY: " + startingY);
        System.out.println("direction: " + direction);
        System.out.println("size: " + size);

        System.out.println("reminder: coordinates are not xy -> array coordinates (start from 0)");
    }

    static void printCoordinate(String anion, String cation, String name, int xLoc, int yLoc, char status) {
        System.out.println("coordinate: (" + xLoc + ", " + yLoc + ")");

        System.out.println("anion: " + anion);
        System.out.println("cation: " + cation);
        System.out.println("name: " + name);


        System.out.println("status: " + status);
    }
}
