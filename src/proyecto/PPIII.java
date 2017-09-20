package proyecto;

import proyecto.controller.controller;
import proyecto.model.model;
import proyecto.model.data;
import proyecto.model.transicion;
import proyecto.view.view;

public class PPIII {

    public static void main(String[] args) {
            model model = new model();
            /*view view = new view();
            controller controller = new controller(model,view);
            view.setVisible(true);*/
            
            data d = new data("Data", 'F');
            data da = new data("SDA", 'M');
            data d2 = new data("PP", 'F');
            data d3 = new data("r.", 'I');
            transicion t = new transicion(da, d, "skj");
            transicion t1 = new transicion(d2, d3, "uij");
            
            model.addTransiciones(t);
            model.addTransiciones(t1);
            
            System.out.print(model.acepta("su"));
            
    }
}