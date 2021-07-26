package com.brunomilitzer.junit;

import com.brunomilitzer.junit.services.GreetingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith( MockitoExtension.class )
public class GreetingImplTest {

    @Mock
    private GreetingService service;

    @InjectMocks
    private GreetingImpl greeting;

    @Test
    public void greetShouldReturnAValidOutput() {

        System.out.println( "greetShouldReturnAValidOutput" );
        when( this.service.greet( "Junit" ) ).thenReturn( "Hello Junit" );
        final String result = this.greeting.greet( "Junit" );
        Assertions.assertNotNull( result );
        assertEquals( "Hello Junit", result );
    }

    @Test()
    public void greetShouldThrowAnException_For_Name_IsNull() {

        System.out.println( "greetShouldThrowAnException_For_Name_IsNull" );
        doThrow( IllegalArgumentException.class ).when( this.service ).greet( null );
        Assertions.assertThrows( IllegalArgumentException.class, () -> {
            this.greeting.greet( null );
        } );
    }

    @Test()
    public void greetShouldThrowAnException_For_Name_IsBlank() {

        System.out.println( "greetShouldThrowAnException_For_Name_IsBlank" );
        doThrow( IllegalArgumentException.class ).when( this.service ).greet( "" );
        Assertions.assertThrows( IllegalArgumentException.class, () -> {
            this.greeting.greet( "" );
        } );
    }

}