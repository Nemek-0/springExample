package ru.nemek.service;

import ru.nemek.entities.Phone;

import java.util.List;

public interface PhoneService {
    Phone getById(int id);
    void add(Phone phone);
    void update(Phone phone);
    void delete(Phone phone);
    List<Phone> getAll();
}
