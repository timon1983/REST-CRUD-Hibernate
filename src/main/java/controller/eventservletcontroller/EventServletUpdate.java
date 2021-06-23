package controller.eventservletcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import model.Event;
import service.EventService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "update_event", value = "/updateevent")
public class EventServletUpdate extends HttpServlet {

    private Event event;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String eventJson = new ObjectMapper().writeValueAsString(event);
        resp.getWriter().write(eventJson);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EventService eventService = new EventService();
        Event newEvent = new Gson().fromJson(req.getReader(), Event.class);
        event = eventService.checkUpdateService(newEvent.getId(), newEvent.getUploadDate(), newEvent.getFile());
        if(event != null) {
            doGet(req, resp);
        }else{
            resp.getWriter().write("Event whith this <id> is not exist");
        }
    }
}
