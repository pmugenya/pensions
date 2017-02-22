package com.brokersystems.setups.model;

import javax.persistence.*;

/**
 * Created by Peter on 1/26/2017.
 */
@Entity
@Table(name="sector_def")
public class SectorDef {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="sector_id")
    private Long sectorId;

    @Column(name="sector_sht_desc",nullable =false,unique =true)
    private String sectorShtDesc;

    @Column(name="sector_name",nullable =false)
    private String sectorName;

    public Long getSectorId() {
        return sectorId;
    }

    public void setSectorId(Long sectorId) {
        this.sectorId = sectorId;
    }

    public String getSectorShtDesc() {
        return sectorShtDesc;
    }

    public void setSectorShtDesc(String sectorShtDesc) {
        this.sectorShtDesc = sectorShtDesc;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }
}
