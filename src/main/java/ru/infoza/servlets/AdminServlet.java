package ru.infoza.servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.infoza.accountServer.AccountServerI;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminServlet extends HttpServlet {
    static final Logger logger = LogManager.getLogger(AdminServlet.class.getName());
    public static final String PAGE_URL = "/admin";
    private final AccountServerI accountServer;

    public AdminServlet(AccountServerI accountServer) {
        this.accountServer = accountServer;
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        int limit = accountServer.getUsersLimit();

        logger.info("Limit: {}", limit);

        response.getWriter().println(limit);
        response.setStatus(HttpServletResponse.SC_OK);

    }
}
