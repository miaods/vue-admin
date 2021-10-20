package com.liu.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author liumiao
 * @create 2021-10-16-9:44
 */

@Data
@TableName("bms_promotion")
@Accessors(chain = true)
public class BmsPromotion implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 广告标题
     */
    @TableField("title")
    private String title;

    /**
     * 广告链接
     */
    @TableField("link")
    private String link;

    /**
     * 说明
     */
    @TableField("`description`")
    private String description;

    public BmsPromotion() {
    }

}
