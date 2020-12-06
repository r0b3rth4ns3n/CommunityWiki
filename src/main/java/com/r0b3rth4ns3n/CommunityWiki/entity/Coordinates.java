package com.r0b3rth4ns3n.CommunityWiki.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Coordinates implements Serializable {
    private Integer latitude;
    private Integer longitude;
}
