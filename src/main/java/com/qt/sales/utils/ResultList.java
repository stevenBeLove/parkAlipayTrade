package com.qt.sales.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 类说明 封装了分页需要的参数
 *
 * @author 张英辉
 */
@SuppressWarnings("unchecked")
public class ResultList {

    /**
     * 记录集合
     */
    private List rows = new ArrayList();
    /**
     * 记录总数
     */
    private long total;

    public ResultList() {
    }

    /**
     * 构造方法
     *
     * @param rows
     * @param total
     */
    public ResultList(List rows, long total) {
        this.rows = rows;
        this.total = total;
    }

    /**
     * 工厂方法
     *
     * @param rows
     * @param total
     * @return
     */
    public static ResultList getResultList(List rows, int total) {
        return new ResultList(rows, total);
    }

    /**
     * 获得记录集合
     *
     * @return 记录集合
     */
    public List getRows() {
        return rows;
    }

    /**
     * 设置记录集合
     *
     * @param rows 记录集合
     */
    public void setRows(List rows) {
        this.rows = rows;
    }

    /**
     * 获得记录总数
     *
     * @return 记录总数
     */
    public long getTotal() {
        return total;
    }

    /**
     * 设置记录总数
     *
     * @param total 记录总数
     */
    public void setTotal(long total) {
        this.total = total;
    }
}
