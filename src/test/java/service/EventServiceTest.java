package service;

import model.Event;
import model.File;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import repository.hibernate.EventRepositoryImpl;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

class EventServiceTest {

    @Mock
    private EventRepositoryImpl eventRepository = Mockito.mock(EventRepositoryImpl.class);
    @Mock
    private EventService eventService = Mockito.mock(EventService.class);

    @Test
    void chekGetInfDelete_Should_Run_getInfDelete() {
        eventService.getInfDelete();
        Mockito.verify(eventService).getInfDelete();
    }

    @Test
    void checkSaveService_Should_Return_Event() {
        File file = new File();
        Event event = new Event(2L , file);
        when(eventRepository.save(event)).thenReturn(event);
    }

    @Test
    void checkGetByIdService_Should_Return_Event_By_Id() {
        File file = new File();
        Event event = new Event(2L , file);
        when(eventRepository.getById(2L)).thenReturn(event);
    }

    @Test
    void checkGetAllService_Should_Show_All_of_Events() {
        List<Event> eventList = new ArrayList<>();
        when(eventRepository.getAll()).thenReturn(eventList);
    }

    @Test
    void checkUpdateService_Should_Return_UpdateEvent() {
        File file = new File();
        Event event = new Event(2L , file);
        when(eventRepository.update(event)).thenReturn(event);
    }

    @Test
    void checkDeleteByIdService() {
        eventService.checkDeleteByIdService(2L);
        Mockito.verify(eventService).checkDeleteByIdService(2L);
    }
}