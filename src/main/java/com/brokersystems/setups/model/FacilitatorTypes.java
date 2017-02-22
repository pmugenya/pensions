package com.brokersystems.setups.model;

import javax.persistence.*;

/**
 * Created by peter on 2/10/2017.
 */
@Entity
@Table(name="facilitator_types_def")
public class FacilitatorTypes {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="facil_id")
    private Long facilId;

    @Column(name="facil_sht_desc",nullable =false,unique =true)
    private String facilShtDesc;

    @Column(name="facil_name",nullable =false)
    private String facilName;

    public Long getFacilId() {
        return facilId;
    }

    public void setFacilId(Long facilId) {
        this.facilId = facilId;
    }

    public String getFacilShtDesc() {
        return facilShtDesc;
    }

    public void setFacilShtDesc(String facilShtDesc) {
        this.facilShtDesc = facilShtDesc;
    }

    public String getFacilName() {
        return facilName;
    }

    public void setFacilName(String facilName) {
        this.facilName = facilName;
    }
}
