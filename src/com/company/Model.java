package com.company;
import java.util.Random;
import java.util.Vector;

public class Model {
    private boolean endGame;
    private int randomNumber;
    private int[] resultInfo = new int[4];
    private Vector collection = new Vector();
    View view;
    Model(View view){
        this.view = view;
        randomNumber = rand(0, 100);
        resultInfo[1] = 0;
        resultInfo[2] = 100;
    }

    public int[] calculateResult(int guessNumber){
        resultInfo[3]++;
        if(guessNumber == randomNumber){
            resultInfo[0] = 1;
        }
        else if(guessNumber < randomNumber){
            resultInfo[0] = 2;
            if(guessNumber > resultInfo[1])
                resultInfo[1] = guessNumber;
        }
        else {
            resultInfo[0] = 3;
            if(guessNumber < resultInfo[2])
                resultInfo[2] = guessNumber;
        }
        addNewBorders();
        return resultInfo;
    }

    private void addNewBorders() {
        collection.add(resultInfo[1]);
        collection.add(resultInfo[2]);
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

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

}
