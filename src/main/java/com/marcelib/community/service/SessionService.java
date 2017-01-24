package com.marcelib.community.service;

import com.marcelib.community.data.User;
import javafx.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SessionService {

    private static List<Pair<User, String>> userSessionKeyMap = new ArrayList<>();

    public boolean matchSession(String sessionString, long userId) {
        return userSessionKeyMap.stream().filter(e -> e.getKey().getId() == userId && e.getValue().equals(sessionString)).count() == 1;
    }

    public boolean invalidateUserSession(String sessionString, long userId) {
        if (!matchSession(sessionString, userId)) {
            return false;
        } else {
            userSessionKeyMap.remove(userSessionKeyMap.stream().filter(e -> e.getKey().getId() == userId && e.getValue().equals(sessionString)).findFirst().get());
            return true;
        }
    }

    public void addUserSession(String sessionString, User user) {
        userSessionKeyMap.add(new Pair<>(user, sessionString));
    }
}
