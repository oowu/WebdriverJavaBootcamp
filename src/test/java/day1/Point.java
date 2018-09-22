package day1;

public class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x=x;
        this.y=y;

        System.out.println(x +" "+y);
    }

    Point(){
        System.out.println("No params");

    }
}

