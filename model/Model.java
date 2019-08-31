package com.javarush.task.task36.task3608.model;

public interface Model {
    void loadUsers();

    ModelData getModelData();

    void loadDeletedUsers();

    void loadUserById(long userId);

    void deleteUserById(long id);

    void changeUserData(String name, long id, int level);
}
