public class ProbarAVLTree {
    
    public static void main(String[] args) {
        
        AVLTree<Integer> arbolAVL  = new AVLTree();
        
        int dato;
        for (int i = 0; i < 14; i++) {
            dato = (int)((Math.random() * 99) + 1);
            arbolAVL.insert(dato);
        }
        
        arbolAVL.imprimirPorNiveles();
        System.out.println("\n");
        
        long time1 = System.nanoTime();
        arbolAVL.preOrder();
        long time2 = System.nanoTime();
        
        long time3 = System.nanoTime();
        arbolAVL.inOrder();
        long time4 = System.nanoTime();
        
        long time5 = System.nanoTime();
        arbolAVL.postOrder();
        long time6 = System.nanoTime();
        
        long time7 = System.nanoTime();
        arbolAVL.insert(500);
        long time8 = System.nanoTime();
        
        long time9 = System.nanoTime();
        arbolAVL.isThere(500);
        long time10 = System.nanoTime();
        
        System.out.println();
        double dif1 = (double)(time2 - time1) * 1.0e-9;
        double dif2 = (double)(time4 - time3) * 1.0e-9;
        double dif3 = (double)(time6 - time5) * 1.0e-9;
        double dif4 = (double)(time8 - time7) * 1.0e-9;
        double dif5 = (double)(time10 - time9) * 1.0e-9;
        System.out.println("El tiempo que toma para el preOrder es: " + dif1 + " segundos");
        System.out.println("El tiempo que toma para el inOrder es: " + dif2 + " segundos");
        System.out.println("El tiempo que toma para el postOrder es: " + dif3 + " segundos");
        System.out.println("El tiempo que toma para el insert es: " + dif4 + " segundos");
        System.out.println("El tiempo que toma para el isThere es: " + dif5 + " segundos");
        System.out.println();
        
        arbolAVL.printer();
    }

}
