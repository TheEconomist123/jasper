package com.zhouzz.controller;

import com.zhouzz.pojo.User;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
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
        params.put("dealDate", "2024年5月20日");
        params.put("dueDate", "2024年8月30日");
        params.put("transDiscBankName", "中国农业银行股份有限公司总行营业部门(非转汇行)");
        params.put("telName", "小明");
        params.put("telNo", "18326187759");
        params.put("dealDate", "2024年5月20日");
        params.put("number", "127419571059");
        params.put("handle", "高圆圆");
        params.put("review", "赵丽颖");
        params.put("rate", "0.34");
        params.put("billMoney", "4234512");
        params.put("signature1","郭德纲");
        params.put("signature2","黄晓明");
        params.put("signature3","诸葛孔明");
        params.put("busApproval","同意");
        params.put("headBusManger","同意");
        params.put("headBankOpinion","不同意");
        params.put("transDiscBankName", "中国农业银行股份有限公司总行营业部门(非转汇行)");
        params.put("desc","1977年6月10日出生于江西省南昌市，中国内地男主持人，毕业于南方冶金学院（现江西理工大学）计算机系1996级。2004年，担任长沙人...");
        params.put("tradeAndCredit", "一.伊朗政府内阁举行特别会议：伊朗第一副总统将承担总统权力和职能财联社5月20日电，伊朗政府内阁举行了特别会议，将会宣布伊朗总统莱希等遇难人员的葬礼安排。根据伊朗宪法规定，在总统去世的情况下，在最高领袖批准下，第一副总统将承担总统的权力和职能。伊朗伊斯兰议会议长等组成的委员会有义务在最多50天内安排选举新总统。\n" +
                "二.5月19日，健身界传来一则令人震惊的消息，知名健身网红刘畊宏因脚部严重受伤，不得不坐上轮椅，至少一个月无法进行跳操活动。这一变故不仅让刘畊宏两年半的健身生涯暂时中断，也让无数粉丝感到惋惜。\n" +
                "三.5月20日，中国乒乓球队球员马龙@captain龙 宣布退出WTT2024重庆冠军赛，林高远将通过世界排名递补参赛 据国际乒联5月14日公布的最新排名显示马龙男单排名世界第三，#马龙积分#4685 。位于王楚钦、樊振东之后。");
        JasperPrint jasperPrint = JasperFillManager.fillReport(cpr.getInputStream(), params, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        System.out.println("--------------------------------结束");
    }

    /**
     * 测试第一个 01_徽商银行票据交易（买入）审批表（总行）拓展信息
     * @return
     */

    @RequestMapping("/headBuyApprovalExp")
    public void headBuyApprovalExp(HttpServletResponse response) throws Exception {
        response.reset();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=headBuyApprovalExp" + System.currentTimeMillis() + ".pdf");
        ClassPathResource cpr = new ClassPathResource("templates/head_buy_approval_exp.jasper");
        System.out.println(cpr.getFilename());
        Map params = new HashMap();
        params.put("approvalDate", "2024-03-20");
        params.put("bankBill", "√");
        params.put("maiDuan", "√");
        params.put("paperBill", "√");
        params.put("dealDate", "2024年5月20日");
        params.put("dueDate", "2024年8月30日");
        params.put("transDiscBankName", "中国农业银行股份有限公司总行营业部门(非转汇行)");
        params.put("telName", "小明");
        params.put("telNo", "18326187759");
        params.put("dealDate", "2024年5月20日");
        params.put("number", "127419571059");
        params.put("handle", "高圆圆");
        params.put("review", "赵丽颖");
        params.put("rate", "0.34");
        params.put("billMoney", "5000000000元");
        params.put("signature1","郭德纲");
        params.put("signature2","黄晓明");
        params.put("signature3","诸葛孔明");
        params.put("busApproval","同意");
        params.put("headBusManger","同意");
        params.put("headBankOpinion","不同意");
        params.put("desc","让世界更好认识中国了解中国\n" +
                "习近平总书记的“文化足迹”遍及全国，指引我们从传承与发展中汲取文化自信的力量。");
        params.put("transDiscBankName", "中国农业银行股份有限公司总行营业部门(非转汇行)");
        params.put("tradeAndCredit","1.\t村此次的战败。毕竟就算是强如保持着忍界第一数十年名头的木叶，也依旧在第三次忍界大战中被四大忍村所击溃。 而此次的反雾隐联盟，其势力之强大更是远胜之前，根本就没有多少人觉着雾隐村有获胜的可能。特别是“半神”山椒鱼半藏的加入，更是给联盟平添了几分威势。 \n" +
                "2.\t作为仅凭一人之力，将雨忍村这个不入流的忍者村，抬高到可以与泷忍村竞争第六大忍者村的强人，山椒鱼半藏在忍界之中的声望如何不言而喻。 也因此，强者恒强，越来越多的秉持着各种目的的人涌入了联盟大军之中，期待着在对雾隐村的战争中咬下一块肥肉。 这些人在扩大了联盟声势的同时，也不可避免的让联盟的成份愈发复杂。\n" +
                "3.\t都不用想，雾隐村必然依靠这些人，在联盟之中掺了沙子。 大野木等人对此终究还是秉持着欢迎态度的，这些人最不济也可以起到消耗雾隐村物资的作用。 不过出于保密的缘由，一些高度机密的计划比如“斩首计划”等，肯定是不会告诉这些人的。 于是在初步的整训以及协调之后，于10月25日，反雾隐联盟正式宣布，对雾隐村发动战争。 纸面上的数据，反雾隐联盟拥有忍者约十万人，而雾隐村满打满算也只有两万人，近乎五比一的数据令在场所有没真正见识过鬼灯新月实力的人，对此充满了胜利的信心。\n" +
                "4.\t 面对着这空前声势的反雾隐联盟，雾隐村首先要做的就是将设在水之国外围的各大前进军事基地全部废除，人员全部收拢。 在第二次忍界大战结束之后，五大国都划分了彼此的势力范围，鬼灯新月当初利用环洋忍者联盟以及雾隐留学生等政策，将水之国周围各小国的忍者村吸收进了雾隐村的军事体系范畴之中。\n" +
                "5.\t日里这些散布在水之国周边的小忍村，都是雾隐村的军事前进基地，主要负责对在外的雾忍进行补给，以及关键时刻的战略支撑作用。 但是面对着这种庞大的军事攻势，这些散落在大陆沿海的前进基地根本体现不出任何作用。在这里布置人手除了白白给对方送人头之外，根本起不到任何作用。 所以鬼灯新月干脆将战线后撤，把包括涡之国在内的这些沿海领地全部拱手相让，集中精力将主战场设置海洋以及水之国本土上。 于是反雾隐联盟与雾隐村之间的第一场战争，就这么正式在海洋之上打响了。\n" +
                "6.\t ——哗啦！海浪声奔涌不息，并不会因为忍界的变故而发生任何改变。 原本日夜不息，船来船往的近海，这几日的客货船数量却是断崖式的下跌，甚至于一整夜间都看不到一艘商船在这近海之上航行。zzz\n");



        JasperPrint jasperPrint = JasperFillManager.fillReport(cpr.getInputStream(), params, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        System.out.println("--------------------------------结束");
    }

    /**
     * 测试第二个 02_徽商银行票据交易（卖出）审批表（总行）
     * @return
     */

    @RequestMapping("/headSaleApproval")
    public void headSaleApproval(HttpServletResponse response) throws Exception {
        response.reset();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=headSaleApproval" + System.currentTimeMillis() + ".pdf");
        ClassPathResource cpr = new ClassPathResource("templates/head_sale_approval.jasper");
        System.out.println(cpr.getFilename());
        Map params = new HashMap();
        params.put("approvalDate", "2024-03-20");
        params.put("bankBill", "√");
        params.put("saleDuan", "√");
        params.put("paperBill", "√");
        params.put("caisiBill", "√");
        params.put("elecBill", "√");
        params.put("zhiYaHuiGouSale", "√");
        params.put("maiDuanHuiGouSale", "√");
        params.put("dealDate", "2024年5月21日");
        params.put("dueDate", "2024年9月30日");
        params.put("transDiscBankName", "中国农业银行股份有限公司总行营业部门(非转汇行)");
        params.put("telName", "小明");
        params.put("telNo", "18326187759");
        params.put("dealDate", "2024年5月20日");
        params.put("number", "127419571059");
        params.put("handle", "高圆圆");
        params.put("review", "赵丽颖");
        params.put("rate", "0.34");
        params.put("billMoney", "5000000000元");
        params.put("billNos", "20");
        params.put("signature1","郭德纲");
        params.put("signature2","黄晓明");
        params.put("signature3","诸葛孔明");
        params.put("busApproval","同意");
        params.put("headBusManger","同意");
        params.put("headBankOpinion","不同意");
        params.put("desc","让世界更好认识中国了解中国\n" +
                "习近平总书记的“文化足迹”遍及全国，指引我们从传承与发展中汲取文化自信的力量。");
        params.put("transDiscBankName", "中国农业银行股份有限公司总行营业部门(非转汇行)");
        params.put("tradeAndCredit","1.\t村此次的战败。毕竟就算是强如保持着忍界第一数十年名头的木叶，也依旧在第三次忍界大战中被四大忍村所击溃。 而此次的反雾隐联盟，其势力之强大更是远胜之前，根本就没有多少人觉着雾隐村有获胜的可能。特别是“半神”山椒鱼半藏的加入，更是给联盟平添了几分威势。 \n" +
                "2.\t作为仅凭一人之力，将雨忍村这个不入流的忍者村，抬高到可以与泷忍村竞争第六大忍者村的强人，山椒鱼半藏在忍界之中的声望如何不言而喻。 也因此，强者恒强，越来越多的秉持着各种目的的人涌入了联盟大军之中，期待着在对雾隐村的战争中咬下一块肥肉。 这些人在扩大了联盟声势的同时，也不可避免的让联盟的成份愈发复杂。\n" +
                "3.\t都不用想，雾隐村必然依靠这些人，在联盟之中掺了沙子。 大野木等人对此终究还是秉持着欢迎态度的，这些人最不济也可以起到消耗雾隐村物资的作用。 不过出于保密的缘由，一些高度机密的计划比如“斩首计划”等，肯定是不会告诉这些人的。 于是在初步的整训以及协调之后，于10月25日，反雾隐联盟正式宣布，对雾隐村发动战争。 纸面上的数据，反雾隐联盟拥有忍者约十万人，而雾隐村满打满算也只有两万人，近乎五比一的数据令在场所有没真正见识过鬼灯新月实力的人，对此充满了胜利的信心。\n" +
                "4.\t 面对着这空前声势的反雾隐联盟，雾隐村首先要做的就是将设在水之国外围的各大前进军事基地全部废除，人员全部收拢。 在第二次忍界大战结束之后，五大国都划分了彼此的势力范围，鬼灯新月当初利用环洋忍者联盟以及雾隐留学生等政策，将水之国周围各小国的忍者村吸收进了雾隐村的军事体系范畴之中。\n" +
                "5.\t日里这些散布在水之国周边的小忍村，都是雾隐村的军事前进基地，主要负责对在外的雾忍进行补给，以及关键时刻的战略支撑作用。 但是面对着这种庞大的军事攻势，这些散落在大陆沿海的前进基地根本体现不出任何作用。在这里布置人手除了白白给对方送人头之外，根本起不到任何作用。 所以鬼灯新月干脆将战线后撤，把包括涡之国在内的这些沿海领地全部拱手相让，集中精力将主战场设置海洋以及水之国本土上。 于是反雾隐联盟与雾隐村之间的第一场战争，就这么正式在海洋之上打响了。\n" +
                "6.\t ——哗啦！海浪声奔涌不息，并不会因为忍界的变故而发生任何改变。 原本日夜不息，船来船往的近海，这几日的客货船数量却是断崖式的下跌，甚至于一整夜间都看不到一艘商船在这近海之上航行。zzz\n");



        JasperPrint jasperPrint = JasperFillManager.fillReport(cpr.getInputStream(), params, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        System.out.println("--------------------------------结束");
    }



    /**
     * 测试第二个 02_徽商银行票据交易（卖出）审批表（总行）拓展信息
     * @return
     */
    @RequestMapping("/headSaleApprovalExp")
    public void headSaleApprovalExp(HttpServletResponse response) throws Exception {
        response.reset();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=headSaleApprovalExp" + System.currentTimeMillis() + ".pdf");
        ClassPathResource cpr = new ClassPathResource("templates/head_sale_approval_exp.jasper");
        System.out.println(cpr.getFilename());
        Map params = new HashMap();
        params.put("approvalDate", "2024-03-20");
        params.put("bankBill", "√");
        params.put("saleDuan", "√");
        params.put("paperBill", "√");
        params.put("caisiBill", "√");
        params.put("elecBill", "√");
        params.put("zhiYaHuiGouSale", "√");
        params.put("maiDuanHuiGouSale", "√");
        params.put("dealDate", "2024年5月21日");
        params.put("dueDate", "2024年9月30日");
        params.put("transDiscBankName", "中国农业银行股份有限公司总行营业部门(非转汇行)");
        params.put("telName", "小明");
        params.put("telNo", "18326187759");
        params.put("dealDate", "2024年5月20日");
        params.put("number", "127419571059");
        params.put("handle", "高圆圆");
        params.put("review", "赵丽颖");
        params.put("rate", "0.34");
        params.put("billMoney", "5000000000元");
        params.put("billNos", "20");
        params.put("signature1","郭德纲");
        params.put("signature2","黄晓明");
        params.put("signature3","诸葛孔明");
        params.put("busApproval","同意");
        params.put("headBusManger","同意");
        params.put("headBankOpinion","不同意");
        params.put("desc","让世界更好认识中国了解中国\n" +
                "习近平总书记的“文化足迹”遍及全国，指引我们从传承与发展中汲取文化自信的力量。");
        params.put("transDiscBankName", "中国农业银行股份有限公司总行营业部门(非转汇行)");
        params.put("tradeAndCredit","1.\t村此次的战败。毕竟就算是强如保持着忍界第一数十年名头的木叶，也依旧在第三次忍界大战中被四大忍村所击溃。 而此次的反雾隐联盟，其势力之强大更是远胜之前，根本就没有多少人觉着雾隐村有获胜的可能。特别是“半神”山椒鱼半藏的加入，更是给联盟平添了几分威势。 \n" +
                "2.\t作为仅凭一人之力，将雨忍村这个不入流的忍者村，抬高到可以与泷忍村竞争第六大忍者村的强人，山椒鱼半藏在忍界之中的声望如何不言而喻。 也因此，强者恒强，越来越多的秉持着各种目的的人涌入了联盟大军之中，期待着在对雾隐村的战争中咬下一块肥肉。 这些人在扩大了联盟声势的同时，也不可避免的让联盟的成份愈发复杂。\n" +
                "3.\t都不用想，雾隐村必然依靠这些人，在联盟之中掺了沙子。 大野木等人对此终究还是秉持着欢迎态度的，这些人最不济也可以起到消耗雾隐村物资的作用。 不过出于保密的缘由，一些高度机密的计划比如“斩首计划”等，肯定是不会告诉这些人的。 于是在初步的整训以及协调之后，于10月25日，反雾隐联盟正式宣布，对雾隐村发动战争。 纸面上的数据，反雾隐联盟拥有忍者约十万人，而雾隐村满打满算也只有两万人，近乎五比一的数据令在场所有没真正见识过鬼灯新月实力的人，对此充满了胜利的信心。\n" +
                "4.\t 面对着这空前声势的反雾隐联盟，雾隐村首先要做的就是将设在水之国外围的各大前进军事基地全部废除，人员全部收拢。 在第二次忍界大战结束之后，五大国都划分了彼此的势力范围，鬼灯新月当初利用环洋忍者联盟以及雾隐留学生等政策，将水之国周围各小国的忍者村吸收进了雾隐村的军事体系范畴之中。\n" +
                "5.\t日里这些散布在水之国周边的小忍村，都是雾隐村的军事前进基地，主要负责对在外的雾忍进行补给，以及关键时刻的战略支撑作用。 但是面对着这种庞大的军事攻势，这些散落在大陆沿海的前进基地根本体现不出任何作用。在这里布置人手除了白白给对方送人头之外，根本起不到任何作用。 所以鬼灯新月干脆将战线后撤，把包括涡之国在内的这些沿海领地全部拱手相让，集中精力将主战场设置海洋以及水之国本土上。 于是反雾隐联盟与雾隐村之间的第一场战争，就这么正式在海洋之上打响了。\n" +
                "6.\t ——哗啦！海浪声奔涌不息，并不会因为忍界的变故而发生任何改变。 原本日夜不息，船来船往的近海，这几日的客货船数量却是断崖式的下跌，甚至于一整夜间都看不到一艘商船在这近海之上航行。zzz\n");



        JasperPrint jasperPrint = JasperFillManager.fillReport(cpr.getInputStream(), params, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        System.out.println("--------------------------------结束");
    }



    /**
     * 测试第三个 03_徽商银行票据交易审批表（分行）
     * @return
     */
    @RequestMapping("/branchApproval")
    public void branchApproval(HttpServletResponse response) throws Exception {
        response.reset();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=branchApproval" + System.currentTimeMillis() + ".pdf");
        ClassPathResource cpr = new ClassPathResource("templates/branch_approval.jasper");
        System.out.println(cpr.getFilename());
        Map params = new HashMap();
        params.put("approvalDate", "2024-03-20");
        params.put("bankBill", "√");
        params.put("saleDuan", "√");
        params.put("paperBill", "√");
        params.put("caisiBill", "√");
        params.put("elecBill", "√");
        params.put("shangBill", "√");
        params.put("buyDuan", "√");
        params.put("dealDate", "2024年5月21日");
        params.put("dueDate", "2024年9月30日");
        params.put("transDiscBankName", "中国农业银行股份有限公司总行营业部门(非转汇行)");
        params.put("telName", "小明");
        params.put("telNo", "18326187759");
        params.put("dealDate", "2024年5月20日");
        params.put("rate", "0.34");
        params.put("billMoney", "5000000000元");
        params.put("billNos", "20");
        params.put("number", "30123121244214410");
        params.put("number", "30123121244214419");
        params.put("signature1","郭德纲");
        params.put("signature2","黄晓明");
        params.put("signature3","诸葛孔明");
        params.put("signature4","刘亦菲");
        params.put("busReApproval","同意！！！！！");
        params.put("departHead","同意！！！！");
        params.put("branchBankOpinion","不同意！！！！！");
        params.put("desc","让世界更好认识中国了解中国\n" +
                "习近平总书记的“文化足迹”遍及全国，指引我们从传承与发展中汲取文化自信的力量。");
        params.put("transDiscBankName", "中国农业银行股份有限公司总行营业部门(非转汇行)");
        params.put("tradeAndCredit","1.\t村此次的战败。毕竟就算是强如保持着忍界第一数十年名头的木叶，也依旧在第三次忍界大战中被四大忍村所击溃。 而此次的反雾隐联盟，其势力之强大更是远胜之前，根本就没有多少人觉着雾隐村有获胜的可能。特别是“半神”山椒鱼半藏的加入，更是给联盟平添了几分威势。 \n" +
                "2.\t作为仅凭一人之力，将雨忍村这个不入流的忍者村，抬高到可以与泷忍村竞争第六大忍者村的强人，山椒鱼半藏在忍界之中的声望如何不言而喻。 也因此，强者恒强，越来越多的秉持着各种目的的人涌入了联盟大军之中，期待着在对雾隐村的战争中咬下一块肥肉。 这些人在扩大了联盟声势的同时，也不可避免的让联盟的成份愈发复杂。\n" +
                "3.\t都不用想，雾隐村必然依靠这些人，在联盟之中掺了沙子。 大野木等人对此终究还是秉持着欢迎态度的，这些人最不济也可以起到消耗雾隐村物资的作用。 不过出于保密的缘由，一些高度机密的计划比如“斩首计划”等，肯定是不会告诉这些人的。 于是在初步的整训以及协调之后，于10月25日，反雾隐联盟正式宣布，对雾隐村发动战争。 纸面上的数据，反雾隐联盟拥有忍者约十万人，而雾隐村满打满算也只有两万人，近乎五比一的数据令在场所有没真正见识过鬼灯新月实力的人，对此充满了胜利的信心。\n" +
                "4.\t 面对着这空前声势的反雾隐联盟，雾隐村首先要做的就是将设在水之国外围的各大前进军事基地全部废除，人员全部收拢。 在第二次忍界大战结束之后，五大国都划分了彼此的势力范围，鬼灯新月当初利用环洋忍者联盟以及雾隐留学生等政策，将水之国周围各小国的忍者村吸收进了雾隐村的军事体系范畴之中。\n" +
                "5.\t日里这些散布在水之国周边的小忍村，都是雾隐村的军事前进基地，主要负责对在外的雾忍进行补给，以及关键时刻的战略支撑作用。 但是面对着这种庞大的军事攻势，这些散落在大陆沿海的前进基地根本体现不出任何作用。在这里布置人手除了白白给对方送人头之外，根本起不到任何作用。 所以鬼灯新月干脆将战线后撤，把包括涡之国在内的这些沿海领地全部拱手相让，集中精力将主战场设置海洋以及水之国本土上。 于是反雾隐联盟与雾隐村之间的第一场战争，就这么正式在海洋之上打响了。\n" +
                "6.\t ——哗啦！海浪声奔涌不息，并不会因为忍界的变故而发生任何改变。 原本日夜不息，船来船往的近海，这几日的客货船数量却是断崖式的下跌，甚至于一整夜间都看不到一艘商船在这近海之上航行。zzz\n");



        JasperPrint jasperPrint = JasperFillManager.fillReport(cpr.getInputStream(), params, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        System.out.println("--------------------------------结束");
    }


    /**
     * 测试第三个 03_徽商银行票据交易审批表（分行）拓展信息
     * @return
     */
    @RequestMapping("/branchApprovalExp")
    public void branchApprovalExp(HttpServletResponse response) throws Exception {
        response.reset();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=branchApprovalExp" + System.currentTimeMillis() + ".pdf");
        ClassPathResource cpr = new ClassPathResource("templates/branch_approval_exp.jasper");
        System.out.println(cpr.getFilename());
        Map params = new HashMap();
        params.put("approvalDate", "2024-03-20");
        params.put("bankBill", "√");
        params.put("saleDuan", "√");
        params.put("paperBill", "√");
        params.put("caisiBill", "√");
        params.put("elecBill", "√");
        params.put("shangBill", "√");
        params.put("buyDuan", "√");
        params.put("dealDate", "2024年5月21日");
        params.put("dueDate", "2024年9月30日");
        params.put("transDiscBankName", "中国农业银行股份有限公司总行营业部门(非转汇行)");
        params.put("telName", "小明");
        params.put("telNo", "18326187759");
        params.put("dealDate", "2024年5月20日");
        params.put("rate", "0.34");
        params.put("billMoney", "5000000000元");
        params.put("billNos", "20");
        params.put("number", "30123121244214410");
        params.put("number", "30123121244214419");
        params.put("signature1","郭德纲");
        params.put("signature2","黄晓明");
        params.put("signature3","诸葛孔明");
        params.put("signature4","刘亦菲");
        params.put("busReApproval","同意！！！！！");
        params.put("departHead","同意！！！！");
        params.put("branchBankOpinion","不同意！！！！！");
        params.put("desc","让世界更好认识中国了解中国\n" +
                "习近平总书记的“文化足迹”遍及全国，指引我们从传承与发展中汲取文化自信的力量。");
        params.put("transDiscBankName", "中国农业银行股份有限公司总行营业部门(非转汇行)");
        params.put("tradeAndCredit","1.\t村此次的战败。毕竟就算是强如保持着忍界第一数十年名头的木叶，也依旧在第三次忍界大战中被四大忍村所击溃。 而此次的反雾隐联盟，其势力之强大更是远胜之前，根本就没有多少人觉着雾隐村有获胜的可能。特别是“半神”山椒鱼半藏的加入，更是给联盟平添了几分威势。 \n" +
                "2.\t作为仅凭一人之力，将雨忍村这个不入流的忍者村，抬高到可以与泷忍村竞争第六大忍者村的强人，山椒鱼半藏在忍界之中的声望如何不言而喻。 也因此，强者恒强，越来越多的秉持着各种目的的人涌入了联盟大军之中，期待着在对雾隐村的战争中咬下一块肥肉。 这些人在扩大了联盟声势的同时，也不可避免的让联盟的成份愈发复杂。\n" +
                "3.\t都不用想，雾隐村必然依靠这些人，在联盟之中掺了沙子。 大野木等人对此终究还是秉持着欢迎态度的，这些人最不济也可以起到消耗雾隐村物资的作用。 不过出于保密的缘由，一些高度机密的计划比如“斩首计划”等，肯定是不会告诉这些人的。 于是在初步的整训以及协调之后，于10月25日，反雾隐联盟正式宣布，对雾隐村发动战争。 纸面上的数据，反雾隐联盟拥有忍者约十万人，而雾隐村满打满算也只有两万人，近乎五比一的数据令在场所有没真正见识过鬼灯新月实力的人，对此充满了胜利的信心。\n" +
                "4.\t 面对着这空前声势的反雾隐联盟，雾隐村首先要做的就是将设在水之国外围的各大前进军事基地全部废除，人员全部收拢。 在第二次忍界大战结束之后，五大国都划分了彼此的势力范围，鬼灯新月当初利用环洋忍者联盟以及雾隐留学生等政策，将水之国周围各小国的忍者村吸收进了雾隐村的军事体系范畴之中。\n" +
                "5.\t日里这些散布在水之国周边的小忍村，都是雾隐村的军事前进基地，主要负责对在外的雾忍进行补给，以及关键时刻的战略支撑作用。 但是面对着这种庞大的军事攻势，这些散落在大陆沿海的前进基地根本体现不出任何作用。在这里布置人手除了白白给对方送人头之外，根本起不到任何作用。 所以鬼灯新月干脆将战线后撤，把包括涡之国在内的这些沿海领地全部拱手相让，集中精力将主战场设置海洋以及水之国本土上。 于是反雾隐联盟与雾隐村之间的第一场战争，就这么正式在海洋之上打响了。\n" +
                "6.\t ——哗啦！海浪声奔涌不息，并不会因为忍界的变故而发生任何改变。 原本日夜不息，船来船往的近海，这几日的客货船数量却是断崖式的下跌，甚至于一整夜间都看不到一艘商船在这近海之上航行。zzz\n");

        JasperPrint jasperPrint = JasperFillManager.fillReport(cpr.getInputStream(), params, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        System.out.println("--------------------------------结束");
    }

    /**
     * 04测试第四个徽商银行票据账务通知书（出账）总行
     *
     */
    @RequestMapping("/headChargeOffInform")
    public void headChargeOffInform(HttpServletResponse response) throws Exception {
        response.reset();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=headChargeOffInform" + System.currentTimeMillis() + ".pdf");
        ClassPathResource cpr = new ClassPathResource("templates/head_charge_off_inform.jasper");
        System.out.println(cpr.getFilename());
        Map params = new HashMap();
        params.put("headChargeOffInform", "√");
        params.put("transDiscBankName", "中国农业银行股份有限公司总行营业部门(非转汇行)");
        params.put("dealDate", "2023-04-05");
        params.put("buyBackDate", "2023-04-05");
        params.put("bankBill", "√");
        params.put("paperBill", "√");
        params.put("elecBill", "√");
        params.put("caisiBill", "√");
        params.put("shangBill", "√");
        params.put("dvp", "√");
        params.put("fop", "√");
        params.put("buyDuan", "√");
        params.put("saleDuan", "√");
        params.put("zhiYaHuiGouBuy", "√");
        params.put("zhiYaHuiGouSale", "√");
        params.put("maiDuanHuiGouBuy", "√");
        params.put("maiDuanHuiGouSale", "√");
        params.put("zaiDiscZhiYaHuiGou", "√");
        params.put("billMoney", "80000000");
        params.put("interest", "200000");
        params.put("actPayOrReceAmount", "1000000");
        params.put("handle", "刘雯雯");
        params.put("review", "李克勤");
        params.put("departHead", "溜达脑袋");
        params.put("headRiskMiddleAudit", "√");
        params.put("billNos", "20");

        JasperPrint jasperPrint = JasperFillManager.fillReport(cpr.getInputStream(), params, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        System.out.println("--------------------------------结束");
    }

    /**
     * 04测试第四个徽商银行票据账务通知书（出账）分行
     *
     */
    @RequestMapping("/branchChargeOffInform")
    public void branchChargeOffInform(HttpServletResponse response) throws Exception {
        response.reset();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=branchChargeOffInform" + System.currentTimeMillis() + "李四.pdf");
        ClassPathResource cpr = new ClassPathResource("templates/branch_charge_off_inform.jasper");
        System.out.println(cpr.getFilename());
        Map params = new HashMap();
        params.put("headChargeOffInform", "√");
        params.put("transDiscBankName", "中国农业银行股份有限公司总行营业部门(非转汇行)");
        params.put("dealDate", "2023-04-05");
        params.put("buyBackDate", "2023-04-05");
        params.put("bankBill", "√");
        params.put("paperBill", "√");
        params.put("elecBill", "√");
        params.put("caisiBill", "√");
        params.put("shangBill", "√");
        params.put("dvp", "√");
        params.put("fop", "√");
        params.put("buyDuan", "√");
        params.put("saleDuan", "√");
        params.put("zaiDiscZhiYaHuiGou", "√");
        params.put("billMoney", "80000000");
        params.put("interest", "200000");
        params.put("actPayOrReceAmount", "1000000");
        params.put("handle", "刘雯雯");
        params.put("review", "李克勤");
        params.put("departHead", "溜达脑袋");
        params.put("billNos", "20");

        JasperPrint jasperPrint = JasperFillManager.fillReport(cpr.getInputStream(), params, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        System.out.println("--------------------------------结束");
    }



    @RequestMapping("/mdshg")
    public void mdshg(HttpServletResponse response) throws Exception {
        response.reset();
        response.setContentType("application/vnd.ms-excel");

       /*
        response.setHeader("Content-disposition", "attachment;filename=mdshg" + System.currentTimeMillis() + "小明.pdf");*/

        String filename = "mdshg" + System.currentTimeMillis() + "不管多波折，多磨难.pdf";
        String encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment; filename*=UTF-8''" + encodedFilename);


        ClassPathResource cpr = new ClassPathResource("templates/sale_slip/mdshg.jasper");
        System.out.println(cpr.getFilename());
        Map params = new HashMap();
        params.put("headChargeOffInform", "√");
        params.put("transDiscBankName", "中国农业银行股份有限公司总行营业部门(非转汇行)");
        params.put("dealDate", "2023-04-05");
        params.put("buyBackDate", "2023-04-05");
        params.put("bankBill", "√");
        params.put("paperBill", "√");
        params.put("elecBill", "√");
        params.put("caisiBill", "√");
        params.put("shangBill", "√");
        params.put("dvp", "√");
        params.put("fop", "√");
        params.put("buyDuan", "√");
        params.put("saleDuan", "√");
        params.put("zaiDiscZhiYaHuiGou", "√");
        params.put("billMoney", "80000000");
        params.put("interest", "200000");
        params.put("actPayOrReceAmount", "1000000");
        params.put("handle", "刘雯雯");
        params.put("review", "李克勤");
        params.put("departHead", "溜达脑袋");
        params.put("billNos", "20");

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
