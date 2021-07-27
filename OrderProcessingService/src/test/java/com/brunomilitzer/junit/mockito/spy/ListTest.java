package com.brunomilitzer.junit.mockito.spy;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.doReturn;

public class ListTest {

    @Spy
    private final List<String> myList = new ArrayList<>();

    @Before
    public void init() {

        MockitoAnnotations.openMocks( this );
    }

    @Test
    public void test() {

        this.myList.add( "Bruno" );
        this.myList.add( "Vanessa" );

        doReturn( 3 ).when( this.myList ).size();
        assertSame( 3, this.myList.size() );
    }

}
