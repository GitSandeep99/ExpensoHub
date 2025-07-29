package com.expensohub.expensohub_api.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensohub.expensohub_api.Exception.ResourceNotFoundException;
import com.expensohub.expensohub_api.common.DateUtil;
import com.expensohub.expensohub_api.dao.TbPsReimbursementDao;
import com.expensohub.expensohub_api.entites.TbPsReimbursement;

@Service
public class TbPsReimbursementServiceImpl implements TbPsReimbursementService {

	@Autowired
	TbPsReimbursementDao tbPsReimbursementDao;

	@Override
	public TbPsReimbursement createTbPsReimbursement(TbPsReimbursement tbPsReimbursement) {
		TbPsReimbursement createReimbursement = null;
		try {
			
			tbPsReimbursement.setCrtTs(DateUtil.getCurrentSystemDate());
			tbPsReimbursement.setIssueDate(DateUtil.getCurrentSystemDate());
			createReimbursement = tbPsReimbursementDao.save(tbPsReimbursement);
		} catch (Exception e) {
		}

		return createReimbursement;

	}

	@Override
	public Optional<TbPsReimbursement> getTbPsReimbursementById(Long rembId) {

		Optional<TbPsReimbursement> getReimbursementById = tbPsReimbursementDao.findById(rembId);

		return getReimbursementById;
	}

	@Override
	public List<TbPsReimbursement> getAllTbPsReimbursement() {
		List<TbPsReimbursement> findListOfReimbursement = tbPsReimbursementDao.findAll();
		return findListOfReimbursement;
	}

	@Override
	public TbPsReimbursement updateReimbursement(TbPsReimbursement tbPsReimbursement, Long rembId) {
		TbPsReimbursement existingReimbursement = tbPsReimbursementDao.findById(rembId)
				.orElseThrow(() -> new ResourceNotFoundException("Reimbursement",
						"Reimbursement ID " + rembId + " not found", rembId));
		existingReimbursement.setEmpId(tbPsReimbursement.getEmpId());
		existingReimbursement.setEmpId(tbPsReimbursement.getEmpId());
		existingReimbursement.setIssueDate(tbPsReimbursement.getIssueDate());
		existingReimbursement.setReimbDesc(tbPsReimbursement.getReimbDesc());
		existingReimbursement.setReimbAmount(tbPsReimbursement.getReimbAmount());
		existingReimbursement.setReimbType(tbPsReimbursement.getReimbType());
		existingReimbursement.setReimbUploadFile(tbPsReimbursement.getReimbUploadFile());

		return existingReimbursement;
	}

}
