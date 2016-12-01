package com.usedmarket.controller.app;

import com.usedmarket.controller.BaseController;
import com.usedmarket.dto.HttpResult;
import com.usedmarket.entity.SubjectHead;
import com.usedmarket.service.SubjectHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Description：标题头controller
 * Created by Peivxuan on 2016/11/29.
 */
@Controller
@RequestMapping("/SubjectHead")
public class SubjectHeadController extends BaseController{

	@Autowired
	private SubjectHeadService subjectHeadService;

	@RequestMapping("/getHead")
	@ResponseBody
	public HttpResult selectAll() {
		return this.getHttpResult("",subjectHeadService.selectAll());
	}

	@RequestMapping("/insert")
	@ResponseBody
	public HttpResult insert(SubjectHead subjectHead) {
		subjectHead.setSubjectHeadId(this.get32UUID());
		subjectHead.setAddDate(new Date());
		subjectHead.setAddUser("tester");
		return this.getFrequentlyUsedReturnResultByBool(this.subjectHeadService.insert(subjectHead));
	}

	@RequestMapping("/delete")
	@ResponseBody
	public HttpResult deleteBySubjectHeadId(String subjectHeadId) {
		return this.getFrequentlyUsedReturnResultByBool(this.subjectHeadService.deleteBySubjectHeadId(subjectHeadId));
	}

	@RequestMapping("/update")
	@ResponseBody
	public HttpResult updateBySubjectHeadId(SubjectHead subjectHead) {
		return this.getFrequentlyUsedReturnResultByBool(this.subjectHeadService.updateBySubjectHeadId(subjectHead));
	}

}
