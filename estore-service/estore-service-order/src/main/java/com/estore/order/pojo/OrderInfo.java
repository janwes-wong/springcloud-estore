package com.estore.order.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author Janwes
 * @version 1.0
 * @package com.janwes.order.domain
 * @date 2021/3/11 17:42
 * @description 订单信息类
 */
@Data
@ApiModel(value = "订单信息")
public class OrderInfo {

    @ApiModelProperty(value = "用户名", required = true, example = "张三")
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "订单id", required = true, example = "SM005")
    @TableField("orderId")
    private String orderId;

    @ApiModelProperty(value = "商品id", required = true, example = "xxxx005")
    @TableField("itemId")
    private String itemId;

    @ApiModelProperty(value = "商品名称", required = true, example = "雀巢咖啡")
    @TableField("itemName")
    private String itemName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8", locale = "zh")
    @TableField("created_time")
    private Date createdTime;
}
