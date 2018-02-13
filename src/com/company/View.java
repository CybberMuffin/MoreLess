package com.company;

public class View {
    public static final String RULES = "Try to guess a NUMBER from 0 to 100. Use integers only.\nEnter your number: ";
    public static final String INCORRECT_DATA = "Your number is out of bounds.\n" +
            "Try to guess a NUMBER from 0 to 100.\n" +
            "Enter your number: ";
    public static final String INCORRECT_TYPE = "Incorrect data type. Use natural integers only.\n" +
            "Enter your number: ";
    public static final String NUMBER_IS_GREATER = "Miss. The NUMBER you trying to guess is greater.\n" +
            "Try to guess on updated  interval [";
    public static final String NUMBER_IS_LESS = "Miss. The NUMBER you trying to guess is less.\n" +
            "Try to guess on updated  interval [";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printMessageAndBounds(String message, int lowerBound, int higherBound){
        System.out.println(message + lowerBound + "; " + higherBound + "].\nEnter your number: ");
    }

    public void victoryMessageAndStats(int[] stats, int numberOfTurns){
        System.out.println("Congratulations! You won!\n" +
                "You made " + numberOfTurns + " guesses to won this game!\n" +
                "Your gamestory:\n");

        for (int i = 0; i < (stats.length / 2); i++){
            if(i == stats.length / 2 - 1)
                System.out.println("Turn " + (i + 1) + " -> Victory!");
            else
                System.out.println("Turn " + (i + 1) + " Range: [" + stats[i * 2] +
                        "; " + stats[i * 2 + 1] + "].");
        }
    }

}
