package listener;

import com.mongodb.MongoClient;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.UnknownHostException;


public class AppContextListener implements ServletContextListener  {

    static MongoClient mongo =null;
    public void contextInitialized(ServletContextEvent servletContextEvent) {

       try{
        ServletContext ctx = servletContextEvent.getServletContext();


        String port = ctx.getInitParameter("PORT");
        String host = ctx.getInitParameter("HOST");

        mongo = new MongoClient(host,Integer.parseInt(port) );

        System.out.println("MongoClient initialized successfully");
        servletContextEvent.getServletContext().setAttribute("MONGO_CLIENT", mongo);

    } catch (UnknownHostException e) {
        throw new RuntimeException("MongoClient init failed");
    }

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        mongo = (MongoClient) servletContextEvent.getServletContext()
                .getAttribute("MONGO_CLIENT");
        mongo.close();
        System.out.println("MongoClient closed successfully");


    }

}

