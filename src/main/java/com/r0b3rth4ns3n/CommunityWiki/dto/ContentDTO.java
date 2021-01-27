package com.r0b3rth4ns3n.CommunityWiki.dto;

public class ContentDTO {

    private String name;

    private String phone;
    private String website;

    private String street;
    private String house;
    private String zip;
    private String city;
    private String country;

    // constructor
    public ContentDTO(String name, String phone, String website, String street, String house, String zip, String city, String country) {
        this.name = name;
        this.phone = phone;
        this.website = website;
        this.street = street;
        this.house = house;
        this.zip = zip;
        this.city = city;
        this.country = country;
    }

    // get
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    // set
    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
