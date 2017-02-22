package com.brokersystems.setups.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="scheme_def")
public class SchemeDef {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="scheme_id")
	private Long schemeId;

	@Column(name="scheme_sht_desc",nullable = false,unique = true)
	private String schemeShtDesc;

	@Column(name="scheme_name",nullable = false)
	private String schemeName;

    @Column(name="scheme_type",nullable = false)
    private String schemeType;

	@Column(name="scheme_category",nullable = false)
	private String schemeCategory;

	@Column(name="scheme_level_admin")
	private String schemeLevelAdmin;

	@ManyToOne
	@JoinColumn(name="scheme_sector_id",nullable=false)
	private SectorDef sector;

	@Column(name="scheme_commence_dt",nullable  =false)
	private Date commenceDate;

	@Column(name="scheme_reg_dt")
	private Date regDate;

	@Column(name="scheme_tin")
	private String tin;

	@Column(name="scheme_min_join_age")
	private Long minJoinAge;

	@Column(name="scheme_max_join_age")
	private Long maxJoinAge;


	@Column(name="scheme_retirement_age")
	private Long retirementAge;

	@Column(name="scheme_pens_cal_mode")
	private String pensionSalCalcMode;

	@Column(name="scheme_life_ins_cover")
	private boolean lifeInsuranceCover;

	@Column(name="scheme_level_cover")
	private String levelOfCover;

	@Column(name="scheme_remmit_mode")
	private String remmittanceMode;

	@Column(name="scheme_contrib_freq")
	private String contribFrequence;

	@Column(name="scheme_mov_interest")
	private String interestRate;

	@Column(name="scheme_calc_interest")
	private boolean calcInterestBasedOnDate;

	@Column(name="scheme_contr_due_date")
	private Long contrDueDate;

	@Column(name="scheme_umbrella")
	private boolean umbrellaSchema;

	@Column(name="scheme_belongs_umbrella")
	private boolean belongsSchema;

	@ManyToOne
	@JoinColumn(name="scheme_parent_id")
	private SchemeDef parentSchema;

	@Column(name="scheme_pen_benef")
	private boolean pensionableBenef;

    @ManyToOne
    @JoinColumn(name="scheme_country_id")
    private Country country;

    @Column(name="scheme_postal_addr")
    private String postalAddress;

    @ManyToOne
    @JoinColumn(name="scheme_town_id")
    private Town town;

    @Column(name="scheme_email")
    private String email;


    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public Long getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(Long schemeId) {
        this.schemeId = schemeId;
    }

    public String getSchemeShtDesc() {
        return schemeShtDesc;
    }

    public void setSchemeShtDesc(String schemeShtDesc) {
        this.schemeShtDesc = schemeShtDesc;
    }

    public String getSchemeCategory() {
        return schemeCategory;
    }

    public void setSchemeCategory(String schemeCategory) {
        this.schemeCategory = schemeCategory;
    }

    public String getSchemeLevelAdmin() {
        return schemeLevelAdmin;
    }

    public void setSchemeLevelAdmin(String schemeLevelAdmin) {
        this.schemeLevelAdmin = schemeLevelAdmin;
    }

    public SectorDef getSector() {
        return sector;
    }

    public void setSector(SectorDef sector) {
        this.sector = sector;
    }

    public Date getCommenceDate() {
        return commenceDate;
    }

    public void setCommenceDate(Date commenceDate) {
        this.commenceDate = commenceDate;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public Long getMinJoinAge() {
        return minJoinAge;
    }

    public void setMinJoinAge(Long minJoinAge) {
        this.minJoinAge = minJoinAge;
    }

    public Long getMaxJoinAge() {
        return maxJoinAge;
    }

    public void setMaxJoinAge(Long maxJoinAge) {
        this.maxJoinAge = maxJoinAge;
    }

    public Long getRetirementAge() {
        return retirementAge;
    }

    public void setRetirementAge(Long retirementAge) {
        this.retirementAge = retirementAge;
    }

    public String getPensionSalCalcMode() {
        return pensionSalCalcMode;
    }

    public void setPensionSalCalcMode(String pensionSalCalcMode) {
        this.pensionSalCalcMode = pensionSalCalcMode;
    }

    public boolean isLifeInsuranceCover() {
        return lifeInsuranceCover;
    }

    public void setLifeInsuranceCover(boolean lifeInsuranceCover) {
        this.lifeInsuranceCover = lifeInsuranceCover;
    }

    public String getLevelOfCover() {
        return levelOfCover;
    }

    public void setLevelOfCover(String levelOfCover) {
        this.levelOfCover = levelOfCover;
    }

    public String getRemmittanceMode() {
        return remmittanceMode;
    }

    public void setRemmittanceMode(String remmittanceMode) {
        this.remmittanceMode = remmittanceMode;
    }

    public String getContribFrequence() {
        return contribFrequence;
    }

    public void setContribFrequence(String contribFrequence) {
        this.contribFrequence = contribFrequence;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public boolean isCalcInterestBasedOnDate() {
        return calcInterestBasedOnDate;
    }

    public void setCalcInterestBasedOnDate(boolean calcInterestBasedOnDate) {
        this.calcInterestBasedOnDate = calcInterestBasedOnDate;
    }

    public Long getContrDueDate() {
        return contrDueDate;
    }

    public void setContrDueDate(Long contrDueDate) {
        this.contrDueDate = contrDueDate;
    }

    public boolean isUmbrellaSchema() {
        return umbrellaSchema;
    }

    public void setUmbrellaSchema(boolean umbrellaSchema) {
        this.umbrellaSchema = umbrellaSchema;
    }

    public boolean isBelongsSchema() {
        return belongsSchema;
    }

    public void setBelongsSchema(boolean belongsSchema) {
        this.belongsSchema = belongsSchema;
    }

    public SchemeDef getParentSchema() {
        return parentSchema;
    }

    public void setParentSchema(SchemeDef parentSchema) {
        this.parentSchema = parentSchema;
    }

    public boolean isPensionableBenef() {
        return pensionableBenef;
    }

    public void setPensionableBenef(boolean pensionableBenef) {
        this.pensionableBenef = pensionableBenef;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchemeType() {
        return schemeType;
    }

    public void setSchemeType(String schemeType) {
        this.schemeType = schemeType;
    }
}
