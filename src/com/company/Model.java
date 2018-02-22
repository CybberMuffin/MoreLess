package com.company;
import java.util.Random;
import java.util.Vector;

public class Model {
    private boolean endGame;
    private int randomNumber;
    private int[] resultInfo = new int[4];
    private Vector collection = new Vector();
    private int lowerBound = 0;
    private int upperBound = 100;
    private int counter = 0;
    private boolean victoryFlag;
    private boolean lowerHigherFlag;

    View view;
    Model(View view){
        this.view = view;
        randomNumber = rand(0, 100);
        resultInfo[1] = 0;
        resultInfo[2] = 100;
    }

    public void calculateResult(int guessNumber){
        counter++;
        if(guessNumber == randomNumber){
            victoryFlag = true;
        }
        else if(guessNumber < randomNumber){
            lowerHigherFlag = false;
            if(guessNumber > lowerBound)
                lowerBound = guessNumber;
        }
        else {
            lowerHigherFlag = true;
            if(guessNumber < upperBound)
                upperBound = guessNumber;
        }
        addNewBorders();
    }

    private void addNewBorders() {
        collection.add(lowerBound);
        collection.add(upperBound);
    }

    private int rand(int a, int b){
        Random random = new Random();
        int num = a + random.nextInt(b - a + 1);
        return num;
    }

    public int[] getCollectionIntArray() {
        int[] arr = new int[collection.size()];
        for (int i = 0; i < collection.size(); i++)
            arr[i] = (Integer)collection.elementAt(i);

        return arr;
    }
    public boolean isEndGame() {
        return endGame;
    }

    public int[] getResultInfo() {
        return resultInfo;
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

    public boolean isVictoryFlag() {
        return victoryFlag;
    }

    public int getCounter() {
        return counter;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public boolean isLowerHigherFlag() {
        return lowerHigherFlag;
    }
}
