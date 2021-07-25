package com.brunomilitzer.junit.dao;

import com.brunomilitzer.junit.dto.Order;

import java.sql.SQLException;

public interface OrderDAO {

    Integer create( Order order ) throws SQLException;

    Order read( Long id ) throws SQLException;

    Integer update( Order order ) throws SQLException;

    Integer delete( Long id ) throws SQLException;

}
