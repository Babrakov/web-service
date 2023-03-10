package ru.infoza.main;

import ru.infoza.accounts.AccountService;
import ru.infoza.accounts.UserProfile;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ru.infoza.dbService.DBService;
import ru.infoza.servlets.SessionsServlet;
import ru.infoza.servlets.UsersServlet;

public class Main {
    public static void main(String[] args) throws Exception {
        AccountService accountService = new AccountService();

//        accountService.addNewUser(new UserProfile("admin"));
//        accountService.addNewUser(new UserProfile("test"));

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new UsersServlet(accountService)), "/signup");
        context.addServlet(new ServletHolder(new SessionsServlet(accountService)), "/signin");

        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setResourceBase("public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});

        Server server = new Server(8080);
        server.setHandler(handlers);

        server.start();
        System.out.println("Server started");
        server.join();
    }
}
