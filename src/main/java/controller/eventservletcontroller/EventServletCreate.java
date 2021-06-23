package controller.eventservletcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import model.Event;
import service.EventService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "create_event", value = "/createevent")
public class EventServletCreate extends HttpServlet {

    private Event event;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String eventJson = new ObjectMapper().writeValueAsString(event);
        resp.getWriter().write(eventJson);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        EventService eventService = new EventService();
        Event newEvent = new Gson().fromJson(req.getReader(), Event.class);
        event = eventService.checkSaveService(newEvent.getUploadDate(),newEvent.getFile());
        doGet(req,resp);
    }
}
