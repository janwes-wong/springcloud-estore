package com.estore.item.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.estore.common.utils.Long2StringSerialize;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author Janwes
 * @version 1.0
 * @package com.estore.item.pojo
 * @date 2021/7/25 22:09
 * @description
 */
@Data
@TableName("item_info")
@ApiModel(value = "商品信息")
public class ItemInfo {

    @ApiModelProperty(value = "主键id")
    @JsonSerialize(using = Long2StringSerialize.class) //
//    @JsonDeserialize // jackson技术：将json反序列化为对象
//    @JSONField(serializeUsing = ToStringSerializer.class) // alibaba的fastjson
    @TableId("id")
    private Long id;

    @TableField("itemId")
    @ApiModelProperty(value = "商品id", example = "EX202100025")
    private String itemId;

    @ApiModelProperty(value = "商品名称", example = "伊利牛奶")
    @TableField("item_name")
    private String itemName;

    @ApiModelProperty(value = "价格", example = "45")
    @TableField("price")
    private Double price;


    @ApiModelProperty(value = "生产日期", example = "2021-05-05 20:00:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8", locale = "zh") // 设置查询数据库时间字段时，根据自定义的格式进行展示
    private Date productTime;

    @ApiModelProperty(value = "有效期", example = "12个月")
    @TableField("useful_life")
    private int usefulLife;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8", locale = "zh")
    @TableField("created_time")
    private Date createdTime;
}