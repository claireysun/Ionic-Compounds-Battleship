package src;

import java.util.Scanner;

public class MakeMove {

    /**
     * Gets input from the user (which coordinate they want to hit).
     * @return the input from the user.
     */
    public static String getInput(Scanner scan) {
        System.out.println("Name an ionic compound.");
        return scan.nextLine();
    }

    /**
     * Takes user input and checks if any of the coordinates match. If there is one that does, this method will return
     * the xLoc and yLoc of the matching coordinate, separated by a period.
     *
     * @param input         the input that the user enters.
     * @param coordinates   the array of coordinates.
     * @return the x and y location of the coordinate that matches the input (or nothing if none of the results matched).
     */
    public static String checkCorrect(String input, Coordinate[][] coordinates) {
        //int numMatchingLetters = 0;
        //String closestName = "";

        for (int yLoc = 0; yLoc < 15; yLoc++) {
            for (int xLoc = 0; xLoc < 15; xLoc++) {
                String currentCorrectName = coordinates[yLoc][xLoc].name;

                //if input is correct
                if (currentCorrectName.equals(input))
                    return xLoc + "." + yLoc;
                /*
                //this stuff is extraaa
                else {
                    int tempNumMatchingLetters = 0;

                    for (int i = 0; i < input.length(); i++) {
                        //if this letter is in the current correct name
                        if (currentCorrectName.indexOf(input.charAt(i)) != -1) {

                            int posOfChar = currentCorrectName.indexOf(input.charAt(i));
                            currentCorrectName = currentCorrectName.substring(0, posOfChar) + currentCorrectName.substring(posOfChar + 1);

                            System.out.println(currentCorrectName);
                            System.out.println(input.charAt(i));

                            tempNumMatchingLetters++;
                        }
                    }

                    //if the temporary counter > numlettersOff
                    if (tempNumMatchingLetters > numMatchingLetters) {
                        numMatchingLetters = tempNumMatchingLetters;
                        closestName = coordinates[yLoc][xLoc].name;
                    }
                    if (tempNumMatchingLetters == numMatchingLetters) {
                        if (input.length() == coordinates[yLoc][xLoc].name.length())
                            closestName = coordinates[yLoc][xLoc].name;
                    }
                }
                 */
            }
        }

        //System.out.println("the closest match to your input was " + closestName);
        //System.out.println("it has " + numMatchingLetters + " matching letters");

        return "";
    }

    /**
     * Checks the potential "move" to see if the spot has already been hit.
     *
     * @param xLoc          x location of the coordinate to be tested.
     * @param yLoc          y location of the coordinate to be tested.
     * @param coordinates   array of coordinates to be tested against.
     * @return boolean if the spot is available.
     */
    public static boolean checkAvailability(int xLoc, int yLoc, Coordinate[][] coordinates) {
        if (coordinates[yLoc][xLoc].status != 'H' && coordinates[yLoc][xLoc].status != 'M')
            return true;

        return false;
    }

    /**
     *
     * @param xLoc          x location of the coordinate to be changed.
     * @param yLoc          y location of the coordinate to be changed.
     * @param coordinates   array of coordinates to be modified.
     * @return updated Coordinate array.
     */
    public static Coordinate[][] makeActualMove(int xLoc, int yLoc, Coordinate[][] coordinates) {
        if (coordinates[yLoc][xLoc].status == 'E')
            coordinates[yLoc][xLoc].status = 'M';
        else
            coordinates[yLoc][xLoc].status = 'H';

        return coordinates;
    }

}
