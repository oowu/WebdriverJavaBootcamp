package day2;
//creating interface(protocols)
interface MyInterface {
    void get();
    void anotherMet();
}
//creating class w/ funcs which communicate with Browser
public class MyDriver implements MyInterface {
    public void get() {}
    public void anotherMet() {}

}
//creating example using our own interface
class Example{
    void test(){
        MyInterface driver = new MyDriver();
        driver.get();
        driver.anotherMet();
    }
}
