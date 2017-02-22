package com.brokersystems.setup.repository;

import com.brokersystems.setups.model.SchemeDef;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Peter on 1/26/2017.
 */
public interface SchemeRepository  extends PagingAndSortingRepository<SchemeDef, Long>, QueryDslPredicateExecutor<SchemeDef> {
}
