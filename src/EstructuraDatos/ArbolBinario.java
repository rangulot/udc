package EstructuraDatos;

import java.util.ArrayList;
import java.util.Collections;

public class ArbolBinario {
    private Nodo raiz;
    private int contadorNodos;
    private int contadorHojas;
    private int contadorNiveles;
    private ArrayList<Integer> numeros;
    private ArrayList<Nodo> hojas;
    private ArrayList<Nodo> nodos;
    private ArrayList<ArrayList<Nodo>> nodosPorNivel;
    private ArrayList<ArrayList<Nodo>> nodosPorNivelIntercambiado;
    private ArrayList<Nodo> internos;

    public ArbolBinario(){
        raiz = null;
        contadorNiveles = 1;
        numeros = new ArrayList<Integer>();
        hojas = new ArrayList<Nodo>();
        internos = new ArrayList<Nodo>();
        nodos = new ArrayList<Nodo>();
        nodosPorNivel = new ArrayList<ArrayList<Nodo>>();
        nodosPorNivelIntercambiado = new ArrayList<ArrayList<Nodo>>();
    }
    
    public void agregarNodo(Nodo nodo, Nodo padre){
        Nodo temp = padre;
        
        if(raiz == null){
            raiz = nodo;
        }else if(temp.getIzquierdo() != null){
            nodo.setPadre(temp);
            temp.setDerecho(nodo);
            contadorNiveles++;
            }else {
                nodo.setPadre(padre);
                temp.setIzquierdo(nodo);
            }
            contadorNodos++;
    }

    public void preOrden(Nodo padre){
        if(padre != null){
            System.out.print(padre.getDato()+" ");
            preOrden(padre.getIzquierdo());
            preOrden(padre.getDerecho());

            if(padre.getIzquierdo() == null && padre.getDerecho() == null){
                contadorHojas++;
            }
        }
    }

    public void inOrden(Nodo padre){
        if(padre != null){
            inOrden(padre.getIzquierdo());
            System.out.print(padre.getDato()+" ");
            inOrden(padre.getDerecho());
        }
    }

    public void postOrden(Nodo padre){
        if(padre != null){
            postOrden(padre.getIzquierdo());
            postOrden(padre.getDerecho());
            System.out.print(padre.getDato()+" ");
        }
    }

    public void arbolToArray(Nodo padre, int iterador){
        if(padre != null){
            
            if(padre.getNivel() == iterador){
                nodos.add(padre);
                iterador++;
            }

            arbolToArray(padre.getIzquierdo(), iterador);
            arbolToArray(padre.getDerecho(), iterador);
        }
    }

    public void arbolToArrayNumeros(Nodo padre){
        if(padre != null){
            arbolToArrayNumeros(padre.getIzquierdo());
            numeros.add(((Number) padre.getDato()).intValue());
            arbolToArrayNumeros(padre.getDerecho());
        }
    }

    public void nodosNivelToArray(){
        int nivelTemp = 0;
        int indiceDeRepetido = 0;

        ArrayList<Nodo> filaTemp = new ArrayList<Nodo>();

        for (int i = 0; i < nodos.size(); i++) {
            filaTemp = new ArrayList<Nodo>();
            nivelTemp = nodos.get(i).getNivel();

            //System.out.println(nodos.get(i).getDato()+" NIVELTEMP = "+nivelTemp);

            if(nodos.get(i).getTipo().equals("raiz")){
                filaTemp.add(nodos.get(i));
            }else{
                for (int j = 1; j < nodos.size(); j++) {
                    if(nodos.get(j).getNivel() == nivelTemp){
                        System.out.println(nodos.get(j).getDato()+" NIVEL = "+nodos.get(j).getNivel()+" NIVELTEMP = "+nivelTemp);
                        filaTemp.add(nodos.get(j));
                        indiceDeRepetido = j;
                        System.out.println("I = "+i);
                        System.out.println("J = "+j);
                    }
                }
                
                //i = indiceDeRepetido + 1;
            }
            
            /*for (Nodo nodo : filaTemp) {
                System.out.print(nodo.getDato()+" ");
            }
            System.out.println("");*/
            nodosPorNivel.add(filaTemp);
        }
    }

    public int valorMayor(){
        arbolToArrayNumeros(raiz);
        Collections.sort(numeros);
        return numeros.get(numeros.size()-1);
    }

    public int promedio(){
        int sumatoria = 0;
        for (int i = 0; i < numeros.size(); i++) {
            sumatoria += numeros.get(i);
        }
        return sumatoria/numeros.size();
    }

    public void tomarHojas(Nodo padre){
        asignarNivel(padre, 0);
        if(padre != null){
            tomarHojas(padre.getIzquierdo());
            tomarHojas(padre.getDerecho());

            if(padre.getIzquierdo() == null && padre.getDerecho() == null){
                hojas.add(padre);
                contadorHojas++;
            }
        }
    }

    public void asignarNivel(Nodo padre, int nivelInicial){
        if(padre == null || nivelInicial > contadorNiveles){
            return;
        }

        if(nivelInicial == 0){
            padre.setNivel(0);
        }else{
            padre.setNivel(nivelInicial);
        }

        asignarNivel(padre.getIzquierdo(), nivelInicial+1);
        asignarNivel(padre.getDerecho(), nivelInicial+1);
    }

    public void asignarTipo(Nodo padre){
        if(padre == null){
            return;
        }

        if(padre.getNivel() == 0){
            padre.setTipo("raiz");
        }else{
            padre.setTipo("padre");
        }

        if(padre.getIzquierdo() == null && padre.getDerecho() == null){
            padre.setTipo("hoja");
        }

        asignarTipo(padre.getIzquierdo());
        asignarTipo(padre.getDerecho());
    }

    public void intercambiarSubarbol(Nodo padre){
        if(padre == null){
            return;
        }
        
        if(padre.getIzquierdo() == null && padre.getDerecho() == null){
            return;
        }

        Nodo temp = padre.getIzquierdo();
        padre.setIzquierdo(padre.getDerecho());
        padre.setDerecho(temp);

        if(padre.getIzquierdo() != null){
            intercambiarSubarbol(padre.getIzquierdo());
        }

        if(padre.getDerecho() != null){
            intercambiarSubarbol(padre.getDerecho());
        }
    }

    public void imprimir(){
        //System.out.print("PRUEBA = "+nodosPorNivel.get(1).get(1).getDato());
        
        /*for (int i = 0; i < nodosPorNivel.size(); i++) {
            for (int j = 0; j <  nodosPorNivel.get(i).size(); j++) {
                System.out.print(nodosPorNivel.get(i).get(j).getDato());
            }
            System.out.println();
        }*/

        for (Nodo nodo : nodos) {
            System.out.println(nodo.getDato()+"---->"+nodo.getNivel()+"---->"+nodo.getTipo());

        }
    }

    public Nodo getRaiz(){
        return raiz;
    }

    public int getContadorNodos(){
        return contadorNodos;
    }

    public int getContadorHojas(){
        return contadorHojas;
    }

    public int getContadorNiveles(){
        return contadorNiveles;
    }

    public ArrayList<Integer> getNumeros(){
        return numeros;
    }

    public ArrayList<Nodo> getHojas(){
        tomarHojas(raiz);
        return hojas;
    }

    public ArrayList<Nodo> getInternos(){
        internos.add(raiz);
        for (int i = 0; i < nodos.size(); i++) {
            if(nodos.get(i).getTipo() == "padre"){
                internos.add(nodos.get(i));
            }
        }
        return internos;
    }
}
