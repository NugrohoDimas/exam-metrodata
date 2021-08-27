/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.nugrohodimas.views;

import its.nugrohodimas.models.Region;
import java.util.List;

/**
 *
 * @author Dony Tri P
 */
public class RegionView {
    public void showAllRegions(List<Region> regions) {
        for (Region r : regions) {
            System.out.println(r.getId() + " - " + r.getName() + " - ");
        }
    }
     public void showStatusRegions(boolean status) {
        System.out.println(status?"Query berhasil":"Query gagal");
    }
}
