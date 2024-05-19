package com.example.demo.test;

import com.lowagie.text.pdf.PdfWriter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/5/11 周六
 * @time 9:14
 * @desc
 */
public class Test {
    public static void main(String[] args) {
   /*     File file = new File("D:\\0408-01");

        File[] files = file.listFiles();

        for (File file1 : files) {
            System.out.println(file1.getName());
        }
*/
        //合并多个文件夹内容
        String folderPath1 = "E:\\各种表格文档\\";
        String folderPath2 = "E:\\ccc\\";
        File[] files1 = new File(folderPath1).listFiles();
        File[] files2 = new File(folderPath2).listFiles();
        File[] mergedFiles = mergeFileArrays(files1, files2);
        for (File mergedFile : mergedFiles) {
            if (mergedFile.isDirectory()){
                System.out.println("文件夹:"+mergedFile.getName());
            }else{
                System.out.println("文件:"+mergedFile.getName());
            }

        }
    }

    // 合并两个 File 数组为一个
    public static File[] mergeFileArrays(File[] files1, File[] files2) {
        int length1 = files1.length;
        int length2 = files2.length;

        // 使用 Arrays.copyOf() 方法合并两个数组
        File[] mergedFiles = Arrays.copyOf(files1, length1 + length2);

        // 将第二个数组的元素复制到合并后的数组中
        System.arraycopy(files2, 0, mergedFiles, length1, length2);

        return mergedFiles;
    }


}
