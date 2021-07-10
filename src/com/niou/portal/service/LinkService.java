package com.niou.portal.service;

import com.niou.portal.bean.Data;
import com.niou.portal.dao.BaseLinkDao;
import com.niou.portal.dao.LinkDao;

import java.util.List;

/**
 * <pre>
 * @Description:
 * </pre>
 * @Auther: Niou
 * @Date: 2021/6/19 15:00
 */
public class LinkService {
    public static BaseLinkDao dao = new LinkDao();

    public static List<Data> findAll(){
        return dao.findALl();
    }
    public static String findById(int id){
        return dao.findById(id);
    }
}
