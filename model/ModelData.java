package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

public class ModelData {
    private User activeUser;
    private boolean displayDeletedUserList;

    public boolean isDisplayDeletedUserList() {
        return displayDeletedUserList;
    }

    public void setDisplayDeletedUserList(boolean displayDeletedUserList) {
        this.displayDeletedUserList = displayDeletedUserList;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    private List<User> users = new ArrayList<>();

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }
}