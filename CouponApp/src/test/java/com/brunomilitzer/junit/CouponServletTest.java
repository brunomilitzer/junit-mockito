package com.brunomilitzer.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith( MockitoJUnitRunner.class )
public class CouponServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher dispatcher;

    @Test
    public void doGet() throws ServletException, IOException {

        final StringWriter stringWriter = new StringWriter();
        final PrintWriter printWriter = new PrintWriter( stringWriter );
        when( this.response.getWriter() ).thenReturn( printWriter );

        new CouponServlet().doGet( this.request, this.response );
        assertEquals( "SUPERSALE", stringWriter.toString() );
    }

    @Test
    public void doPost() throws ServletException, IOException {

        when( this.request.getParameter( "coupon" ) ).thenReturn( "SUPERSALE" );
        when( this.request.getRequestDispatcher( "response.jsp" ) ).thenReturn( this.dispatcher );
        new CouponServlet().doPost( this.request, this.response );
        verify( this.request ).setAttribute( "discount", "Discount for coupon SUPERSALE is 50%" );
        verify( this.dispatcher ).forward( this.request, this.response );
    }

}