package com.company;

public class View {
    private boolean continueSwitcher = false;
    public static final String RULES = "Try to guess a NUMBER from 0 to 100. Use integers only.\nEnter your number: ";
    public static final String INCORRECT_DATA = "Your number is out of bounds.\n" +
            "Try to guess a NUMBER from 0 to 100.\n" +
            "Enter your number: ";
    public static final String INCORRECT_TYPE = "Incorrect data type. Use natural integers only.\n" +
            "Enter your number: ";

    public static void message(String message){
        System.out.println(message);
    }

    public void response(int[] result, int[] stats){
        if(result[0] == 1){
            System.out.println("Congratulations! You won!\n" +
                "You made " + result[3] + " guesses to won this game!\n" +
                "Your gamestory:\n");

            for (int i = 0; i < (stats.length / 2); i++){
                if(i == stats.length / 2 - 1)
                    System.out.println("Turn " + (i + 1) + " -> Victory!");
                else
                    System.out.println("Turn " + (i + 1) + " Range: [" + stats[i * 2] +
                        "; " + stats[i * 2 + 1] + "].");
            }
            continueSwitcher = true;
        }
        else if(result[0] == 2){
            System.out.println("Miss. The NUMBER you trying to guess is greater.\n" +
                    "Try to guess on updated  interval [" + result[1] + "; " + result[2] + "].\n" +
                    "Enter your number: ");
        }
        else if(result[0] == 3) {
            System.out.println("Miss. The NUMBER you trying to guess is less.\n" +
                    "Try to guess on updated  interval [" + result[1] + "; " + result[2] + "].\n" +
                    "Enter your number: ");
        }
    }

    public boolean isContinueSwitcher() {
        return continueSwitcher;
    }
}
