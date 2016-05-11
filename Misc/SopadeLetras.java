package sopadeletras;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SopadeLetras {

    char c[][] = new char [10][10];
    char solucion[][] = new char [10][10];
    static String[] d = {"CABALLO", "CAMELLO", "GATO", "LEON", "LOBO", "PAJARO", "PATO", "PERRO", "PUMA", "TIGRE"};
    
    private void mostrarSopa()
    {
        try(BufferedReader br = new BufferedReader(new FileReader("sopa.txt")))
        {
            for(int i = 0; i < 10; i++)
            {
                String s;
                s = br.readLine();
                for(int j = 0; j < s.length(); j++)
                {
                    c[i][j] = s.charAt(j);
                }
            }                  
        }
        catch(Exception e)
        {
            System.err.println("Archivo no encontrado.");
        }
        System.out.println(">>Sopa de letras cargada.");
        System.out.print("*********************");
        for(int i = 0; i < 10; i++)
        {
            System.out.println("");
            for(int j = 0; j < 10; j++)
                System.out.print(c[i][j]);
        }
        System.out.println("");
        System.out.println("*********************");
    }
    
    private void mostrarSolucion()
    {
        try(BufferedReader br = new BufferedReader(new FileReader("soparesuelta.txt")))
        {
            for(int i = 0; i < 10; i++)
            {
                String s;
                s = br.readLine();
                for(int j = 0; j < s.length(); j++)
                {
                    solucion[i][j] = s.charAt(j);
                }
            }                  
        }
        catch(Exception e)
        {
            System.err.println("Archivo no encontrado.");
        }
        System.out.print("*********************");
        for(int i = 0; i < 10; i++)
        {
            System.out.println("");
            for(int j = 0; j < 10; j++)
                System.out.print(solucion[i][j]);
        }
        System.out.println("");
        System.out.println("*********************");
    }
    
    private void mostrarDiccionario()
    {
        System.out.println("*********************");
        System.out.println(">>Diccionario:");
        for(int i = 0; i < d.length; i++)
        {
            System.out.println(d[i]);
        }
        System.out.println("*********************");
    }
    
    private void buscarPalabra(String w)
    {
        boolean found = false;
        while(!found)
        {
            //Horizontal izq. a der.
            try(BufferedReader br = new BufferedReader(new FileReader("sopa.txt")))
            {
                for(int i = 0; i < 10; i++)
                {
                    String s;
                    s = br.readLine();
                    for(int j = 0; j < d.length; j++)
                    {
                        if(s.contains(w))
                        {
                            System.out.println(">>" + w + " fue encontrada horizontalmente de izquierda a derecha.");
                            found = true;
                        }
                    }
                }
            }
            catch(Exception e)
            {
                System.err.println("Archivo no encontrado.");
            }
            //Horizontal der. a izq.
            try(BufferedReader br = new BufferedReader(new FileReader("sopa.txt")))
            {
                for(int i = 0; i < 10; i++)
                {
                    String s;
                    s = br.readLine();
                    String reverse = new StringBuffer(s).reverse().toString();
                    for(int j = 0; j < d.length; j++)
                    {
                        if(reverse.contains(w))
                        {
                            System.out.println(">>" + w + " fue encontrada horizontalmente de derecha a izquierda.");
                            found = true;
                            break;
                        }
                    }
                }
            }
            catch(Exception e)
            {
                System.err.println("Archivo no encontrado.");
            }
            //Vertical arriba hacia abajo.
            String temp = "";
            for(int j = 0; j < 10; j++)
            {
                for(int i = 0; i < d.length; i++)
                {
                    temp += new StringBuilder().append(c[i][j]).toString();
                }
            }
            //System.out.println("DEBUG: "+ temp);
            if(temp.contains(w))
            {
                System.out.println(">>" + w + " fue encontrada verticalmente de arriba hacia abajo.");
                found = true;
                break;
            }
            //Vertical abajo hacia arriba.
            temp = "";
            for(int j = 0; j < 10; j++)
            {
                for(int i = 0; i < d.length; i++)
                {
                    temp += new StringBuilder().append(c[i][j]).toString();
                }
            }
            String reverse = new StringBuffer(temp).reverse().toString();
            if(reverse.contains(w))
            {
                System.out.println(">>" + w + " fue encontrada verticalmente de abajo hacia arriba.");
                found = true;
                break;
            }
            if(!found)
            {
                System.out.println("Está en el diccionario pero no en la sopa de letras. Algo anda mal.");
                break;
            }
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException 
    {
        int opc;
        Scanner sc = new Scanner(System.in);
        SopadeLetras sp = new SopadeLetras();
        while(true)
        {
            System.out.println("¿Qué desea hacer?");
            System.out.println("1. Cargar y mostrar sopa de letras.");
            System.out.println("2. Buscar palabra en la sopa de letras.");
            System.out.println("3. Mostrar diccionario.");
            System.out.println("4. Mostrar solución.");
            System.out.println("5. Salir.");
            opc = sc.nextInt();
            if(opc == 1)
            {
                sp.mostrarSopa();
            }
            else
            if(opc == 2)
            {
                String w = "";
                w = sc.nextLine();
                boolean dictWord = false;
                while(!dictWord)
                {
                    System.out.println("¿Qué palabra del diccionario desea buscar?");
                    w = sc.nextLine();
                    for(int i = 0; i < d.length; i++)
                    {
                        if(d[i].contains(w))
                        {
                            dictWord = true;
                            break;
                        }
                    }
                    if(dictWord)
                        break;
                    else
                        System.out.println(">>" + w + " no se encuentra en el diccionario.");
                }
                sp.buscarPalabra(w);
            }
            else
            if(opc == 3)
            {
                sp.mostrarDiccionario();
            }
            else
            if(opc == 4)
            {
                sp.mostrarSolucion();
            }
            else
                break;
        }
    }
}
