package com.spring.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.addressbook.entity.AddressBookEntity;

@Repository
public interface IAddressBookRespository extends JpaRepository<AddressBookEntity,Integer>
{
	
}
