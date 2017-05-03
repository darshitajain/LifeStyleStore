/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author DELL
 */
public class Settings extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String email = request.getParameter("email");
        String oldpwd = request.getParameter("oldpwd");
        String newpwd = request.getParameter("newpwd");
        String repwd = request.getParameter("repwd");
        
        
        
        try{ 
             Class.forName("org.apache.derby.jdbc.ClientDriver");

	//creating connection with the database 
          Connection  con=DriverManager.getConnection("jdbc:derby://localhost:1527/register","darshita","1401");

        PreparedStatement ps=con.prepareStatement
                  ("update DARSHITA.SIGNUP set password=? where password=? and email=?");

        ps.setString(1,newpwd);
        ps.setString(2,oldpwd);
        ps.setString(3,email);
        
        int i=ps.executeUpdate();
        
          if(i<=0)
              out.println("Try again");
          else {
              response.sendRedirect("settings1.html");
            }
        
    }catch(Exception se)
        {
            se.printStackTrace();
        }

   
    }

 
 

}
