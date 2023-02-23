package controller;

import dto.Address;
import dto.DVD;
import dto.Studio;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Address testAddress = new Address("Vancouver", "V5V 1Z1", "Canada");
        Studio testStudio = new Studio("TestStudio", testAddress);
        DVD testDVD = new DVD("5", "Joanna", testStudio , "Harry Potter", "2022-02-20", "Brilliant");
        System.out.println(testDVD);
    }
}