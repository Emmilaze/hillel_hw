package com.hillel.webapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UtilClass {

    public static String sortArray(String str){
        String[] array = str.split(", ");
        List<Integer> list = new ArrayList<>();
        for (String number : array) {
            list.add(Integer.parseInt(number));
        }
        Collections.sort(list);
        return list.toString();
    }


    public static String findWord(String word){
        int number = 0;
        for (String str : getWords()) {
            if(str.equals(word)){
                number++;
            }
        }
        return String.valueOf(number);
    }

    private static String[] getWords(){
        String content = "";
        try {
            content = Files.lines(Paths.get("D:\\Programs\\apache-tomcat-9.0.30-windows-x64\\apache-tomcat-9.0.30\\webapps\\ROOT\\text.txt")).reduce("", String::concat);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.replaceAll("[\\p{P}]", "").split(" ");
    }
}
