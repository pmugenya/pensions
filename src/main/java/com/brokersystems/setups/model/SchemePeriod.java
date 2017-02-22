package com.brokersystems.setups.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by Admin on 2/19/2017.
 */
@Entity
@Table(name="scheme_periods")
public class SchemePeriod {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="period_id")
    private Long periodId;

    @Column(name="sp_name",nullable = false)
    private String speriodName;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name="start_date")
    private Date startDate;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name="end_date")
    private Date endDate;

    public Long getPeriodId(){
        return periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public String getSperiodName() {
        return speriodName;
    }

    public void setSperiodName(String speriodName) {
        this.speriodName = speriodName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
