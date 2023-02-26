package dao;
/*
Ben Miller - 2022-02-22
dao.DVDLibrary interacts with FileIO to read and write a dto.DVD dao.Library
 */

import dto.Address;
import dto.DVD;
import dto.Studio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DVDLibrary implements Library<DVD> {

    private final ArrayList<DVD> dvdCollection= new ArrayList<DVD>();

    /**
     * A DVD, if the title is unique, is added to the collection.
     * If the title is not unique, append (copy), similar to an OS's file explorer
     * @param dvd The DVD to be added to the dvdCollection
     */
    public void create(DVD dvd) {
        System.out.println("Adding DVD");

        while(isDuplicate(dvd)) {
            dvd.setTitle(dvd.getTitle() + " (copy)");
        }

        dvdCollection.add(dvd);
    }

    /**
     * A helper method to ensure the title's of DVD objects can be treated as unique IDs.
     * The method is used to append (copy) to any duplicate DVD titles, similar to an OS's
     * file explorer
     * @param dvd The DVD object whose title is validated as unique
     * @return true if a DVD with the same title exists
     */
    public boolean isDuplicate(DVD dvd) {
        for (DVD currentDVD : dvdCollection) {
            if (dvd.getTitle().equalsIgnoreCase(currentDVD.getTitle())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Delete a DVD by a unique (forced) title
     * @param title The title of the DVD to be deleted
     */
    public void deleteByTitle(String title) {
        for (DVD potentialDVDMatch : dvdCollection) {
            if (title.equalsIgnoreCase(potentialDVDMatch.getTitle())) {
                dvdCollection.remove(potentialDVDMatch);
                break;
            }
        }
    }

    /**
     * Displays the DVD object with DVD's overridden toString method
     * @param dvd The DVD object which should be displayed
     */
    public void displayInformation(DVD dvd) {
        for (DVD potentialDVDMatch : dvdCollection) {
            if (dvd.getTitle().equalsIgnoreCase(potentialDVDMatch.getTitle())) {
                System.out.println(dvd);
                System.out.println();
            }
        }
    }

    /**
     * Read csv file and create DVD objects added to the ArrayList
     * @param fileName
     */
    public void readFromFile(String fileName) {
        Scanner sc = null;
        try {
            sc = new Scanner(
                    new BufferedReader(new FileReader(fileName)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
// go through the file line by line
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            String[] inputs = currentLine.split(",");
            String title = inputs[0];
            String releaseDate = inputs[1];
            String comments = inputs[2];
            String rating = inputs[3];
            String director = inputs[4];
            String studioName = inputs[5];
            String studioCity = inputs[6];
            String studioCountry = inputs[7];
            Address studioAddress = new Address(studioCity, studioCountry);
            Studio studio = new Studio(studioName, studioAddress);
            DVD dvdCandidate = new DVD(rating, director, studio, title, releaseDate, comments);
            dvdCollection.add(dvdCandidate);
        }
    }

    /**
     * Marshall and write to disk
     * @param fileName The name of the file to which marshalled data should be written
     */
    public void writeDVDs(String fileName) {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(fileName));
        } catch (IOException e) {
            throw new RuntimeException();
        }

        String DVDAsString;
        for (DVD dvd : dvdCollection) {
            // turn a Student into a String
            DVDAsString = marshallDVD(dvd);
            // write the Student object to the file
            out.println(DVDAsString);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }

    /**
     * Marshall the DVD
     * @param dvd The DVD object to be marshalled
     * @return String of marshalled DVD
     */
    public String marshallDVD(DVD dvd) {
        String runningDVD;
        runningDVD = dvd.getTitle() + ","
                    + dvd.getReleaseDate() + ","
                    + dvd.getUserNotes() + ","
                    + dvd.getMpaaRating() + ","
                    + dvd.getDirector() + ","
                    + dvd.getStudio().getName() + ","
                    + dvd.getStudio().getAddress().getCity() + ","
                    + dvd.getStudio().getAddress().getCountry();

        return runningDVD;
    }

    /**
     * Find a DVD, given a DVD title
     * @param title The title property of a DVD
     * @return DVD or null if no DVD is found
     */
    public DVD findDVDByTitle(String title) {
        for (DVD dvd: dvdCollection) {
            if (title.equalsIgnoreCase(dvd.getTitle())) {
                return dvd;
            }
        }
        return null;
    }

    /**
     * Print out each DVD object in the in-memory ArrayList
     */
    public void getAllDVDs() {
        for (DVD dvd : dvdCollection) {
            System.out.println(dvd);
        }
    }

    /**
     * Print out each DVD title only
     * This method helps when searching for a particular DVD to edit
     */
    public void getAllDVDTitles() {
        for (DVD dvd : dvdCollection) {
            System.out.println(dvd.getTitle());
        }
    }

    /**
     * Given a DVD title, updated the provided property with the given value
     * @param title The title of the DVD to be updated
     * @param propertyToEdit The name of the property to be updated
     * @param updatedPropertyValue The value that should replace the previous property's value
     */
    public void editDVDPropertyByTitle(String title, int propertyToEdit, String updatedPropertyValue) {
        for (DVD dvd : dvdCollection) {
            if (!title.equalsIgnoreCase(dvd.getTitle())) {
                continue;
            }
            switch (propertyToEdit) {
                case 1:
                    dvd.setTitle(updatedPropertyValue);
                    break;
                case 2:
                    dvd.setReleaseDate(updatedPropertyValue);
                    break;
                case 3:
                    dvd.setUserNotes(updatedPropertyValue);
                    break;
                case 4:
                    dvd.setMpaaRating(updatedPropertyValue);
                    break;
                case 5:
                    dvd.setDirector(updatedPropertyValue);
                    break;
                case 6:
                    dvd.getStudio().setName(updatedPropertyValue);
                    break;
                case 7:
                    dvd.getStudio().getAddress().setCity(updatedPropertyValue);
                    break;
                case 8:
                    dvd.getStudio().getAddress().setCountry(updatedPropertyValue);
                    break;
                default:
                    System.out.println("Not a valid property");
            }
        }
    }
}
