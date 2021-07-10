package com.niou.portal.dao;

import com.niou.portal.bean.Data;

import java.util.List;

/**
 * <pre>
 * @Description:
 * </pre>
 * @Auther: Niou
 * @Date: 2021/6/19 15:00
 */
public interface BaseLinkDao {  

    /**
     * <pre>
     * @description:
     * </pre> 
     * @author Niou 
     * @return: java.util.List<com.niou.portal.bean.Data>
     * @throws  
     */
    List<Data> findALl();

     /**
      * <pre>
      * @description:
      * </pre> 
      * @author Niou 
      * @param: id
      * @return: java.lang.String
      * @throws  
      */
    String findById(int id);
}
