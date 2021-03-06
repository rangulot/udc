package JAVA.Pila;

import java.util.Stack;

public class Pila {
    private Stack<Carro> pila;
    private int size;
    private Carro [] arrayPila;
    
    public Pila() {
        pila = new Stack<>();
        size = 0;
    }

    public void agregar(Carro carro) {
        pila.push(carro);
        System.out.println("Carro de "+carro.getPlaca()+" ha sido AGREGADO");
        size++;
    }

    public int buscar(String placa){
        for(int i = 0; i < size; i++){
            if(pila.get(i).getPlaca().equals(placa.toUpperCase())){
                return i;
            }
        }
        return -1;
    }

    public void pilaToArray(){
        arrayPila = new Carro[size];
        for(int i = 0; i < size; i++){
            arrayPila[i] = pila.get(i);
        }
    }

    public void arrayToPila(){
        pila.clear();
        size = 0;
        for(int i = 0; i < arrayPila.length; i++){
            pila.push(arrayPila[i]);
            size++;
        }
    }

    public void ordenar(){
        pilaToArray();
        Carro [] aux = new Carro[size];
        int i = 0;
        int j = 0;
        while(i < size){
            for(j = 0; j < size; j++){
                if(arrayPila[i].getPlaca().compareTo(arrayPila[j].getPlaca()) < 0){
                    aux[i] = arrayPila[i];
                    arrayPila[i] = arrayPila[j];
                    arrayPila[j] = aux[i];
                }
            }
            i++;
        }
        System.out.println("COLECCION DE CARROS ORDENADA");
        arrayToPila();
    }

    public void desordenar(){
        pilaToArray();
        Carro [] arrayPilaInv = new Carro[size];
        for(int i = 0; i < size; i++){
            arrayPilaInv[i] = arrayPila[size - 1 - i];
        }
        
        for(int i = 0; i < size; i++){
            arrayPila[i] = arrayPilaInv[i];
        }
        System.out.println("COLECCION DE CARROS DESORDENADA");
        arrayToPila();
    }

    public void eliminar(String placa){
        int ctrl = 0;
        for(int i = 0; i < size; i++){
            if(pila.get(i).getPlaca().equals(placa)){
                pila.remove(i);
                size--;
                System.out.println("Carro de "+placa+" ha sido eliminado");
                ctrl = 0;
                break;
            }else{
                ctrl++;
            }
        }

        if(ctrl > 0){
            System.out.println("Placa no encontrada");
        }
    }

    public void insertar(int pos, Carro carro){
        if(pos >= 0 && pos < size){
            pila.add(pos, carro);
            if(pos == 0){
                System.out.println("Carro de "+carro.getPlaca()+" ha sido INSERTADO en la CABEZA de la colecci??n");    
            }
            System.out.println("Carro de "+carro.getPlaca()+" ha sido INSERTADO en la POSICION ["+pos+"] de la colecci??n");
            size++;
        }else{
            System.out.println("Posicion no valida");
        }
    }

    public void recorrerInicioFin(){
        for (int i = 0; i < size; i++) {
            System.out.println(pila.elementAt(i).getPlaca());
        }
    }

    public void recorrerFinInicio(){
        for (int i = size - 1; i >= 0; i--) {
            System.out.println(pila.elementAt(i).getPlaca());
        }
    }

    public void imprimir() {
        for (int i = 0; i < size; i++) {
            System.out.println(pila.elementAt(i));
        }
    }

    public void imprimir(int indice) {
        System.out.println(pila.elementAt(indice));
    }
}
