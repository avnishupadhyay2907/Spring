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
import com.rays.dto.TimeTableDTO;
import com.rays.form.TimeTableForm;
import com.rays.service.TimeTableService;

@RestController
@RequestMapping(value = "TimeTableCtl")
public class TimeTableCtl extends BaseCtl {

	@Autowired
	TimeTableService service;

	@PostMapping("save")
	public ORSResponse save(@RequestBody @Valid TimeTableForm form, BindingResult bindingResult) {

		ORSResponse res = new ORSResponse();

		res = validate(bindingResult);

		if (res.isSuccess() == false) {
			return res;
		}

		TimeTableDTO dto = (TimeTableDTO) form.getDto();

		service.save(dto);

		res.addMessage("TimeTable saved successfully");
		res.addData(dto);
		res.setSuccess(true);

		return res;
	}

	// http://localhost:8080/TimeTable/update
	@PostMapping("update")
	public ORSResponse update(@RequestBody TimeTableForm form) {

		ORSResponse res = new ORSResponse();

		TimeTableDTO dto = (TimeTableDTO) form.getDto();

		service.save(dto);

		res.addMessage("TimeTable updated successfully");
		res.addData(dto);
		res.setSuccess(true);

		return res;
	}

	// http://localhost:8080/TimeTable/delete/id
	@GetMapping("delete/{ids}")
	public ORSResponse delete(@PathVariable long[] ids) {

		ORSResponse res = new ORSResponse();

		for (long id : ids) {
			service.delete(id);
			res.addMessage("TimeTable delete successfully");
			res.setSuccess(true);
		}

		return res;
	}

	// http://localhost:8080/TimeTable/get/id
	@GetMapping("get/{id}")
	public ORSResponse get(@PathVariable long id) {

		ORSResponse res = new ORSResponse();

		TimeTableDTO dto = service.findById(id);

		if (dto != null) {
			res.addMessage("TimeTable find successfully");
			res.setSuccess(true);
			res.addData(dto);
		}

		return res;
	}

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "/search/{pageNo}")
	public ORSResponse search(@RequestBody TimeTableForm form, @PathVariable int pageNo) {
		ORSResponse res = new ORSResponse();

		int pageSize = 5;

		TimeTableDTO dto = (TimeTableDTO) form.getDto();

		List<TimeTableDTO> list = service.search(dto, pageNo, pageSize);

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
