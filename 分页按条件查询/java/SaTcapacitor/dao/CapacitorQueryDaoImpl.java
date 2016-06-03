package com.tiedate.csmiswh.business.SaTcapacitor.dao;

import com.tiedate.csmis.common.constant.SystemConstants;
import com.tiedate.csmiswh.business.SaTcapacitor.data.SaTcapacitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.tiedate.csmiswh.business.SaTcapacitor.data.SearchData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 123456 on 2016/3/22.
 */
@Repository
public class CapacitorQueryDaoImpl implements CapacitorQueryDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Object getBackById(Long id) {
        String sqlStr = " select T.VC_SERVER vcServer, " +
                "        T.N_ID nId, " +
                "       T.DT_FIND dtFind, " +
                "        T3.VC_NAME AS line, " +
                "        T1.VC_NAME AS workshop, " +
                "        T2.VC_NAME AS workarea, " +
                "        T4.VC_NAME AS station, " +
                "        T.SECTOR sector, " +
                "        T.LOSE_CAPACITOR loseCapacitor, " +
                "        T.RL_STANDARD rlStandard, " +
                "        T.RL_BEFORE rlBefore, " +
                "        T.DY_BEFORE dyBefore, " +
                "        T.DL_BEFORE dlBefore, " +
                "        T.FACTORY_BEFORE factoryBefore, " +
                "        T.RL_AFTER rlAfter, " +
                "        T.DY_AFTER dyAfter, " +
                "        T.DL_AFTER dlAfter, " +
                "        T.FACTORY_AFTER factoryAfter, " +
                "        T.TEST_CONDITION testCondition, " +
                "        T.DEAL_CONDITION dealCondition, " +
                "        T.DEAL_USER dealUser, " +
                "        T.DT_BACK dtBack, " +
                "        T.NOTE note, " +
                "        T.TEST_DEPARTMENT testDepartment, " +
                "        T.DT_DATE dtDate, " +
                "        T.VC_USER vcUser, " +
                "        DECODE(T.VC_STATUS, '0', '<font style=\"color:#00CC33\">未反馈</font>', '1', '<font style=\"color:blue\">已反馈</font>', '2', '<font style=\"color:green\">已确认</font>') vcStatus, " +
                "        DECODE(T.VC_TYPE,'0','上行','1','下行') vcType " +
                "   from sa_t_capacitor T, " +
                "        SYS_T_ORG      T1, " +
                "        SYS_T_ORG      T2, " +
                "        SYS_T_LINE     T3, " +
                "        SYS_T_STATION  T4 " +
                "  WHERE 1 = 1 " +
                "    AND T.VC_SERVER = '" + SystemConstants.SERVER_ID + "' " +
                "    AND T1.VC_SERVER = '" + SystemConstants.SERVER_ID + "' " +
                "    AND T2.VC_SERVER = '" + SystemConstants.SERVER_ID + "' " +
                "    AND T3.VC_SERVER = '" + SystemConstants.SERVER_ID + "' " +
                "    AND T4.VC_SERVER = '" + SystemConstants.SERVER_ID + "' " +
                "    AND T.LINE = T3.VC_LINE$ID " +
                "    AND T.WORKSHOP = T1.VC_ORG$ID " +
                "    AND T.WORKAREA = T2.VC_ORG$ID " +
                "    AND T.STATION = T4.VC_STATION$ID and t.N_id=?";
        SaTcapacitor saTcapacitor = jdbcTemplate.queryForObject(sqlStr, new Object[]{id}, BeanPropertyRowMapper.newInstance(SaTcapacitor.class));
        return saTcapacitor;
    }

    @Override
    public Object initPage(SearchData searchData) {

        String countSql = "select count(*) from sa_t_capacitor t";
        int total = jdbcTemplate.queryForInt(countSql);
        String sqlStr = " select T.VC_SERVER vcServer, " +
                "        T.N_ID nId, " +
                "        to_char(T.DT_FIND,'yyyy-MM-dd') dtFind, " +
                "        T3.VC_NAME AS line, " +
                "        T1.VC_NAME AS workshop, " +
                "        T2.VC_NAME AS workarea, " +
                "        T4.VC_NAME AS station, " +
                "        T.SECTOR sector, " +
                "        T.LOSE_CAPACITOR loseCapacitor, " +
                "        T.RL_STANDARD rlStandard, " +
                "        T.RL_BEFORE rlBefore, " +
                "        T.DY_BEFORE dyBefore, " +
                "        T.DL_BEFORE dlBefore, " +
                "        T.FACTORY_BEFORE factoryBefore, " +
                "        T.RL_AFTER rlAfter, " +
                "        T.DY_AFTER dyAfter, " +
                "        T.DL_AFTER dlAfter, " +
                "        T.FACTORY_AFTER factoryAfter, " +
                "        T.TEST_CONDITION testCondition, " +
                "        T.DEAL_CONDITION dealCondition, " +
                "        T.DEAL_USER dealUser, " +
                "        to_char(T.DT_BACK,'yyyy-MM-dd') dtBack, " +
                "        T.NOTE note, " +
                "        T.TEST_DEPARTMENT testDepartment, " +
                "        T.DT_DATE dtDate, " +
                "        T.VC_USER vcUser, " +
                "        DECODE(T.VC_STATUS, '0', '<font style=\"color:#00CC33\">222</font>', '1', '<font style=\"color:blue\">555</font>', '2', '<font style=\"color:green\">666</font>') vcStatus, " +
                "        DECODE(T.VC_TYPE,'0','444','1','333') vcType " +
                "   from sa_t_capacitor T, " +
                "        SYS_T_ORG      T1, " +
                "        SYS_T_ORG      T2, " +
                "        SYS_T_LINE     T3, " +
                "        SYS_T_STATION  T4 " +
                "  WHERE 1 = 1 " +
                "    AND T.VC_SERVER = '" + SystemConstants.SERVER_ID + "' " +
                "    AND T1.VC_SERVER = '" + SystemConstants.SERVER_ID + "' " +
                "    AND T2.VC_SERVER = '" + SystemConstants.SERVER_ID + "' " +
                "    AND T3.VC_SERVER = '" + SystemConstants.SERVER_ID + "' " +
                "    AND T4.VC_SERVER = '" + SystemConstants.SERVER_ID + "' " +
                "    AND T.LINE = T3.VC_LINE$ID " +
                "    AND T.WORKSHOP = T1.VC_ORG$ID " +
                "    AND T.WORKAREA = T2.VC_ORG$ID " +
                "    AND T.STATION = T4.VC_STATION$ID";
        //add query
        sqlStr += getQuery(searchData.getSearchLine(), "t.LINE");
        sqlStr += getQuery(searchData.getSearchWorkshop(), "t.WORKSHOP");
        sqlStr += getQuery(searchData.getSearchWorkarea(), "t.WORKAREA");
        sqlStr += getQuery(searchData.getSearchStation(), "t.STATION");
        sqlStr += getQuery(searchData.getSearchVcType(), "t.VC_TYPE");

        sqlStr+=" ORDER BY T.DT_DATE DESC ";

        if (total > 0) {
            sqlStr = getPageSql(sqlStr, searchData.getPage(), searchData.getRows());
            System.out.println("SQL - "+sqlStr);
            List<Map<String, Object>> dataList = jdbcTemplate.queryForList(sqlStr);
            Map map = new HashMap();
            map.put("total", total);
            map.put("rows", dataList);
            return map;
        } else {
            return null;
        }
    }

    /***
     * paged methed
     *
     * @param sql  sql
     * @param page ???
     * @param rows ????
     * @return
     */
    private String getPageSql(String sql, Integer page, Integer rows) {
        StringBuilder sqlStr = new StringBuilder();
        Integer smallPage = ((page - 1) * rows) + 1;
        Integer bigPage = smallPage + rows;
        sqlStr.append("select * from (select t.*,rownum rn from ( ");
        sqlStr.append(sql);
        sqlStr.append(") t where rownum<" + bigPage + ") t1 where rn>=" + smallPage + "");
        return sqlStr.toString();
    }

    /**
     * append query sql
     *
     * @param queryValue
     * @param queryObject
     * @return
     */
    private String getQuery(String queryValue, String queryObject) {
        if (queryValue == null || queryValue == "") {
            return "";
        } else {
            return " and " + queryObject + "=" + "'" + queryValue + "'";
        }
    }
}
