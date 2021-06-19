package com.niou.portal.dao;

import com.niou.portal.bean.Data;
import com.niou.portal.bean.Link;

import java.util.List;

/**
 * <pre>
 * @Description:
 * </pre>
 * @author 董珊珊<br>
 * <b>mail</b> dongshanshan@syncsoft.com<br>
 * <b>date</b> 2021/06/19 14:12<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/06/19 	董珊珊		    		新建
 * </pre>
 */
public interface BaseLinkDao {
    /**
     * <pre>
     * 查询所有的连接
     * </pre>
     * @author 董珊珊
     * @param
     * @return java.util.List<com.niou.portal.bean.Data>
     * @throws
     */
    List<Data> findALl();

    /**
     * <pre>
     * 根据id查询连接
     * </pre>
     * @author 董珊珊
     * @param id
     * @return com.niou.portal.bean.Link
     * @throws
     * <pre>
     * 修改记录
     *  版本号     修订日期        修改人     bug编号       修改内容
     *  1.0.0      2021/6/19      董珊珊                     新建
     * </pre>
     */
    String findById(int id);
}
