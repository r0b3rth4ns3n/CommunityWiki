package com.r0b3rth4ns3n.CommunityWiki.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Coordinates implements Serializable {

    private Double latitude;

    private Double longitude;

    // constructors
    public Coordinates() { }

    public Coordinates(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // get
    public Double getLatitude() {
        return this.latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    // set
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}
