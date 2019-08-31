package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model {
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    // эти методы возвращают данные.
    // Controller вызывает эти методы, и получает запрашиваемые данные
    private List<User> getAllUsers(){
        return userService.filterOnlyActiveUsers(userService.getUsersBetweenLevels(1, 100));
    }
    @Override
    public ModelData getModelData() {
        return modelData;
    }
    // эти методы работают с UserService(который в свою очередь работает с DAO, которая в свою очередь работает с данными)
    // Controller вызывает эти методы, тем самым "просит" Model сформитовать нужные данные и "упаковать" их объект класса ModelData
    @Override
    public void loadUsers() {
        modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(getAllUsers());
    }
    @Override
    public void loadDeletedUsers() {
        modelData.setDisplayDeletedUserList(true);
        modelData.setUsers(userService.getAllDeletedUsers());
    }

    @Override
    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }
    @Override
    public void deleteUserById(long id){
        userService.deleteUser(id);
        loadUsers();
    }
    @Override
    public void changeUserData(String name, long id, int level){
        userService.createOrUpdateUser(name,id,level);
        loadUsers();
    }
}