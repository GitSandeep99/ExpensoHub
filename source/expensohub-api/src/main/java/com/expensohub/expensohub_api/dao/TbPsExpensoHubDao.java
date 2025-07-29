package com.expensohub.expensohub_api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.expensohub.expensohub_api.entites.TbPsExpensohubEmp;

@Repository
public interface TbPsExpensoHubDao extends JpaRepository<TbPsExpensohubEmp, Long>, JpaSpecificationExecutor<TbPsExpensohubEmp> {

	
	
}