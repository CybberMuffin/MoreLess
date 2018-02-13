package com.company;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller();
        View look =  new View();

        View.message(View.RULES);
        while(!look.isContinueSwitcher())
            look.response(model.calculateResult(controller.controlData()), model.getCollection());
    }
}
