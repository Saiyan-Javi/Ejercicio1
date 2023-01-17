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
                            radio = "\n---------------------------------------------------------\n                      Modo: AM\n                  Frecuencia: "+panel.getAMActualStation()+"\n---------------------------------------------------------\n";
                            }
                        else {
                            if(panel.getFrequence().equals("FM")){
                                radio = "\n---------------------------------------------------------\n                      Modo: FM\n                  Frecuencia: "+panel.getFMActualStation()+"\n---------------------------------------------------------\n";
                            }
                        }
                        String menu2 = "Elija una de las opciones\n1. Apagar radio\n2. Cambiar AM/FM\n3. Avanzar/Retroceder emisora\n4. Guardar emisora actual\n5. Cargar emisora";
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
                                    break;
                                }
                                case 3:{
                                    String menu4 = "\nElija una de las opciones\n1. Avanzar emisora\n2. Retroceder emisora\n3. Cambiar emisora manualmente\n4. Volver al menu anterior\n(Recuerde que las emisoras de AM avanzan en intervalos de 10 y las de FM de 0.2) ";
                                    int opc4 = 0;
                                    System.out.println(menu4);
                                    opc4 = teclado.nextInt();
                                    teclado.nextLine();
                                    while(opc4>=1 && opc4<5){
                                        switch(opc4){
                                            case 1:{
                                                panel.Forward();
                                                if(panel.getFrequence().equals("AM")){
                                                        radio = "\n---------------------------------------------------------\n                      Modo: AM\n                  Frecuencia: "+panel.getAMActualStation()+"\n---------------------------------------------------------\n";
                                                    }
                                                else {
                                                    if(panel.getFrequence().equals("FM")){
                                                        radio = "\n---------------------------------------------------------\n                      Modo: FM\n                  Frecuencia: "+panel.getFMActualStation()+"\n---------------------------------------------------------\n";
                                                    }
                                                }
                                                System.out.println(radio);
                                                String menu5 = "\nElija una de las opciones\n1. Regresar al menu anterior\n2. Seguir aumentando";
                                                int opc5 = 0;
                                                System.out.println(menu5);
                                                opc5 = teclado.nextInt();
                                                teclado.nextLine();
                                                while(opc5>=1 && opc5<3){
                                                    switch(opc5){
                                                        case 1:{
                                                            opc4 = 0;
                                                            opc5 = 0;
                                                            break;
                                                        }
                                                        case 2:{
                                                            opc5 = 0;
                                                            break;
                                                        }
                                                    }
                                                    opc5 = 0;
                                                }
                                                break;
                                            }
                                            case 2:{
                                                panel.Backward();
                                                if(panel.getFrequence().equals("AM")){
                                                    radio = "\n---------------------------------------------------------\n                      Modo: AM\n                  Frecuencia: "+panel.getAMActualStation()+"\n---------------------------------------------------------\n";
                                                }
                                            else {
                                                if(panel.getFrequence().equals("FM")){
                                                    radio = "\n---------------------------------------------------------\n                      Modo: FM\n                  Frecuencia: "+panel.getFMActualStation()+"\n---------------------------------------------------------\n";
                                                }
                                            }
                                            System.out.println(radio);
                                            String menu5 = "\nElija una de las opciones\n1. Regresar al menu anterior\n2. Seguir disminuyendo";
                                            int opc5 = 0;
                                            System.out.println(menu5);
                                            opc5 = teclado.nextInt();
                                            teclado.nextLine();
                                            while(opc5>=1 && opc5<3){
                                                switch(opc5){
                                                    case 1:{
                                                        opc4 = 0;
                                                        opc5 = 0;
                                                        break;
                                                    }
                                                    case 2:{
                                                        opc5 = 0;
                                                        break;
                                                    }
                                                }
                                                opc5 = 0;
                                            }
                                            break;
                                            }
                                            case 3:{

                                            }
                                            case 4:{
                                                opc2 = 0;
                                                opc4 = 0;
                                                break;
                                            }
                                        }
                                        opc4 = 0;
                                    }
                                    break;
                                }
                                case 4:{

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