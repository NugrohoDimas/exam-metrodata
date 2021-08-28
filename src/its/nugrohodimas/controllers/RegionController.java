/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.nugrohodimas.controllers;

import its.nugrohodimas.daos.RegionDAO;
import its.nugrohodimas.models.Region;
import its.nugrohodimas.views.RegionView;
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
public class RegionController implements RegionDAO{
    private RegionView regionView;
    private Connection connection;

    public RegionController(RegionView regionView, Connection connection) {
        this.regionView = regionView;
        this.connection = connection;
    }

    /**
     * Mendapatkan list dari table Regions
     * @return list dari Object region
     * @author Dony Tri P
     */
    @Override
    public List<Region> getAllRegion() {
          List<Region> regions = new ArrayList<>();
        try {
            ResultSet resultSet = connection.prepareStatement("select * from regions")
                    .executeQuery();
            while (resultSet.next()) {
                regions.add(new Region(resultSet.getString(1), resultSet.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return regions;
    }

    /**
     * Menghapus objek region dari dari database berdasarkan id yang dimasukkan
     * param id - id dari region
     * @return status boolean dari query
     * @author Dony Tri P
     */
    @Override
    public boolean deleteRegion(String id) {
         try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from regions where id = ?");
            preparedStatement.setString(1, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Mengambil objek tunggal region berdasarkan id yang dimasukan
     * param id - id dari region
     * @return sebuah objek dari region
     * @author Dony Tri P
     */
    @Override
    public Region getById(String id) {
        Region region = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT *FROM regions WHERE id=?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                region = new Region(resultSet.getString(1), resultSet.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return region;
    }

    /**
     * Menyimpan atau memasukkan objek ke region
     * param region - objek yang ada di dalam region
     * @return status boolean dari query
     * @author Dony Tri P
     */
    @Override
    public boolean saveRegion(Region region) {
         try {
            boolean isInsert = getById(region.getId()) == null;
            String query = isInsert
                    ? "INSERT INTO regions(name, id) VALUES(?,?)"
                    : "UPDATE regions SET name = ? WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, region.getName());
            preparedStatement.setString(2, region.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public void showAllRegions() {
        this.regionView.showAllRegions(getAllRegion());
    }

    public void showSaveRegion(Region region) {
        this.regionView.showStatusRegions(saveRegion(region));
    }

    public void showDelete(String id) {
        this.regionView.showStatusRegions(deleteRegion(id));
    }
}