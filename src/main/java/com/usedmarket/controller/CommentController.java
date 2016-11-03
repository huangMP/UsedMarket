package com.usedmarket.controller;

import com.usedmarket.dto.CommentCustom;
import com.usedmarket.entity.Comment;
import com.usedmarket.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Description：enter your comment
 * Created by Peivxuan on 2016/11/3.
 */

@Controller
@RequestMapping("/Comment")
public class CommentController {

	@Autowired
	CommentService commentService;

	@RequestMapping(value = "/searchByCommodityId")
	@ResponseBody
	public List<CommentCustom> searchCommentByCommodityId(String commodityId) {
		return commentService.findByCommodityId(commodityId);
	}

	@RequestMapping(value = "/deleteByCommentId")
	@ResponseBody
	public int insert(Comment comment) {
		return commentService.insert(comment);
	}

	@RequestMapping(value = "/deleteByCommentId")
	@ResponseBody
	public String deleteByCommentId(String commodityId) {
		if (commentService.deleteByCommentId(commodityId)) {
			return "删除成功";
		}
		return "操作失败";
	}

	@RequestMapping(value = "/deleteByCommodityId")
	@ResponseBody
	public String deleteByCommodityId(String commodityId) {
		if (commentService.deleteByCommodityId(commodityId)) {
			return "删除成功";
		}
		return "操作失败";
	}

}
