public class AVLNode<T> {
    public T          dato;       // el dato del nodo
    public AVLNode<T> izquierdo;  // hijo izquierdo
    public AVLNode<T> derecho;    // hijo derecho
    public int        height;     // altura

    // Constructors
    public AVLNode(){
        this(null);
    }

    public AVLNode(T dato){
        this.dato      = dato;
        this.izquierdo = null;
        this.derecho   = null;
        height         = 0;     // altura predeterminada
    }
}