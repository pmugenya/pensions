package com.brokersystems.setups.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import com.brokersystems.setup.repository.*;
import com.brokersystems.setups.model.*;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.action.internal.QueuedOperationCollectionAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brokersystems.server.datatables.DataTablesRequest;
import com.brokersystems.server.datatables.DataTablesResult;
import com.brokersystems.server.exception.BadRequestException;
import com.brokersystems.setups.service.SetupsService;
import com.mysema.query.jpa.JPASubQuery;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.BooleanExpression;

@Service
public class SetupsServiceImpl implements SetupsService {

	@Autowired
	private CurrencyRepository currRepo;

	@Autowired
	private CountryRepository countryRepo;

	@Autowired
	private CountyRepository countyRepo;

	@Autowired
	private TownRepository townRepo;

	@Autowired
	private OrgBranchRepository branchRepo;

	@Autowired
	private PaymentModeRepo payRepo;

	@Autowired
	private SchemeRepository schemeRepository;

	@Autowired
	private SectorRepository sectorRepository;

	@Autowired
	private FacilitatorRepo facilitatorRepo;

	@Autowired
	private ServiceProviderRepo serviceProviderRepo;

	@Autowired
	private PeriodRepository periodRepository;


	@Override
	@Transactional(readOnly = true)
	public DataTablesResult<Currencies> findAllCurrencies(DataTablesRequest request) throws IllegalAccessException {
		Page<Currencies> page = currRepo.findAll(request.searchPredicate(QCurrencies.currencies), request);
		return new DataTablesResult<>(request, page);
	}

	

	@Override
	@Modifying
	@Transactional(readOnly = false)
	public void defineCurrency(Currencies currency) {

		currRepo.save(currency);

	}

	@Override
	@Modifying
	@Transactional(readOnly = false)
	public void deleteCurrency(Long currCode) {
		currRepo.delete(currCode);

	}

	@Override
	public DataTablesResult<Country> findAllCountries(DataTablesRequest request) throws IllegalAccessException {
		Page<Country> page = countryRepo.findAll(request.searchPredicate(QCountry.country), request);
		return new DataTablesResult<>(request, page);
	}

	@Override
	@Modifying
	@Transactional(readOnly = false)
	public void defineCountry(Country country) {
		countryRepo.save(country);

	}

	@Override
	@Modifying
	@Transactional(readOnly = false)
	public void deleteCountry(Long couCode) {
		countryRepo.delete(couCode);

	}

	@Override
	public DataTablesResult<County> findCountiesByCountry(long couCode, DataTablesRequest request)
			throws IllegalAccessException {
		QCountry country = QCounty.county.country;
		BooleanExpression pred = country.couCode.eq(couCode);
		Page<County> page = countyRepo.findAll(pred.and(request.searchPredicate(QCounty.county)), request);
		return new DataTablesResult(request, page);
	}

	@Override
	@Modifying
	@Transactional(readOnly = false)
	public void defineCounty(County county) {
		countyRepo.save(county);

	}

	@Override
	@Modifying
	@Transactional(readOnly = false)
	public void deleteCounty(Long countyCode) {
		countyRepo.delete(countyCode);

	}

	@Override
	public DataTablesResult<Town> findTownsByCounty(long countyCode, DataTablesRequest request)
			throws IllegalAccessException {
		QCounty county = QTown.town.county;
		BooleanExpression pred = county.countyId.eq(countyCode);
		Page<Town> page = townRepo.findAll(pred.and(request.searchPredicate(QTown.town)), request);
		return new DataTablesResult(request, page);
	}

	@Override
	@Modifying
	@Transactional(readOnly = false)
	public void defineTown(Town town) {
		townRepo.save(town);
	}

	@Override
	@Modifying
	@Transactional(readOnly = false)
	public void deleteTown(Long townCode) {
		townRepo.delete(townCode);
	}

	

	@Override
	public Page<OrgBranch> findBranchForSelect(String paramString, Pageable paramPageable) {
		Predicate pred = null;
		if (paramString == null || StringUtils.isBlank(paramString)) {
			pred = QOrgBranch.orgBranch.isNotNull();
		} else {
			pred = QOrgBranch.orgBranch.obName.containsIgnoreCase(paramString);
		}
		return branchRepo.findAll(pred, paramPageable);
	}

	

	@Override
	public DataTablesResult<PaymentModes> findAllPaymentModes(DataTablesRequest request) throws IllegalAccessException {
		Page<PaymentModes> page = payRepo.findAll(request.searchPredicate(QPaymentModes.paymentModes), request);
		return new DataTablesResult<>(request, page);
	}

	@Override
	@Modifying
	@Transactional(readOnly = false)
	public void definePaymentMode(PaymentModes mode) throws BadRequestException {
		if (mode.getPmMaxValue().compareTo(mode.getPmMinValue()) == -1) {
			throw new BadRequestException("Max Value cannot be less than min Value");
		}
		payRepo.save(mode);

	}

	@Override
	@Modifying
	@Transactional(readOnly = false)
	public void deletePaymentMode(Long pmId) {
		payRepo.delete(pmId);

	}


	@Override
	public DataTablesResult<SchemeDef> findAllSchemes(DataTablesRequest request) throws IllegalAccessException {
		Page<SchemeDef> page = schemeRepository.findAll(request.searchPredicate(QSchemeDef.schemeDef), request);
		return new DataTablesResult<>(request, page);
	}

	@Override
	public void defineSectors(SectorDef sectorDef) throws BadRequestException {
         sectorRepository.save(sectorDef);
	}

	@Override
	public DataTablesResult<SectorDef> findAllSectors(DataTablesRequest request) throws IllegalAccessException {
		Page<SectorDef> page = sectorRepository.findAll(request.searchPredicate(QSectorDef.sectorDef), request);
		return new DataTablesResult<>(request, page);
	}

	@Override
	public void deleteSectors(Long sectorId) {
        sectorRepository.delete(sectorId);
	}

	@Override
	public Page<SectorDef> findSectorsForSelect(String paramString, Pageable paramPageable) {
		Predicate pred = null;
		if (paramString == null || StringUtils.isBlank(paramString)) {
			pred = QSectorDef.sectorDef.isNotNull();
		} else {
			pred = QSectorDef.sectorDef.sectorName.containsIgnoreCase(paramString);
		}
		return sectorRepository.findAll(pred, paramPageable);
	}

	@Override
	public Page<Town> findTownsLov(String paramString, Pageable paramPageable) {
		Predicate pred = null;
		if (paramString == null || StringUtils.isBlank(paramString)) {
			pred = QTown.town.isNotNull();
		} else {
			pred = QTown.town.ctName.containsIgnoreCase(paramString);
		}
		return townRepo.findAll(pred, paramPageable);
	}

	@Override
	public Page<SchemeDef> findSchemeLov(String paramString, Pageable paramPageable) {
		Predicate pred = null;
		if (paramString == null || StringUtils.isBlank(paramString)) {
			pred = QSchemeDef.schemeDef.isNotNull();
		} else {
			pred = QSchemeDef.schemeDef.schemeName.containsIgnoreCase(paramString);
		}
		return schemeRepository.findAll(pred, paramPageable);
	}

	@Override
	public void createSchema(SchemeDef schemeDef) throws  BadRequestException {
		if(schemeDef.getMinJoinAge()!=null && schemeDef.getMaxJoinAge()!=null){
              if(schemeDef.getMaxJoinAge() < schemeDef.getMinJoinAge())
				  throw new BadRequestException("Max Join Age Cannot be less than Min Join Age");
		}

		schemeRepository.save(schemeDef);
	}


	@Override
	public SchemeDef getSchemeDetails(Long schemeId)  throws  BadRequestException {
		if(schemeId==null) throw new BadRequestException("Scheme Id is mandatory");
		SchemeDef schemeDef = schemeRepository.findOne(schemeId);
		if(schemeDef==null) throw new BadRequestException("Error getting Scheme Details");
         return schemeDef;
	}

	@Override
	public void defineFacilitatorTypes(FacilitatorTypes facilitatorTypes) throws BadRequestException {
        facilitatorRepo.save(facilitatorTypes);
	}

	@Override
	public void deleteFacilitatorTypes(Long facilId) {
        facilitatorRepo.delete(facilId);
	}

	@Override
	public DataTablesResult<FacilitatorTypes> findAllFacilitatorTypes(DataTablesRequest request) throws IllegalAccessException {
		Page<FacilitatorTypes> page = facilitatorRepo.findAll(request.searchPredicate(QFacilitatorTypes.facilitatorTypes), request);
		return new DataTablesResult<>(request, page);
	}

	@Override
	public DataTablesResult<ServiceProvider> findAllServiceProviders(DataTablesRequest request) throws IllegalAccessException {
		Page<ServiceProvider> page = serviceProviderRepo.findAll(request.searchPredicate(QServiceProvider.serviceProvider), request);
		return new DataTablesResult<>(request, page);
	}

	@Override
	public void defineServiceprovider(ServiceProvider provider) throws BadRequestException {
		serviceProviderRepo.save(provider);
	}

	@Override
	public void deleteServiceProvider(Long facilId) {
		serviceProviderRepo.delete(facilId);
	}

	@Override
	public DataTablesResult<SchemePeriod> findAllSchemePeriods(DataTablesRequest request) throws IllegalAccessException{
		Page<SchemePeriod> page = periodRepository.findAll(request.searchPredicate(QSchemePeriod.schemePeriod), request);
		return new DataTablesResult<>(request, page);
	}

	@Override
	public void defineSchemePeriod(SchemePeriod period) throws BadRequestException{
		periodRepository.save(period);
	}

	@Override
	public void deleteSchemePeriod(Long periodId)
	{
		periodRepository.delete(periodId);
	}
}
