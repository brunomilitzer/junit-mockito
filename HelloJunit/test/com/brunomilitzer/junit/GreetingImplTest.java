package com.brunomilitzer.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GreetingImplTest {

    private Greeting greeting;

    @Before
    public void setup() {

        System.out.println("Setup");
        greeting = new GreetingImpl();
    }

    @Test
    public void greetShouldReturnAValidOutput() {
        System.out.println("greetShouldReturnAValidOutput");
        String result = greeting.greet( "Junit" );
        assertNotNull( result );
        assertEquals( "Hello Junit", result );
    }

    @Test(expected = IllegalArgumentException.class)
    public void greetShouldThrowAnException_For_Name_IsNull() {
        System.out.println("greetShouldThrowAnException_For_Name_IsNull");
        greeting.greet( null );
    }

    @Test(expected = IllegalArgumentException.class)
    public void greetShouldThrowAnException_For_Name_IsBlank() {
        System.out.println("greetShouldThrowAnException_For_Name_IsBlank");
        greeting.greet( "" );
    }

    @After
    public void teardown() {
        System.out.println("teardown");
        greeting = null;
    }
}