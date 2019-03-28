package com.futsal.manage.DAOImplement;

import com.futsal.manage.DAO.EntriesDAO;
import com.futsal.manage.DBconnection.DBconnection;
import com.futsal.manage.entity.Entries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntriesDAOImplementation implements EntriesDAO {

    DBconnection dBconnection;
    Connection connection;

    public EntriesDAOImplementation() throws ClassNotFoundException {
        dBconnection = new DBconnection();
    }

    @Override
    public Entries add(Entries entries) throws SQLException, ClassNotFoundException {

        connection = dBconnection.open();

        String sql = "INSERT INTO entries (team_name, start_time,end_time, contact, futsal_id) value(?, ?, ?, ?, ?);";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, entries.getTeamName());
        preparedStatement.setInt(2, entries.getStartTime());
        preparedStatement.setInt(3, entries.getEndTime());
        preparedStatement.setString(4, entries.getContact());
        preparedStatement.setInt(5, entries.getFutsalId());

        int result = preparedStatement.executeUpdate();

        connection.close();

        return result != 0 ? entries : null;
    }

    @Override
    public List<Entries> getFutsalEntries(int futsalId) throws SQLException, ClassNotFoundException {

        connection = dBconnection.open();
        List<Entries> resultList = new ArrayList<>();

        String sql = "SELECT * FROM entries WHERE futsal_id = ?;";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, futsalId);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Entries entries = new Entries();

            entries.setId(resultSet.getInt("id"));
            entries.setTeamName(resultSet.getString("team_name"));
            entries.setContact(resultSet.getString("contact"));
            entries.setEndTime(resultSet.getInt("end_time"));
            entries.setStartTime(resultSet.getInt("start_time"));

            resultList.add(entries);
        }

        return resultList;
    }

    @Override
    public List<Entries> getAll() throws SQLException, ClassNotFoundException {

        connection = dBconnection.open();
        List<Entries> resultList = new ArrayList<>();

        String sql = "SELECT * FROM entries;";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Entries entries = new Entries();

            entries.setId(resultSet.getInt("id"));
            entries.setTeamName(resultSet.getString("team_name"));
            entries.setContact(resultSet.getString("contact"));
            entries.setEndTime(resultSet.getInt("end_time"));
            entries.setStartTime(resultSet.getInt("start_time"));
            entries.setFutsalId(resultSet.getInt("futsal_id"));

            resultList.add(entries);
        }

        return resultList;

    }

    @Override
    public boolean delete(int id) throws SQLException, ClassNotFoundException {

        connection = dBconnection.open();

        String sql = "DELETE FROM entries WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,id);

        boolean result = preparedStatement.execute();

        if(result){
            return true;
        }
        return  false;
    }
}
