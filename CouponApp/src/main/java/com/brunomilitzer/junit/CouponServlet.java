package com.brunomilitzer.junit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/coupon" )
public class CouponServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet( final HttpServletRequest request, final HttpServletResponse response )
            throws ServletException, IOException {

        response.getWriter().print( "SUPERSALE" );
    }

    protected void doPost( final HttpServletRequest request, final HttpServletResponse response )
            throws ServletException, IOException {

        final String coupon = request.getParameter( "coupon" );
        request.setAttribute( "discount", "Discount for coupon " + coupon + " is 50%" );
        request.getRequestDispatcher( "response.jsp" ).forward( request, response );
    }

}
