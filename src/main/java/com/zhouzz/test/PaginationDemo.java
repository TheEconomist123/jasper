package com.zhouzz.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/6/5 周三
 * @time 20:42
 * @desc
 */
public class PaginationDemo {
    public static void main(String[] args) {

        // 创建一个示例列表
        List<String> exampleList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            exampleList.add("Item " + i);
        }

        int page = 2;
        int pageSize = 10;
        List<String> paginatedList = paginate(exampleList, page, pageSize);

        // 打印分页结果
        paginatedList.forEach(System.out::println);
    }

    // 方法用于分页查询
    public static <T> List<T> paginate(List<T> sourceList, int page, int pageSize) {
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
