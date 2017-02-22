package com.brokersystems.setup.controllers;

import com.brokersystems.server.datatables.DataTable;
import com.brokersystems.server.datatables.DataTablesRequest;
import com.brokersystems.server.datatables.DataTablesResult;
import com.brokersystems.server.exception.BadRequestException;
import com.brokersystems.setups.model.*;
import com.brokersystems.setups.service.SetupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by Peter on 1/26/2017.
 */
@Controller
@RequestMapping({ "/protected/setups/schemes" })
public class SchemeController {

    @Autowired
    private SetupsService setupsService;

    @RequestMapping(value = "schemedef", method = RequestMethod.GET)
    public String schemeHome(Model model) {
        return "schemedefinition";
    }


    @RequestMapping(value = "schemenew", method = RequestMethod.GET)
    public String newScheme(Model model) {
        model.addAttribute("schemeId", -2000);
        return "newscheme";
    }

    @RequestMapping(value = "/editScheme", method = RequestMethod.POST)
    public String editRentalForm(@Valid @ModelAttribute SchemeHelperForm helperForm, Model model,
                                 HttpServletRequest request) {
        System.out.println("scheme id "+helperForm.getSchemeId());
        model.addAttribute("schemeId", helperForm.getSchemeId());
        return "newscheme";
    }



    @RequestMapping(value = { "schemeList" }, method = { RequestMethod.GET })
    @ResponseBody
    public DataTablesResult<SchemeDef> getAllSchemes(@DataTable DataTablesRequest pageable)
            throws IllegalAccessException {
        return setupsService.findAllSchemes(pageable);
    }

    @RequestMapping(value = { "selSectors" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
    @ResponseBody
    public Page<SectorDef> findSelectedSectors(@RequestParam(value = "term", required = false) String term,
                                               Pageable pageable) throws IllegalAccessException {
        return setupsService.findSectorsForSelect(term, pageable);
    }


    @RequestMapping(value = { "selTowns" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
    @ResponseBody
    public Page<Town> findSelectedTowns(@RequestParam(value = "term", required = false) String term,
                                        Pageable pageable) throws IllegalAccessException {
        return setupsService.findTownsLov(term, pageable);
    }


    @RequestMapping(value = { "selSchemes" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
    @ResponseBody
    public Page<SchemeDef> SchemesLov(@RequestParam(value = "term", required = false) String term,
                                        Pageable pageable) throws IllegalAccessException {
        return setupsService.findSchemeLov(term, pageable);
    }

    @RequestMapping(value = { "createNewScheme" }, method = {
            org.springframework.web.bind.annotation.RequestMethod.POST })
    @ResponseStatus(HttpStatus.CREATED)
    public void saveScheme(SchemeDef schemeDef) throws BadRequestException {
        setupsService.createSchema(schemeDef);
    }

    @RequestMapping(value = { "getSchemeDetails/{schemeId}" }, method = {
            org.springframework.web.bind.annotation.RequestMethod.GET })
    public ResponseEntity<SchemeDef> getPolicyDetails(@PathVariable Long schemeId) throws BadRequestException {
        SchemeDef created = setupsService.getSchemeDetails(schemeId);
        return new ResponseEntity<SchemeDef>(created, HttpStatus.OK);
    }

}
