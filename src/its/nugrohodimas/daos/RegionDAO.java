/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.nugrohodimas.daos;

import its.nugrohodimas.models.Region;
import java.util.List;

/**
 *
 * @author Dony Tri P
 */
public interface RegionDAO{
    List<Region> getAllRegion();

    boolean deleteRegion(String id);

    Region getById(String id);

    boolean saveRegion(Region region);
}
