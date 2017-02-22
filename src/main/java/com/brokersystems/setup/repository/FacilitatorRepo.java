package com.brokersystems.setup.repository;

import com.brokersystems.setups.model.FacilitatorTypes;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by peter on 2/10/2017.
 */
public interface FacilitatorRepo extends PagingAndSortingRepository<FacilitatorTypes, Long>, QueryDslPredicateExecutor<FacilitatorTypes> {
}
