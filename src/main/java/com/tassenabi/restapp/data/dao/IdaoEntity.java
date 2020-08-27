package com.tassenabi.restapp.data.dao;

import com.tassenabi.restapp.entity.User;
import java.util.List;

/**If there would be more then the entity User -> then is a marker interface also required
 *
 */

public interface IdaoEntity {

    List<User> getAllUser();
    User getUser(String userName);
    void deleteUser(String userName);
    void updateUser(String oldUserName, String newUserName);
    void insertUser(String userName);
}
