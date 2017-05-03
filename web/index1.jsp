<%-- 
    Document   : index1
    Created on : Apr 9, 2017, 1:41:06 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
    <!--jQuery library--> 
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!--Latest compiled and minified JavaScript--> 
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="css/index.css" rel="stylesheet" type="text/css">
    
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#mynavbar">
                        
                      <span class="icon-bar"></span>  
                       <span class="icon-bar"></span>   
                         <span class="icon-bar"></span> 
                        
                        
                    </button>
                <a href="index.html" class="navbar-brand"  >Lifestyle Store</a>
                    
                </div>
                <% 
                    String uname=(String)session.getAttribute("name");
                if(uname!=null){ 
                    
                %>
              <div class="collapse navbar-collapse" id="mynavbar">
               
                  <ul class="nav navbar-nav navbar-right">
                      
                      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Hello,<%=uname %> </a></li>
                       <li><a href="Logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                      
                  </ul>
              
              
              
              </div>  
                <% } 
else{  %>
        <div class="collapse navbar-collapse" id="mynavbar">
               
                  <ul class="nav navbar-nav navbar-right">
                      
                      <li><a href="signup.html"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                       <li><a href="login.html"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                      
                  </ul>
              
              
              
              </div>  
                
                
              <% }  %>       
            </div>
            
        </nav>
      <div class="content">
	<div class="banner-image">
	<div class="inner-banner-image">
            <div class="container">
            <center>
	<div class="banner_content">
		<h1>We sell lifestyle.</h1>
		<p>Flat 40% OFF on premium brands</p>
                <form method="post" action="buttonServlet">
		 <button class="btn btn-danger btn-lg active">Shop Now</button>
                 </form>
	</div>
                </center>
	</div>
        </div>
        </div>
</div>
        
        <div class="row">
  <div class="col-md-4 col-sm-4">
    <div class="thumbnail">
      
        <img src="image/c.jpg" alt="Camera" style="width:80%">
        <div class="caption"><center>
           <h2>Cameras</h2>
          <p>Choose among the best available in the world</p>
          </center>
        </div>
     
    </div>
  </div>
  <div class="col-md-4 col-sm-4">
    <div class="thumbnail">
     
        <img src="image/w.jpg" alt="Watch" style="width:80%">
        <div class="caption">
            <center>
          <h2>Watches</h2>
          <p>Original watches from the best brands</p>
          </center>
        </div>
     
    </div>
  </div>
  <div class="col-md-4 col-sm-4">
    <div class="thumbnail">
              <img src="image/s.jpg" alt="Shirts" style="width:80%">
        <div class="caption">
            <center>
            <h2>Shirts</h2>
          <p>Our exquisite collection of shirts</p>
            </center>
        </div>
     
    </div>
  </div>
</div>
        

        <footer>
            <div class="container">
                <center>
                    Copyright &copy; Lifestyle Store. All Rights Reserved.
                </center>
            </div>
        </footer>
    </body>
</html>
