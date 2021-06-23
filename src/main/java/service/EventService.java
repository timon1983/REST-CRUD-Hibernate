package service;

import model.Event;
import model.File;
import model.User;
import repository.hibernate.EventRepositoryImpl;
import java.util.List;

public class EventService {

    private EventRepositoryImpl eventRepository = new EventRepositoryImpl();

    private UserService userService = new UserService();

    private FileService fileService = new FileService();

    private String infDelete;

    public String getInfDelete() {
        return infDelete;
    }

    public Event checkSaveService(Long uploaded ,File file) {
        Event event = new Event(uploaded);
        event.setFile(file);
        return eventRepository.save(event);
    }

    public Event checkGetByIdService(Long id) {
        Event event = eventRepository.getById(id);
        if (event != null) {
            return event;
        }else {
            return null;
        }
    }

    public List<Event> checkGetAllService(){
        List<Event> events = eventRepository.getAll();
        if(events != null){
            return events;
        }else {
            return null;
        }
    }

    public Event checkUpdateService(Long id, Long uploaded , File file) {
        Event event = new Event(uploaded);
        event.setId(id);
        event.setFile(fileService.checkSaveService(file.getPath(),file.getMetaData()));
        Event updateEvent = eventRepository.update(event);
        if (updateEvent != null) {
            return updateEvent;
        }else{
            return null;
        }
    }

    public void checkDeleteByIdService(Long id) {
        Event event = eventRepository.getById(id);
        if (event != null) {
            eventRepository.deleteById(id);
            infDelete = "User whith id = " + id + " is delete";
        } else {
            infDelete = "User whith id = " + id + " is not exist";
        }
    }
}
