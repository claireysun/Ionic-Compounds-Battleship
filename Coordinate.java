package src;

import java.util.ArrayList;
import java.util.Collections;

public class Coordinate {

    /*
     * STATUS KEY:
     * E = empty
     * S = ship
     * H = hit
     * M = miss
     */
    char status;
    int xLoc, yLoc;
    String anion, cation;
    String name;

    int shipStatus;
    // either is the 1 person ship, 2 person ship, 3 person ship, 4 person ship, 5 person ship, or 0 (no ship)
    // negative value (1-5) means the ship sank

    static ArrayList<String> anions, cations;

    static String[] anionsList = new String[]{"Li+ lithium", "K+ potassium", "Na+ sodium", "Be2+ beryllium", "NH4+ ammonium",
            "Mg2+ magnesium", "Ca2+ calcium", "Al3+ aluminum", "Zn2+ zinc", "Ag+ silver", "Hg22+ mercury(I)", "Co2+ cobalt(II)", 
            "Hg2+ mercury(II)", "Ni2+ nickel(II)", "Cd2+ cadmium(II)"};

    static String[] cationsList = new String[]{"CO32- carbonate", "CrO42- chromate", "O2- oxide", "OH- hydroxide",
            "S2- sulfide", "C4H4O62- tartrate", "SO32- sulfite", "PO43- phosphate", "Br- bromide", "NO3- nitrate", 
            "ClO4- perchlorate", "ClO- hypochlorite", "O22- peroxide", "F- fluoride", "I- iodide"};

    /**
     * Creates a randomly shuffled ArrayList of cations and anions.
     */
    public static void createAnionCationArrayLists() {
        anions = new ArrayList<String>();
        for (int i = 0; i < 15; i++)
            anions.add(anionsList[i]);

        cations = new ArrayList<String>();
        for (int i = 0; i < 15; i++)
            cations.add(cationsList[i]);

        Collections.shuffle(anions);
        Collections.shuffle(cations);
    }

    /**
     * Coordinate constructor
     * @param xLoc  xLoc on the grid
     * @param yLoc  yLoc on the grid
     */
    public Coordinate(int xLoc, int yLoc) {
        //update coordinates
        this.xLoc = xLoc;
        this.yLoc = yLoc;

        //status starts as empty
        this.status = 'E';
        this.shipStatus = 0;

        //update anion, cation, and name
        this.anion = anions.get(xLoc).substring(0, anions.get(xLoc).indexOf(" "));
        this.cation = cations.get(yLoc).substring(0, cations.get(yLoc).indexOf(" "));
        this.name = anions.get(xLoc).substring(anions.get(xLoc).indexOf(" ") + 1) + " " 
            + cations.get(yLoc).substring(cations.get(yLoc).indexOf(" ") + 1);

        //Printing.printCoordinate(anion, cation, name, xLoc, yLoc, status);
    }
}
