package com.tiedate.csmiswh.business.SaTcapacitor.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tiedate.csmis.common.constant.SystemConstants;
import com.tiedate.csmis.common.util.DateUtil;
import com.tiedate.csmis.system.login.User;
import com.tiedate.csmiswh.business.SaTcapacitor.data.SaTcapacitor;
import com.tiedate.csmiswh.business.SaTcapacitor.data.SearchData;
import com.tiedate.csmiswh.business.SaTcapacitor.service.SaTcapacitorService;
import com.tiedate.csmiswh.business.utils.excel.ExcelUtil;
import com.tiedate.csmiswh.business.utils.excel.ExportExcel;
import net.sf.json.JSONArray;
import org.apache.poi.hssf.record.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * sa_t_capacitor ??????
 * Tue Mar 22 21:12:32 CST 2016 eaglezhy
 */
@RestController
@RequestMapping(value = "/capacitor")
public class SaTcapacitorController {

    @Autowired
    SaTcapacitorService saTcapacitorService;

    @RequestMapping(value = "getInit")
    public Object getInit() {
        ModelAndView mv = new ModelAndView("/safe/capacitor/dataPage.jsp");
        return mv;
    }

    @RequestMapping(value = "initAll")
    public Object initAll(SearchData searchData) {

        return saTcapacitorService.initAll(searchData);
    }

    @RequestMapping(value = "getOneById")
    public Object getOneById(Long id) {

        ModelAndView mv = new ModelAndView("/safe/capacitor/dataModify.jsp");
        SaTcapacitor map = (SaTcapacitor) saTcapacitorService.getOneById(id);
        mv.addObject("map", map);
        return mv;
    }

    @RequestMapping(value = "getBackById")
    public Object getBackById(Long id, @RequestParam(required = false) Long show) {
        ModelAndView mv = null;
        if (show == null) {
            mv = new ModelAndView("/safe/capacitor/backModify.jsp");
        } else {
            mv = new ModelAndView("/safe/capacitor/dataView.jsp");
        }
        SaTcapacitor map = (SaTcapacitor) saTcapacitorService.getBackById(id);
        mv.addObject("map", map);
        return mv;
    }

    @RequestMapping(value = "delDataById")
    public void delDataById(Long id) {

        saTcapacitorService.delDataById(id);
    }

    @RequestMapping(value = "save")
    public void save(SaTcapacitor capacitor, HttpServletRequest request) {
        User user = User.getCurrUser(request);
        capacitor.setVcUser(user.getVcName());
        capacitor.setVcServer(SystemConstants.SERVER_ID);
        saTcapacitorService.save(capacitor);
    }

    @RequestMapping(value = "saveBack")
    public void saveBack(SaTcapacitor capacitor, HttpServletRequest request) {
        User user = User.getCurrUser(request);
        capacitor.setDealUser(user.getVcName());
        saTcapacitorService.saveBack(capacitor);
    }

    @RequestMapping(value = "dataExcel")
    public void dataExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nowStr = DateUtil.getMonthToday();
        String fileName = "安全电容信息列表" + nowStr;
        //???projects????
        List<SaTcapacitor> projects = saTcapacitorService.getExportData();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ExcelUtil.createWorkBook(projects, SaTcapacitor.class).write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // ????response??????????????????
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String((fileName + ".xls").getBytes(), "iso-8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
    }

    @RequestMapping(value = "jpatest")
    public Object getAllDatasByJpa(SearchData searchData){
        return saTcapacitorService.getAllDatasByJpa(searchData);
    }

}

