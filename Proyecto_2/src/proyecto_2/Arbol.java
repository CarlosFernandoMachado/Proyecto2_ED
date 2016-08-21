/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_2;

/**
 *
 * @author carlos
 */
public class Arbol {
    TreeNode root;

    public Arbol(TreeNode root) {
        this.root = root;
    }

    public Arbol() {
        root = null;
    }
    
    public TreeNode father(TreeNode nodo){
        return nodo.getFather();
    }
    
    public TreeNode Leftestson(TreeNode nodo){
        return nodo.Leftestson();
    }
    
    public TreeNode Rightbrother(TreeNode nodo){
        return nodo.Rightbrother();
    }
    
    public Object label(TreeNode nodo){
        return nodo.getData();
    }
    
    public Arbol create(Object data,VSAList nodos){
        TreeNode temp = new TreeNode(data,null,nodos);
        Arbol newtree = new Arbol(temp);
        return newtree;
    }
    
    public  TreeNode getRoot(){
        if (root == null) {
            return null;
        }
        return root;
    }
    
    public void clear(){
        root = null;
    }
}
