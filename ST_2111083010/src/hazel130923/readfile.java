/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hazel130923;
import java.io.*;
        

public class readfile {
    public static void main(String[] args) throws IOException {
        System.out.println("Nama File");
        String filename;
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        filename = br.readLine();
        System.out.println("Now reading from" + filename + "...");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filename);
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
    }       
    try {
        char data;
        int temp;
        do {
            temp = fis.read();
            data = (char) temp;
            if (temp != -1) {
                System.out.print(data);
            }
        } while (temp != -1) ;
    } catch (IOException ex) {
            System.out.println("file failed");
            }                 
    }
}
