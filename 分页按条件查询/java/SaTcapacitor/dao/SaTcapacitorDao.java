package com.tiedate.csmiswh.business.SaTcapacitor.dao;

import com.tiedate.csmiswh.business.SaTcapacitor.data.SaTcapacitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * sa_t_capacitor ������
 * Tue Mar 22 21:12:32 CST 2016 eaglezhy
 */
@Repository
public interface SaTcapacitorDao extends JpaSpecificationExecutor<SaTcapacitor>,
        JpaRepository<SaTcapacitor, Long> {//第一步,继承JpaSpecificationExecutor接口

}

