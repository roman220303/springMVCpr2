package com.example.springmvcpr2.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import com.example.springmvcpr2.models.Avto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class AvtoDAO {
    //private final JdbcTemplate jdbcTemplate;

    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "qwerty";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Avto> index() {
        List<Avto> avtoList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Avto";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Avto avto = new Avto();

                avto.setId(resultSet.getInt("id"));
                avto.setNumber(resultSet.getInt("number"));
                avto.setPrice(resultSet.getInt("price"));
                avto.setMarka(resultSet.getString("marka"));
                avto.setCurrency(resultSet.getInt("currency"));

                avtoList.add(avto);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return avtoList;
        //return  jdbcTemplate.query("SELECT * FROM AVTO", new BeanPropertyRowMapper<>(Avto.class));

    }

    public Avto show(int id) {
        Avto avto = null;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM Avto WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            avto = new Avto();

            avto.setId(resultSet.getInt("id"));
            avto.setNumber(resultSet.getInt("number"));
            avto.setPrice(resultSet.getInt("price"));
            avto.setMarka(resultSet.getString("marka"));
            avto.setCurrency(resultSet.getInt("currency"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return avto;
        /*return jdbcTemplate.query("SELECT * FROM AVTO WHERE ID=?"
                , new Object[]{id},
                new BeanPropertyRowMapper<>(Avto.class)).stream().findAny().orElse(null);*/
    }

    public void add(Avto avto) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO Avto VALUES(?,?,?,?,?)");

            preparedStatement.setInt(1, avto.getId());
            preparedStatement.setInt(2, avto.getNumber());
            preparedStatement.setFloat(3, avto.getPrice());
            preparedStatement.setString(4, avto.getMarka());
            preparedStatement.setInt(5, avto.getCurrency());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        /*jdbcTemplate.update("INSERT INTO AVTO VALUES (?,?,?,?,?)",
                avto.getId(),
                avto.getNumber(),
                avto.getPrice(),
                avto.getMarka(),
                avto.getCurrency());*/
    }

    public void change(int id, Avto avto) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE AVTO SET NUMBER=?, PRICE=?, MARKA=?, CURRENCY=? WHERE ID=?");

            preparedStatement.setInt(1, avto.getNumber());
            preparedStatement.setFloat(2, avto.getPrice());
            preparedStatement.setString(3, avto.getMarka());
            preparedStatement.setInt(4, avto.getCurrency());
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        /*jdbcTemplate.update("UPDATE AVTO SET NUMBER=?, PRICE=?, MARKA=?, CURRENCY=? WHERE ID=?",
                avto.getNumber(),
                avto.getPrice(),
                avto.getMarka(),
                avto.getCurrency(),
                id);*/
    }

    public void delete(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM AVTO WHERE id=?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //jdbcTemplate.update("DELETE FROM AVTO WHERE id=?", id);
    }
}
