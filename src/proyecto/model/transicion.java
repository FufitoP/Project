package proyecto.model;

public class transicion {
    public data Inicial;
    public data Final;
    String codigo;
    
    public transicion(data Inicial, data Final, String codigo){
        this.Inicial = Inicial;
        this.Final = Final;
        this.codigo = codigo;
    }
    
    public boolean estadoLocal(char caracter){
        if(codigo.indexOf(caracter) != -1){
            return true;
        }
        return false;
    }

    public data getInicial() {
        return Inicial;
    }

    public data getFinal(){
        return Final;
    }

    public String getCodigo() {
        return codigo;
    }
    
    public void setInicial(data Inicial){
        this.Inicial = Inicial;
    }
    
    public void setFinal(data Final){
        this.Final = Final;
    }
    
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
      
    
}