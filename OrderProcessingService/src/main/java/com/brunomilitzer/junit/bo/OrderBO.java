package com.brunomilitzer.junit.bo;

import com.brunomilitzer.junit.exceptions.BOException;
import com.brunomilitzer.junit.spring.dto.Order;

public interface OrderBO {

    Boolean placeOrder( Order order ) throws BOException;

    Boolean cancelOrder( Long id ) throws BOException;

    Boolean deleteOrder( Long id ) throws BOException;

}
