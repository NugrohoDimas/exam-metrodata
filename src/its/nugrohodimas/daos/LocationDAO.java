/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.nugrohodimas.daos;

import its.nugrohodimas.models.Location;
import java.util.List;

/**
 *
 * @author Dony Tri P
 */
public interface LocationDAO {
    public List<Location> getAllLocations();

    public boolean deleteLocation(String id);

    public Location getById(String id);

    public boolean saveLocation(Location location);
}
