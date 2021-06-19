/**
 * Copyright 2021 json.cn
 */
package com.niou.portal.bean;
import java.util.List;

/**
 * Auto-generated: 2021-06-19 13:30:43
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Data {

    private List<Link> links;
    private String type;

    @Override
    public String toString() {
        return "Data{" +
                "links=" + links +
                ", type='" + type + '\'' +
                '}';
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
    public List<Link> getLinks() {
        return links;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

}