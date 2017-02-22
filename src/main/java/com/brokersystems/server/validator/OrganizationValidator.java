package com.brokersystems.server.validator;

import com.brokersystems.server.exception.BadRequestException;
import org.springframework.stereotype.Component;

@Component
public class OrganizationValidator
{
  public void validateSelectCountiesForCountry(Long countryId)
    throws BadRequestException
  {
    if (countryId == null) {
      throw new BadRequestException("Country id is required");
    }
  }
  
  public void validateSelectTownsForCounty(Long countyId)
    throws BadRequestException
  {
    if (countyId == null) {
      throw new BadRequestException("County id is required");
    }
  }
  
  public void validateCity(Long cityCode)
    throws BadRequestException
  {
    if (cityCode == null) {
      throw new BadRequestException("Town id is required");
    }
  }
  
  public void validateCurrency(Long currCode)
    throws BadRequestException
  {
    if (currCode == null) {
      throw new BadRequestException("Currency is required");
    }
  }
}
