package controller.eventservletcontroller;

import service.EventService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delete_event", value = "/deleteevent")
public class EventServletDelete extends HttpServlet {

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        EventService eventService = new EventService();
        String idLine= req.getParameter("id");
        eventService.checkDeleteByIdService(Long.parseLong(idLine));
        resp.getWriter().write(eventService.getInfDelete());
    }
}
