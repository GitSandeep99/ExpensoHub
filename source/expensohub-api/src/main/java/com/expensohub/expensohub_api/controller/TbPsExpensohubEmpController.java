package com.expensohub.expensohub_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expensohub.expensohub_api.Exception.ResourceNotFoundException;
import com.expensohub.expensohub_api.entites.TbPsExpensohubEmp;

import com.expensohub.expensohub_api.response.ApiResponse;
import com.expensohub.expensohub_api.service.TbPsExpensohubEmpService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/ExpensohubEmp")
public class TbPsExpensohubEmpController {

	@Autowired
	private TbPsExpensohubEmpService tbPsExpensohubEmpService;

	@PostMapping(value = "/add")
	public ResponseEntity<ApiResponse> addTbPsExpensohubEmp(@RequestBody TbPsExpensohubEmp tbPsExpensohubEmp) {

		TbPsExpensohubEmp tbPsExpensohubEmp1 = tbPsExpensohubEmpService.createTbPsExpensohubEmp(tbPsExpensohubEmp);
		return new ResponseEntity<ApiResponse>(new ApiResponse(tbPsExpensohubEmp1, "Success", 200, true),
				HttpStatus.OK);

	}

	@GetMapping(value = "/getAllTbPsExpensohubEmp")
	public ResponseEntity<ApiResponse> getAllTbPsExpensohubEmp() {

		List<TbPsExpensohubEmp> tbPsExpensohubEmp = tbPsExpensohubEmpService.getListTbPsExpensohubEmp();
		return new ResponseEntity<ApiResponse>(new ApiResponse(tbPsExpensohubEmp, "Success", 200, true), HttpStatus.OK);

	}

	@GetMapping(value = "/getTbPsExpensohubEmpById/{empId}")
	public ResponseEntity<ApiResponse> getTbPsExpensohubEmpById(@PathVariable("empId") Long empId) {

		try {
			TbPsExpensohubEmp tbPsExpensohubEmpById = tbPsExpensohubEmpService.getTbPsExpensohubEmpByid(empId).get();
			return new ResponseEntity<>(new ApiResponse(tbPsExpensohubEmpById, "Success", 200, true), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new ApiResponse("Employee",
							"Employee No record Found with "
									+ this.tbPsExpensohubEmpService.getTbPsExpensohubEmpByid(empId),
							404, false),
					HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping(value = "/updateEmp/{id}")
	public ResponseEntity<ApiResponse> updateTbPsExpensohubEmp(@RequestBody TbPsExpensohubEmp tbPsExpensohubEmp,
			@PathVariable Long id) {

		
		try {
			TbPsExpensohubEmp updateTbPsExpensohubEmpById = tbPsExpensohubEmpService
					.updateTbPsExpensohubEmpById(tbPsExpensohubEmp, id);
			return new ResponseEntity<ApiResponse>(new ApiResponse(updateTbPsExpensohubEmpById, "Success", 200, true),
					HttpStatus.OK);
			
		}catch(Exception e) {
			
			return new ResponseEntity<ApiResponse>(new ApiResponse("Employee", "Employee Id Not Found With"+ id, 404, false),
					HttpStatus.OK);
			
		}
		
		
		
		

	}

}
