package com.spring.addressbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.spring.addressbook.dto.AddressBookDTO;
import com.spring.addressbook.entity.AddressBookEntity;
import com.spring.addressbook.repository.IAddressBookRespository;

@Service
public class AddressBookService implements IAddressBookService
{
	/**
	 * implement IAddressBookService interface to the service class and implement all abstract functions
	 */
	@Autowired
	private IAddressBookRespository repo;

	/**
	 * This function is used to retrived all from the database table
	 * getAllDetails() --> i create simple arraylist and after that reference variable of repository 
	 * 					   i call findAll inbuilt function that find all records after that in for each loop 
	 * 					   i simply add one complete record it time on the list.
	 * @return    	  -->  This function return list of addressbook records
	 */
	@Override
	public List<AddressBookEntity> getAllDetails() {
		List<AddressBookEntity> entity = new ArrayList<>();
		repo.findAll().forEach(entity :: add);
		return entity;
	}
	/**
	 * getById()	--> Based on id in table finding specific record here.
	 * @param		-->this id passed from controller class based on id user can enter in the url
	 * 				   that perticular record will find / show
	 * @return		-->This function return single record based user input in url section
	 */
	@Override
	public AddressBookEntity getById(int id) {
		
		return repo.findById(id).orElse(null);
	}
	
	/**
	 * insertRecord()	--> This function inserting single record in the AddressBook database table
	 * @param			--> AddressBookDTO dto here dto is the reference of class AddressBookDTO which i passed in the
	 * 						controller class which can hold all the information which is given by user
	 * @return			--> this method can return null
	 */
	@Override
	public AddressBookEntity insertRecord(AddressBookDTO dto) {
		AddressBookEntity entity = new AddressBookEntity(dto);
		repo.save(entity);
		return null;
	}

	/**
	 * updateRecord()	--> This method can updated the current data in the table to user given input on the tool like postman
	 *@param			--> This id variable find perticular record and giving to entity class reference
	 *@param			--> dto reference used to set updated values to the attributes
	 *						first i check if given name is not null and not empty then upadte it
	 *						and save this record through repositroy reference.save()
	 *@return			--> This method is return null  
	 */
	@Override
	public AddressBookEntity updateRecord(int id, AddressBookDTO dto) {
		AddressBookEntity entity = repo.findById(id).get();
		
		if (null != dto.getName() && ! dto.getName().isEmpty()) 
		{
			entity.setName(dto.getName());
		}
		
		if (null != dto.getAddress() && ! dto.getAddress().isEmpty()) 
		{
			entity.setAddress(dto.getAddress());
		}
		
		if (null != dto.getCity() && ! dto.getCity().isEmpty()) 
		{
			entity.setCity(dto.getCity());
		}
		
		if (null != dto.getEmail() && ! dto.getEmail().isEmpty())
		{
			entity.setEmail(dto.getEmail());
		}
		
		if (null != dto.getPhone() && ! dto.getPhone().isEmpty())
		{
			entity.setPhone(dto.getPhone());
		}
			
		if (null != dto.getZip() && ! dto.getZip().isEmpty()) 
		{
			entity.setZip(dto.getZip());
		}
		
		repo.save(entity);
		return null;
	}

	/**
	 * deleteRecord()	--> This function can delete record based on id
	 * @param			--> I set primary key to attribute id so it should always be unique 
	 * 						based this deletedById function can remove that record
	 * @return			--> This function is return as null 
	 */
	@Override
	public AddressBookEntity deleteRecord(int id) {
		repo.deleteById(id);
		return null;
	}

	
}
