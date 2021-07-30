package com.brunomilitzer.junit.spring.dao;

import com.brunomilitzer.junit.spring.dto.Ticket;

public interface TicketingDAO {

    int createTicket( Ticket ticket );

}
