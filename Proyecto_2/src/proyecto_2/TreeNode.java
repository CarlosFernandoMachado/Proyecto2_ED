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
public class TreeNode {

    private Object data;
    private TreeNode father;
    private VSAList hijos;

    public TreeNode(Object data, TreeNode father) {
        this.data = data;
        this.father = father;
        hijos = new VSAList();
    }

    public TreeNode(Object data, TreeNode father, VSAList hijos) {
        this.data = data;
        this.father = father;
        this.hijos = hijos;
    }

    public TreeNode(TreeNode nodo) {
        data = nodo.getData();
        father = nodo.getFather();
        hijos = nodo.getHijos();
    }
    
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public TreeNode getFather() {
        return father;
    }

    public void setFather(TreeNode father) {
        this.father = father;
    }

    public TreeNode Leftestson() {
        if (hijos.Size() == 0) {
            return null;
        }
        return ((TreeNode)(hijos.get(0)));
    }
    
    public TreeNode Rightbrother(){
        if (father == null) {
            return null;
        }
        VSAList temp = father.getHijos();
        int me = temp.indexOf(this);
        if (temp.get(me+1) != null) {
            return ((TreeNode)(temp.get(me+1)));
        }
        return null;
    }
    
    public VSAList getHijos(){
        return hijos;
    }
}
