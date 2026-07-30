package com.rays.ctl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.CollegeDTO;
import com.rays.form.CollegeForm;
import com.rays.service.CollegeService;

@RestController
@RequestMapping(value = "CollegeCtl")
public class CollegeCtl extends BaseCtl {

	@Autowired
	CollegeService service;

	@PostMapping("save")
	public ORSResponse save(@RequestBody @Valid CollegeForm form, BindingResult bindingResult) {

		ORSResponse res = new ORSResponse(true);

		res = validate(bindingResult);
		if (res.isSuccess() == false) {
			return res;
		}

		CollegeDTO dto = (CollegeDTO) form.getDto();

		service.save(dto);

		res.addMessage("College Saved Successfully");
		res.addData(dto);
		res.setSuccess(true);
		return res;

	}

	@PostMapping("update")
	public ORSResponse update(@RequestBody CollegeForm form) {

		ORSResponse res = new ORSResponse();

		CollegeDTO dto = (CollegeDTO) form.getDto();

		service.save(dto);

		res.addMessage("College Updated Successfully..");
		res.addData(dto);
		res.setSuccess(true);
		return res;

	}

	@GetMapping("delete/{ids}")
	public ORSResponse delete(@PathVariable long[] ids) {

		ORSResponse res = new ORSResponse();

		for (long id : ids) {

			service.delete(id);
			res.addMessage("College Deleted Successfully");
			res.setSuccess(true);

		}
		return res;

	}

	@GetMapping("get/{id}")
	public ORSResponse get(@PathVariable long id) {

		ORSResponse res = new ORSResponse();
		CollegeDTO dto = service.findById(id);

		if (dto != null) {

			res.addData(dto);
			res.setSuccess(true);
			res.addMessage("Data get successfully");
		}
		return res;

	}

}
