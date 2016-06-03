package com.tiedate.csmiswh.business.SaTcapacitor.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tiedate.csmis.common.constant.SystemConstants;
import com.tiedate.csmiswh.business.constants.ApplicationContexConstants;
import com.tiedate.csmiswh.business.manager.line.service.SysTlineService;
import com.tiedate.csmiswh.business.manager.line.util.SysTlineUtils;
import com.tiedate.csmiswh.business.orgInfo.personInfo.service.IOrgServcie;
import com.tiedate.csmiswh.business.sysStation.service.SysStationService;
import com.tiedate.csmiswh.business.utils.excel.annotation.ExcelField;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * sa_t_capacitor ?????
 * Tue Mar 22 21:12:32 CST 2016 eaglezhy
 */
@Entity
@Table(name = "SA_T_CAPACITOR")
public class SaTcapacitor {
    @Column(name = "VC_SERVER", updatable = false)
    private String vcServer;

    @Id
    @Column(name = "N_ID", updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long nId;

    @ExcelField(title = "发现日期")
    @Column(name = "DT_FIND")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtFind;

    @Column(name = "LINE")
    private String line;

    @ExcelField(title = "先别")
    @Transient
    private String lineName;

    public String getLineName() {
        return ApplicationContexConstants.getApplicationContext().getBean(SysTlineService.class).findOne(line);
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    @Column(name = "WORKSHOP")
    private String workshop;

    @ExcelField(title = "车间")
    @Transient
    private String workshopName;

    @Column(name = "WORKAREA")
    private String workarea;

    @ExcelField(title = "工区")
    @Transient
    private String workareaName;

    @Column(name = "STATION")
    private String station;

    @ExcelField(title = "车站")
    @Transient
    private String stationName;

    public String getWorkshopName() {
        return ApplicationContexConstants.getApplicationContext().getBean(IOrgServcie.class).getVcOrgName(SystemConstants.SERVER_ID, workshop).get(0).getVcName();
    }

    public void setWorkshopName(String workshopName) {
        this.workshopName = workshopName;
    }

    public String getWorkareaName() {
        return ApplicationContexConstants.getApplicationContext().getBean(IOrgServcie.class).getVcOrgName(SystemConstants.SERVER_ID, workarea).get(0).getVcName();
    }

    public void setWorkareaName(String workareaName) {
        this.workareaName = workareaName;
    }

    public String getStationName() {
        return ApplicationContexConstants.getApplicationContext().getBean(SysStationService.class).getSysTstation4JPA(station).get(0).getVcName();
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @ExcelField(title = "区间")
    @Column(name = "SECTOR")
    private String sector;

    @ExcelField(title = "失效")
    @Column(name = "LOSE_CAPACITOR")
    private String loseCapacitor;

    @ExcelField(title = "1容量")
    @Column(name = "RL_STANDARD")
    private String rlStandard;

    @ExcelField(title = "2容量")
    @Column(name = "RL_BEFORE")
    private String rlBefore;

    @ExcelField(title = "1电压")
    @Column(name = "DY_BEFORE")
    private String dyBefore;

    @ExcelField(title = "2电压")
    @Column(name = "DL_BEFORE")
    private String dlBefore;

    @ExcelField(title = "1常见")
    @Column(name = "FACTORY_BEFORE")
    private String factoryBefore;

    @ExcelField(title = "2厂家")
    @Column(name = "RL_AFTER")
    private String rlAfter;

    @ExcelField(title = "后电压")
    @Column(name = "DY_AFTER")
    private String dyAfter;

    @ExcelField(title = "后电流源")
    @Column(name = "DL_AFTER")
    private String dlAfter;

    @ExcelField(title = "后工程")
    @Column(name = "FACTORY_AFTER")
    private String factoryAfter;

    @ExcelField(title = "测试")
    @Column(name = "TEST_CONDITION")
    private String testCondition;

    @ExcelField(title = "处理情况")
    @Column(name = "DEAL_CONDITION")
    private String dealCondition;

    @ExcelField(title = "处理人")
    @Column(name = "DEAL_USER")
    private String dealUser;

    @ExcelField(title = "反馈")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_BACK")
    private Date dtBack;

    @ExcelField(title = "备注")
    @Column(name = "NOTE")
    private String note;

    @ExcelField(title = "检测部门")
    @Column(name = "TEST_DEPARTMENT")
    private String testDepartment;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_DATE", updatable = false)
    private Date dtDate = new Date();

    @Column(name = "VC_USER", updatable = false)
    private String vcUser;

    @Column(name = "VC_STATUS")
    private String vcStatus;

    @Column(name = "VC_TYPE", updatable = false)
    private String vcType;

    public void setVcServer(String vcServer) {
        this.vcServer = vcServer;
    }

    public String getVcServer() {
        return vcServer;
    }

    public void setNId(Long nId) {
        this.nId = nId;
    }

    public Long getNId() {
        return nId;
    }

    public void setDtFind(Date dtFind) {
        this.dtFind = dtFind;
    }

    public Date getDtFind() {
        return dtFind;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getLine() {
        return line;
    }

    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }

    public String getWorkshop() {
        return workshop;
    }

    public void setWorkarea(String workarea) {
        this.workarea = workarea;
    }

    public String getWorkarea() {
        return workarea;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getStation() {
        return station;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getSector() {
        return sector;
    }

    public void setLoseCapacitor(String loseCapacitor) {
        this.loseCapacitor = loseCapacitor;
    }

    public String getLoseCapacitor() {
        return loseCapacitor;
    }

    public void setRlStandard(String rlStandard) {
        this.rlStandard = rlStandard;
    }

    public String getRlStandard() {
        return rlStandard;
    }

    public void setRlBefore(String rlBefore) {
        this.rlBefore = rlBefore;
    }

    public String getRlBefore() {
        return rlBefore;
    }

    public void setDyBefore(String dyBefore) {
        this.dyBefore = dyBefore;
    }

    public String getDyBefore() {
        return dyBefore;
    }

    public void setDlBefore(String dlBefore) {
        this.dlBefore = dlBefore;
    }

    public String getDlBefore() {
        return dlBefore;
    }

    public void setFactoryBefore(String factoryBefore) {
        this.factoryBefore = factoryBefore;
    }

    public String getFactoryBefore() {
        return factoryBefore;
    }

    public void setRlAfter(String rlAfter) {
        this.rlAfter = rlAfter;
    }

    public String getRlAfter() {
        return rlAfter;
    }

    public void setDyAfter(String dyAfter) {
        this.dyAfter = dyAfter;
    }

    public String getDyAfter() {
        return dyAfter;
    }

    public void setDlAfter(String dlAfter) {
        this.dlAfter = dlAfter;
    }

    public String getDlAfter() {
        return dlAfter;
    }

    public void setFactoryAfter(String factoryAfter) {
        this.factoryAfter = factoryAfter;
    }

    public String getFactoryAfter() {
        return factoryAfter;
    }

    public void setTestCondition(String testCondition) {
        this.testCondition = testCondition;
    }

    public String getTestCondition() {
        return testCondition;
    }

    public void setDealCondition(String dealCondition) {
        this.dealCondition = dealCondition;
    }

    public String getDealCondition() {
        return dealCondition;
    }

    public void setDealUser(String dealUser) {
        this.dealUser = dealUser;
    }

    public String getDealUser() {
        return dealUser;
    }

    public void setDtBack(Date dtBack) {
        this.dtBack = dtBack;
    }

    public Date getDtBack() {
        return dtBack;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setTestDepartment(String testDepartment) {
        this.testDepartment = testDepartment;
    }

    public String getTestDepartment() {
        return testDepartment;
    }

    public void setDtDate(Date dtDate) {
        this.dtDate = dtDate;
    }

    public Date getDtDate() {
        return dtDate;
    }

    public void setVcUser(String vcUser) {
        this.vcUser = vcUser;
    }

    public String getVcUser() {
        return vcUser;
    }

    public void setVcStatus(String vcStatus) {
        this.vcStatus = vcStatus;
    }

    public String getVcStatus() {
        return vcStatus;
    }

    public void setVcType(String vcType) {
        this.vcType = vcType;
    }

    public String getVcType() {
        return vcType;
    }

}

