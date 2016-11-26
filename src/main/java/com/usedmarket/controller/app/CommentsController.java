package com.usedmarket.controller.app;

import com.usedmarket.dto.CommentCustom;
import com.usedmarket.dto.HttpResult;
import com.usedmarket.entity.Comment;
import com.usedmarket.service.CommentService;
import com.usedmarket.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Description：enter your comment
 * Created by Peivxuan on 2016/11/3.
 */

@Controller
@RequestMapping("/Comment")
public class CommentsController {

	@Autowired
	CommentService commentService;

	@RequestMapping(value = "/searchByCommodityId")
	@ResponseBody
	public HttpResult searchCommentByCommodityId(String commodityId) {
		return new HttpResult<List<CommentCustom>>(commentService.findByCommodityId(commodityId));
	}

	@RequestMapping(value = "/insert")
	@ResponseBody
	public HttpResult insert(Comment comment) {
		comment.setCommentId(UuidUtil.get32UUID());
		comment.setCommentDate(new Date());
		HttpResult httpResult = new HttpResult();
		if (commentService.insert(comment)) {
			httpResult.setResultCenter("评论成功");
		} else
			httpResult.setResultCenter("操作失败");
		return httpResult;
	}

	@RequestMapping(value = "/deleteByCommentId")
	@ResponseBody
	public HttpResult deleteByCommentId(String commodityId) {
		HttpResult httpResult = new HttpResult();
		if (commentService.deleteByCommentId(commodityId)) {
			httpResult.setResultCenter("删除成功");
		} else
			httpResult.setResultCenter("操作失败");
		return httpResult;
	}

	@RequestMapping(value = "/deleteByCommodityId")
	@ResponseBody
	public HttpResult deleteByCommodityId(String commodityId) {
		HttpResult httpResult = new HttpResult();
		if (commentService.deleteByCommodityId(commodityId)) {
			httpResult.setResultCenter("删除成功");
		} else
			httpResult.setResultCenter("操作失败");
		return httpResult;
	}

}
