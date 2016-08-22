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
        Arbol arbol = new Arbol(getRoot(herarquia));
        CreateTree(arbol.getRoot(), herarquia, 1, 1);
        PrintTree(arbol.getRoot(),0);
        System.out.println("");
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

    public static TreeNode getRoot(VSAList herarquia) {
        Arbol arbol = new Arbol();
        for (int i = 0; i < herarquia.Size(); i++) {
            if (herarquia.get(i) instanceof String) {
                String temp = herarquia.get(i).toString();
                if (temp.charAt(0) != '\t') {
                    arbol.setRoot(new TreeNode(temp, null));
                    break;
                }
            }
        }
        return arbol.getRoot();
    }

    public static void CreateTree(TreeNode padre, VSAList herarquia, int cont, int newi) {
        for (int i = newi; i < herarquia.Size(); i++) {
            int cont2 = 0;
            String temp = herarquia.get(i).toString();
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '\t') {
                    cont2 += 1;
                }
            }
            if (cont-1 == cont2) {
                break;
            }
            if (cont2 == cont) {
                String temporal = temp.replace('\t', '\0');
                TreeNode nodo = new TreeNode(temporal, padre);
                padre.getHijos().add(nodo);
                cont2 = 0;
                if (i + 1 < herarquia.Size()) {
                    temp = herarquia.get(i + 1).toString();
                    for (int j = 0; j < temp.length(); j++) {
                        if (temp.charAt(j) == '\t') {
                            cont2 += 1;
                        }
                    }
                    if (cont2 == cont + 1) {
                        CreateTree(nodo,herarquia,cont+1,i+1);
                    }
                }
            }
        }
    }
    public static void PrintTree(TreeNode root,int cont){
        for (int i = 0; i < cont; i++) {
            System.out.print("\t");
        }
        System.out.print(root.getData());
        for (int i = 0; i < root.getHijos().Size(); i++) {
            System.out.println("");
            PrintTree(((TreeNode)(root.getHijos().get(i))),cont+1);
        }
    }
}
