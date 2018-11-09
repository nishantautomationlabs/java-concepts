package com.nal.others;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Nishant on 03-11-2018.
 */
public class TryWithResources {

    public static void main(String[] args) {
        String line;
        try (FileReader reader = new FileReader("D:\\test.txt");
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {

        }
    }
}
