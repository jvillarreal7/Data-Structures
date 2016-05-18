package algoritmosordi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class AlgoritmosOrdi {
    
    int a[] = new int[1000];
    int b[] = new int[1000];
    int c[] = new int[1000];
    int d[] = new int[a.length + b.length + c.length];

    private void RNG() throws IOException 
    { 
       BufferedWriter outputWriter = null; 
       outputWriter = new BufferedWriter(new FileWriter("numbers1.txt")); 
       Random r = new Random(); 
       for (int i = 0; i < a.length; i++) 
       { 
           int temp = r.nextInt(10000)+1;
           a[i] = temp;
           outputWriter.write(Integer.toString(temp)); 
           outputWriter.newLine(); 
       } 
       outputWriter.close(); 
       outputWriter = new BufferedWriter(new FileWriter("numbers2.txt")); 
       for (int i = 0; i < b.length; i++) 
       { 
           int temp = r.nextInt(10000)+1; 
           b[i] = temp;
           outputWriter.write(Integer.toString(temp)); 
           outputWriter.newLine(); 
       } 
       outputWriter.close();
       outputWriter = new BufferedWriter(new FileWriter("numbers3.txt")); 
       for (int i = 0; i < c.length; i++) 
       { 
           int temp = r.nextInt(10000)+1;
           c[i] = temp;
           outputWriter.write(Integer.toString(temp)); 
           outputWriter.newLine(); 
       } 
       outputWriter.close();
       
       System.out.println(">>Arreglos numéricos generados en memoria y archivo.");
    }
    
    private void Combine() throws IOException
    {
        int i = 0, j = 0, k = 0, p = 0;

        while (i < a.length && j < b.length)
        {
            if (a[i] < b[j])       
                d[k++] = a[i++];

            else        
                d[k++] = b[j++];               
        }

        while (i < a.length && p < c.length)
        {
            if (a[i] < c[p])
                d[k++] = a[i++];
            else
                d[k++] = c[p++];
        }

        while (j < b.length && p < c.length)
        {
            if (b[j] < c[p])
                d[k++]= b[j++];
            else
                d[k++]= c[p++];
        }
        while (i < a.length)  
            d[k++] = a[i++];

        while (j < b.length)    
            d[k++] = b[j++];

        while (p < c.length)    
            d[k++] = c[p++];
        
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter("sorted_numbers1.txt"));
        Arrays.sort(a);
        for (int z = 0; z < a.length; z++) 
        { 
            int temp = a[z];
            outputWriter.write(Integer.toString(temp)); 
            outputWriter.newLine(); 
        } 
        outputWriter.close();
        
        outputWriter = new BufferedWriter(new FileWriter("sorted_numbers2.txt"));
        Arrays.sort(b);
        for (int z = 0; z < b.length; z++) 
        { 
            int temp = b[z];
            outputWriter.write(Integer.toString(temp)); 
            outputWriter.newLine(); 
        } 
        outputWriter.close();
        
        outputWriter = new BufferedWriter(new FileWriter("sorted_numbers3.txt"));
        Arrays.sort(c);
        for (int z = 0; z < c.length; z++) 
        { 
            int temp = c[z];
            outputWriter.write(Integer.toString(temp)); 
            outputWriter.newLine(); 
        } 
        outputWriter.close();
        
        System.out.println(">>Array combinado sin acomodar:");
        for (int q = 0; q < d.length; q++) {
            System.out.print(d[q]);
            if(q != d.length - 1)
                System.out.print(" ");
            if(q % 30 == 0 && q != 0)
                System.out.println("");
        }
        System.out.println("");
        
        Arrays.sort(d);
        outputWriter = new BufferedWriter(new FileWriter("sorted_combined.txt"));
        for (int z = 0; z < d.length; z++) 
        { 
            int temp = d[z];
            outputWriter.write(Integer.toString(temp)); 
            outputWriter.newLine(); 
        } 
        outputWriter.close();
        
        System.out.println(">>Array combinado acomodado:");
        for (int q = 0; q < d.length; q++) {
            System.out.print(d[q]);
            if(q != d.length - 1)
                System.out.print(" ");
            if(q % 30 == 0 && q != 0)
                System.out.println("");
        }
        System.out.println("");
    }
    
    private void LeerBuscarArchivo(String s)
    {
        System.out.println("********************");
        try(BufferedReader br = new BufferedReader(new FileReader("strings.txt")))
        {
            String str = "";
            while((str = br.readLine()) != null) 
            {
                System.out.println(str);
            }
            System.out.println("********************");
        }
        catch(Exception e)
        {
            System.out.println("No se encuentra el archivo.");
        }
        
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
    
    private void VocalesConsonantes()
    {
        try(BufferedReader br = new BufferedReader(new FileReader("strings.txt")))
        {
            String str = "";
            int lineCounter = 0;
            while((str = br.readLine()) != null) 
            {
                int vowelCounter = 0;
                int consCounter = 0;
                int letterCounter = 0;
                lineCounter++;
                str = str.toLowerCase();
                for(int i = 0; i < str.length(); i++)
                {
                    char aux = str.charAt(i);
                    if(Character.isLetter(aux))
                    {
                        letterCounter++;
                        if(aux == 'a' || aux == 'e' || aux == 'i' || aux == 'o' || aux == 'u')
                        {
                            vowelCounter++;
                        }
                        else
                        {
                            consCounter++;
                        }
                    }
                }
                System.out.println("Se encontraron " + letterCounter + " letras, " + vowelCounter + " vocales y " + consCounter + " consonantes en la línea " + lineCounter + ".");
            }
        }
        catch(Exception e)
        {
            System.out.println("No se encuentra el archivo.");
        }
    }
    
    private void ContarPalabras()
    {
        try(BufferedReader br = new BufferedReader(new FileReader("strings.txt")))
        {
            String str = "";
            int spaceCounter = 0;
            int lineCounter = 1;
            int last = 0;
            while((str = br.readLine()) != null) 
            {
                for (int i = 0; i < str.length(); i++) {
                    if(str.charAt(i) == ' ')
                    {
                        spaceCounter++;
                    }
                }
                lineCounter++; 
                System.out.println("Se encontraron " + (spaceCounter + lineCounter - 1 - last) + " palabras en la linea " + (lineCounter - 1) + ".");
                last = (spaceCounter + lineCounter - 1);
            }
            System.out.println("Se encontraron " + (spaceCounter + lineCounter - 1) + " palabras en todo el texto.");
        }
        catch(Exception e)
        {
            System.out.println("No se encuentra el archivo.");
        }
    }
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        AlgoritmosOrdi ao = new AlgoritmosOrdi();
        while(true)
        {
            System.out.println("¿Qué desea hacer?");
            System.out.println("1. Generar arreglo numérico e imprimirlo al archivo de texto.");
            System.out.println("2. Combinar y acomodar arreglos numéricos.");
            System.out.println("3. Leer y buscar en archivo string.");
            System.out.println("4. Contar vocales y consonantes.");
            System.out.println("5. Contar palabras.");
            System.out.println("6. Salir.");
            int opc = sc.nextInt();
            if(opc == 1)
            {
                ao.RNG();
            }
            else
            if(opc == 2)
            {
                ao.Combine();
            }
            else
            if(opc == 3)
            {
                System.out.println("¿Qué string desea buscar?");
                String s = sc.nextLine();
                s = sc.nextLine();
                ao.LeerBuscarArchivo(s);
            }
            else
            if(opc == 4)
            {
                ao.VocalesConsonantes();
            }
            else
            if(opc == 5)
            {
                ao.ContarPalabras();
            }
            else
                break;
        }
    }   
}
