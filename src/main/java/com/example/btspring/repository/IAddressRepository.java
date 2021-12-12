package com.example.btspring.repository;

import com.example.btspring.model.Address;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends PagingAndSortingRepository<Address,Long> {
}
