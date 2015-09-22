package package1;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Jaime Humberto Villarreal Flores
 * Matrícula: 14253221
 * Estructura de Datos
 */

public class ClientesAcme {
    Queue<String> a = new LinkedList();
    Stack<String> b = new Stack();
    Stack<String> pilatemp = new Stack();
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ClientesAcme ca = new ClientesAcme();
        System.out.println("");
        while(true)
        {
            System.out.println("¿Qué desea hacer?");
            System.out.println("1. Formar cliente a la cola.");
            System.out.println("2. Atender cliente.");
            System.out.println("3. Manejar clientes atendidos. (pila)");
            System.out.println("4. Mostrar pila principal.");
            System.out.println("5. Mostrar cola principal.");
            System.out.println("6. Salir.");
            int opc = Integer.parseInt(scan.next());
            if(opc == 1)
            {
                ca.agregarCliente();
            }
            else
            if(opc == 2)
            {
                ca.clienteAtendido();
            }
            else
            if(opc == 3)
            {
                ca.pilaClientes();
            }
            else
            if(opc == 4)
            {
                ca.mostrarPila();
            }
            else
            if(opc == 5)
            {
                ca.mostrarCola();
            }
            else
            {
                break;
            }
        }
        System.exit(1);
    }
    private void agregarCliente()
    {
        String nomcliente = "";
        System.out.println(">>Ingrese el cliente a agregar a la cola: ");
        nomcliente = sc.next();
        a.add(nomcliente);
        System.out.println(">>Cliente "+ nomcliente + " agregado a la cola.");
    }
    private void clienteAtendido()
    {
        if(!a.isEmpty())
        {
            b.push(a.remove());
            String aux = b.peek();
            System.out.println(">>Cliente " + aux + " ha sido atendido.");
        }
        else
            System.out.println(">>La cola de clientes está vacía.");
    }
    private void pilaClientes()
    {
        System.out.println(">>¿Qué cliente desea remover de la pila?");
        String rem = sc.next();
        if(!b.contains(rem))
        {
            System.out.println(">>El cliente que desea remover no se encuentra en la pila.");
        }
        else
        try {
                if(b.peek().equals(rem))
                {
                    b.pop();
                    System.out.println(">>Cliente "+ rem +" removido.");
                    System.out.println("Pila principal: "+b);
                    System.out.println("Pila temporal: "+pilatemp);
                }
                else
                {
                    while(!b.peek().equals(rem))        
                    {
                        String peekResult = b.peek();
                        b.pop();
                        pilatemp.push(peekResult);
                    }
                    b.pop();
                    System.out.println(">>Cliente "+ rem +" removido.");
                    System.out.println("Pila principal: "+b);
                    System.out.println("Pila temporal: "+pilatemp);
                    System.out.println(">>Regresando los otros a su lugar...");
                    while(!pilatemp.empty())
                    {
                        String peekResult = pilatemp.peek();
                        pilatemp.pop();
                        b.push(peekResult);
                    }
                    System.out.println("Pila principal: "+b);
                    System.out.println("Pila temporal: "+pilatemp);
                }
            }     
            catch(EmptyStackException e)
                {
                    System.out.println(">>La pila está vacía.");
                }
    }
    private void mostrarPila()
    {
        System.out.println(">>Pila principal: "+b);
    }
    private void mostrarCola()
    {
        System.out.println(">>Cola principal: "+a);
    }
}
