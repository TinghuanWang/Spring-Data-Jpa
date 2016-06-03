package com.tiedate.csmiswh.business.SaTcapacitor.data;

/**
 * Created by wth on 2016/4/20.
 */
public class SearchData {
    private Integer page;
    private Integer rows;
    private String searchLine;
    private String searchWorkshop;
    private String searchWorkarea;
    private String searchStation;
    private String searchVcType;
    private String startDate;
    private String endDate;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getSearchLine() {
        return searchLine;
    }

    public void setSearchLine(String searchLine) {
        this.searchLine = searchLine;
    }

    public String getSearchWorkshop() {
        return searchWorkshop;
    }

    public void setSearchWorkshop(String searchWorkshop) {
        this.searchWorkshop = searchWorkshop;
    }

    public String getSearchWorkarea() {
        return searchWorkarea;
    }

    public void setSearchWorkarea(String searchWorkarea) {
        this.searchWorkarea = searchWorkarea;
    }

    public String getSearchStation() {
        return searchStation;
    }

    public void setSearchStation(String searchStation) {
        this.searchStation = searchStation;
    }

    public String getSearchVcType() {
        return searchVcType;
    }

    public void setSearchVcType(String searchVcType) {
        this.searchVcType = searchVcType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
