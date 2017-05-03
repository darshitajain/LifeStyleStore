/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


/**
 *
 * @author DELL
 */
public class signup extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
	
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String contact = request.getParameter("contact");
        String city = request.getParameter("city");
        String address = request.getParameter("address");
        try{
        
        //loading drivers for mysql
        Class.forName("org.apache.derby.jdbc.ClientDriver");

	//creating connection with the database 
          Connection  con=DriverManager.getConnection("jdbc:derby://localhost:1527/register","darshita","1401");

        PreparedStatement ps=con.prepareStatement
                  ("insert into DARSHITA.SIGNUP values(?,?,?,?,?,?)");
        
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, pwd);
        ps.setString(4, contact);
        ps.setString(5, city);
        ps.setString(6, address);
        int i=ps.executeUpdate();
        
          if(i<=0)
              response.sendRedirect("signup1.html");
          else {
              response.sendRedirect("login.html");
            }
        
        }
        catch(Exception se)
        {
            se.printStackTrace();
        }
	
      }
}
