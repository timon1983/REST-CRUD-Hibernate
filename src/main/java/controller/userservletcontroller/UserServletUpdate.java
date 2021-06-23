package controller.userservletcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import model.User;
import service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "update_user", value = "/updateuser")
public class UserServletUpdate extends HttpServlet {

    private User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usersJson = new ObjectMapper().writeValueAsString(user);
        resp.getWriter().write(usersJson);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        User newUser = new Gson().fromJson(req.getReader(), User.class);
        user = userService.checkUpdateService(newUser.getId(), newUser.getFirstName(), newUser.getLastName());
        if(user != null){
            doGet(req,resp);
        }else{
            resp.getWriter().write("User whith this <id> is not exist");
        }
    }
}
