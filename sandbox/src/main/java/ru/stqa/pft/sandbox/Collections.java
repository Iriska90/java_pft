package ru.stqa.pft.sandbox;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
  public static void main(String[] args) {
    String[] langs = {"Java", "C#", "Phython", "PHP"};

    List<String> languages = Arrays.asList("Java", "C#", "Phython", "PHP");


    for (String l : languages) {
      System.out.println("Я хочу выучить " + l);
    }

   /* for (int i = 0; i < langs.length; i++){
      System.out.println("Я хочу выучить " + langs[i]); */
    }

   /* Тоже самое, что и выше
   String[] langs = new String[4];
    langs[0] = "Java";
    langs[1] = "C#";
    langs[2] = "Phython";
    langs[3] = "PHP";
    */

   /*
    public static void main(String[] args) {
    String[] langs = {"Java", "C#", "Phython", "PHP"};

    List<String> languages = new ArrayList<String>();
    languages.add("Java");
    languages.add("C#");
    languages.add("Phyton");


    for (String l : languages) {
      System.out.println("Я хочу выучить " + l);
    }
    */

   /*
   List languages = Arrays.asList("Java", "C#", "Python", "PHP");

    for (Object l : languages) { System.out.println("Я хочу выучить " + l); }
    */
  }
