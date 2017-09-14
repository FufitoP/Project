package proyecto1;

import proyecto.controller.controller;
import proyecto.model.model;
import proyecto.view.view;

public class PPIII {

    public static void main(String[] args) {
        model model=new model() ;
        view view = new view();
        controller controller = new controller(model,view);
        view.setVisible(true);

    }
}