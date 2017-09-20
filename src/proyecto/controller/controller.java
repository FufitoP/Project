package proyecto.controller;

import java.awt.Rectangle;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import proyecto.model.data;
import proyecto.model.model;
import proyecto.model.transicion;
import proyecto.view.view;

public class controller extends MouseAdapter implements MouseListener, ActionListener, MouseMotionListener{
        model model;
        view view;
        data aux = null;
        data pred;
        boolean llave = true;
        
        private int dragFromX = 0;
        private int dragFromY = 0;
        
        private boolean candrag = false;

    public controller(model model, view view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        data d;
        for(int i = 0; i < model.getSeries().size(); i++){
                d = model.getSeries().get(i);
                Rectangle r = new Rectangle(d.getX(), d.getY(), data.sizeBall, data.sizeBall);    
                    
                    //if(aux == d){model.addTransiciones(new transicion(aux, aux, view.getCodigo()));}
                    
                    if(r.contains(e.getPoint()) && aux == null){//Lo q tocó existe
                        aux = d;
                    }
                    
                    else if(r.contains(e.getPoint()) && aux != null){
                        model.addTransiciones(new transicion(aux, d, view.getCodigo()));
                        aux = null;
                    }
            }
        //model.ver();
    }
    
    @Override
    public void mousePressed(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        data d;
        
        for(int i = 0; i < model.getSeries().size(); i++){
                    d = model.getSeries().get(i);
                Rectangle r = new Rectangle(d.getX(), d.getY(), data.sizeBall, data.sizeBall);    
                    
                    if(r.contains(e.getPoint())){
                        pred = d;
                    if(x >= d.getX() && x <= (d.getX() + data.sizeBall) && y >= d.getY() && y <= (d.getY() + data.sizeBall)){
                        candrag = true;
                        dragFromX = x - d.getX();
                        dragFromY = y - d.getY();
                    }
                    else{
                        candrag = false;
                    }
                }
            }
        }
    
    @Override
    public void mouseDragged(MouseEvent e){
                if(candrag){
                    
                    pred.setX(e.getX() - dragFromX);
                    pred.setY(e.getY() - dragFromY);
                    
                    pred.setX(Math.max(pred.getX(), 0));
                    pred.setX(Math.min(pred.getX(), view.getWidth()-data.sizeBall));
                    
                    pred.setY(Math.max(pred.getY(), 0));
                    pred.setY(Math.min(pred.getY(), view.getHeight()-data.sizeBall));
                }
            model.aux();
            }
    
    @Override
      public void mouseExited(MouseEvent e) {
          candrag = false;
      }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Inicial":
                    model.addSeries(new data (view.getEstado(), 'I'));
                break;
                
            case "Intermedio":
                    model.addSeries(new data(view.getEstado(),'M' ));
                break;
                
            case "Final":
                    model.addSeries(new data(view.getEstado(), 'F'));
                break;
                
            case "Limpiar":
                    model.delete();
                break;
                
            case "Hilera":
                    if(model.acepta(view.getHilera())){
                        view.solicitudAprobada();
                    }
                    else{
                        view.solicitudNegada();
                    }
                break;
        }
    }
}