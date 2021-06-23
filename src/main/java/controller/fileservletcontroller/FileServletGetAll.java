package controller.fileservletcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.File;
import service.FileService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "files", value = "/files")
public class FileServletGetAll extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        FileService fileService = new FileService();
        String idLine= req.getParameter("id");
        if(idLine == null) {
            List<File> files = fileService.checkGetAllService();
            if(files != null) {
                String fileJson = new ObjectMapper().writeValueAsString(files);
                resp.getWriter().write(fileJson);
            }else{
                resp.getWriter().write("The list of files is empty");
            }
        }else{
            long id = Long.parseLong(idLine);
            File file = fileService.checkGetByIdService(id);
            if(file != null) {
                String fileJson = new ObjectMapper().writeValueAsString(file);
                resp.getWriter().write(fileJson);
            }else{
                resp.getWriter().write("File whith this <id> is not exist");
            }
        }
    }
}
