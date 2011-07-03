package org.conan.taobao.web.util;

import java.util.List;

import org.conan.taobao.base.BaseObject;

public class PageOut<E> extends BaseObject {
    private static final long serialVersionUID = -4186074274297349106L;

    public PageOut() {
    }

    public PageOut(int count, List<E> list, int pageNo) {
        this(count, list, pageNo, 10);
    }

    /**
     * 
     * @param count
     * @param list
     * @param pageNo
     *            从1开始
     * @param pageSize
     *            默认10
     */
    public PageOut(int count, List<E> list, int pageNo, int pageSize) {
        this.count = count;
        this.list = list;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    private int count;
    private int pageNo;
    private int pageSize = 10;
    private List<E> list;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /*-----------page function----------*/
    public int getItemBegin() {
        if (count == 0) {
            return 0;
        }
        return (pageNo - 1) * pageSize + 1;
    }

    public int getItemEnd() {
        int tmp = pageNo * pageSize;
        if (count < tmp) {
            return count;
        }
        return tmp;
    }

    public int getPageCount() {
        int tmp = count / pageSize;
        if (count % pageSize == 0) {
            return tmp;
        }
        return (int) (Math.floor(tmp) + 1);
    }

    public int getPageNow() {
        if (getItemBegin() > count) {
            return getPageCount();
        }

        if (getItemBegin() == 0) { // 没有记录的情况
            return 0;
        }

        if (getItemBegin() < getPageSize()) { // 不足一页的情况
            return getFirstPage();
        } else {
            return (int) (Math.floor(getItemBegin() / getPageSize())) + 1;
        }
    }

    public int getFirstPage() {
        return 1;
    }

    public int getPreviousPage() {
        if (getPageNow() <= 1) {
            return getFirstPage();
        }
        return getPageNow() - 1;
    }

    public int getNextPage() {
        if (getPageNow() >= getLastPage()) {
            return getLastPage();
        }
        return getPageNow() + 1;
    }

    public int getLastPage() {
        return getPageCount();
    }

    public int getPageItem(int page) {
        return (page - 1) * getPageSize();
    }

}
