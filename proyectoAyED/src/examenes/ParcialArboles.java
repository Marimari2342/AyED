package examenes;

public class ParcialArboles {

    public ArbolBinario<ArbolSyD> sumAndDif(ArbolBinario<Integer> arbol) {
        if (arbol.isEmpty()) {
            return new ArbolBinario<ArbolSyD>();
        }
        return construir(arbol, 0, 0);
    }

    private ArbolBinario<ArbolSyD> SumaDifConstruir(ArbolBinario<Integer> nodo, int suma, int valorPadre) {
        //Recorrido PREORDEN (Raiz, hI, hD)
        if (nodo.isEmpty()) {
            return null;
        }

        int nuevaSuma = suma + nodo.getData();
        int diferencia = nodo.getData() - valorPadre;

        ArbolSyD aux = new ArbolSyD(nuevaSuma, diferencia);
        ArbolBinario<ArbolSyD> nuevoNodo = new ArbolBinario<ArbolSyD>(aux);

        nuevoNodo.setHijoIzquierdo(construir(nodo.getHijoIzquierdo(), nuevaSuma, nodo.getDato()));
        nuevoNodo.setHijoDerecho(construir(nodo.getHijoDerecho(), nuevaSuma, nodo.getDato()));

        return nuevoNodo;
    }
}
