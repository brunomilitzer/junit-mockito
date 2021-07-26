package com.brunomilitzer.junit.bo;

import com.brunomilitzer.junit.dao.OrderDAO;
import com.brunomilitzer.junit.dto.Order;
import com.brunomilitzer.junit.exceptions.BOException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OrderBOImplTest {

    @Mock
    private OrderDAO dao;

    private OrderBOImpl bo;

    private static final Long ORDER_ID = 123L;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks( this );

        this.bo = new OrderBOImpl();
        this.bo.setDao( this.dao );
    }

    @Test
    public void placeOrder_Should_Create_An_Order() throws SQLException, BOException {

        final Order order = new Order();

        when( this.dao.create( order ) ).thenReturn( 1 );
        final Boolean result = this.bo.placeOrder( order );

        assertTrue( result );
        verify( this.dao ).create( order );
    }

    @Test
    public void placeOrder_Should_Not_Create_An_Order() throws SQLException, BOException {

        final Order order = new Order();

        when( this.dao.create( order ) ).thenReturn( 0 );
        final Boolean result = this.bo.placeOrder( order );

        assertFalse( result );
        verify( this.dao ).create( order );
    }

    @Test( expected = BOException.class )
    public void placeOrder_Should_Throw_BOException() throws SQLException, BOException {

        final Order order = new Order();

        when( this.dao.create( order ) ).thenThrow( SQLException.class );
        this.bo.placeOrder( order );
    }

    @Test
    public void cancelOrder_Should_Cancel_An_Order() throws SQLException, BOException {

        final Order order = new Order();

        when( this.dao.read( ORDER_ID ) ).thenReturn( order );
        when( this.dao.update( order ) ).thenReturn( 1 );
        final Boolean result = this.bo.cancelOrder( ORDER_ID );
        assertTrue( result );
        verify( this.dao ).read( ORDER_ID );
        verify( this.dao ).update( order );
    }

    @Test
    public void cancelOrder_Should_Not_Cancel_An_Order() throws SQLException, BOException {

        final Order order = new Order();

        when( this.dao.read( ORDER_ID ) ).thenReturn( order );
        when( this.dao.update( order ) ).thenReturn( 0 );
        final Boolean result = this.bo.cancelOrder( ORDER_ID );
        assertFalse( result );
        verify( this.dao ).read( ORDER_ID );
        verify( this.dao ).update( order );
    }

    @Test( expected = BOException.class )
    public void cancelOrder_Should_Throw_BOException_On_Read() throws SQLException, BOException {

        when( this.dao.read( ORDER_ID ) ).thenThrow( SQLException.class );
        this.bo.cancelOrder( ORDER_ID );
    }

    @Test( expected = BOException.class )
    public void cancelOrder_Should_Throw_BOException_On_Update() throws SQLException, BOException {

        final Order order = new Order();

        when( this.dao.read( ORDER_ID ) ).thenReturn( order );
        when( this.dao.read( ORDER_ID ) ).thenThrow( SQLException.class );
        this.bo.cancelOrder( ORDER_ID );
    }

    @Test
    public void deleteOrder_Deletes_The_Order() throws SQLException, BOException {

        when( this.dao.delete( ORDER_ID ) ).thenReturn( 1 );
        final boolean result = this.bo.deleteOrder( ORDER_ID );
        assertTrue( result );
        verify( this.dao ).delete( ORDER_ID );
    }

    @Test
    public void deleteOrder_Deletes_The_Order_With_Non_Existing_Order() throws SQLException, BOException {

        when( this.dao.delete( ORDER_ID ) ).thenReturn( 0 );
        final boolean result = this.bo.deleteOrder( ORDER_ID );
        assertFalse( result );
        verify( this.dao ).delete( ORDER_ID );
    }

    @Test( expected = BOException.class )
    public void deleteOrder_Deletes_The_Order_Should_Throw_BOException_On_Delete() throws SQLException, BOException {

        when( this.dao.delete( ORDER_ID ) ).thenThrow( SQLException.class );
        this.bo.deleteOrder( ORDER_ID );
        verify( this.dao ).delete( ORDER_ID );
    }

}