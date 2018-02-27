package com.company;
import java.util.Scanner;

public class Controller {
    View view;
    Model model;
    public void processUser(){
        view.printMessage(View.RULES);
        while(!model.isEndGame())
            response(model.calculateResult(controlData()), model.getCollectionIntArray());
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

    public void response(int[] result, int[] stats){
            if(result[0] == 1){
                view.victoryMessageAndStats(stats, result[3]);
                model.setEndGame(true);
            } else if (result[0] == 2) {
                view.printMessageAndBounds(View.NUMBER_IS_GREATER, result[1], result[2]);
    }
            else if (result[0] == 3){
                view.printMessageAndBounds(View.NUMBER_IS_LESS, result[1], result[2 ]);
            }
    }

    private static boolean isOnlyDigits(String str) {
        return str.matches("[\\d]+");
    }
}
