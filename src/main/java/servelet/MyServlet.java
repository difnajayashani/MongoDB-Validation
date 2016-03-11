package servelet;


import com.mongodb.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;


public class MyServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        /** username and password entered to the form are captured*/
        String n=request.getParameter("username");
        String p=request.getParameter("password");
        out.print("Suceed..... !!!</p>");



        HttpSession session = request.getSession(false);
        if(session!=null)
            session.setAttribute("name", n);

    try {
        MongoClient mongo = (MongoClient) request.getServletContext()
                .getAttribute("MONGO_CLIENT");

        /** obtain the required database from mongoDB server
         * here db object will be a connection to MongoDB server for the
         * spcified database*/
        DB db = mongo.getDB("test_db");

        /** get the collection "user_data" */
        DBCollection table = db.getCollection("user_data");


        /** can get a single document with a query passed to the find statement*/

        BasicDBObject query = new BasicDBObject("user_name", n);

        /** find the document that matches the query*/
        DBCursor cursor = table.find(query);

        /**validate the login */
        if (cursor.hasNext()) {
            out.print("<p style=\"color:red\">Suceed..... !!!</p>");
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);
        } else {
            out.print("<p style=\"color:blue\">Sorry username or password error</p>");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.include(request, response);
        }
    } catch (UnknownHostException ex) {
        ex.printStackTrace();

    } catch (MongoException ex) {
        ex.printStackTrace();
    }
    }
}