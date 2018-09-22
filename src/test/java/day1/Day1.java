package day1;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Day1 {
    @Test
    public void test001(){
        String mess1 = "Welcome";
        String mess2 = "Welcome to PCS";
        Tools.myPrint(mess1);
        Tools.myPrint(mess2);
    }

    @Test
    public void test002(){
        Tools.myPrint("Hi there");

    }

    @Test
    public void test003() throws Exception {
        String leftSide = "leftSideMessage";
        String rightSide = "rightSideMessage";
        System.out.println(leftSide +" " +rightSide);
    }

    @Test
    public void test004() throws Exception {
        String string1 = "Hello";
        String name = "BB";
        System.out.println(string1 +" "+ name);
    }

    @Test
    public void test005() throws Exception {
        String string1 = "I have ";
        int number = 5;
        String string2 = " apples";
        Tools.myPrint(string1 +number+ string2);
    }

    @Test
    public void test006() throws Exception {
        boolean b = false;
        b = true;

        boolean toBe = false;
        b = toBe || !toBe;
        if (b) {
            System.out.println(toBe);
        }
    }

    @Test
    public void test007() throws Exception {
        boolean a = false;
        String b = "Good";
        if (!a){
            System.out.println(b);
        }
    }

    @Test
    public void test008() throws Exception {
        int a = 4;
        int b = 5;
        if (a==b){
            Tools.myPrint("a and b are equal");
        }else {
            Tools.myPrint("a and b !equal");
        }
    }

    @Test
    public void test009() throws Exception {
        String a = "myName";
        String b = "myNamq";
        if (a==b){
            Tools.myPrint("EQUAL");
        }else {
            Tools.myPrint("!EQUAL");
        }

        String c = "yourName";
        boolean result1 = c == "yourname";
        System.out.println(result1);
    }

    @Test
    public void test010() throws Exception {

        for (int i = 0; i < 5; i++){
            Tools.myPrint(Integer.toString(i));
        }
    }

    @Test
    public void test011() throws Exception {
        String a = "Hello";
        for (int i = 0; i < 10; i++){
            Tools.myPrint(a);
            System.out.println(i);
        }
    }

    @Test
    public void test012() throws Exception {
        String a = "While loop";
        int i = 0;
        while (i<10){
            Tools.myPrint("while loop");
            i++;
        }
    }

    @Test
    public void test013() throws Exception {
        Point point = new Point(3,4);
        Point point1 = new Point();
    }

    @Test
    public void test014() throws Exception {


        int[] arr = {1,2,3,4,5};
        int arrLength =  arr.length;


        for (int i = arrLength -1; i >=0; i--){
            int value = arr[i];
            System.out.println(value);
        }

    }

    @Test
    public void test015() throws Exception {
        Point[] points = {new Point(3,4),new Point(6,9),new Point(7,11),new Point(44,55),new Point(123,123),new Point(555,666)};
        int pointsLenght = points.length;
        for (int i = 0; i < pointsLenght;i++){
            Point currentElement = points[i];
            System.out.println(currentElement.x);
        }
    }


    //create method that takes array and swap first and last element
    @Test
    public void test000() throws Exception {
        for(int i=1;i<=10;i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
    //create method that takes array and swap first and last element
    @Test
    public void test017() throws Exception {
        int[] arr1 = {66,2,3,4,77};
        int firstNum = arr1[0];
        arr1[0] = arr1[arr1.length-1];
        arr1[arr1.length-1]= firstNum;
        System.out.println(Arrays.toString(arr1));
    }

    //how would u count the number of letters 'L' in the text 'hello world'
    @Test
    public void test018() throws Exception {
        String myText = "Hello Wlorld";

        int counter = 0;
        for (int i=0;i<myText.length();i++){
            if (myText.charAt(i)=='l') {counter++;}
        }
        System.out.println(counter);
    }
    @Test
    public void testFunc() {
        int[] numbers = {
                951, 402, 984, 651, 360, 69, 408, 319, 601, 485, 980, 507, 725, 547, 544,
                615, 83, 165, 141, 501, 263, 617, 865, 575, 219, 390, 984, 592, 236, 105, 942, 941,
                386, 462, 47, 418, 907, 344, 236, 375, 823, 566, 597, 978, 328, 615, 953, 345,
                399, 162, 758, 219, 918, 237, 412, 566, 826, 248, 866, 950, 626, 949, 687, 217,
                815, 67, 104, 58, 512, 24, 892, 894, 767, 553, 81, 379, 843, 831, 445, 742, 717,
                958, 609, 842, 451, 688, 753, 854, 685, 93, 857, 440, 380, 126, 721, 328, 753, 470,
                743, 527};
        for(int i = 0; i<numbers.length; i++){
            int element = numbers[i];
            if(element%2==0){
                System.out.println(element);
            }
        }
    }

    //aleksey_petroff/alexeyamur
}
