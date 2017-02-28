package com.brokersystems.setups.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by peter on 2/10/2017.
 */
@Entity
@Table(name="service_providers")
public class ServiceProvider {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="sp_id")
    private Long spId;


    @Column(name="sp_code",nullable = false)
    private String spCode;

    @Column(name="sp_name",nullable = false)
    private String spName;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name="sp_appoint_dt")
    private Date spAppointDt;

    @Column(name="sp_pin",nullable = false)
    private String spPin;

    @ManyToOne
    @JoinColumn(name="sp_sector_id",nullable=false)
    private SectorDef sector;

    @ManyToOne
    @JoinColumn(name="sp_cou_code")
    private Country country;

    @Column(name="sp_address")
    private String address;

    @ManyToOne
    @JoinColumn(name="sp_tou_code")
    private Town town;

    @Column(name="sp_tel")
    private String telephone;

    @Column(name="sp_email")
    private String email;

    @Column(name="sp_phy_address")
    private String physicalAddress;

    public Long getSpId() {
        return spId;
    }

    public void setSpId(Long spId) {
        this.spId = spId;
    }


    public String getSpCode() {
        return spCode;
    }

    public void setSpCode(String spCode) {
        this.spCode = spCode;
    }

    public String getSpName() {
        return spName;
    }

    public void setSpName(String spName) {
        this.spName = spName;
    }

    public Date getSpAppointDt() {
        return spAppointDt;
    }

    public void setSpAppointDt(Date spAppointDt) {
        this.spAppointDt = spAppointDt;
    }

    public String getSpPin() {
        return spPin;
    }

    public void setSpPin(String spPin) {
        this.spPin = spPin;
    }

    public SectorDef getSector() {
        return sector;
    }

    public void setSector(SectorDef sector) {
        this.sector = sector;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }
}
