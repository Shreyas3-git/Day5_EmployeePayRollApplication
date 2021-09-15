package com.bridgelabz.employee.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employee.dto.EmployeeDTO;
import com.bridgelabz.employee.model.EmployeeEntity;
import com.bridgelabz.employee.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService
{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<EmployeeEntity> getEmployeePayRollData() 
	{
		return employeeRepository.findAll();
	}

	@Override
	public EmployeeEntity getEmployeePayRollData(int id)
	{
		return employeeRepository.findById(id).orElse(null);
	}

	@Override
	public EmployeeEntity addRecord(EmployeeDTO dto) 
	{
		EmployeeEntity entity = new EmployeeEntity(dto);
		employeeRepository.save(entity);
		return null;
	}

	@Override
	public EmployeeEntity updateRecord(int id, EmployeeDTO dto) 
	{
		EmployeeEntity entity = employeeRepository.findById(id).orElse(null);
		BeanUtils.copyProperties(dto, entity);
		employeeRepository.save(entity);
		return null;
	}

	@Override
	public EmployeeEntity deleteRecord(int id) 
	{
		employeeRepository.deleteById(id);
		return null;
	}

}
