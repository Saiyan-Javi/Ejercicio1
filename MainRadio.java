import java.util.Scanner;
import java.util.ArrayList;

public class MainRadio {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        IRadio panel = new Radio();
        String menu1 = "\nEncienda la radio para acceder al resto de las opciones\n1. Encender radio ";
        int opc1 = 0;
        String radio = "";

        while(panel.isOn() != true){
            System.out.println(menu1);
            opc1 = teclado.nextInt();
            teclado.nextLine();
            switch(opc1){
                case 0:{
                    panel.off();
                    break;
                }
                case 1:{
                    panel.on();
                    while(panel.isOn() == true){
                        if(panel.getFrequence().equals("AM")){
                            radio = "\n---------------------------------------------------------\n--                    Modo: AM                         --\n--                Frecuencia: "+panel.getAMActualStation()+"                      --\n---------------------------------------------------------\n";
                            }
                        else {
                            if(panel.getFrequence().equals("FM")){
                                radio = "\n---------------------------------------------------------\n--                    Modo: FM                         --\n--                Frecuencia: "+panel.getFMActualStation()+"                     --\n---------------------------------------------------------\n";
                            }
                        }
                        String menu2 = "Elija una de las opciones\n1. Apagar radio\n2. Cambiar AM/FM\n3. ";
                        int opc2 = 0;
                        System.out.println(radio);
                        System.out.println(menu2);
                        opc2 = teclado.nextInt();
                        teclado.nextLine();
                        while(opc2 >= 1 && opc2 < 5){
                            switch(opc2){
                                case 1:{
                                    panel.off();
                                    opc2 = 0;
                                    break;
                                }
                                case 2:{
                                    String menu3 = "\nElija una de las opciones\n1. AM\n2. FM ";
                                    int opc3 = 0;
                                    System.out.println(menu3);
                                    opc3 = teclado.nextInt();
                                    teclado.nextLine();
                                    while(opc3 >= 1 && opc3 < 3){
                                        switch(opc3){
                                            case 1:{
                                                try{
                                                    panel.setFrequence("AM");
                                                    //System.out.println("AM");
                                                    opc3 = 0;
                                                    opc2 = 0;
                                                } catch(Exception ex) {
                                                    System.out.println("Error detectado");
                                                }
                                                break;
                                            }
                                            case 2:{
                                                try{
                                                    panel.setFrequence("FM");
                                                    opc3 = 0;
                                                    opc2 = 0;
                                                } catch(Exception ex) {
                                                    System.out.println("Error detectado");
                                                }
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                }
            }
        }
    }
}