package com.tiedate.csmiswh.business.SaTcapacitor.dao;

import com.tiedate.csmiswh.business.SaTcapacitor.data.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wth on 2016/6/1.
 */
@Repository
public interface UserDao extends JpaRepository<UserModel,Integer>,JpaSpecificationExecutor<UserModel> {
    @Modifying
    @Query("delete from UserModel s where s.uuid = ?1")
    void deleteById(Integer id);

    @Query("select name from UserModel um where um.uuid = ?1")
    String getNameById(Integer uuid);

    @Query("select age from UserModel um where um.uuid=?1 and um.name=?2")
    String getAgeByIdAndName(Integer uuid,String name);
}
