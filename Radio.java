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

    public void setAMActualStation(int fam){
        ama = fam;
    }

    public void setFMActualStation(double ffm){
        fma = ffm;
    }

    public void Forward(){
        if(freq.equals("AM")){
            if(ama==1610){
                ama = 530;
            }
            else {
                ama = ama + 10;
            }
        }
        else if(freq.equals("FM")){
            if(fma==107.9){
                fma = 87.9;
            }
            else {
                fma = fma + 0.2;
            }
        }
    }

    public void Backward(){
        if(freq.equals("AM")){
            if(ama==530){
                ama = 1610;
            }
            else {
                ama = ama - 10;
            }
        }
        else if(freq.equals("FM")){
            if(fma==87.9){
                fma = 107.9;
            }
            else {
                fma = fma - 0.2;
            }
        }
    }
}
