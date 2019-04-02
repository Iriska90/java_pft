package Exersises;

class PointDist
{
  public static void main(String args[])
  {

    Point p1 = new Point(0, 0);
    Point p2 = new Point(30, 40);

    System.out.println("p1 = " + p1.x + ", " + p1.y);
    System.out.println("p2 = " + p2.x + ", " + p2.y);
    System.out.println("Point.distance(p1, p2)) = " + Point.distance(p1, p2));
  }
}


