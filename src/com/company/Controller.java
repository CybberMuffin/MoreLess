package com.company;
import java.util.Scanner;

public class Controller {
    public int controlData(){
        Scanner in = new Scanner(System.in);

        String userLine = in.nextLine();
        int userNumber = -1;

        while (!isOnlyDigits(userLine) || (userNumber < 0 || userNumber > 100)) {
            if (!isOnlyDigits(userLine)) {
                View.message(View.INCORRECT_TYPE);
                userLine = in.nextLine();
            }
            else {
                userNumber = Integer.parseInt(userLine);
                if ((userNumber < 0 || userNumber > 100)) {
                    View.message(View.INCORRECT_DATA);
                    userLine = in.nextLine();
                }
            }
        }
        return userNumber;
    }

    private static boolean isOnlyDigits(String str) {
        return str.matches("[\\d]+");
    }
}
