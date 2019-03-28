package com.futsal.manage.DAO;

import com.futsal.manage.entity.Futsal;

import java.sql.SQLException;
import java.util.List;

public interface FutsalDAO {
    public Futsal add(Futsal futsal) throws SQLException, ClassNotFoundException;
    public List<Futsal> getAll() throws  SQLException, ClassNotFoundException;
    public boolean delete(int id) throws SQLException, ClassNotFoundException;
}
