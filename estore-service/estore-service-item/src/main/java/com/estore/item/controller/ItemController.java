package com.estore.item.controller;

import com.estore.common.model.Result;
import com.estore.item.pojo.ItemInfo;
import com.estore.item.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Janwes
 * @version 1.0
 * @package com.estore.item.controller
 * @date 2021/7/25 21:53
 * @description
 */
@Api(tags = "商品服务")
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @ApiOperation(value = "获取商品信息")
    @PostMapping("/getItem")
    public String getItem() {
        return "获取商品信息";
    }

    @ApiOperation(value = "获取商品信息")
    @PostMapping("/itemInfo")
    public Result<ItemInfo> findItemInfo(@RequestParam("itemId") String itemId) {
        String id = "sn20210727001";
        ItemInfo itemInfo = new ItemInfo();
        if (id.equals(itemId)) {
            itemInfo.setItemId(itemId);
            itemInfo.setItemName("百事可乐");
            itemInfo.setProductTime(new Date());
            itemInfo.setUsefulLife(15);
            itemInfo.setPrice(45.00);
        }
        return Result.ok(itemInfo);
    }
}
