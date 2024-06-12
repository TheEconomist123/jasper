package com.zhouzz.controller;

import com.zhouzz.pojo.CommonResp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/6/5 周三
 * @time 20:44
 * @desc
 */

@RestController
@RequestMapping("/page")
public class PaginationController {


    @RequestMapping("/getData")
    public CommonResp getData(@RequestParam int page,@RequestParam int  pageSize){
        CommonResp commonResp = new CommonResp();
        // 创建一个示例列表
        List<String> exampleList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            exampleList.add("Item " + i);
        }
        // 示例：获取第2页，每页10条数据

        List<String> paginatedList = paginate(exampleList, page, pageSize);

        commonResp.setRetMsg("成功");
        commonResp.setRetCode("000000");
        commonResp.setRetData(paginatedList);

        return  commonResp;
    }

    // 方法用于分页查询
    public  <T> List<T> paginate(List<T> sourceList, int page, int pageSize) {
        // 验证页码和页面大小是否有效
        if (page < 1 || pageSize < 1) {
            throw new IllegalArgumentException("页码和页面大小必须大于0");
        }

        // 计算起始和结束索引
        int fromIndex = (page - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, sourceList.size());

        // 验证起始索引是否超出列表范围
        if (fromIndex >= sourceList.size()) {
            return new ArrayList<>(); // 返回空列表
        }

        // 返回分页数据
        return sourceList.subList(fromIndex, toIndex);
    }

}
