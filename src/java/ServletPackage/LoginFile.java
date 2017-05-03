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
public class LoginFile extends HttpServlet {

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
        
        String email=request.getParameter("email");
        String pwd=request.getParameter("pwd");
        
        
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");

	//creating connection with the database 
          Connection  con=DriverManager.getConnection("jdbc:derby://localhost:1527/register","darshita","1401");

        PreparedStatement ps=con.prepareStatement
                  ("select name,email,password from DARSHITA.SIGNUP where email=? and password=? ");
        
        ps.setString(1, email);
        ps.setString(2, pwd);
        ResultSet rs = ps.executeQuery();
        
            if(rs.next()){
                String uname =  rs.getString("name");
                    
                   
              HttpSession session = request.getSession();
              session.setAttribute("name", uname);
               response.sendRedirect("index1.jsp");
              // RequestDispatcher rd=request.getRequestDispatcher("index1.jsp");
              // rd.forward(request, response);
            }
            else
                response.sendRedirect("login1.html");
        
        } catch(Exception se)
        {
            se.printStackTrace();
        }
        
    }

    

}
