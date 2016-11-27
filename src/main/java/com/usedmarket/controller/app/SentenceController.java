package com.usedmarket.controller.app;

import com.usedmarket.dto.HttpResult;
import com.usedmarket.dto.SentenceQueryCondition;
import com.usedmarket.entity.SentenceBean;
import com.usedmarket.service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Description：单文字的controller（跑马条、推荐、一级标题）
 * Created by Peivxuan on 2016/11/27.
 */
@Controller
@RequestMapping("/Sentence")
public class SentenceController {

	@Autowired
	private SentenceService sentenceService;

	@RequestMapping(value = "/select")
	@ResponseBody
	public HttpResult selectSentencesByCondition(SentenceQueryCondition sentenceQueryCondition) {
		return new HttpResult<List<SentenceBean>>(sentenceService.selectSentencesByCondition(sentenceQueryCondition));
	}

	@RequestMapping(value = "/add")
	@ResponseBody
	public HttpResult insert(SentenceBean sentenceBean) {
		HttpResult httpResult = new HttpResult();
		if (sentenceService.insert(sentenceBean)) {
			httpResult.setResultCenter("上传成功");
		} else
			httpResult.setResultCenter("操作失败");
		return httpResult;
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public HttpResult delete(String sentenceId) {
		HttpResult httpResult = new HttpResult();
		if (sentenceService.deleteBySentenceId(sentenceId)) {
			httpResult.setResultCenter("删除成功");
		} else
			httpResult.setResultCenter("操作失败");
		return httpResult;
	}

	@RequestMapping(value = "/update")
	@ResponseBody
	public HttpResult update(SentenceBean sentenceBean) {
		HttpResult httpResult = new HttpResult();
		if (sentenceService.updateBySentenceId(sentenceBean)) {
			httpResult.setResultCenter("更新成功");
		} else
			httpResult.setResultCenter("操作失败");
		return httpResult;
	}

}
