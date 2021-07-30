package com.brunomilitzer.junit.spring.services;

import com.brunomilitzer.junit.spring.dao.TicketDAOImpl;
import com.brunomilitzer.junit.spring.dto.Ticket;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = "classpath:application-context.xml" )
public class TicketServiceImplTest {

    public static final String PASSENGER_NAME = "Bruno";
    public static final String PASSENGER_PHONE = "1234467890";
    public static final int RESULT = 1;

    @Mock
    private TicketDAOImpl dao;

    @Autowired
    @InjectMocks
    private TicketServiceImpl service;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks( this );
    }

    @Test
    public void buyTicketsShouldReturnAValidValue() {

        when( this.dao.createTicket( any( Ticket.class ) ) ).thenReturn( 1 );
        final int result = this.service.buyTicket( PASSENGER_NAME, PASSENGER_PHONE );
        assertEquals( result, RESULT );
    }

}