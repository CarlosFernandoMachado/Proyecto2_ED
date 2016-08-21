/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_2;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author carlos
 */
public class Proyecto_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VSAList herarquia = leerarchivo();
        for (int i = 0; i < herarquia.Size(); i++) {
            System.out.println(((String)(herarquia.get(i))));
        }
        if (((String)(herarquia.get(0))).charAt(0) == '\t') {
            System.out.println("SI FUNCIONA");
        }
    }
    public static VSAList leerarchivo() {
        VSAList herarquia = new VSAList();
        String cadena;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("Arbol.txt");
            br = new BufferedReader(fr);
            while ((cadena = br.readLine()) != null) {
                herarquia.add(cadena);
            }
        } catch (Exception e) {
        }
        try {
            br.close();
        } catch (Exception e) {
        }
        return herarquia;
    }
}
