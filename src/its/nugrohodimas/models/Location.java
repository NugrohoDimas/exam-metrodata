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
public class Location {
    private String id;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    private String countryId;

    public Location() {
    }

    public Location(String id, String streetAddress, String postalCode, String city, String stateProvince, String countryId) {
        this.id = id;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.stateProvince = stateProvince;
        this.countryId = countryId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "Location{" + "id=" + id + 
                ", streetAddress=" + streetAddress + 
                ", postalCode=" + postalCode + 
                ", city=" + city + 
                ", stateProvince=" + stateProvince + 
                ", countryId=" + countryId + '}';
    }
}
