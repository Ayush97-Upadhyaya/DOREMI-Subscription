package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import com.example.geektrust.Calculate.TotalCollection;
import com.example.geektrust.Constants.CommandConstants;

public class Main {

    private static TotalCollection collection;
    public static void main(String[] args) {
        /*
        Sample code to read from file passed as command line argument*/
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            collection = new TotalCollection();
            while (sc.hasNextLine()) {
               //Add your code here to process input commands
               runCommand(sc.nextLine());
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private static void runCommand(String command)
    {
        String[] splitCommand = command.split(" ");
        switch(splitCommand[0])
        {
            case CommandConstants.BALANCE:
                collection.createMetroCard(splitCommand[1], Float.parseFloat(splitCommand[2]));
                break;
            case CommandConstants.CHECK_IN:
                collection.checkInForTravel(splitCommand[1], splitCommand[2], splitCommand[3]);
                break;
            case CommandConstants.PRINT_SUMMARY:
                collection.printSummary();
                break;
        }
    }
}
