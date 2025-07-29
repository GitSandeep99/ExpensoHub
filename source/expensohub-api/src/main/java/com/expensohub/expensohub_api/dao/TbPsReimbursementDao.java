package com.expensohub.expensohub_api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.expensohub.expensohub_api.entites.TbPsReimbursement;

public interface TbPsReimbursementDao
		extends JpaRepository<TbPsReimbursement, Long>, JpaSpecificationExecutor<TbPsReimbursement> {

}
