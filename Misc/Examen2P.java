/*
 * Jaime Humberto Villarreal Flores
 * Matrícula: 14253221
 * Algoritmos de ordenamiento y búsqueda, 2do parcial.
 */

package algoritmos2p;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Examen2P
{
    private void LeerArchivo(String s)
    {
        try(BufferedReader br = new BufferedReader(new FileReader("strings.txt")))
        {
            String str = "";
            while((str = br.readLine()) != null) 
            {
                System.out.println(str);
            }
        }
        catch(Exception e)
        {
            System.out.println("No se encuentra el archivo.");
        }
    }
    
    private void BuscarArchivo(String s)
    {
        try(BufferedReader br = new BufferedReader(new FileReader("strings.txt")))
        {
            int count = 0;
            boolean[] arr = new boolean[5000];
            int lineCounter = 0;
            String str = "";
            while((str = br.readLine()) != null) 
            {
                int lastIndex = 0;
                lineCounter++;
                while(lastIndex != -1)
                {
                    lastIndex = str.indexOf(s,lastIndex);
                    if(lastIndex != -1)
                    {
                        if(arr[lineCounter - 1] == false)
                        {
                            System.out.println(">> '" + s + "' encontrado en la línea " + lineCounter + ": " + str);
                            arr[lineCounter - 1] = true;
                        }
                        System.out.println("Encontrado en el índice: " + lastIndex);
                        count++;
                        lastIndex += s.length();
                    }
                }
            }
            System.out.println("Número total de strings encontrados: " + count);
        }
        catch(Exception e)
        {
            System.out.println("No se encuentra el archivo.");
        }
    }
    
    private void StringInicial(String s)
    {
        boolean found = false;
        try(BufferedReader br = new BufferedReader(new FileReader("strings.txt")))
        {
            int count = 0;
            int lineCounter = 0;
            String str = "";
            while((str = br.readLine()) != null) 
            {
                int lastIndex = 0;
                lineCounter++;
                while(lastIndex != -1)
                {
                    lastIndex = str.indexOf(s,lastIndex);
                    if(lastIndex != -1)
                    {
                        if(lastIndex == 0)
                        {
                            System.out.println("'" + s + "' se encuentra al inicio de la línea " + lineCounter + ": " + str);
                            found = true;
                        }
                        lastIndex += s.length();
                    }
                }
            }
            if(!found)
            {
                System.out.println("No se encontro una línea que iniciara con '" + s + "'.");
            }
        }
        catch(Exception e)
        {
            System.out.println("No se encuentra el archivo.");
        }
    }
    
    private void VocalesConsonantes(String s)
    {
        try(BufferedReader br = new BufferedReader(new FileReader("strings.txt")))
        {
            String str = "";
            int lineCounter = 0;
            while((str = br.readLine()) != null) 
            {
                int vowelCounter = 0;
                int consCounter = 0;
                lineCounter++;
                str = str.toLowerCase();
                for(int i = 0; i < str.length(); i++)
                {
                    char c = str.charAt(i);
                    if(Character.isLetter(c))
                    {
                        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                        {
                            vowelCounter++;
                        }
                        else
                        {
                            consCounter++;
                        }
                    }
                }
                System.out.println("Se encontraron " + vowelCounter + " vocales y " + consCounter + " consonantes en la línea " + lineCounter + ".");
            }
        }
        catch(Exception e)
        {
            System.out.println("No se encuentra el archivo.");
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException 
    {
        Scanner sc = new Scanner(System.in);
        Examen2P ex = new Examen2P();
        System.out.println("¿Qué string desea buscar?");
        String s = sc.nextLine();
        while(true)
        {
            System.out.println("");
            System.out.println("¿Qué desea hacer?");
            System.out.println("1. Leer todas las líneas del archivo.");
            System.out.println("2. Buscar '" + s + "', imprimir líneas y contarlos.");
            System.out.println("3. Imprimir líneas que empiecen con '" + s + "'.");
            System.out.println("4. Contar vocales y consonantes.");
            System.out.println("5. Buscar otro string.");
            System.out.println("6. Salir");
            int opc = sc.nextInt();
            if(opc == 1)
            {
                System.out.println("-------------------------------");
                ex.LeerArchivo(s);
                System.out.println("-------------------------------");
            }
            else
            if(opc == 2)
            {
                System.out.println("-------------------------------");
                ex.BuscarArchivo(s);
                System.out.println("-------------------------------");
            }
            else
            if(opc == 3)
            {
                System.out.println("-------------------------------");
                ex.StringInicial(s);
                System.out.println("-------------------------------");
            }
            else
            if(opc == 4)
            {
                System.out.println("-------------------------------");
                ex.VocalesConsonantes(s);
                System.out.println("-------------------------------");
            }
            else
            if(opc == 5)
            {
                System.out.println("-------------------------------");
                System.out.println("¿Qué string desea buscar?");
                s = sc.nextLine();
                s = sc.nextLine();
                System.out.println("-------------------------------");
            }
            else
                break;
        }
    }
}
