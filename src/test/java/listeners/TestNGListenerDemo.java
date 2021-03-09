package listeners;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.TestNGListeners.class)
public class TestNGListenerDemo {
    @Test
    public void test1(){
        System.out.println("I am in Test 1");
    }
    @Test
    public void test2(){
        System.out.println("I am in Test 2");
    }
    @Test
    public void test3(){
        System.out.println("I am in Test 3");
    }
    @Test
    public void test4(){
        System.out.println("I am in Test 4");
    }

}
