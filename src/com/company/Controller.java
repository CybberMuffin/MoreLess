package com.company;
import java.util.Scanner;

public class Controller {
    View view;
    Model model;
    public void processUser(){
        view.printMessage(View.RULES);
        while(!model.isEndGame())
            model.response(model.calculateResult(controlData()), model.getCollectionIntArray());
    }

    public Controller(Model model, View view){
        this.view = view;
        this.model = model;
    }
    public int controlData(){
        Scanner in = new Scanner(System.in);

        String userLine = in.nextLine();
        int userNumber = -1;

        while (!isOnlyDigits(userLine) || (userNumber < 0 || userNumber > 100)) {
            if (!isOnlyDigits(userLine)) {
                view.printMessage(View.INCORRECT_TYPE);
                userLine = in.nextLine();
            }
            else {
                userNumber = Integer.parseInt(userLine);
                if ((userNumber < 0 || userNumber > 100)) {
                    view.printMessage(View.INCORRECT_DATA);
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
