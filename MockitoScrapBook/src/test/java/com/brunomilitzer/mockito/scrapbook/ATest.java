package com.brunomilitzer.mockito.scrapbook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

class ATest {

    @Mock
    private B b;

    private A a;

    @BeforeEach
    public void setup() {

        MockitoAnnotations.openMocks( this );
        this.a = new A( this.b );
    }

    @Test
    public void usesVoidMethod_Should_Call_The_Void_Method() throws Exception {

        assertSame( 1, this.a.usesVoidMethod() );
        verify( this.b ).voidMethod();
    }

    @Test
    public void usesVoidMethod_Do_Nothing() throws Exception {

        doNothing().when( this.b ).voidMethod();
        assertSame( 1, this.a.usesVoidMethod() );
        verify( this.b ).voidMethod();
    }

    @Test()
    public void usesVoidMethod_Consecutive_Calls() throws Exception {

        doNothing().doThrow( Exception.class ).when( this.b ).voidMethod();
        this.a.usesVoidMethod();
        verify( this.b ).voidMethod();
        Assertions.assertThrows( Exception.class, () -> this.a.usesVoidMethod() );
    }

}