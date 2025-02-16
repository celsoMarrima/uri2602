package com.devsuperior.uri2602.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2602.dto.CustomerMinDTO;
import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustomerMinProjection;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	@Query(nativeQuery = true, value = "select name "
			+ "from customers "
			+ "where UPPER(state)= UPPER(:state)")
	List<CustomerMinProjection> list(String state);
	
	@Query("select new com.devsuperior.uri2602.dto.CustomerMinDTO(obj.name) "
			+ "from Customer obj "
			+ "where UPPER(obj.state)= UPPER(:state)")
	List<CustomerMinDTO> list1(String state);
}

