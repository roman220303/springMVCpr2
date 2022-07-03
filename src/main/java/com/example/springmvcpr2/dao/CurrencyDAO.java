package com.example.springmvcpr2.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import com.example.springmvcpr2.models.Avto;
import com.example.springmvcpr2.models.Currency;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CurrencyDAO {

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

    public List<Currency> index() {
        List<Currency> currencyList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Currency";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Currency currency = new Currency();

                currency.setId(resultSet.getInt("id"));
                currency.setValue(resultSet.getFloat("value"));
                currency.setName(resultSet.getString("name"));

                currencyList.add(currency);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return currencyList;

    }

    public Currency show(int id) {

        Currency currency = null;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM Currency WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            currency = new Currency();

            currency.setId(resultSet.getInt("id"));
            currency.setValue(resultSet.getFloat("value"));
            currency.setName(resultSet.getString("name"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return currency;
        /*return jdbcTemplate.query("SELECT * FROM Currency WHERE ID=?"
                , new Object[]{id},
                new BeanPropertyRowMapper<>(Currency.class)).stream().findAny().orElse(null);*/
    }

    public void change(int id, Currency currency) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE Currency SET VALUE=? WHERE ID=?");

            preparedStatement.setFloat(1, currency.getValue());
            preparedStatement.setInt(2, currency.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        /*jdbcTemplate.update("UPDATE Currency SET VALUE=? WHERE ID=?",
                currency.getValue(),
                id
        );*/
    }

    /*public void changeAvto(float dol, Currency currency) {
        jdbcTemplate.update("UPDATE Currency SET DOL=?, EURO=? WHERE DOL=?",
                currency.getDollar(),
                currency.getEuro(),
                dol
        );
    }*/

}
