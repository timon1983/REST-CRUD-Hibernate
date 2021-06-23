package controller.userservletcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import service.UserService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "users", value = "/users")
public class UserServletGetAll extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserService userService = new UserService();
        String idLine= req.getParameter("id");
        if(idLine == null) {
            List<User> users = userService.checkGetAllService();
            if(users != null) {
                String usersJson = new ObjectMapper().writeValueAsString(users);
                resp.getWriter().write(usersJson);
            }else{
                resp.getWriter().write("The list of users is empty");
            }
        }else{
            long id = Long.parseLong(idLine);
            User user = userService.checkGetByIdService(id);
            if(user != null) {
            String userJson = new ObjectMapper().writeValueAsString(user);
            resp.getWriter().write(userJson);
            }else{
                resp.getWriter().write("User whith this <id> is not exist");
            }
        }
    }
}
