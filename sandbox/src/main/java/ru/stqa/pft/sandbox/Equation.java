package ru.stqa.pft.sandbox;

public class Equation {

  private double a;
  private double b;
  private double c;

  private int n;

  public Equation(double a, double b, double c) {

    this.a = a;
    this.b = b;
    this.c = c;

    double d = b * b - 4 * a * c;
/*
// Полный алгоритм решения уравнения:
    if (a == 0) {
      if (b == 0) {
        if (c == 0) {
          n = -1;
        } else {
          n = 0;
        }
      } else {
        n = 1;
      }

    } else if (d > 0) {
      n = 2;
    } else if (d == 0) {
      n = 1;
    } else {
      n = 0;
    }
    */
// ----
    /*if (a == 0){
      System.out.println("Это вырожденное уравнение");
    }

    if (d > 0) {
      n = 2;
    } else {
      if (d == 0){
        n = 1;
     } else {
        n = 0;
      }
    }
//Тоже самое что и выше
    if (d > 0) {
      n = 2;
    } else if (d == 0){
      n = 1;
    } else {
      n = 0;
    }

//Тоже самое что и выше. Не лучший вариант, т.к без блока "else" будут выполняться все три проверки.
    if (d > 0) {
      n = 2;
    }
    if (d == 0){
      n = 1;
    }
    if (d < 0) {
      n = 0;
    }


  */
    /*
    if (a != 0) {
      if (b == 0) {
        if (c == 0) {
          n = -1;
        } else {
          n = 0;
        }
      } else {
        n = 1;
      }

    } else if (b == 0){
        if (c == 0){
          n = -1;
        } else {
          n = 0;
        }
      }else {
        n = 1;
      }
    */
    /*
    if (a != 0) {
      if (b == 0) {
        if (c == 0) {
          n = -1;
        } else {
          n = 0;
        }
      } else {
        n = 1;
      }

    } else if (b != 0) {
      n = 1;

    }else if (c == 0){
      n = -1;

    }else {
      n = 0;
    }
    */
    if (a != 0) {
      if (b == 0) {
        if (c == 0) {
          n = -1;
        } else {
          n = 0;
        }
      } else {
       n = 1;
      }

    } else if (b != 0) {
      n = 1;

    }else if (c != 0){
     n = 0;

    }else {
     n = -1;
    }

  }

    public int rootNamber () {
      return n;
    }
  }
