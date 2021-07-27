package com.estore.order.controller;

import com.estore.common.model.Result;
import com.estore.order.feign.ItemInfoFeign;
import com.estore.order.pojo.ItemInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Janwes
 * @version 1.0
 * @package com.estore.order.controller
 * @date 2021/7/27 15:07
 * @description
 */
@Api(tags = "订单服务")
@RestController
@RequestMapping("/order")
public class OrderInfoController {

    @Autowired
    private ItemInfoFeign itemInfoFeign;

    @ApiOperation(value = "获取商品信息")
    @PostMapping("/orderInfo")
    public Result<ItemInfo> getMessage() {
        String itemId = "sn20210727001";
        // 服务远程调用
        return itemInfoFeign.findItemInfo(itemId);
    }
}