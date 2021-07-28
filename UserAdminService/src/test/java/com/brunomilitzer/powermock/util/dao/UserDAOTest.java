package com.brunomilitzer.powermock.util.dao;

import com.brunomilitzer.powermock.util.IDGenerator;
import com.brunomilitzer.powermock.util.dto.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith( PowerMockRunner.class )
@PrepareForTest( IDGenerator.class )
public class UserDAOTest {

    @Test
    public void createShouldReturnAUserId() {

        final UserDAO dao = new UserDAO();

        mockStatic( IDGenerator.class );
        when( IDGenerator.generateID() ).thenReturn( 1 );

        final int result = dao.create( new User() );
        assertEquals( 1, result );
    }

}