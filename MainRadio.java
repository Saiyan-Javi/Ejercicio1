import java.util.Scanner;

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
                        String menu2 = "Elija una de las opciones\n1. Apagar radio\n2. Cambiar AM/FM\n3. Avanzar/Retroceder emisora\n4. Guardar/Cargar emisoras";
                        int opc2 = 0;
                        System.out.println(radio);
                        System.out.println(menu2);
                        opc2 = teclado.nextInt();
                        teclado.nextLine();
                        while(opc2 >= 1 && opc2 < 6){
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
                                        opc3 = 0;
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
                                                break;
                                            }
                                            case 3:{
                                                if(panel.getFrequence().equals("AM")){
                                                    String menu6 = "\nIngrese la frecuencia a la cual quiere cambiar:\n(Recuerde que AM se encuentra entre 530 y 1610 con intervalos de 10)";
                                                    int freq = 0;
                                                    while(freq<530 || freq>1610){
                                                        System.out.println(menu6);
                                                        freq = teclado.nextInt();
                                                        teclado.nextLine();
                                                        if(freq%10 != 0){
                                                            System.out.println("\nFrecuencia invalida, debe ser un multiplo de 10 entre 530 y 1610.");
                                                            freq = 0;
                                                        }
                                                    }
                                                    panel.setAMActualStation(freq);

                                                }
                                                else if(panel.getFrequence().equals("FM")){
                                                    String menu6 = "\nIngrese la frecuencia a la cual quiere cambiar:\n(Recuerde que FM se encuentra entre 87.9 y 107.9 con intervalos de 0.2)";
                                                    double freq = 0;
                                                    while(freq<87.9 || freq>107.9){
                                                        System.out.println(menu6);
                                                        freq = teclado.nextDouble();
                                                        teclado.nextLine();
                                                        if((freq*10)%2 != 1){
                                                            System.out.println("\nFrecuencia invalida, debe ser un valor entre 87.9 y 107.9 con interavalos de 0.2");
                                                            freq = 0;
                                                        }
                                                    }
                                                    panel.setFMActualStation(freq);
                                                }
                                                if(panel.getFrequence().equals("AM")){
                                                    radio = "\n---------------------------------------------------------\n                      Modo: AM\n                  Frecuencia: "+panel.getAMActualStation()+"\n---------------------------------------------------------\n";
                                                }
                                                else {
                                                    if(panel.getFrequence().equals("FM")){
                                                    radio = "\n---------------------------------------------------------\n                      Modo: FM\n                  Frecuencia: "+panel.getFMActualStation()+"\n---------------------------------------------------------\n";
                                                }
                                            }
                                            System.out.println(radio);
                                                break;
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
                                    String menu7 = "\nElija una de las opciones\n1. Guardar emisora\n2. Ver slots de emisora\n3. Para cargar una emisora\n4. Volver al menu anterior";
                                    int opc7 = 0;
                                    System.out.println(menu7);
                                    opc7 = teclado.nextInt();
                                    while(opc7>=1 && opc7<5){
                                        switch(opc7){
                                            case 1:{
                                                String menu71 = "\nIndique en que slot desea guardar la emisora actual";
                                                int slot71 = 0;
                                                while(slot71<1 || slot71>12){
                                                    System.out.println(menu71);
                                                    slot71 = teclado.nextInt();
                                                }
                                                if(panel.getFrequence().equals("AM")){
                                                panel.saveAMStation(panel.getAMActualStation(), slot71);
                                                } else {
                                                    if(panel.getFrequence().equals("FM")){
                                                        panel.saveFMStation(panel.getFMActualStation(), slot71);
                                                    }
                                                }
                                                break;
                                            }
                                            case 2:{
                                                String menu72 = "\nIndique que slot desea ver:\n(Recuerde que van del 1 al 12)";
                                                int slot72 = 0;
                                                while(slot72<1 || slot72>12){
                                                    System.out.println(menu72);
                                                    slot72 = teclado.nextInt();
                                                }
                                                if(panel.getFrequence().equals("AM")){
                                                    System.out.println("\nEl slot tiene ocupado la emisora: "+panel.getAMSlot(slot72));
                                                    } else {
                                                        if(panel.getFrequence().equals("FM")){
                                                            System.out.println("\nEl slot tiene ocupado la emisora: "+panel.getFMSlot(slot72));
                                                        }
                                                    }
                                                System.out.println("\nSi este muestra 0 significa que aun no tiene asignada una emisora.");
                                                break;
                                            }
                                            case 3:{
                                                String menu73 = "\nQue slot de emisora desea cargar:\n(Recuerde que van del 1 al 12)";
                                                int slot73 = 0;
                                                while(slot73<1 || slot73>12){
                                                    System.out.println(menu73);
                                                    slot73 = teclado.nextInt();
                                                }
                                                if(panel.getFrequence().equals("AM")){
                                                    if(panel.getAMSlot(slot73) == 0){
                                                        System.out.println("\nNo se puede cargar este slot porque no tiene guardada una emisora.");
                                                        break;
                                                    }
                                                    else {
                                                    System.out.println("\nSe ha cargado la emisora: "+panel.getAMSlot(slot73));
                                                    panel.setAMActualStation(panel.getAMSlot(slot73));
                                                    radio = "\n---------------------------------------------------------\n                      Modo: AM\n                  Frecuencia: "+panel.getAMActualStation()+"\n---------------------------------------------------------\n";
                                                    }
                                                } else {
                                                    if(panel.getFrequence().equals("FM")){
                                                        if(panel.getFMSlot(slot73) == 0){
                                                            System.out.println("\nNo se puede cargar este slot porque no tiene guardada una emisora.");
                                                            break;
                                                        }
                                                        else {
                                                        System.out.println("\nSe ha cargado la emisora: "+panel.getFMSlot(slot73));
                                                        panel.setFMActualStation(panel.getFMSlot(slot73));
                                                        radio = "\n---------------------------------------------------------\n                      Modo: FM\n                  Frecuencia: "+panel.getFMActualStation()+"\n---------------------------------------------------------\n";
                                                        }
                                                    }
                                                }
                                                System.out.println(radio);
                                                break;
                                            }
                                            case 4:{
                                                opc7 = 0;
                                                opc2 = 0;
                                            }
                                        }
                                        opc7 = 0;
                                    }
                                    break;
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