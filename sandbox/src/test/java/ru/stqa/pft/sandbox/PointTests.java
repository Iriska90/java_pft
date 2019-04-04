package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


public class PointTests {

  @Test
  public void testDistance() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(30, 40);
    //assert Point.distance(p1, p2) == 50;
    Assert.assertEquals (Point.distance(p1, p2), 50.0);
  }

  @Test
  public void testDistance2() {
    Point p1 = new Point(10, 20);
    Point p2 = new Point(25, 40);
    assert Point.distance(p1, p2) ==  25.0;
    //Assert.assertEquals (Point.distance(p1, p2), 25.0);
    }
  }
