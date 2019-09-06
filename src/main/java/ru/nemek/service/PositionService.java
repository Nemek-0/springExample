package ru.nemek.service;

import ru.nemek.entities.Position;

import java.util.List;

public interface PositionService {
    Position getById(int id);
    void add(Position position);
    void update(Position position);
    void delete(Position position);
    List<Position> getAll();
}
