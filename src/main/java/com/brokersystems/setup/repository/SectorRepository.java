package com.brokersystems.setup.repository;

import com.brokersystems.setups.model.SectorDef;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Peter on 1/26/2017.
 */
public interface SectorRepository extends PagingAndSortingRepository<SectorDef, Long>, QueryDslPredicateExecutor<SectorDef> {

}
