package com.usedmarket.controller.app;

import com.usedmarket.entity.SubjectHead;
import com.usedmarket.service.SubjectHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Description：标题头controller
 * Created by Peivxuan on 2016/11/29.
 */
/*@Controller
@RequestMapping("/SubjectHead")*/
public class SubjectHeadController {

	@Autowired
	private SubjectHeadService subjectHeadService;

	@RequestMapping("/getHead")
	@ResponseBody
	public List<SubjectHead> selectAll() {
		return subjectHeadService.selectAll();
	}

	@RequestMapping("/delete")
	@ResponseBody
	public void insert(SubjectHead subjectHead) {
		this.subjectHeadService.insert(subjectHead);
	}

	@RequestMapping("/delete")
	@ResponseBody
	public void deleteBySubjectHeadId(String subjectHeadId) {
		this.subjectHeadService.deleteBySubjectHeadId(subjectHeadId);
	}

	@RequestMapping("/update")
	@ResponseBody
	public void updateBySubjectHeadId(SubjectHead subjectHead) {
		this.subjectHeadService.updateBySubjectHeadId(subjectHead);
	}

}
