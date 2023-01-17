public class Radio implements IRadio {
    
    private int estado;
    private int ama;
    private double fma;
    private String freq;
    private int EmisorasAM[];
    private double EmisorasFM[];

    public Radio(){
        estado = 0;
        ama = 530;
        fma = 87.9;
        freq = "AM";
        this.EmisorasAM = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
        this.EmisorasFM = new double[]{0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
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
                double fmar = fma + 0.2;
                fma = Math.round(fmar*100d) / 100d;
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
                double fmar = fma - 0.2;
                fma = Math.round(fmar*100d) / 100d;
            }
        }
    }

    public int getAMSlot(int slot){
        int emisoraam = EmisorasAM[slot-1];
        return emisoraam;
    }

    public void saveAMStation(int emisora, int slot){
        EmisorasAM[slot-1] = emisora;
        System.out.println("Emisora: "+emisora+" agregada al slot: "+slot);
    }

    public double getFMSlot(int slot){
        double emisorafm = EmisorasFM[slot-1];
        return emisorafm;
    }

    public void saveFMStation(double emisora, int slot){
        EmisorasFM[slot-1] = emisora;
        System.out.println("Emisora: "+emisora+" agregada al slot: "+slot);
    }
}