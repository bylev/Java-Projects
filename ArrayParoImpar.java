
public class ArrayParoImpar {
    public static void main(String[] args){
        int[] arreglo = new int[20];

        //Crear un array random del 1-20
        for(int i = 0;  i<arreglo.length; i++){
            arreglo[i] = (int)(Math.random()*100);
    }
    
    //Imprimir mi arreglo
    for(int i = 0; i<arreglo.length; i++){
        System.out.println("P" + i + ": " + arreglo[i]);
    }
    
    int pares = 0;
    int impares = 0;
    for(int i = 0; i<arreglo.length; i++){
        if(arreglo[i] % 2 == 0){
            pares++;
        }else{
            impares++;
        }
    }
    
    System.out.println("======================================================");
    System.out.println("Pares: " + pares);
    System.out.println("Impares: " + impares);

    System.out.println("======================================================");
    //Crear nuevo arreglo con los pares
    int[] arregloNuevo= new int[pares];
    int j = 0;
    
    for (int i = 0; i < arreglo.length; i++) {
        if (arreglo[i] % 2 == 0) {
            arregloNuevo[j] = arreglo[i];
            j++;
        }
    }
        for(int i = 0; i<arregloNuevo.length; i++){
        System.out.println("P" + i + ": " + arregloNuevo[i]);
    }

    


}
}
