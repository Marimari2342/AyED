import tp2.ejercicio1.BinaryTree;
import tp2.ejercicio1.ContadorArbol;
import tp2.ejercicio1.ParcialArbolesA;
import tp2.ejercicio1.ParcialArbolesB;
import tp2.ejercicio1.ParcialArbolesC;
import tp2.ejercicio1.ProfundidadArbolBinario;
import tp2.ejercicio1.RedBinariaLlena;
import tp2.ejercicio1.SumDif;
import tp2.ejercicio1.Transformacion;

public class Main {
        public static void main(String[] args) {
            // Creamos un árbol:
            //        1
            //       / \
            //      2   3
            //     / \   \
            //    4   5   6
            //   / \
            //  7   8        --> (tengo 4 hojas)
    
            //Creamos el árbol binario
            BinaryTree<Integer> arbol = new BinaryTree<>(1);
            BinaryTree<Integer> nodo2 = new BinaryTree<>(2);
            BinaryTree<Integer> nodo3 = new BinaryTree<>(3);
            BinaryTree<Integer> nodo4 = new BinaryTree<>(4);
            BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
            BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
            BinaryTree<Integer> nodo7 = new BinaryTree<>(7);
            BinaryTree<Integer> nodo8 = new BinaryTree<>(8);
    
            arbol.addLeftChild(nodo2);
            arbol.addRightChild(nodo3);
            nodo2.addLeftChild(nodo4);
            nodo2.addRightChild(nodo5);
            nodo3.addRightChild(nodo6);
            nodo4.addLeftChild(nodo7);
            nodo4.addRightChild(nodo8);
    
            // CUENTO LAS HOJAS DEL ÁRBOL
            System.out.println("Cantidad de hojas: " + arbol.contarHojas());
            // Debería imprimir: Cantidad de hojas: 4

            // TESTEO EL MÉTODO ESPEJO
            // Original:                Espejo:
            //        1                     1
            //       / \                   / \
            //      2   3                 3   2
            //     / \   \               /   / \
            //    4   5   6     -->     6   5   4
            //   / \                           / \
            //  7   8                         8   7

            BinaryTree<Integer> arbolEspejo = arbol.espejo();
            System.out.print("Árbol original: ");
            arbol.imprimirEnOrden();
            System.out.println();
            System.out.print("Árbol espejo: ");
            arbolEspejo.imprimirEnOrden();
            System.out.println();
        
            // TESTEO IMPRIMIR ENTRE NIVELES
            // Nivel 1 --> 2 3
            // Nivel 2 --> 4 5 6
            System.out.println("Entre niveles 1 y 2:");
            arbol.entreNiveles(1,2);

            // (PUNTO3) TESTEO EL MÉTODO NÚMEROS PARES INORDEN Y POSTORDEN 
            ContadorArbol contador = new ContadorArbol(arbol);
            System.out.println("Números pares inOrden:");
            System.out.println(contador.numerosParesInOrden());
            System.out.println("Números pares postOrden:");
            System.out.println(contador.numerosParesPostOrden());

            // (PUNTO4) TESTEO EL RETARDO DE REENVÍO EN UNA RED BINARIA LLENA
            // Creamos la red binaria llena:
            //            10
            //        /        \
            //       2           3
            //     /   \       /   \
            //    5     4     9     8
            //   / \   / \   / \   / \
            //  7   8 5   6 12  8 2   1     --> (10+3+9+12=34)
            BinaryTree<Integer> red = new BinaryTree<>(10);     
            BinaryTree<Integer> n2 = new BinaryTree<>(2);
            BinaryTree<Integer> n3 = new BinaryTree<>(3);     
            BinaryTree<Integer> n4 = new BinaryTree<>(5);
            BinaryTree<Integer> n5 = new BinaryTree<>(4);
            BinaryTree<Integer> n6 = new BinaryTree<>(9);
            BinaryTree<Integer> n7 = new BinaryTree<>(8); 
            BinaryTree<Integer> n8 = new BinaryTree<>(7);
            BinaryTree<Integer> n9 = new BinaryTree<>(8);         
            BinaryTree<Integer> n10 = new BinaryTree<>(5);
            BinaryTree<Integer> n11 = new BinaryTree<>(6);
            BinaryTree<Integer> n12 = new BinaryTree<>(12);
            BinaryTree<Integer> n13 = new BinaryTree<>(8);
            BinaryTree<Integer> n14 = new BinaryTree<>(2);
            BinaryTree<Integer> n15 = new BinaryTree<>(1);

            red.addLeftChild(n2);
            red.addRightChild(n3);
            n2.addLeftChild(n4);
            n2.addRightChild(n5);
            n3.addLeftChild(n6);
            n3.addRightChild(n7);   
            n4.addLeftChild(n8);
            n4.addRightChild(n9);
            n5.addLeftChild(n10);
            n5.addRightChild(n11);   
            n6.addLeftChild(n12);
            n6.addRightChild(n13);
            n7.addLeftChild(n14);
            n7.addRightChild(n15);
            //creo la red binaria llena
            RedBinariaLlena redBinariaLlena = new RedBinariaLlena(red);
            System.out.println("Retardo de reenvío en la red binaria llena: " + redBinariaLlena.retardoReenvio());
        
            // (PUNTO5) TESTEO LA SUMA DE ELEMENTOS A UNA PROFUNDIDAD DADA
            // Suma de elementos a profundidad 2: 4 + 5 + 6
            ProfundidadArbolBinario prof = new ProfundidadArbolBinario(arbol);
            prof.sumaElementosProfundidad(0);
            prof.sumaElementosProfundidad(1);
            prof.sumaElementosProfundidad(2);
            prof.sumaElementosProfundidad(3);

            // (Punto6) TESTEO TRANSFORMACIÓN DEL ÁRBOL
                // Arbol:                      Resultado:
            //            1                       35
            //         /     \                  /    \
            //        2       3                4      26
            //         \     / \       -->      \    /  \
            //          4   5   6                0  15   0
            //             / \                     /  \
            //            7   8                   0    0

            BinaryTree<Integer> arbolB = new BinaryTree<>(1);
            BinaryTree<Integer> nodoB2 = new BinaryTree<>(2);    
            BinaryTree<Integer> nodoB3 = new BinaryTree<>(3);
            BinaryTree<Integer> nodoB4 = new BinaryTree<>(4);
            BinaryTree<Integer> nodoB5 = new BinaryTree<>(5);    
            BinaryTree<Integer> nodoB6 = new BinaryTree<>(6);
            BinaryTree<Integer> nodoB7 = new BinaryTree<>(7);
            BinaryTree<Integer> nodoB8 = new BinaryTree<>(8);
            arbolB.addLeftChild(nodoB2);
            arbolB.addRightChild(nodoB3);
            nodoB2.addRightChild(nodoB4);
            nodoB3.addLeftChild(nodoB5);
            nodoB3.addRightChild(nodoB6);
            nodoB5.addLeftChild(nodoB7);
            nodoB5.addRightChild(nodoB8);
            Transformacion a = new Transformacion(arbolB);
            a.suma();
            a.getArbol().imprimirEnOrden();

            // (Punto7) TESTEO PARCIAL DE ÁRBOLES
            // Creamos un árbol:
            //            2
            //          /   \
            //         7    -5
            //        / \     \
            //      23   6     19
            //     /    / \      \
            //   -3   55   11     4
            //                   /
            //                 18

            BinaryTree<Integer> arbolParcial = new BinaryTree<>(2);
            BinaryTree<Integer> nodoP7 = new BinaryTree<>(7);
            BinaryTree<Integer> nodoP5 = new BinaryTree<>(-5);
            BinaryTree<Integer> nodoP23 = new BinaryTree<>(23);
            BinaryTree<Integer> nodoP6 = new BinaryTree<>(6);
            BinaryTree<Integer> nodoP19 = new BinaryTree<>(19);
            BinaryTree<Integer> nodoP3 = new BinaryTree<>(-3);
            BinaryTree<Integer> nodoP55 = new BinaryTree<>(55);
            BinaryTree<Integer> nodoP11 = new BinaryTree<>(11);
            BinaryTree<Integer> nodoP4 = new BinaryTree<>(4);
            BinaryTree<Integer> nodoP18 = new BinaryTree<>(18);

            arbolParcial.addLeftChild(nodoP7);
            arbolParcial.addRightChild(nodoP5);
            nodoP7.addLeftChild(nodoP23);
            nodoP7.addRightChild(nodoP6);
            nodoP5.addRightChild(nodoP19);
            nodoP23.addLeftChild(nodoP3);
            nodoP6.addLeftChild(nodoP55);
            nodoP6.addRightChild(nodoP11);
            nodoP19.addRightChild(nodoP4);
            nodoP4.addLeftChild(nodoP18);

            //creo el parcial de árboles
            ParcialArbolesA parcial = new ParcialArbolesA(arbolParcial);
            boolean siete = parcial.isLeftTree(7);
            System.out.println("\nPara siete: " + siete); //devuelve true
            boolean dos = parcial.isLeftTree(2);
            System.out.println("Para dos: " + dos); //devuelve false

            // (Punto8) TESTEO SI UN ÁRBOL ES PREFIJO DE OTRO
            // Creamos tres árboles:
            // Arbol 1:                Arbol 2:             Arbol 3:
            //        65                      65                   65
            //       /  \                   /    \               /    \
            //     37    81               37      81            5      81
            //       \     \             /  \    /  \            \    /  
            //       47    93           4   47  2   93           47  2   
            //                         / \       \    \   
            //                        7   5      11    9
            
            BinaryTree<Integer> arbol1 = new BinaryTree<>(65); //Arbol 1
            BinaryTree<Integer> nodo1_37 = new BinaryTree<>(37);
            BinaryTree<Integer> nodo1_81 = new BinaryTree<>(81);
            BinaryTree<Integer> nodo1_47 = new BinaryTree<>(47);
            BinaryTree<Integer> nodo1_93 = new BinaryTree<>(93);
            arbol1.addLeftChild(nodo1_37);
            arbol1.addRightChild(nodo1_81);
            nodo1_37.addRightChild(nodo1_47);
            nodo1_81.addRightChild(nodo1_93);         

            BinaryTree<Integer> arbol2 = new BinaryTree<>(65); //Arbol 2
            BinaryTree<Integer> nodo2_37 = new BinaryTree<>(37);
            BinaryTree<Integer> nodo2_81 = new BinaryTree<>(81);
            BinaryTree<Integer> nodo2_47 = new BinaryTree<>(47);
            BinaryTree<Integer> nodo2_93 = new BinaryTree<>(93);
            BinaryTree<Integer> nodo2_4 = new BinaryTree<>(4);
            BinaryTree<Integer> nodo2_2 = new BinaryTree<>(2);
            BinaryTree<Integer> nodo2_7 = new BinaryTree<>(7);
            BinaryTree<Integer> nodo2_5 = new BinaryTree<>(5);
            BinaryTree<Integer> nodo2_11 = new BinaryTree<>(11);
            BinaryTree<Integer> nodo2_9 = new BinaryTree<>(9);  
            arbol2.addLeftChild(nodo2_37);
            arbol2.addRightChild(nodo2_81); 
            nodo2_37.addLeftChild(nodo2_4);
            nodo2_37.addRightChild(nodo2_47);
            nodo2_81.addLeftChild(nodo2_2);
            nodo2_81.addRightChild(nodo2_93);
            nodo2_4.addLeftChild(nodo2_7);
            nodo2_4.addRightChild(nodo2_5);
            nodo2_81.addLeftChild(nodo2_2);
            nodo2_81.addRightChild(nodo2_93);
            nodo2_4.addLeftChild(nodo2_7);
            nodo2_4.addRightChild(nodo2_5);
            nodo2_2.addRightChild(nodo2_11);
            nodo2_93.addRightChild(nodo2_9);

            BinaryTree<Integer> arbol3 = new BinaryTree<>(65); //Arbol 3
            BinaryTree<Integer> nodo3_5 = new BinaryTree<>(5);  
            BinaryTree<Integer> nodo3_81 = new BinaryTree<>(81);
            BinaryTree<Integer> nodo3_47 = new BinaryTree<>(47);
            BinaryTree<Integer> nodo3_2 = new BinaryTree<>(2);
            arbol3.addLeftChild(nodo3_5);
            arbol3.addRightChild(nodo3_81);
            nodo3_5.addRightChild(nodo3_47);
            nodo3_81.addLeftChild(nodo3_2);

            ParcialArbolesB parcialArbolesB = new ParcialArbolesB(arbol1);
            boolean esPrefijo1 = parcialArbolesB.esPrefijo(arbol1, arbol2);
            System.out.println("\nEl árbol 1 es prefijo del árbol 2: " + esPrefijo1);

            ParcialArbolesB parcialArbolesB2 = new ParcialArbolesB(arbol3);
            boolean esPrefijo2 = parcialArbolesB2.esPrefijo(arbol3, arbol2);
            System.out.println("El árbol 3 es prefijo del árbol 2: " + esPrefijo2);

            // (Punto9) TESTEO LA TRANSFORMACIÓN DE UN ÁRBOL
            // Creamos un árbol:        Arbol transformado:
            //        20                        20|20
            //       /  \                      /      \
            //      5   30                 25|-15     50|10
            //     /      \                 /            \
            //    -5       -9            20|-10        41|-39
            BinaryTree<Integer> arbolParaTransformar = new BinaryTree<>(20);
            BinaryTree<Integer> nodoT5 = new BinaryTree<>(5);
            BinaryTree<Integer> nodoT30 = new BinaryTree<>(30);
            arbolParaTransformar.addLeftChild(nodoT5);
            arbolParaTransformar.addRightChild(nodoT30);
            nodoT5.addLeftChild(new BinaryTree<>(-5));
            nodoT30.addRightChild(new BinaryTree<>(-9));
            
            ParcialArbolesC transformacion = new ParcialArbolesC(arbolParaTransformar);
            System.out.println(transformacion);
        }

    }


