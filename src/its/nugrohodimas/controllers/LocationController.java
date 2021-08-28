/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.nugrohodimas.controllers;

import its.nugrohodimas.daos.LocationDAO;
import its.nugrohodimas.models.Location;
import its.nugrohodimas.views.LocationView;
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
public class LocationController implements LocationDAO{
    private LocationView locationView;
    private Connection connection;

    public LocationController(LocationView locationView, Connection connection) {
        this.locationView = locationView;
        this.connection = connection;
    }
    
    /**
     * Mendapatkan list dari table Locations
     * @return list dari Object location
     * @author Dony Tri P
     */
    @Override
    public List<Location> getAllLocations() {
          List<Location> locations = new ArrayList<>();
        try {
            ResultSet resultSet = connection.prepareStatement("select * from locations")
                    .executeQuery();
            while (resultSet.next()) {
                locations.add(new Location(resultSet.getString(1), resultSet.getString(2),
                                            resultSet.getString(3), resultSet.getString(4),
                                            resultSet.getString(5), resultSet.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locations;
    }

    /**
     * Menghapus objek location dari dari database berdasarkan id yang dimasukkan
     * param id - id dari location
     * @return status boolean dari query
     * @author Dony Tri P
     */
    @Override
    public boolean deleteLocation(String id) {
         try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from locations where id = ?");
            preparedStatement.setString(1, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Mengambil objek tunggal location berdasarkan id yang dimasukan
     * param id - id dari location
     * @return sebuah objek dari location
     * @author Dony Tri P
     */
    @Override
    public Location getById(String id) {
        Location location = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT *FROM locations WHERE id=?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                location = new Location(resultSet.getString(1), resultSet.getString(2),
                                        resultSet.getString(3), resultSet.getString(4),
                                        resultSet.getString(5), resultSet.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return location;
    }

    /**
     * Menyimpan atau memasukkan objek ke location
     * param location - objek yang ada di dalam location
     * @return status boolean dari query
     * @author Dony Tri P
     */
    @Override
    public boolean saveLocation(Location location) {
         try {
            boolean isInsert = getById(location.getId()) == null;
            String query = isInsert
                    ? "INSERT INTO locations(street_address, postal_code, city, state_province, country_id  ,id) VALUES(?,?,?,?,?,?)"
                    : "UPDATE locations SET street_address = ?, postal_code = ?, city = ?, state_province = ?, country_id = ? WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, location.getStreetAddress());
            preparedStatement.setString(2, location.getPostalCode());
            preparedStatement.setString(3, location.getCity());
            preparedStatement.setString(4, location.getStateProvince());
            preparedStatement.setString(5, location.getCountryId());
            preparedStatement.setString(6, location.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public void showAllLocations() {
        this.locationView.showAllLocations(getAllLocations());
    }

    public void showSaveLocation(Location location) {
        this.locationView.showStatusLocations(saveLocation(location));
    }

    public void showDelete(String id) {
        this.locationView.showStatusLocations(deleteLocation(id));
    }
    
}