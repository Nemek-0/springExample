package ru.nemek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nemek.dao.EmployeeDAO;
import ru.nemek.dao.PositionDAO;
import ru.nemek.entities.Employee;
import ru.nemek.entities.Position;

import java.util.ArrayList;
import java.util.List;
@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionDAO positionDAO;

    @Transactional
    @Override
    public Position getById(int id) {
        return positionDAO.getById(id);
    }

    @Transactional
    @Override
    public void add(Position position) {
        positionDAO.add(position);
    }

    @Transactional
    @Override
    public void update(Position position) {
        positionDAO.update(position);
    }

    @Transactional
    @Override
    public void delete(Position position) {
        positionDAO.delete(position);
    }

    @Transactional
    @Override
    public List<Position> getAll() {
        List<Position> list = new ArrayList<>();
        for(Object position : positionDAO.getAll())
            list.add((Position) position);
        return list;
    }
}
