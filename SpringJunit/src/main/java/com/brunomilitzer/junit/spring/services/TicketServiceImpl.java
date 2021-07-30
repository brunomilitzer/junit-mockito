package com.brunomilitzer.junit.spring.services;

import com.brunomilitzer.junit.spring.dao.TicketingDAO;
import com.brunomilitzer.junit.spring.dto.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketingDAO dao;

    @Override
    public int buyTicket( final String passengerName, final String phone ) {

        final Ticket ticket = new Ticket();
        ticket.setPassengerName( passengerName );
        ticket.setPhone( phone );

        return this.dao.createTicket( ticket );
    }

    public TicketingDAO getDao() {

        return this.dao;
    }

    public void setDao( final TicketingDAO dao ) {

        this.dao = dao;
    }

}
