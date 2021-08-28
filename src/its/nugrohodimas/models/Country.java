/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.nugrohodimas.models;

/**
 *
 * @author Dony Tri P
 */
public class Country {
    private String id;
    private String name;
    private String regionId;

    public Country() {
    }

    public Country(String id, String name, String regionId) {
        this.id = id;
        this.name = name;
        this.regionId = regionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    @Override
    public String toString() {
        return "Country{" + "id=" + id + 
                ", name=" + name + 
                ", regionId=" + regionId + '}';
    }
}
