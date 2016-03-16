
package mainpackage;

import java.util.LinkedList;
import java.util.Scanner;

public class ListaSimple {
    LinkedList<String> a = new LinkedList();
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ListaSimple l = new ListaSimple();
        int opc;
        while(true)
        {          
            System.out.println("¿Qué desea hacer?");
            System.out.println("1. Añadir elementos a la lista.");
            System.out.println("2. Quitar el elemento del principio.");
            System.out.println("3. Quitar el elemento del final.");
            System.out.println("4. Mostrar lista.");
            System.out.println("5. Salir.");
            opc = s.nextInt();
            if(opc == 1)
            {
                l.llenarLista();
            }
            else
            if(opc == 2)
            {
                l.quitarElementoFront();
            }
            else
            if(opc == 3)
            {
                l.quitarElementoEnd();
            }
            else
            if(opc == 4)
            {
                l.mostrarLista();
            }   
            else
                break;
        }
        System.exit(1);
    }
    private void llenarLista()
    {
        String elem = "";
        System.out.println(">>Ingrese un elemento a la lista.");
        elem = sc.next();
        a.add(elem);
        System.out.println("Elemento " + elem + " añadido.");
    }
    private void quitarElementoFront()
    {
        a.removeFirst();
        System.out.println(">>El elemento al frente de la lista ha sido removido.");
    }
    private void quitarElementoEnd()
    {
        a.removeLast();
        System.out.println(">>El elemento al final de la lista ha sido removido.");
    }
    private void mostrarLista()
    {
        System.out.println(a);
    }
}
