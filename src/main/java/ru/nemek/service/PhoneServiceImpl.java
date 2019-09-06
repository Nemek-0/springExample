package ru.nemek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nemek.dao.PhoneDAO;
import ru.nemek.dao.PositionDAO;
import ru.nemek.entities.Phone;
import ru.nemek.entities.Position;

import java.util.ArrayList;
import java.util.List;
@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneDAO phoneDAO;

    @Transactional
    @Override
    public Phone getById(int id) {
        return phoneDAO.getById(id);
    }
    @Transactional
    @Override
    public void add(Phone phone) {
        phoneDAO.add(phone);
    }
    @Transactional
    @Override
    public void update(Phone phone) {
        phoneDAO.update(phone);
    }
    @Transactional
    @Override
    public void delete(Phone phone) {
        phoneDAO.delete(phone);
    }

    @Transactional
    @Override
    public List<Phone> getAll() {
        List<Phone> list = new ArrayList<>();
        for(Object phone : phoneDAO.getAll())
            list.add((Phone) phone);
        return list;
    }
}
