package com.liu;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liu.mapper.BmsBillboardMapper;
import com.liu.mapper.BmsTopicMapper;
import com.liu.model.entity.BmsBillboard;
import com.liu.model.entity.BmsPost;
import com.liu.model.vo.PostVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class LiuApplicationTests {

    @Resource
    BmsBillboardMapper bmsBillboardMapper;

    @Resource
    BmsTopicMapper bmsTopicMapper;


    @Test
    void contextLoads() {
        BmsBillboard billboard = BmsBillboard.builder()
                .content("系统可更新之新版本")
                .show(true)
                .build();

        System.out.println(billboard);
        int insert = bmsBillboardMapper.insert(billboard);
        System.out.println(insert);
    }

    @Test
    void select(){
        QueryWrapper<BmsBillboard> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("show","false");

        LambdaQueryWrapper<BmsBillboard> eq = new LambdaQueryWrapper<BmsBillboard>().eq(BmsBillboard::isShow, false).last("limit 1");

        List<BmsBillboard> bmsBillboards = bmsBillboardMapper.selectList(eq);
        System.out.println(bmsBillboards);


    }

    @Test
    void SelectList(){
        PostVO postVO = new PostVO();

        Page<PostVO> liu = bmsTopicMapper.selectListAndPage(new Page<>(1, 10), "1");
        System.out.println(liu);

    }

    @Test
    void SelectPost(){
        LambdaUpdateWrapper<BmsPost> miao = new LambdaUpdateWrapper<BmsPost>().eq(BmsPost::getTitle, "淼淼");

        BmsPost bmsPost = bmsTopicMapper.selectOne(miao);
        Assert.notNull(bmsPost,"报错了");
        System.out.println(bmsPost);
    }
    @Test
    void SelectPost1() {
        LambdaUpdateWrapper<BmsPost> miao = new LambdaUpdateWrapper<BmsPost>().eq(BmsPost::getTitle, "淼淼");

        QueryWrapper<BmsPost> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(BmsPost::getId, 1332682473151635458L);

        //BmsPost bmsPost = bmsTopicMapper.selectById(1332682473151635458L);
        ArrayList<BmsPost> list = new ArrayList<>();

    }
}
