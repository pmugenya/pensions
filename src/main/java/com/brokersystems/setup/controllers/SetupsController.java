package com.brokersystems.setup.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.brokersystems.setups.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.brokersystems.server.datatables.DataTable;
import com.brokersystems.server.datatables.DataTablesRequest;
import com.brokersystems.server.datatables.DataTablesResult;
import com.brokersystems.server.exception.BadRequestException;
import com.brokersystems.setups.service.SetupsService;

@Controller
@RequestMapping({ "/protected/setups" })
public class SetupsController {

	@Autowired
	private SetupsService setupsService;
	
	@InitBinder({ "account" })
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@ModelAttribute
	public ModelHelperForm createHelperForm() {
		return new ModelHelperForm();
	}

	@RequestMapping(value = "currency", method = RequestMethod.GET)
	public String currencyHome(Model model) {
		return "currency";
	}
	
	@RequestMapping(value = "countries", method = RequestMethod.GET)
	public String countryHome(Model model) {
		return "countries";
	}

	@RequestMapping(value = "paymentmodes", method = RequestMethod.GET)
	public String paymentModesHome(Model model) {
		return "paymodesList";
	}

	@RequestMapping(value = "sectorhome", method = RequestMethod.GET)
	public String sectorsHome(Model model) {
		return "sectorsList";
	}

	@RequestMapping(value = "facilitatorHome", method = RequestMethod.GET)
	public String facilitatorTypeHome(Model model) {
		return "facilList";
	}

	@RequestMapping(value = "sprovidersHome", method = RequestMethod.GET)
	public String sprovidersHome(Model model) {
		return "sproviders";
	}
	@RequestMapping(value = "speriodsHome", method = RequestMethod.GET)
	public String speriodsHome(Model model) {return "speriods";}

	@RequestMapping(value = { "currencies" }, method = { RequestMethod.GET })
	@ResponseBody
	public DataTablesResult<Currencies> getCurrencies(@DataTable DataTablesRequest pageable)
			throws IllegalAccessException {
		return setupsService.findAllCurrencies(pageable);
	}


	@RequestMapping(value = { "createCurrency" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public void saveOrUpdateCurrency(Currencies currency) throws IllegalAccessException {
		setupsService.defineCurrency(currency);
	}

	@RequestMapping(value = { "deleteCurrency/{currCode}" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.GET })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCurrency(@PathVariable Long currCode) {
		setupsService.deleteCurrency(currCode);
	}

	@RequestMapping(value = { "allCountries" }, method = { RequestMethod.GET })
	@ResponseBody
	public DataTablesResult<Country> getCountries(@DataTable DataTablesRequest pageable) throws IllegalAccessException {
		return setupsService.findAllCountries(pageable);
	}

	@RequestMapping(value = { "createCountry" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public void saveOrUpdateCountry(Country country) throws IllegalAccessException {
		setupsService.defineCountry(country);
	}

	@RequestMapping(value = { "deleteCountry/{couCode}" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.GET })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCountry(@PathVariable Long couCode) {
		setupsService.deleteCountry(couCode);
	}

	@RequestMapping(value = { "allCounties/{couCode}" }, method = { RequestMethod.GET })
	@ResponseBody
	public DataTablesResult<County> getCounties(@DataTable DataTablesRequest pageable, @PathVariable Long couCode)
			throws IllegalAccessException {
		return setupsService.findCountiesByCountry(couCode, pageable);
	}

	@RequestMapping(value = { "createCounty" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public void saveOrUpdateCounty(County county) throws IllegalAccessException {
		setupsService.defineCounty(county);
	}

	@RequestMapping(value = { "deleteCounty/{countyCode}" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.GET })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCounty(@PathVariable Long countyCode) {
		setupsService.deleteCounty(countyCode);
	}

	@RequestMapping(value = { "allTowns/{countyCode}" }, method = { RequestMethod.GET })
	@ResponseBody
	public DataTablesResult<Town> getTowns(@DataTable DataTablesRequest pageable, @PathVariable Long countyCode)
			throws IllegalAccessException {
		return setupsService.findTownsByCounty(countyCode, pageable);
	}

	@RequestMapping(value = { "createTown" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public void saveOrUpdateTown(Town town) throws IllegalAccessException {
		setupsService.defineTown(town);
	}

	@RequestMapping(value = { "deleteTown/{townCode}" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.GET })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteTown(@PathVariable Long townCode) {
		setupsService.deleteTown(townCode);
	}

	@RequestMapping(value = { "allpaymentModes" }, method = { RequestMethod.GET })
	@ResponseBody
	public DataTablesResult<PaymentModes> getPayemtModes(@DataTable DataTablesRequest pageable)
			throws IllegalAccessException {
		return setupsService.findAllPaymentModes(pageable);
	}

	@RequestMapping(value = { "createPaymentModes" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public void saveOrUpdatePaymentModes(PaymentModes mode) throws BadRequestException {
		setupsService.definePaymentMode(mode);
	}

	@RequestMapping(value = { "deletePayMode/{pmId}" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.GET })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePaymentMode(@PathVariable Long pmId) {
		setupsService.deletePaymentMode(pmId);
	}


	@RequestMapping(value = { "allSectors" }, method = { RequestMethod.GET })
	@ResponseBody
	public DataTablesResult<SectorDef> getAllSectors(@DataTable DataTablesRequest pageable)
			throws IllegalAccessException {
		return setupsService.findAllSectors(pageable);
	}

	@RequestMapping(value = { "createSectors" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public void saveSectors(SectorDef sectorDef) throws BadRequestException {
		setupsService.defineSectors(sectorDef);
	}

	@RequestMapping(value = { "deleteSector/{sectorId}" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.GET })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteSector(@PathVariable Long sectorId) {
		setupsService.deleteSectors(sectorId);
	}

	@RequestMapping(value = { "allFacilitTypes" }, method = { RequestMethod.GET })
	@ResponseBody
	public DataTablesResult<FacilitatorTypes> getAllFacilitatorTypes(@DataTable DataTablesRequest pageable)
			throws IllegalAccessException {
		return setupsService.findAllFacilitatorTypes(pageable);
	}

	@RequestMapping(value = { "createFacilTypes" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public void createFacilTypes(FacilitatorTypes facilitatorTypes) throws BadRequestException {
		setupsService.defineFacilitatorTypes(facilitatorTypes);
	}


	@RequestMapping(value = { "deleteFaciliTypes/{facilId}" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.GET })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteFaciliTypes(@PathVariable Long facilId) {
		setupsService.deleteFacilitatorTypes(facilId);
	}

	@RequestMapping(value = { "allServiceProviders" }, method = { RequestMethod.GET })
	@ResponseBody
	public DataTablesResult<ServiceProvider> getAllServiceProviders(@DataTable DataTablesRequest pageable)
			throws IllegalAccessException {
		return setupsService.findAllServiceProviders(pageable);
	}

	@RequestMapping(value = { "createServiceProvider" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public void createServiceProvider(ServiceProvider provider) throws BadRequestException {
		setupsService.defineServiceprovider(provider);
	}


	@RequestMapping(value = { "deleteServiceProviders/{spId}" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.GET })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteServiceProviders(@PathVariable Long spId) {
		setupsService.deleteServiceProvider(spId);
	}

	@RequestMapping(value = {"allSchemePeriods"}, method = { RequestMethod.GET })
	@ResponseBody
	public DataTablesResult<SchemePeriod> getAllSchemePeriods(@DataTable DataTablesRequest pageable)
			throws IllegalAccessException{
		return setupsService.findAllSchemePeriods(pageable);
	}
	@RequestMapping(value = { "createSchemePeriod" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public void createSchemePeriod(SchemePeriod schemePeriod) throws BadRequestException {
		setupsService.defineSchemePeriod(schemePeriod);
	}
	@RequestMapping(value = { "deleteSchemePeriod/{periodId}" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.GET })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteSchemePeriods(@PathVariable Long periodId) {
		setupsService.deleteSchemePeriod(periodId);
	}
}
