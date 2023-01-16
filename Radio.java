public class Radio implements IRadio {
    
    private int estado;

    public Radio(){
        estado = 0;
    }


    public boolean isOn(){
        boolean estadoradio;

        if(estado == 0){
            estadoradio = false;
        }
        else{
            estadoradio = true;
        }
        return estadoradio;
    }

    public void on(){
        estado = 1;
    }

    public void off(){
        estado = 0;
    }

}
