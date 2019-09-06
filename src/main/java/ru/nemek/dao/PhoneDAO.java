package ru.nemek.dao;

import ru.nemek.entities.Phone;

import java.util.List;

public interface PhoneDAO {
    Phone getById(int id);
    void add(Phone phone);
    void update(Phone phone);
    void delete(Phone phone);
    List getAll();
}
