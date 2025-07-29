package com.expensohub.expensohub_api.controller;


import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.expensohub.expensohub_api.entites.TbPsExpensohubEmp;
import com.expensohub.expensohub_api.entites.TbPsReimbursement;
import com.expensohub.expensohub_api.model.ReimbursementModel;
import com.expensohub.expensohub_api.response.ApiResponse;
import com.expensohub.expensohub_api.service.TbPsReimbursementService;

@RestController
@RequestMapping("/Reimbursement")
public class TbPsReimbursementController {

	@Autowired
	private TbPsReimbursementService tbPsReimbursementService;

//	@PostMapping(value = "/add")
//	public ResponseEntity<ApiResponse> createReimbursement(@RequestBody TbPsReimbursement tbPsReimbursement, @RequestParam final MultipartFile reimbUploadFile) throws SerialException, SQLException, IOException {
//
//		tbPsReimbursement.setReimbUploadFile(new SerialBlob(reimbUploadFile.getBytes()));
//		TbPsReimbursement createReimbursement = tbPsReimbursementService.createTbPsReimbursement(tbPsReimbursement);
//		return new ResponseEntity<ApiResponse>(new ApiResponse(createReimbursement, "Success", 200, true),
//				HttpStatus.OK);
//	}

	
	@PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ApiResponse> createReimbursement(@ModelAttribute ReimbursementModel model)
	        throws SerialException, SQLException, IOException {

	    TbPsReimbursement tb = new TbPsReimbursement();
	    tb.setEmpId(model.getEmpId());
	    tb.setReimbType(model.getReimbType());
	    tb.setReimbAmount(model.getReimbAmount());
	    tb.setReimbDesc(model.getReimbDesc());
	    tb.setCrtBy(model.getCrtBy());
	    tb.setIssueDate(model.getIssueDate());
	   	tb.setReimbUploadFile(new SerialBlob(model.getReimbUploadFile().getBytes()));

	    TbPsReimbursement saved = tbPsReimbursementService.createTbPsReimbursement(tb);
	    return ResponseEntity.ok(new ApiResponse(saved, "Success", 200, true));
	}

	
	@GetMapping("/getById/{rembId}")
	public ResponseEntity<ApiResponse> createReimbursement(@PathVariable Long rembId) {

		Optional<TbPsReimbursement> tbPsReimbursementById = tbPsReimbursementService.getTbPsReimbursementById(rembId);
		return new ResponseEntity<ApiResponse>(new ApiResponse(tbPsReimbursementById, "Success", 200, true),
				HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<ApiResponse> getAllReimbursement() {

		List<TbPsReimbursement> allTbPsReimbursement = tbPsReimbursementService.getAllTbPsReimbursement();
		return new ResponseEntity<ApiResponse>(new ApiResponse(allTbPsReimbursement, "Success", 200, true),
				HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponse> updateReimbursement(@RequestBody TbPsReimbursement tbPsReimbursement,
			@PathVariable Long id) {

		try {
			 TbPsReimbursement updateReimbursement = tbPsReimbursementService
					.updateReimbursement(tbPsReimbursement, id);
			return new ResponseEntity<ApiResponse>(new ApiResponse(updateReimbursement, "Success", 200, true),
					HttpStatus.OK);
			
		}catch(Exception e) {
			
			return new ResponseEntity<ApiResponse>(new ApiResponse("Employee", "Employee Id Not Found With"+ id, 404, false),
					HttpStatus.OK);
			
		}
	}

}
