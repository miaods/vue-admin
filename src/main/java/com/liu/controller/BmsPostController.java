package com.liu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liu.common.api.ApiResult;
import com.liu.model.dto.CreateTopicDTO;
import com.liu.model.entity.BmsPost;
import com.liu.model.entity.UmsUser;
import com.liu.model.vo.PostVO;
import com.liu.service.IBmsPostService;
import com.liu.service.IUmsUserService;
import com.vdurmont.emoji.EmojiParser;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.liu.jwt.JwtUtil.USER_NAME;

/**
 * @author liumiao
 * @create 2021-10-16-16:53
 */
@RestController
@RequestMapping("/post")
public class BmsPostController extends BaseController {

    @Resource
    private IBmsPostService iBmsPostService;
    @Resource
    private IUmsUserService umsUserService;

    /*获取列表*/
    @GetMapping("/list")
    public ApiResult<Page<PostVO>> list(@RequestParam(value = "tab", defaultValue = "latest") String tab,
                                        @RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
                                        @RequestParam(value = "size", defaultValue = "10") Integer pageSize){

        Page<PostVO> list = iBmsPostService.getList(new Page<>(pageNo, pageSize), tab);
        System.out.println(list);
        return ApiResult.success(list);
    }

    /*添加列表*/
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ApiResult<BmsPost> create(@RequestHeader(value = USER_NAME) String userName
                                         ,@RequestBody CreateTopicDTO dto){
        UmsUser user = umsUserService.getUserByUsername(userName);
        BmsPost topic = iBmsPostService.create(dto, user);
        return ApiResult.success(topic);
    }

    /*查看单列表*/
    @GetMapping()
    public ApiResult<Map<String,Object>> view(@RequestParam("id") String id){
        Map<String, Object> map = iBmsPostService.viewTopic(id);
        return ApiResult.success(map);
    }

    /*获取id*/
    @GetMapping("/recommend")
    public ApiResult<List<BmsPost>> getRecommend(@RequestParam("topicId") String id) {
        List<BmsPost> topics = iBmsPostService.getRecommend(id);
        System.out.println(topics);
        return ApiResult.success(topics);
    }

    /*更新列表*/
    @PostMapping("/update")
    public ApiResult<BmsPost> update(@RequestHeader(value = USER_NAME) String userName
                                                   ,@Valid @RequestBody BmsPost post){
        UmsUser umsUser = umsUserService.getUserByUsername(userName);
        Assert.isTrue(umsUser.getId().equals(post.getUserId()),"非本人无权修改");
        post.setModifyTime(new Date());
        post.setContent(EmojiParser.parseToAliases(post.getContent()));
        iBmsPostService.updateById(post);
        return ApiResult.success(post);
    }

    /*删除列表*/
    @DeleteMapping("/delete/{id}")
    public ApiResult<String> delete(@RequestHeader(value = USER_NAME) String userName
                                                       ,@PathVariable("id") String id){
        UmsUser umsUser = umsUserService.getUserByUsername(userName);
        BmsPost byId = iBmsPostService.getById(id);
        Assert.notNull(byId,"来晚一步，话题已不存在");
        Assert.isTrue(byId.getUserId().equals(umsUser.getId()),"你为什么可以删除别人的话题？？？");
        iBmsPostService.removeById(id);
        return ApiResult.success(null,"删除成功");
    }
}
