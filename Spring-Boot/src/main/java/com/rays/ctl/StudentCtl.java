package com.rays.ctl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.StudentDTO;
import com.rays.form.StudentForm;
import com.rays.service.StudentService;

@RestController
@RequestMapping(value = "StudentCtl")
public class StudentCtl extends BaseCtl {

	@Autowired
	StudentService service;

	@PostMapping("save")
	public ORSResponse save(@RequestBody @Valid StudentForm form, BindingResult bindingResult) {

		ORSResponse res = new ORSResponse();

		res = validate(bindingResult);

		if (res.isSuccess() == false) {
			return res;
		}

		StudentDTO dto = (StudentDTO) form.getDto();

		service.save(dto);

		res.addMessage("Student saved successfully");
		res.addData(dto);
		res.setSuccess(true);

		return res;
	}

	// http://localhost:8080/Student/update
	@PostMapping("update")
	public ORSResponse update(@RequestBody StudentForm form) {

		ORSResponse res = new ORSResponse();

		StudentDTO dto = (StudentDTO) form.getDto();

		service.save(dto);

		res.addMessage("Student updated successfully");
		res.addData(dto);
		res.setSuccess(true);

		return res;
	}

	// http://localhost:8080/Student/delete/id
	@GetMapping("delete/{ids}")
	public ORSResponse delete(@PathVariable long[] ids) {

		ORSResponse res = new ORSResponse();

		for (long id : ids) {
			service.delete(id);
			res.addMessage("Student delete successfully");
			res.setSuccess(true);
		}

		return res;
	}

	// http://localhost:8080/Student/get/id
	@GetMapping("get/{id}")
	public ORSResponse get(@PathVariable long id) {

		ORSResponse res = new ORSResponse();

		StudentDTO dto = service.findById(id);

		if (dto != null) {
			res.addMessage("Student find successfully");
			res.setSuccess(true);
			res.addData(dto);
		}

		return res;
	}

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "/search/{pageNo}")
	public ORSResponse search(@RequestBody StudentForm form, @PathVariable int pageNo) {
		ORSResponse res = new ORSResponse();

		int pageSize = 5;

		StudentDTO dto = (StudentDTO) form.getDto();

		List<StudentDTO> list = service.search(dto, pageNo, pageSize);

		if (list != null && list.size() > 0) {
			res.setSuccess(true);
			res.addData(list);
			res.addMessage("Record find successfully");
		} else {
			res.addMessage("Record not found");
		}

		return res;

	}

}
