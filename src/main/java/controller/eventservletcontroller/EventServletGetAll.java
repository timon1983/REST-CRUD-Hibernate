package controller.eventservletcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Event;
import service.EventService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "events", value = "/events")
public class EventServletGetAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        EventService eventService = new EventService();
        String idLine= req.getParameter("id");
        if(idLine == null) {
            List<Event> events = eventService.checkGetAllService();
            if (events != null) {
                String eventJson = new ObjectMapper().writeValueAsString(events);
                resp.getWriter().write(eventJson);
            }else{
                resp.getWriter().write("The list of events is empty");
            }
        }else{
            long id = Long.parseLong(idLine);
            Event event = eventService.checkGetByIdService(id);
            if(event != null) {
                String eventJson = new ObjectMapper().writeValueAsString(event);
                resp.getWriter().write(eventJson);
            }else{
                resp.getWriter().write("Event whith this <id> is not exist");
            }
        }
    }
}
