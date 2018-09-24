package com.dibrova;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private List<User> users=new ArrayList<>(Arrays.asList(
            new User(1, "Vivi"),
            new User(2, "Vlad"),
            new User(3,"Valera")

    ));

    public List<User> getAll(){
        return users;
    }

    public User getId(int id) {
        return users.stream().filter(t->t.getId()==id).findFirst().get();
    }
    public void addUser(User user) {
        users.add(user);
    }
    public void deleteUser(int id) {
        users.removeIf(t->t.getId()==id);
    }

    public void updateUsers(int id,User user) {
        for(int i=0;i<users.size();i++) {
            int us=users.get(i).getId();
            if(us==id) {
                users.set(i, user);
                return;
            }
        }
    }
}
