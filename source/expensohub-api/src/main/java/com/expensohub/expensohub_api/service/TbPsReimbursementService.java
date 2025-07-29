package com.expensohub.expensohub_api.service;

import java.util.List;
import java.util.Optional;

import com.expensohub.expensohub_api.entites.TbPsReimbursement;

public interface TbPsReimbursementService {

	TbPsReimbursement createTbPsReimbursement(TbPsReimbursement tbPsReimbursement);

	Optional<TbPsReimbursement> getTbPsReimbursementById(Long id);
	
	List<TbPsReimbursement>getAllTbPsReimbursement();
	TbPsReimbursement updateReimbursement(TbPsReimbursement tbPsReimbursement,Long rembId);

}
