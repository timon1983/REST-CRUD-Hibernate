package service;

import model.Event;
import model.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import repository.hibernate.UserRepositoryImpl;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private UserRepositoryImpl userRepository = Mockito.mock(UserRepositoryImpl.class);
    @Mock
    private UserService userServiceMock = Mockito.mock(UserService.class);


    @Test
    void chekGetInfDelete_Should_Run_getInfDelete() {
        userServiceMock.getInfDelete();
        Mockito.verify(userServiceMock).getInfDelete();
    }

    @Test
    void checkSaveService_Should_Return_User() {
        List<Event> events = new ArrayList<>();
        User user = new User("Igor","Golin");
        user.setEvents(events);
        when(userRepository.save(user)).thenReturn(user);
    }

    @Test
    void checkGetByIdService_Should_Return_User_By_Id() {
        List<Event> events = new ArrayList<>();
        User user = new User("Igor","Golin");
        user.setEvents(events);
        when(userRepository.getById(2L)).thenReturn(user);
    }

    @Test
    void checkGetAllService_Should_Show_All_of_Users() {
        List<User> users = new ArrayList<>();
        when(userRepository.getAll()).thenReturn(users);
    }

    @Test
    void checkUpdateService_Should_Return_UpdateUser() {
        List<Event> events = new ArrayList<>();
        User user = new User("Igor","Golin");
        user.setEvents(events);
        when(userRepository.update(user)).thenReturn(user);
    }

    @Test
    void checkDeleteByIdService_Should_Run_DeleteUser() {
        userServiceMock.checkDeleteByIdService(2L);
        Mockito.verify(userServiceMock).checkDeleteByIdService(2L);
    }
}