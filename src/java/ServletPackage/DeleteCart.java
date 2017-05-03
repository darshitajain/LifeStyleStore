/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPackage;

import java.io.*;
import java.util.HashMap;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

/**
 *
 * @author DELL
 */
public class DeleteCart extends HttpServlet {

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
        
          String pname = request.getParameter("pname");
         // out.println(pname);
       HttpSession session = request.getSession();
        
         CartP shoppingCart;
          shoppingCart = (CartP) session.getAttribute("cart");
          
        shoppingCart.deleteFromCart(pname);
        session.setAttribute("cart", shoppingCart);
         shoppingCart = (CartP) session.getAttribute("cart");
         HashMap<String,Integer> items = shoppingCart.getCartItems();
         try{
         
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>result</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" >");
            out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>");
            out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n" +
            "    <link href=\"css/index.css\" rel=\"stylesheet\" type=\"text/css\">");
            out.println("<meta charset=\"UTF-8\">\n" +"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<style>\n" +
"            .row_style{\n" +
"                margin-top:100px;\n" +
"                margin-left:350px;\n" +
"            }\n" +
"            \n" +
                    "            .al{\n" +
"                margin-top:100px;\n" +

"            }\n" +
"            \n" +
"            #fd{\n" +
"            padding: 10px;\n" +
"            \n" +
"        }\n" +
"        .p_width{\n" +
"            width : 370px;\n" +
"            \n" +
"        }\n" +
"        \n" +
"        .t_width{\n" +
"            margin-top:100px;\n" +
"        }\n" +
"        \n" +
"        </style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<nav class=\"navbar navbar-inverse navbar-fixed-top\">\n" +
"            <div class=\"container\">\n" +
"                <div class=\"navbar-header\">\n" +
"                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#mynavbar\">\n" +
"                        \n" +
"                      <span class=\"icon-bar\"></span>  \n" +
"                       <span class=\"icon-bar\"></span>   \n" +
"                         <span class=\"icon-bar\"></span> \n" +
"                        \n" +
"                        \n" +
"                    </button>\n" +
"                <a href=\"index1.jsp\" class=\"navbar-brand\"  >Lifestyle Store</a>\n" +
"\n" +
"                    \n" +
"                </div>\n" +
"              <div class=\"collapse navbar-collapse\" id=\"mynavbar\">\n" +
"               \n" +
"                  <ul class=\"nav navbar-nav navbar-right\">\n" +
"                      \n" +
"                      <li><a href=\"cart.html\"><span class=\"glyphicon glyphicon-shopping-cart\"></span> Cart</a></li>\n" +
"                      <li><a href=\"settings.html\"><span class=\"glyphicon glyphicon-user\"></span> Settings</a></li>\n" +
"                       <li><a href=\"Logout\"><span class=\"glyphicon glyphicon-log-out\"></span> Logout</a></li>\n" +
"                      \n" +
"                  </ul>\n" +
"              \n" +
"              \n" +
"              \n" +
"              </div>  \n" +
"                \n" +
"            </div>\n" +
"            \n" +
"        </nav>");
            out.println("<div class=\"container\" >");
            
            
            out.println("<table class=\"table table-bordered table-responsive t_width\">\n" +
"    <thead>\n" +
"      <tr>\n" +

"        <th>Item Name</th>\n" +
"        <th>Price</th>\n" +
"        <th></th>\n" +
//"        <th></th>\n" +
"      </tr>\n" +
"    </thead>");

             out.println("<tbody>"); //<a href="#" data-toggle="tooltip" data-placement="right" title="Hooray!">Right</a>
             int total=0;
            for(String key: items.keySet()){
                total+=items.get(key);
                out.println("<form method=\"post\" action=\"DeleteCart\"><input type=\"hidden\" name='pname' value='"+key+"' ><tr><td>"+key+" </td><td> ₹"+items.get(key)+"</td><td align='right'><input type=\"submit\" value='Cancel Order'></td></tr></form>");
            }
            
           // out.println("<tr class=\"warning\"><td>Total : </td><td></td><td> ₹ "+total+"</td></tr>");
             out.println("</tbody>");
            out.println("</table><br>");
            out.println("<a href='products.html'><input class=\"btn btn-primary\" type='submit' value='Continue shopping'></a><form method=\"post\" action=\"Confirm\"><input class=\"btn btn-primary\" type='submit' value='Confirm Order'></form>");
            
            
            
            
            
            
            out.println("<footer style=\"margin-top:480px ;height:50px;\">\n" +
"            <div class=\"container\" >\n" +
"                <center>\n" +
"                    Copyright &copy; Lifestyle Store. All Rights Reserved.\n" +
"                </center>\n" +
"            </div>\n" +
"        </footer>");
            
            out.println("</body>");
            out.println("</html>");
         
         
         }catch(Exception e){e.printStackTrace();} 

    }  
    
}
// String pname = request.getParameter("pname");
     //   int price = Integer.parseInt(request.getParameter("price"));  
       
       