package com.niou.portal.service;

import com.niou.portal.bean.Data;
import com.niou.portal.dao.BaseLinkDao;
import com.niou.portal.dao.LinkDao;

import java.util.List;

/**
 * <pre>
 * @Description: 连接服务
 * </pre>
 * @author 董珊珊<br>
 * <b>mail</b> dongshanshan@syncsoft.com<br>
 * <b>date</b> 2021/06/19 14:55<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/06/19 	董珊珊		    		新建
 * </pre>
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
