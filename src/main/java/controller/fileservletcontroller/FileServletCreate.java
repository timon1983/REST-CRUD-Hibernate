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

@WebServlet(name = "create_file", value = "/createfile")
public class FileServletCreate extends HttpServlet {

    private File file;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String fileJson = new ObjectMapper().writeValueAsString(file);
        resp.getWriter().write(fileJson);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        FileService fileService = new FileService();
        File newFile = new Gson().fromJson(req.getReader(), File.class);
        file = fileService.checkSaveService(newFile.getPath(), newFile.getMetaData());
        System.out.println();
        doGet(req,resp);
    }
}
