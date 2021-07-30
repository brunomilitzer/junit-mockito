package com.brunomilitzer.junit.bo;

import com.brunomilitzer.junit.dao.OrderDAO;
import com.brunomilitzer.junit.exceptions.BOException;
import com.brunomilitzer.junit.spring.dto.Order;

import java.sql.SQLException;

public class OrderBOImpl implements OrderBO {

    private OrderDAO dao;

    @Override
    public Boolean placeOrder( final Order order ) throws BOException {

        try {
            final Integer result = this.dao.create( order );

            if ( result == 0 ) {
                return false;
            }

        } catch ( final SQLException e ) {
            throw new BOException( e );
        }

        return true;
    }

    @Override
    public Boolean cancelOrder( final Long id ) throws BOException {

        try {
            final Order order = this.dao.read( id );
            order.setStatus( "cancelled" );
            final Integer result = this.dao.update( order );

            if ( result == 0 ) {
                return false;
            }

        } catch ( final SQLException e ) {
            throw new BOException( e );
        }

        return true;
    }

    @Override
    public Boolean deleteOrder( final Long id ) throws BOException {

        try {
            final Integer result = this.dao.delete( id );

            if ( result == 0 ) {
                return false;
            }

        } catch ( final SQLException e ) {
            throw new BOException( e );
        }

        return true;
    }

    public void setDao( final OrderDAO dao ) {

        this.dao = dao;
    }

}
