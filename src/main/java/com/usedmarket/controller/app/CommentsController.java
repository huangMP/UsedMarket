package com.usedmarket.controller.app;

import com.usedmarket.controller.BaseController;
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
public class CommentsController extends BaseController{

	@Autowired
	CommentService commentService;

	@RequestMapping(value = "/searchByCommodityId")
	@ResponseBody
	public HttpResult searchCommentByCommodityId(String commodityId) {
		return this.getHttpResult("",this.commentService.findByCommodityId(commodityId));
	}

	@RequestMapping(value = "/insert")
	@ResponseBody
	public HttpResult insert(Comment comment) {
		comment.setCommentId(UuidUtil.get32UUID());
		comment.setCommentDate(new Date());
		return this.getFrequentlyUsedReturnResultByBool(commentService.insert(comment));
	}

	@RequestMapping(value = "/deleteByCommentId")
	@ResponseBody
	public HttpResult deleteByCommentId(String commodityId) {
		return this.getFrequentlyUsedReturnResultByBool(commentService.deleteByCommentId(commodityId));
	}

	@RequestMapping(value = "/deleteByCommodityId")
	@ResponseBody
	public HttpResult deleteByCommodityId(String commodityId) {
		return this.getFrequentlyUsedReturnResultByBool(commentService.deleteByCommodityId(commodityId));
	}

}
