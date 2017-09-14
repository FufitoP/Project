package proyecto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import proyecto.model.model;
import proyecto.view.view;

public class controller extends MouseAdapter implements MouseListener,ActionListener{

    model model;
    view view;

    public controller(model model, view view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }

        // MouseListener Interface
    @Override
    public void mouseClicked(MouseEvent e) {
//       Point p= e.getPoint();
//        Data d;
//        for(int i=0; i<model.getSeries().size();i++){
//            d= model.getSeries().get(i);
//            Rectangle r = new Rectangle(50+i*70,250-d.getData(),50,d.getData());
//            if (r.contains(p)){
//                model.incrementar(i);
//            }
//        }       
               
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    //    Data d = new Data (view.getColumna(),Integer.parseInt(view.getValor()));
//        model.add(d);    
    }
    
}