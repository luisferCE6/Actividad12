/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad12;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ferna
 */
public class Actividad12{

    //Menú
    public static int menu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.println("############MENU###########");
        System.out.println("# 1. Mostrar contactos    #");
        System.out.println("# 2. Crear nuevo contacto #");
        System.out.println("# 3. Eliminar contacto    #");
        System.out.println("# 4. Salir                #");
        System.out.println("###########################");

        try {
            opcion = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Selecciona una opción valida del menú.");
            return menu();
        }

        if (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4) {
            return menu();
        }

        return opcion;
    }

    public static void main(String[] args) {

        //Variables
        boolean exitApp = false;

        //Objetos
        AddressBook contactos = new AddressBook();

        //Implementación
        contactos.load();

        do {
            switch (menu()) {
                case 1:
                    contactos.list();
                    break;

                case 2:
                    contactos.create();
                    break;

                case 3:
                    contactos.delete();
                    break;

                case 4:
                    exitApp = true;
                    break;
            }
        } while (exitApp == false);

        try {
            contactos.save();
        } catch (IOException ex) {
            Logger.getLogger(Actividad12.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
