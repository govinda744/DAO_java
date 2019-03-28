package com.futsal.manage.DAO;

import com.futsal.manage.entity.Entries;

import java.sql.SQLException;
import java.util.List;

public interface EntriesDAO {


    Entries add(Entries entries) throws SQLException, ClassNotFoundException;
    List<Entries> getFutsalEntries(int id) throws SQLException, ClassNotFoundException;
    List<Entries> getAll() throws SQLException, ClassNotFoundException;
    boolean delete(int id) throws SQLException, ClassNotFoundException;
}
