package com.rays.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.ORSResponse;
import com.rays.dto.UserDTO;
import com.rays.service.UserService;

@RestController
@RequestMapping(value = "UserCtl")
public class UserCtl {

	@Autowired
	UserService service;

	@PostMapping("add")
	public ORSResponse addUser(@RequestBody UserDTO dto) {

		ORSResponse res = new ORSResponse();

		int pk = service.add(dto);

		res.addData(pk);
		res.addMessage("Data added Successfully..!!");
		res.setSuccess(true);
		return res;

	}

	@PostMapping("save")
	public ORSResponse saveUser(@RequestBody UserDTO dto) {

		ORSResponse res = new ORSResponse();

		service.save(dto);

		res.addData(dto);
		res.addMessage("Data Updated Successfully..!!");
		res.setSuccess(true);
		return res;

	}

	@PostMapping("delete/{id}")
	public ORSResponse deleteUser(@PathVariable int id) {

		ORSResponse res = new ORSResponse();

		service.delete(id);

		res.addMessage("Data Deleted Successfully..!!");
		res.setSuccess(true);

		return res;

	}

}
