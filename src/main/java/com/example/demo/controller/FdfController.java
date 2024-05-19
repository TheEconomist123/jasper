package com.example.demo.controller;

import com.example.demo.pojo.User;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/5/14 周二
 * @time 15:50
 * @desc
 */
@RestController
@RequestMapping("/pdf")
public class FdfController {


    @RequestMapping("/downloadpdf")
    public void downloadpdf(HttpServletResponse response) throws Exception {
        System.out.println("请求过来了。。。。。。。。。。。");
        response.reset();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=One" + System.currentTimeMillis() + ".pdf");
        ClassPathResource cpr = new ClassPathResource("templates/test02.jasper");
        System.out.println(cpr.getFilename());
        Map params = new HashMap();
        params.put("userName", "周政之√");
        params.put("tick", "√");
        JasperPrint jasperPrint = JasperFillManager.fillReport(cpr.getInputStream(), params, new JREmptyDataSource());
        // JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        // JasperExportManager.exportReportToPdfFile(jasperPrint, "f://report.pdf");
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        System.out.println("--------------------------------结束");
    }

    @RequestMapping("/downloadPdfConn")
    public void downloadPdfConn(HttpServletResponse response) throws IOException {
        response.reset();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=testConn" + System.currentTimeMillis() + ".pdf");
        ClassPathResource cpr = new ClassPathResource("templates/testConn.jasper");
        ServletOutputStream os = response.getOutputStream();
        try {
            Map params = new HashMap();
            params.put("uid","3");
            Connection connection = getConnection();
            JasperPrint jasperPrint = JasperFillManager.fillReport(cpr.getInputStream(), params, connection);
            JasperExportManager.exportReportToPdfStream(jasperPrint, os);
        } catch (JRException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            os.flush();
        }
    }



    @RequestMapping("/downloadPdfJavaBean")
    public void downloadPdfJavaBean(HttpServletResponse response) throws Exception {
        long start = System.currentTimeMillis();
        response.reset();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=JavaBean" + System.currentTimeMillis() + ".pdf");
        ClassPathResource cpr = new ClassPathResource("templates/testJavaBean.jasper");
        System.out.println(cpr.getFilename());
        Map params = new HashMap();
        JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(getList());
        JasperPrint jasperPrint = JasperFillManager.fillReport(cpr.getInputStream(), params, jrBeanCollectionDataSource);
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start)/1000+"秒");

    }

    /**
     * 测试第一个 01_徽商银行票据交易（买入）审批表（总行）
     * @return
     */

    @RequestMapping("/headBuyApproval")
    public void headBuyApproval(HttpServletResponse response) throws Exception {
        response.reset();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=headBuyApproval" + System.currentTimeMillis() + ".pdf");
        ClassPathResource cpr = new ClassPathResource("templates/head_buy_approval.jasper");
        System.out.println(cpr.getFilename());
        Map params = new HashMap();
        params.put("approvalDate", "2024-03-20");
        params.put("bankBill", "√");
        params.put("maiDuan", "√");
        params.put("paperBill", "√");
        params.put("number", "127419571059");
        params.put("tradeAndCredit", "视频提供了功能强大的方法帮助您证明您的观点。当您单击联机视频时，可以在想要添加的视频的嵌入代码中进行粘贴。您也可以键入一个关键字以联机搜索最适合您的文档的视频。\n" +
                "为使您的文档具有专业外观，Word 提供了页眉、页脚、封面和文本框设计，这些设计可互为补充。例如，您可以添加匹配的封面、页眉和提要栏。单击“插入”，然后从不同库中选择所需元素。\n" +
                "主题和样式也有助于文档保持协调。当您单击设计并选择新的主题时，图片、图表或 SmartArt 图形将会更改以匹配新的主题。当应用样式时，您的标题会进行更改以匹配新的主题。\n" +
                "使用在需要位置出现的新按钮在 Word 中保存时间。若要更改图片适应文档的方式，请单击该图片，图片旁边将会显示布局选项按钮。当处理表格时，单击要添加行或列的位置，然后单击加号。\n" +
                "在新的阅读视图中阅读更加容易。可以折叠文档某些部分并关注所需文本。如果在达到结尾处之前需要停止读取，Word 会记住您的停止位置 - 即使在另一个设备上。\n");
        JasperPrint jasperPrint = JasperFillManager.fillReport(cpr.getInputStream(), params, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        System.out.println("--------------------------------结束");
    }

     public List<User> getList(){
         List<User> list = new ArrayList<>();
         for (int i = 1; i <=1000000; i++) {
             User user = new User(i, "用户" + i, 20 + i, "描述" + i);
             list.add(user);
         }
         return  list;

     }

    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/zzz", "root", "root");
        return connection;
    }

}
