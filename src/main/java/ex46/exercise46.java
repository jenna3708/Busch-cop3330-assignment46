package ex46;

/*
 *  UCF COP3330 Fall 2021 Assignment 46 Solution
 *  Copyright 2021 Jenna Busch
 */

//pseudocode
//I will first need to make a new class for the animals containing their info
//I will then need to loop through the input file and count the frequencies
//of each animal
//I can then make animal objects for each one and enter the amount inside them
//Then sort the array list of animals in order of highest to lowest frequency
//after I have them sorted i can print out the histogram

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class exercise46 {

    public static class animal
    {
        private int amount;
        private String name;

        public animal(int a, String n)
        {
            amount = a;
            name = n;
        }

        public String getName()
        {
            return name;
        }
        public int getAmount()
        {
            return amount;
        }
        public String toString()
        {
            return String.valueOf(amount) + name;
        }

        public static Comparator<animal> amountComparator = new Comparator<animal>()
        {
            public int compare(animal a1, animal a2)
            {
                return a2.getAmount() - a1.getAmount();
            }
            //less than zero if a2 is less that a1
        };

    }

    public static void main(String[] args) throws FileNotFoundException {
        int bCount = 0;
        int sCount = 0;
        int mCount = 0;

        //create a scanner
        Scanner input = new Scanner(System.in);
        File file = new File("src/main/java/ex46/exercise46_input.txt");
        Scanner inputFile = new Scanner(file);

        //go through input file and count up num of repeats
        while(inputFile.hasNext())
        {
            String words = inputFile.next();
            if(words.equals("badger"))
            {
                bCount++;
            }
            if(words.equals("mushroom"))
            {
                mCount++;
            }
            if(words.equals("snake"))
            {
                sCount++;
            }

        }

        //make the animals
        animal badger = new animal(bCount, "badger");
        animal mushroom = new animal(mCount, "mushroom");
        animal snake = new animal(sCount, "snake");

        //make an array list of the animals and add them
        ArrayList<animal> animals = new ArrayList<animal>();
        animals.add(badger);
        animals.add(mushroom);
        animals.add(snake);

        //sort the array
        Collections.sort(animals, animal.amountComparator);

        //now that we know the frequency we need to make the histogram
        //and print in the correct order
        for(int i = 0; i < animals.size(); i++)
        {
            String amnimnal = animals.get(i).getName()+":";

            //printing out the frequency by each entry
            String stars = "";
            for(int j = 0; j < animals.get(i).getAmount(); j++)
            {
                stars += '*';
            }
            System.out.printf("%-9s %-9s", amnimnal, stars); //formatting the line so they are even
            System.out.println();
        }

    }
}

