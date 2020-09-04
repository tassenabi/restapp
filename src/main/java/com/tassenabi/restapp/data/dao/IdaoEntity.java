package com.tassenabi.restapp.data.dao;

import java.util.List;
import java.util.Optional;

/**If there would be more then the entity User -> then is a marker interface also required
 * I am using DAO as an abstraction of data persistence.
 */


public interface IdaoEntity<T> {

    void insert(T t);
    List<T> getAll();
    void deleteUser(T t);
    void update(T t, T r);
    Optional<T> get(T t);

}