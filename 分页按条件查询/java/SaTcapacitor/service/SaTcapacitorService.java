package com.tiedate.csmiswh.business.SaTcapacitor.service;

import com.tiedate.csmiswh.business.SaTcapacitor.dao.CapacitorQueryDao;
import com.tiedate.csmiswh.business.SaTcapacitor.dao.SaTcapacitorDao;
import com.tiedate.csmiswh.business.SaTcapacitor.data.SaTcapacitor;
import com.tiedate.csmiswh.business.SaTcapacitor.data.SearchData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

/**
 * sa_t_capacitor ������
 * Tue Mar 22 21:12:32 CST 2016 eaglezhy
 */
@Service
@Transactional("transactionManagerJpa")
public class SaTcapacitorService {

    @Autowired
    private SaTcapacitorDao saTcapacitorDao;
    @Autowired
    private CapacitorQueryDao capacitorQueryDao;

    @PersistenceContext
    private EntityManager em;

    private SearchData searchData;

    /***
     * 新增数据
     *
     * @return
     */
    public Object initAll(SearchData searchData) {
        return capacitorQueryDao.initPage(searchData);
    }

    /***
     * 获取反馈相关信息 需要显示中文名称等
     *
     * @param id
     * @return
     */
    public Object getBackById(Long id) {
        return capacitorQueryDao.getBackById(id);
    }

    /***
     * 获取修改的基础数据
     *
     * @param id
     * @return
     */
    public Object getOneById(Long id) {
        return saTcapacitorDao.findOne(id);
    }

    /**
     * 删除基础数据
     *
     * @param id
     */
    public void delDataById(Long id) {
        saTcapacitorDao.delete(id);
    }

    /**
     * 保存提交数据
     *
     * @param capacitor
     */
    public void save(SaTcapacitor capacitor) {
        saTcapacitorDao.save(capacitor);
    }

    /***
     * 更新反馈信息
     *
     * @param capacitor
     */
    public void saveBack(SaTcapacitor capacitor) {
        SaTcapacitor tempObj = saTcapacitorDao.findOne(capacitor.getNId());
        tempObj.setRlAfter(capacitor.getRlAfter());
        tempObj.setDyAfter(capacitor.getDyAfter());
        tempObj.setDlAfter(capacitor.getDlAfter());
        tempObj.setFactoryAfter(capacitor.getFactoryAfter());
        tempObj.setTestCondition(capacitor.getTestCondition());
        tempObj.setDealCondition(capacitor.getDealCondition());
        tempObj.setDealUser(capacitor.getDealUser());
        tempObj.setDtBack(new Date());
        tempObj.setTestDepartment(capacitor.getTestDepartment());
        tempObj.setVcStatus(capacitor.getVcStatus());
        saTcapacitorDao.save(tempObj);
    }

    /***
     * 获取所有数据
     *
     * @return
     */
    public List<SaTcapacitor> getExportData() {

        return saTcapacitorDao.findAll();
    }

    /****
     * 实现Spring Data Jpa分页按条件查询
     * @param searchDatapara
     * @return
     */
    public Object getAllDatasByJpa(SearchData searchDatapara) {
        this.searchData = searchDatapara;
        Integer page = searchData.getPage();//1
        Integer rows = searchData.getRows();//20

        //创建分页的请求
        PageRequest pageRequest =  buildPageRequest(page,rows,"auto");

        //创建动态查询条件组合
        Specification<SaTcapacitor> spec = new Specification<SaTcapacitor>() {
            @Override
            public Predicate toPredicate(Root<SaTcapacitor> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();
                if(searchData.getSearchVcType()!=null && searchData.getSearchVcType()!="" ){
                    list.add(criteriaBuilder.equal(root.get("vcType").as(String.class), searchData.getSearchVcType()));
                }

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        };

        Page<SaTcapacitor> p = saTcapacitorDao.findAll(spec,pageRequest);//分页按条件查询

        //拼接返回datagrid的map
        List<SaTcapacitor> listCount = saTcapacitorDao.findAll();//查询总数
        Integer total = listCount.size();
        Map map = new HashMap();
        map.put("total", total);
        map.put("rows", p.getContent());
        return map;
    }

    /***
     * 创建分页请求
     * @param pageNumber 页码
     * @param pagzSize 页数
     * @param sortType 排序类型
     * @return
     */
    private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {//第二步，创建分页请求
        Sort sort = null;
        if ("auto".equals(sortType)) {
            sort = new Sort(Sort.Direction.ASC, "nId");
        } else if ("factoryBefore".equals(sortType)) {
            sort = new Sort(Sort.Direction.ASC, "factoryBefore");
        }
        return new PageRequest(pageNumber - 1, pagzSize, sort);
    }


    public SearchData getSearchData() {
        return searchData;
    }

    public void setSearchData(SearchData searchData) {
        this.searchData = searchData;
    }
}

