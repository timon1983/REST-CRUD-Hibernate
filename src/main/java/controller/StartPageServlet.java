package controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "start_servlet", value = "/")
public class StartPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write("WELCOME!!!\nThis is my first REST_API_Hibernate project\n Enter URL next addresses for:\n" +
                "-create user : http://localhost:8080/createuser\n-get all users or get user by id (add id " +
                "parametr http://lo...?id=..) : http://localhost:8080/users\n" +
                "-update user : http://localhost:8080/updateuser\n-delete user : http://localhost:8080/deleteuser\n" +
                "All the following operations on other entities are performed similarly ");
    }
}
