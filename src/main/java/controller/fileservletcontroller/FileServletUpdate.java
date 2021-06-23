package controller.fileservletcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import model.File;
import service.FileService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "update_file", value = "/updatefile")
public class FileServletUpdate extends HttpServlet {

    private File file;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String fileJson = new ObjectMapper().writeValueAsString(file);
        resp.getWriter().write(fileJson);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        FileService fileService = new FileService();
        File newFile = new Gson().fromJson(req.getReader(), File.class);
        file = fileService.checkUpdateService(newFile.getId(),newFile.getPath(), newFile.getMetaData());
        if(file != null){
            doGet(req,resp);
        }else{
            resp.getWriter().write("File whith this <id> is not exist");
        }
    }
}
