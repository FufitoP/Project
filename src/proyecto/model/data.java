package proyecto.model;

public class data {
    
    public final static int sizeBall = 80;
    
    String nombre;
    char tipo;
    int x;
    int y;

    public data(String nombre, char tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.x = 70;
        this.y = 70;
    }

    public char getTipo(){
        return tipo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}