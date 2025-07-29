package com.expensohub.expensohub_api.service;

import java.util.List;
import java.util.Optional;

import com.expensohub.expensohub_api.entites.TbPsExpensohubEmp;

public interface TbPsExpensohubEmpService {
	TbPsExpensohubEmp createTbPsExpensohubEmp(TbPsExpensohubEmp tbPsExpensohubEmp);
	List<TbPsExpensohubEmp> getListTbPsExpensohubEmp();
	Optional<TbPsExpensohubEmp> getTbPsExpensohubEmpByid(Long empId);
	TbPsExpensohubEmp updateTbPsExpensohubEmpById(TbPsExpensohubEmp tbPsExpensohubEmp, Long id);

}
