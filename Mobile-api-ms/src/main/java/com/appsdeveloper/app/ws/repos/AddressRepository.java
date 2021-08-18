package com.appsdeveloper.app.ws.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appsdeveloper.app.ws.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
