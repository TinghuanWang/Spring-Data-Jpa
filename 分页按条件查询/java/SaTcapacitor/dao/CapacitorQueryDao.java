package com.tiedate.csmiswh.business.SaTcapacitor.dao;

import com.tiedate.csmiswh.business.SaTcapacitor.data.SearchData;

/**
 * Created by 123456 on 2016/3/22.
 */
public interface CapacitorQueryDao {

    Object initPage(SearchData searchData);

    Object getBackById(Long id);
}
