/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.nugrohodimas.controllers;

import its.nugrohodimas.daos.CountryDAO;
import its.nugrohodimas.models.Country;
import its.nugrohodimas.views.CountryView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dony Tri P
 */
public class CountryController implements CountryDAO{
    private CountryView countryView;
    private Connection connection;

    public CountryController(CountryView countryView, Connection connection) {
        this.countryView = countryView;
        this.connection = connection;
    }

    /**
     * Mendapatkan list dari table Countries
     * @return list dari Object country
     * @author Dony Tri P
     */
    @Override
    public List<Country> getAllCountries() {
        Country country = new Country();
          List<Country> countries = new ArrayList<>();
        try {
            ResultSet resultSet = connection.prepareStatement("select * from countries")
                    .executeQuery();
            while (resultSet.next()) {
                countries.add(new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }

    /**
     * Menghapus objek country dari dari database berdasarkan id yang dimasukkan
     * param id - id dari country
     * @return status boolean dari query
     * @author Dony Tri P
     */
    @Override
    public boolean deleteCountry(String id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from countries where id = ?");
            preparedStatement.setString(1, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Mengambil objek tunggal country berdasarkan id yang dimasukan
     * param id - id dari country
     * @return sebuah objek dari country
     * @author Dony Tri P
     */
    @Override
    public Country getById(String id) {
        Country country = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT *FROM countries WHERE id=?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                country = new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }
    /**
     * Menyimpan atau memasukkan objek ke country
     * param country - objek yang ada di dalam country
     * @return status boolean dari query
     * @author Dony Tri P
     */
    @Override
    public boolean saveCountry(Country country) {
        try {
            boolean isInsert = getById(country.getId()) == null;
            String query = isInsert
                    ? "INSERT INTO countries(name, region_id ,id) VALUES(?,?,?)"
                    : "UPDATE countries SET name = ?, region_id = ? WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, country.getName());
            preparedStatement.setString(2, country.getRegionId());
            preparedStatement.setString(3, country.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public void showAllCountries() {
        this.countryView.showAllCountries(getAllCountries());
    }

    public void showSaveCountry(Country country) {
        this.countryView.showStatusCountries(saveCountry(country));
    }

    public void showDelete(String id) {
        this.countryView.showStatusCountries(deleteCountry(id));
    }
}
