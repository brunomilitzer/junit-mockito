package com.brunomilitzer.junit.spring.dao;

import com.brunomilitzer.junit.spring.dto.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketDAOImpl implements TicketingDAO {

    @Override
    public int createTicket( final Ticket ticket ) {

        return 1;
    }

}
