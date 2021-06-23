package controller.userservletcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import model.User;
import service.UserService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "create_user", value = "/createuser")
public class UserServletCreate extends HttpServlet {

    private User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String usersJson = new ObjectMapper().writeValueAsString(user);
        resp.getWriter().write(usersJson);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserService userService = new UserService();
        User newUser = new Gson().fromJson(req.getReader(), User.class);
        System.out.println(newUser);
        user = userService.checkSaveService(newUser.getFirstName(), newUser.getLastName());
        System.out.println(user);
        doGet(req,resp);
    }
}
