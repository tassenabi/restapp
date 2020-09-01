package com.tassenabi.restapp.data.dao;

import com.tassenabi.restapp.entity.User;
import java.util.List;
import java.util.Optional;

/**If there would be more then the entity User -> then is a marker interface also required
 *
 */

public interface IdaoEntity<T> {
<<<<<<< HEAD

    void insert(T t);
    List<T> getAll();
    void deleteUser(T t);
    void update(T t, T r);
    Optional<T> get(T t);

}
=======

    void insert(T t);
    List<T> getAll();
    void deleteUser(T t);
    void update(T t, T r);
    Optional<T> get(T t);

}
>>>>>>> beforeRefactoringDAOUser
