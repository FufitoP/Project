package examen1.control;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import java.awt.Point;

import examen1.control.Control;
import examen1.model.Model;
import examen1.view.View;
import examen1.enteros.Enteros;

public class Control extends MouseAdapter{
    Model model;
    View view;
    int contador = 0;

    public Control(Model model, View view) {
        this.model = model;
        this.view = view;
        view.setModelo(model);
        view.setControlador(this);
    }
    
    // MouseListener Interface
    @Override
    public void mouseClicked(MouseEvent e) {
        Point coord = (Point)((JButton)e.getSource()).getClientProperty("Coordenadas");
            if(model.permiso(coord.x, coord.y)){
                contador++;
            }
            model.verifica(coord.x, coord.y);
        }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}