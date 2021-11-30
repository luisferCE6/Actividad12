/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author ferna
 */

public class AddressBook implements Serializable {

    HashMap<String, String> book = new HashMap<String, String>();

    public void load() {
        try {
            FileInputStream dataIn = new FileInputStream("data.txt");
            ObjectInputStream in = new ObjectInputStream(dataIn);
            this.book = (HashMap) in.readObject();
        } catch (Exception e) {

        }
    }

    public void save() throws FileNotFoundException, IOException {
        FileOutputStream dataOut = new FileOutputStream("data.txt");
        try (ObjectOutputStream out = new ObjectOutputStream(dataOut)) {
            out.writeObject(this.book);
        }
    }

    public void list() {
        for (String phone : this.book.keySet()) {
            String key = phone.toString();
            String value = this.book.get(phone).toString();
            System.out.println(key + " " + value);
        }
    }

    public void create() {
        Scanner sc = new Scanner(System.in);
        String phone, name;
        System.out.print("\n Teléfono: ");
        phone = sc.nextLine();
        System.out.print("\n Nombre del contacto: ");
        name = sc.nextLine();
        this.book.put(phone, name);
        System.out.println("\n Se agregó el contacto con exito. \n");
    }

    public void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Qué teléfono desea eliminar?");
        this.book.remove(sc.nextLine());
    }

}
