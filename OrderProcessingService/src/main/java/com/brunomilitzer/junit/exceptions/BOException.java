package com.brunomilitzer.junit.exceptions;

import java.sql.SQLException;

public class BOException extends Exception {

    private static final long serialVersionUID = -1495612488773981890L;

    public BOException( final SQLException exception ) {

        super( exception );
    }

}
