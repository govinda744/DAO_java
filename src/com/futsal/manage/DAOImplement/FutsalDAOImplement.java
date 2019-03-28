package com.futsal.manage.DAOImplement;

import com.futsal.manage.DAO.FutsalDAO;
import com.futsal.manage.DBconnection.DBconnection;
import com.futsal.manage.entity.Futsal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FutsalDAOImplement implements FutsalDAO {

    DBconnection dBconnection;
    Connection connection;

    public FutsalDAOImplement() throws ClassNotFoundException {
        dBconnection = new DBconnection();
    }

    @Override
    public Futsal add(Futsal futsal) throws SQLException, ClassNotFoundException {

        connection = dBconnection.open();

        String sql = "INSERT INTO futsal (name, location, contact, opening_hour, closing_hour) value (?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,futsal.getName());
        preparedStatement.setString(2,futsal.getLocation());
        preparedStatement.setString(3,futsal.getContact());
        preparedStatement.setInt(4,futsal.getOpeningHour());
        preparedStatement.setInt(5,futsal.getClosingHour());

        int result = preparedStatement.executeUpdate();
        connection.close();

        if(result != 0){
            return futsal;
        }

        return null;
    }

    @Override
    public List<Futsal> getAll() throws SQLException, ClassNotFoundException {

        connection = dBconnection.open();
        List<Futsal> futsals = new ArrayList<>();

        String sql = "SELECT  * FROM futsal";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){

            Futsal futsal = new Futsal();

            futsal.setId(resultSet.getInt("id"));
            futsal.setName(resultSet.getString("name"));
            futsal.setLocation(resultSet.getString("location"));
            futsal.setContact(resultSet.getString("contact"));
            futsal.setOpeningHour(resultSet.getInt("opening_hour"));
            futsal.setClosingHour(resultSet.getInt("closing_hour"));

            futsals.add(futsal);
        }

        connection.close();

        return futsals;
    }

    @Override
    public boolean delete(int id) throws SQLException, ClassNotFoundException {

        connection = dBconnection.open();

        String sql = "DELETE FROM futsal WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,id);

        boolean result = preparedStatement.execute();

        if(result){
            return true;
        }

        return  false;
    }

}
