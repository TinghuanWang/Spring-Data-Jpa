package com.tiedate.csmiswh.business.SaTcapacitor.service;

import com.tiedate.csmiswh.business.SaTcapacitor.dao.UserDao;
import com.tiedate.csmiswh.business.SaTcapacitor.data.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wth on 2016/6/1.
 */
@Service
@Transactional("transactionManagerJpa")
public class UserService {

    @Autowired
    private  UserDao userDao;

    /***
     * 添加数据
     * @param um
     */
    public void testAdd(UserModel um){ userDao.save(um); }

    /***
     * 删除数据
     * @param uuid
     */
    public void deleteById(Integer uuid){
        userDao.deleteById(uuid);
    }

    /***
     * 获取某一字段值
     * @param uuid
     * @return
     */
    public  String getNameById(Integer uuid){
        String name  = userDao.getNameById(uuid);
        return name;
    }

    public List<UserModel> getContent(){
        /***
         * 按照某一字段倒序或者顺序排序，取前面几项记录的集合
         */
        Page<UserModel> p =
                userDao.findAll(new PageRequest(0,3,new Sort(new Sort.Order(Sort.Direction.ASC,"uuid"))));
        return p.getContent();
    }

    public String getAgeByIdAndName(Integer uuid,String name){
        return userDao.getAgeByIdAndName(uuid,name);
    }

    public List<UserModel> getDatas(Integer rows,Integer page){
//        List<UserModel> datas =  userDao.findAll();
//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("total",100);
//        map.put("rows",datas);
//        System.out.println(map.toString());
        Page<UserModel> p =  userDao.findAll(new PageRequest(rows,page,new Sort(new Sort.Order(Sort.Direction. DESC,"uuid"))));
        return p.getContent();
    }

    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserService c = (UserService) ctx.getBean("UserService");
////        UserModel um = new UserModel();
////        um.setAge(1);
////        um.setName("张三");
////        um.setUuid(6);
////        c.testAdd(um);
////        c.deleteById(1);
////        System.out.println(c.getNameById(2));
////        List<UserModel> list = c.getContent();
////        System.out.println(list.get(0).getName());
////        System.out.println(list.get(1).getName());
//
//        System.out.println(c.getAgeByIdAndName(2,"lisi"));
    }
}
