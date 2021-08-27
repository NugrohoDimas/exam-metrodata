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
    public List<Region> getAllRegion();

    public boolean deleteRegion(String id);

    public Region getById(String id);

    public boolean saveRegion(Region region);
}
