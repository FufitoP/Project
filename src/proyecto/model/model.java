package proyecto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class model extends Observable{

    List<data> series;
    List<transicion> transiciones;
    
    public model() {
        series = new ArrayList<data>();
        transiciones = new ArrayList<transicion>();
    }
    
    public void aux(){
        this.setChanged();
        this.notifyObservers(null); // parametro no usado por ahora        
    }
    
    public List<data> getSeries() {
        return series;
    }
    
    public List<transicion> getTransiciones() {
        return transiciones;
    }
    
    public boolean acepta(String hilera){//su
            //transicion t = new transicion(da, d, "skj");
            //transicion t1 = new transicion(d2, d3, "uij");
        char []v = hilera.toCharArray();
        
        
        for(int i = 0; i < transiciones.size(); i++){//Recorre las transiciones 
            if(i < hilera.length()){
                transiciones.get(i).estadoLocal(v[i]);
            }
            
        }
        
        return false;
    }
    
    public model addSeries(data d){
            series.add(d);
        this.setChanged();
        this.notifyObservers(null); // parametro no usado por ahora
        return this;
    }
    
    public model addTransiciones(transicion t){
            transiciones.add(t);
        this.setChanged();
        this.notifyObservers(null); // parametro no usado por ahora
        return this;
    }
    
    public void delete(){
        series.removeAll(series);
        transiciones.removeAll(transiciones);
        this.setChanged();
        this.notifyObservers(null); // parametro no usado por ahora
    }
    
    public boolean isEmptySeries(){
        return series.isEmpty();
    }
    
    public boolean isEmptyTransiciones(){
        return transiciones.isEmpty();
    }
    public void ver(){
        for(int i=0; i<transiciones.size(); i++){
            System.out.print(transiciones.get(i).getInicial().getX() + "-" + transiciones.get(i).getInicial().getY() + "\n");
            System.out.print(transiciones.get(i).getFinal().getX() + "-" + transiciones.get(i).getFinal().getY() + "\n");
        }
    }
    
    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(null); // parametro no usado por ahora
    }
    
}