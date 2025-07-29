package com.expensohub.expensohub_api.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.expensohub.expensohub_api.Exception.ResourceNotFoundException;
import com.expensohub.expensohub_api.common.DateUtil;
import com.expensohub.expensohub_api.dao.TbPsExpensoHubDao;
import com.expensohub.expensohub_api.entites.TbPsExpensohubEmp;

@Service
public class TbPsExpensohubEmpServiceImpl implements TbPsExpensohubEmpService {
	@Autowired
	TbPsExpensoHubDao tbPsExpensoHubDao;

	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public TbPsExpensohubEmp createTbPsExpensohubEmp(TbPsExpensohubEmp tbPsExpensohubEmp) {
		TbPsExpensohubEmp tbPsExpensohubEmpSave =null;
		try {
			tbPsExpensohubEmp.setCrtTs(DateUtil.getCurrentSystemDate());
			tbPsExpensohubEmp.setEmpPswd(passwordEncoder.encode(tbPsExpensohubEmp.getEmpPswd()));
			 tbPsExpensohubEmpSave = tbPsExpensoHubDao.save(tbPsExpensohubEmp);
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tbPsExpensohubEmpSave;
	}
		
		

	 
	

	@Override
	public List<TbPsExpensohubEmp> getListTbPsExpensohubEmp() {
		List<TbPsExpensohubEmp> findListofEmp = tbPsExpensoHubDao.findAll();
		return findListofEmp;
	}

	@Override
	public Optional<TbPsExpensohubEmp> getTbPsExpensohubEmpByid(Long empId) {
		Optional<TbPsExpensohubEmp> TbPsExpensohubEmpById = tbPsExpensoHubDao.findById(empId);
		return TbPsExpensohubEmpById;
		
	}

	public TbPsExpensohubEmp updateTbPsExpensohubEmpById(TbPsExpensohubEmp tbPsExpensohubEmp, Long id) {
		 TbPsExpensohubEmp existingEmp = tbPsExpensoHubDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "Employee ID " + id + " not found", id));
		existingEmp.setEmpFirstName(tbPsExpensohubEmp.getEmpFirstName());
		existingEmp.setEmpLastName(tbPsExpensohubEmp.getEmpLastName());
		existingEmp.setEmpCode(tbPsExpensohubEmp.getEmpCode());
		existingEmp.setEmpEmail(tbPsExpensohubEmp.getEmpEmail());
		existingEmp.setEmpRole(tbPsExpensohubEmp.getEmpRole());
		existingEmp.setEmpDepartment(tbPsExpensohubEmp.getEmpDepartment());
		existingEmp.setEmpDesignation(tbPsExpensohubEmp.getEmpDesignation());
		existingEmp.setEmpCompId(tbPsExpensohubEmp.getEmpCompId());
		existingEmp.setEmpCompName(tbPsExpensohubEmp.getEmpCompName());

		return tbPsExpensoHubDao.save(existingEmp);
	}
}
