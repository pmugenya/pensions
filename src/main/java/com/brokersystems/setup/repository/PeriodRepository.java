package com.brokersystems.setup.repository;


import com.brokersystems.setups.model.SchemePeriod;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
/**
 * Created by Admin on 2/19/2017.
 */
public interface PeriodRepository extends PagingAndSortingRepository<SchemePeriod, Long>, QueryDslPredicateExecutor<SchemePeriod>{
}
