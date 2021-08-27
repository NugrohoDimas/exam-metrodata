/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.nugrohodimas.views;

import its.nugrohodimas.models.Country;
import java.util.List;

/**
 *
 * @author Dony Tri P
 */
public class CountryView {
     public void showAllCountries(List<Country> countries) {
        for (Country c : countries) {
            System.out.println(c.getId() + " - " + c.getName() + " - " + c.getRegionId());
        }
    }
     public void showStatusCountries(boolean status) {
        System.out.println(status?"Query berhasil":"Query gagal");
    }
}
