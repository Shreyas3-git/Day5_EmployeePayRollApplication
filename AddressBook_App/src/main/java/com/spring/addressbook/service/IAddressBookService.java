package com.spring.addressbook.service;
import java.util.List;

import com.spring.addressbook.dto.AddressBookDTO;
import com.spring.addressbook.entity.AddressBookEntity;

public interface IAddressBookService 
{
	public abstract List<AddressBookEntity> getAllDetails();
	public abstract AddressBookEntity getById(int id);
	public abstract AddressBookEntity insertRecord(AddressBookDTO dto);
	public abstract AddressBookEntity updateRecord(int id,AddressBookDTO dto);
	public abstract AddressBookEntity deleteRecord(int id);
}
