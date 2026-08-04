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
import com.rays.dto.CourseDTO;
import com.rays.form.CourseForm;
import com.rays.service.CourseService;

@RestController
@RequestMapping(value = "CourseCtl")
public class CourseCtl extends BaseCtl {

	@Autowired
	CourseService service;

	// http://localhost:8080/USer/save
	@PostMapping("save")
	public ORSResponse save(@RequestBody @Valid CourseForm form, BindingResult bindingResult) {

		ORSResponse res = new ORSResponse();

		res = validate(bindingResult);

		if (res.isSuccess() == false) {
			return res;
		}

		CourseDTO dto = (CourseDTO) form.getDto();

		service.save(dto);

		res.addMessage("user saved successfully");
		res.addData(dto);
		res.setSuccess(true);

		return res;
	}

	// http://localhost:8080/USer/update
	@PostMapping("update")
	public ORSResponse update(@RequestBody CourseForm form) {

		ORSResponse res = new ORSResponse();

		CourseDTO dto = (CourseDTO) form.getDto();

		service.save(dto);

		res.addMessage("user updated successfully");
		res.addData(dto);
		res.setSuccess(true);

		return res;
	}

	// http://localhost:8080/USer/delete/id
	@GetMapping("delete/{ids}")
	public ORSResponse delete(@PathVariable long[] ids) {

		ORSResponse res = new ORSResponse();

		for (long id : ids) {
			service.delete(id);
			res.addMessage("user delete successfully");
			res.setSuccess(true);
		}

		return res;
	}

	// http://localhost:8080/USer/get/id
	@GetMapping("get/{id}")
	public ORSResponse get(@PathVariable long id) {

		ORSResponse res = new ORSResponse();

		CourseDTO dto = service.findById(id);

		if (dto != null) {
			res.setSuccess(true);
			res.addData(dto);
		}

		return res;
	}

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "/search/{pageNo}")
	public ORSResponse search(@RequestBody CourseForm form, @PathVariable int pageNo) {
		ORSResponse res = new ORSResponse();

		int pageSize = 5;

		CourseDTO dto = (CourseDTO) form.getDto();

		List<CourseDTO> list = service.search(dto, pageNo, pageSize);

		if (list != null && list.size() > 0) {
			res.setSuccess(true);
			res.addData(list);
			res.addMessage("Record find successfully");
		} else {
			res.addMessage("record not found");
		}

		return res;

	}

}
