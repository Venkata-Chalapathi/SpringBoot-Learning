package in.gvc.service;


import in.gvc.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserService {

    private HashMap<Integer, User> map;

    public UserService() {
        map = new HashMap<>();
    }

    public User createUser(User user) {
        map.put(user.getId(), user);
        return user;
    }

    public User getUserById(Integer id) {
        return map.get(id);
    }

    public List<User> getAllUsers() {

        List<User> usersResp = new ArrayList<>();
        for(User user : map.values()){
            usersResp.add(user);
        }

        return usersResp;
    }
}
