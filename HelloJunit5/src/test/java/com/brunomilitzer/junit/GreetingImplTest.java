package com.brunomilitzer.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

@RunWith( JUnitPlatform.class )
public class GreetingImplTest {

    private Greeting greeting;

    @BeforeEach
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

    @Test()
    public void greetShouldThrowAnException_For_Name_IsNull() {
        System.out.println("greetShouldThrowAnException_For_Name_IsNull");
        assertThrows( IllegalArgumentException.class, () -> {
            greeting.greet( null );
        } );
    }

    @Test()
    public void greetShouldThrowAnException_For_Name_IsBlank() {
        System.out.println("greetShouldThrowAnException_For_Name_IsBlank");
        assertThrows( IllegalArgumentException.class, () -> {
            greeting.greet( "" );
        } );
    }

    @AfterEach
    public void teardown() {
        System.out.println("teardown");
        greeting = null;
    }
}