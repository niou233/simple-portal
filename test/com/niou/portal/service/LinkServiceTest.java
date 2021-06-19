package com.niou.portal.service;

import com.niou.portal.bean.Data;
import com.niou.portal.bean.Link;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: Niou
 * @Date: 2021/6/19 15:03
 * @Description:
 */
public class LinkServiceTest {

    @Test
    public void findAll() {
        List<Data> data = LinkService.findAll();
        System.out.println(data);
    }

    @Test
    public void findById() {
        String link = LinkService.findById(100);
        System.out.println(link);
    }
}