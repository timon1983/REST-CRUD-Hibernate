package service;

import model.Event;
import model.User;
import repository.hibernate.EventRepositoryImpl;
import repository.hibernate.UserRepositoryImpl;
import java.util.List;

public class UserService {

   private EventRepositoryImpl eventRepository = new EventRepositoryImpl();

   private UserRepositoryImpl userRepository = new UserRepositoryImpl();

   private String infDelete;

    public String getInfDelete() {
        return infDelete;
    }

    public User checkSaveService(String firstName, String lastName) {
       List<Event> events = eventRepository.getAll();
       User user = new User(firstName,lastName);
       user.setEvents(events);
        System.out.println(user + "service");
       return userRepository.save(user);
    }

    public User checkGetByIdService(Long id) {
        User user = userRepository.getById(id);
        if (user != null) {
            return user;
        }else {
            return null;
        }
    }

    public List<User> checkGetAllService(){
        List<User> users = userRepository.getAll();
        if(users != null){
            return users;
        }else {
            return null;
        }
    }

    public User checkUpdateService(Long id,String firstName, String lastName) {
        List<Event> events = eventRepository.getAll();
        User newUser = new User(firstName, lastName);
        newUser.setId(id);
        newUser.setEvents(events);
        User updateUser = userRepository.update(newUser);
        if (updateUser != null) {
            return updateUser;
        }else{
            return null;
        }
    }

    public void checkDeleteByIdService(Long id) {
        User user = userRepository.getById(id);
        if (user != null) {
            userRepository.deleteById(id);
            infDelete = "User whith id = " + id + " is delete";
        } else {
            infDelete = "User whith id = " + id + " is not exist";
        }
    }
}
