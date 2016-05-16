import java.util.*;
import java.lang.*;
import java.io.*;

public class Encriptador
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for(int i = 0; i < s.length(); i++) 
        {
            char c = s.charAt(i);
            if(c >= 'a' && c <= 'm')
            c += 13;
            else
            if(c >= 'A' && c <= 'M')
            c += 13;
            else
            if(c >= 'n' && c <= 'z') 
            c -= 13;
            else
            if(c >= 'N' && c <= 'Z')
            c -= 13;
            System.out.print(c);
        }
        System.out.println();
    }
}
