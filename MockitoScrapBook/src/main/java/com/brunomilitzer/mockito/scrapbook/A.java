package com.brunomilitzer.mockito.scrapbook;

public class A {

    private final B b;

    public A( final B b ) {

        this.b = b;
    }

    public int usesVoidMethod() {

        try {
            this.b.voidMethod();
        } catch ( final Exception e ) {
            throw new RuntimeException( e );
        }

        return 1;
    }

}
