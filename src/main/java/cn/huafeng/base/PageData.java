package cn.huafeng.base;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

/**
 * 封装分页查询数据
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class PageData<T> implements Serializable {
    private static final long serialVersionUID = 1756293685402420070L;
    //总记录条数
    private long total;
    //每页条数
    private int pageSize=3;
    //页码，从1开始
    private int pageNumber=1;
    //排序方式
    private String order = "asc";
    //排序字段
    private String sort;
    //数据集合
    private List<T> rows=null;

    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getPageNumber() {
        return pageNumber;
    }
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
    public String getOrder() {
        return order;
    }
    public void setOrder(String order) {
        this.order = order;
    }
    public String getSort() {
        return sort;
    }
    public void setSort(String sort) {
        this.sort = sort;
    }
    public List<T> getRows() {
        return rows;
    }
    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public static <T> PageData<T> createPageData(){
        PageData<T> data = new PageData<>();
        return data;
    }
    /**
     * 创建分页数据对象
     */
    public static <T> PageData<T> createPageData(int pageSize,int pageNumber){
        PageData<T> data = new PageData<>();
        data.setPageSize(pageSize);
        data.setPageNumber(pageNumber);
        return data;
    }
    /**
     * 创建分页数据对象
     */
    public static <T> PageData<T> createPageData(int pageSize,int pageNumber,String order,String sort){
        PageData<T> data = new PageData<>();
        data.setPageSize(pageSize);
        data.setPageNumber(pageNumber);
        data.setOrder(order);
        data.setSort(sort);
        return data;
    }
    /**
     * 获取结束索引，索引从1开始
     */
    public int getEndIndex(){
        return getPageNumber()*getPageSize();
    }
    /**
     * 获取开始索引
     */
    public int getBeginIndex(){
        return getEndIndex()-getPageSize()+1;
    }

}
