package com.company;
import java.util.Scanner;

public class Controller {
    View view;
    Model model;
    public void processUser(){
        view.printMessage(View.RULES);
        while(!model.isEndGame())
            model.calculateResult(controlData());
            response(model.getCounter(), model.getCollectionIntArray());
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

    public void response(int counter, int[] stats){
        if(model.isVictoryFlag()){
            view.victoryMessageAndStats(stats, counter);
            model.setEndGame(true);
        }
        else if(model.isLowerHigherFlag()){
            view.printMessageAndBounds(View.NUMBER_IS_GREATER, model.getLowerBound(), model.getUpperBound());
        }
        else if(!model.isLowerHigherFlag()) {
            view.printMessageAndBounds(View.NUMBER_IS_LESS, model.getLowerBound(), model.getUpperBound());
        }
    }

    private static boolean isOnlyDigits(String str) {
        return str.matches("[\\d]+");
    }
}
