public class Radio implements IRadio {
    
    private int estado;
    private int ama;
    private double fma;
    private String freq;

    public Radio(){
        estado = 0;
        ama = 530;
        fma = 87.9;
        freq = "AM";
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

    public String getFrequence(){
        return freq;
    }

    public void setFrequence(String freq){
        this.freq = freq;
    }

    public int getAMActualStation(){
        return ama;
    }

    public double getFMActualStation(){
        return fma;
    }
}
