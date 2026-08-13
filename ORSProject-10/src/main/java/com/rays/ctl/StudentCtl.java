package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.StudentDTO;
import com.rays.form.StudentForm;
import com.rays.service.StudentServiceInt;

@RestController
@RequestMapping(value = "StudentCtl")
public class StudentCtl extends BaseCtl<StudentDTO, StudentForm, StudentServiceInt> {

}
