package org.academiadecodigo.bootcamp;

import java.io.*;
import java.util.Iterator;

/**
 * Created by codecadet on 18/06/2019.
 */
public class ReadWrite  {

    private static final String PATH = "resources/save.txt";

    public void write(String conversion) {

    FileWriter fileWriter;
    BufferedWriter bufferedWriter;

        try {
            fileWriter = new FileWriter(PATH);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(conversion);
            bufferedWriter.flush();
            bufferedWriter.close();



        } catch (IOException e ) {

            System.out.println("IO exception");
        }

    }

    public  String read() {

        FileReader fileReader;
        BufferedReader bufferedReader;
        String result = "";


        try {
            fileReader = new FileReader(PATH);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";

            while((line = bufferedReader.readLine()) !=  null ) {

                result += line;
                System.out.println(result);
                bufferedReader.read();
                bufferedReader.close();
            }

        } catch (IOException e) {

            System.out.println("IO exception");
        }


            return result;
    }

}
