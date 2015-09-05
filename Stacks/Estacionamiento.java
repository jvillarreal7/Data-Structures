package mainpackage;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.Scanner;

public class Estacionamiento {
    Stack<String> a = new Stack();
    Stack<String> b = new Stack();
    Scanner sc = new Scanner(System.in);
    String carro;
    public static void main(String[] args) {
        Estacionamiento e = new Estacionamiento();
        e.agregaCarro();
        e.eligeCarro();
        e.manejaPila();
    }
    private void agregaCarro()
    {
        System.out.println(">>¿Qué carros desea agregar al estacionamiento? (4)");
        for (int i = 0; i < 4; i++) {
            a.push(sc.nextLine());
        }
        System.out.println(">>Carros agregados con éxito.");
    }
    private void eligeCarro()
    {
        System.out.println(">>Elija el carro a sacar del estacionamiento:");
        carro = sc.nextLine();
        System.out.println("Pilas iniciales:");
        System.out.println("Pila 1: "+a);
        System.out.println("Pila 2: "+b);
    }
    private void manejaPila()
    {
        try {
                if(a.peek().equals(carro))
                {
                    a.pop();
                    System.out.println(">>Carro "+carro+" removido.");
                    System.out.println("Pila 1: "+a);
                    System.out.println("Pila 2: "+b);
                }
                else
                {
                    while(!a.peek().equals(carro))        
                    {
                        String peekResult = a.peek();
                        a.pop();
                        b.push(peekResult);
                    }
                    a.pop();
                    System.out.println(">>Carro "+carro+" removido.");
                    System.out.println("Pila 1: "+a);
                    System.out.println("Pila 2: "+b);
                    System.out.println(">>Regresando los otros a su lugar...");
                    while(!b.empty())
                    {
                        String peekResult = b.peek();
                        b.pop();
                        a.push(peekResult);
                    }
                    System.out.println("Pila 1: "+a);
                    System.out.println("Pila 2: "+b);
                }
            }     
            catch(EmptyStackException e)
                {
                    System.out.println(">>La pila está vacía.");
                }
    }
}
