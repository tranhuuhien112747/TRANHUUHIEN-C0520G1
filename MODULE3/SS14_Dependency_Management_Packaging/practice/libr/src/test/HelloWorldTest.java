package test;

import main.Greeter;
import main.HelloWorld;

public class HelloWorldTest {
    public void testGreet() {
        Greeter greeter = new HelloWorld();
        String actual = greeter.greet();
        String expected = "Hello world!";
        String assertResult = expected.equals(actual) ? "PASS" : "FAIL";
        String message = String.format("testGreet: %s, expected: <%s>, actual: <%s>", assertResult, expected, actual);
        System.out.println(message);
    }
}
