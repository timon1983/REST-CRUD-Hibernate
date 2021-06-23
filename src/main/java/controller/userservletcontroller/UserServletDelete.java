package controller.userservletcontroller;

import service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delete_user", value = "/deleteuser")
public class UserServletDelete extends HttpServlet {

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        String idLine= req.getParameter("id");
        userService.checkDeleteByIdService(Long.parseLong(idLine));
        resp.getWriter().write(userService.getInfDelete());
    }
}
