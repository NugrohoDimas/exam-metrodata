/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.nugrohodimas.views;

import its.nugrohodimas.models.Location;
import java.util.List;

/**
 *
 * @author Dony Tri P
 */
public class LocationView {
    public void showAllLocations(List<Location> locations) {
        for (Location l : locations) {
            System.out.println(l.getId() + " - " + l.getStreetAddress() + " - " + 
                    l.getPostalCode()+ " - " + l.getCity()+ " - " +
                    l.getStateProvince()+ " - " + l.getCountryId()+ " - ");
        }
    }
     public void showStatusLocations(boolean status) {
        System.out.println(status?"Query berhasil":"Query gagal");
    }
}
