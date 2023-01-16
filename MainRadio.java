import java.util.Scanner;
import java.util.ArrayList;

public class MainRadio {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        IRadio panel = new Radio();
        String menu1 = "\nEncienda la radio para acceder al resto de las opciones\n1. Encender radio ";
        int opc1 = 0;

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
                    break;
                }
            }
            while(panel.isOn() == true){
                System.out.print("a");
            }
        }
    }
}