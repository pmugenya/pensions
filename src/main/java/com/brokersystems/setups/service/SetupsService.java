package com.brokersystems.setups.service;

import com.brokersystems.setups.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.brokersystems.server.datatables.DataTablesRequest;
import com.brokersystems.server.datatables.DataTablesResult;
import com.brokersystems.server.exception.BadRequestException;
import com.mysema.query.types.Predicate;

/**
 * This  is used to maintain crud and query services of several setups screens
 * in the system like Currency, Countries, Counties, Citys
 * @author mugenyq
 *
 */
public interface SetupsService {
	
	
	DataTablesResult<Currencies> findAllCurrencies(DataTablesRequest request)  throws IllegalAccessException;
	
	void defineCurrency(Currencies currency);
	
	void deleteCurrency(Long currCode);
	
	DataTablesResult<Country> findAllCountries(DataTablesRequest request)  throws IllegalAccessException;
	
	void defineCountry(Country country);
	
	void deleteCountry(Long couCode);
	
	DataTablesResult<County> findCountiesByCountry(long couCode,DataTablesRequest request)  throws IllegalAccessException;
	
    void defineCounty(County county);
	
	void deleteCounty(Long countyCode);
	
    DataTablesResult<Town> findTownsByCounty(long countyCode,DataTablesRequest request)  throws IllegalAccessException;
	
    void defineTown(Town town);
	
	void deleteTown(Long townCode);
		
	 Page<OrgBranch> findBranchForSelect(String paramString, Pageable paramPageable);
	 
     DataTablesResult<PaymentModes> findAllPaymentModes(DataTablesRequest request)  throws IllegalAccessException;
 	
     void definePaymentMode(PaymentModes mode) throws BadRequestException;
 	
 	 void deletePaymentMode(Long pmId);

	DataTablesResult<SchemeDef> findAllSchemes(DataTablesRequest request)  throws IllegalAccessException;

	DataTablesResult<SectorDef> findAllSectors(DataTablesRequest request)  throws IllegalAccessException;

	void defineSectors(SectorDef sectorDef) throws BadRequestException;

	void deleteSectors(Long sectorId);

	Page<SectorDef> findSectorsForSelect(String paramString, Pageable paramPageable);

	Page<Town> findTownsLov(String paramString, Pageable paramPageable);

	Page<SchemeDef> findSchemeLov(String paramString, Pageable paramPageable);

	void createSchema(SchemeDef schemeDef) throws BadRequestException;

	SchemeDef getSchemeDetails(Long schemeId) throws  BadRequestException;

	DataTablesResult<FacilitatorTypes> findAllFacilitatorTypes(DataTablesRequest request)  throws IllegalAccessException;

	void defineFacilitatorTypes(FacilitatorTypes facilitatorTypes) throws BadRequestException;

	void deleteFacilitatorTypes(Long facilId);

	DataTablesResult<ServiceProvider> findAllServiceProviders(DataTablesRequest request) throws IllegalAccessException;

	void defineServiceprovider(ServiceProvider provider) throws BadRequestException;

	void deleteServiceProvider(Long facilId);

	DataTablesResult<SchemePeriod> findAllSchemePeriods(DataTablesRequest request) throws IllegalAccessException;

	void defineSchemePeriod(SchemePeriod period) throws BadRequestException;

	void deleteSchemePeriod(Long periodId);

}
