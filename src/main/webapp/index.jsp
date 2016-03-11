<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="style.css">

    </head>

    <body>
        <center>
        <h3>Simple Login Page</h3>


             <form class="form-2" name=login  method="post" action="MyServlet" >

                 <h1><span class="log-in">Log in</span> </h1>
                    <table>
                        <tr>
                            <td>  Username:</td> <td><input type= text name=username required/></td>
                        </tr>
                        <tr>
                             <td> Password:</td> <td><input type=password name=password required/></td>
                        </tr>
                        <tr>
                            <td><input type=submit value=Login name=submit/></td>
                        </tr>
                    </table>


              </form>
        </center>

    </body>
</html>