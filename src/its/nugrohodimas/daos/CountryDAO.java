/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.nugrohodimas.daos;

import its.nugrohodimas.models.Country;
import java.util.List;

/**
 *
 * @author Dony Tri P
 */
public interface CountryDAO {
    public List<Country> getAllCountries();

    public boolean deleteCountry(String id);

    public Country getById(String id);

    public boolean saveCountry(Country country);
}
