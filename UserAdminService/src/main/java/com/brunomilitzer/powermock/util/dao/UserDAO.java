package com.brunomilitzer.powermock.util.dao;

import com.brunomilitzer.powermock.util.IDGenerator;
import com.brunomilitzer.powermock.util.dto.User;

public class UserDAO {

    public int create( final User user ) {

        final int id = IDGenerator.generateID();

        // Save the user object to db
        return id;
    }

}
