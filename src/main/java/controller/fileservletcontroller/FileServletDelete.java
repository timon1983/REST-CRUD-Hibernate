package controller.fileservletcontroller;

import service.FileService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delete_file", value = "/deletefile")
public class FileServletDelete extends HttpServlet {

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        FileService fileService = new FileService();
        String idLine= req.getParameter("id");
        fileService.checkDeleteByIdService(Long.parseLong(idLine));
        resp.getWriter().write("User whith this <id> is delete");
    }
}
