package com.rays.ctl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.ORSResponse;
import com.rays.dto.TestDTO;

@RestController
@RequestMapping(value = "Ors")
public class ORSCtl {

	@GetMapping
	public ORSResponse getOrs() {

		ORSResponse res = new ORSResponse();

		res.addMessage("User Login Successfully");

		res.setSuccess(true);
		return res;

	}

	@GetMapping("getDto")
	public ORSResponse getDto() {

		ORSResponse res = new ORSResponse();

		TestDTO dto = new TestDTO();

		dto.setFirstName("Vansha");
		dto.setLastName("Upadhyay");
		dto.setLogin("vansha2907@gmail.com");
		dto.setPassword("pass12345");

		res.addData(dto);

		res.addMessage("Data get successfully...");
		res.setSuccess(true);
		return res;
	}

}
