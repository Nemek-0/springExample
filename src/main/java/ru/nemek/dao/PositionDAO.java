package ru.nemek.dao;

import ru.nemek.entities.Position;

import java.util.List;

public interface PositionDAO {
    Position getById(int id);
    void add(Position position);
    void update(Position position);
    void delete(Position position);
    List getAll();
}
