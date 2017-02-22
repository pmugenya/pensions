package com.brokersystems.setup.repository;

import com.brokersystems.setups.model.ServiceProvider;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by peter on 2/10/2017.
 */
public interface ServiceProviderRepo extends PagingAndSortingRepository<ServiceProvider, Long>, QueryDslPredicateExecutor<ServiceProvider> {
}
