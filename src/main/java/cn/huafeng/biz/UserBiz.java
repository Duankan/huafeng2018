package cn.huafeng.biz;

import cn.huafeng.base.PageData;
import cn.huafeng.base.ResponsePojo;
import cn.huafeng.dto.UserDto;
import cn.huafeng.dto.UserVo;
import cn.huafeng.enums.ResponseEnum;
import cn.huafeng.po.UserPo;
import cn.huafeng.service.IUservice;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class UserBiz {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(UserBiz.class);

    @Autowired
    IUservice uservice;
    //查询all
    public List<UserDto> listAll(){
        return uservice.queryAll();
    }
    //add
    public void add(UserPo po){
        if(po==null){

        }else {
            uservice.insert(po);
        }
    }

    //del
    public String del(Integer id){
        if(id!=null){
            uservice.deleteById(id);
            return "y";
        }
        else {
            return "n";
        }
    }

    //查询某个用户
     public UserDto queryId(Integer id){
        if(id!=null){
            return uservice.queryById(id);
        }
        return null;
     }

     //保存更改的用户信息
    public void update(UserDto dto){
        if(dto!=null){
            uservice.update(dto);
        }
    }

    //模糊查询
    public List<UserDto> search(String kw){
        if(StringUtils.isEmpty(kw)){
            return null;
        }
        else {
            return uservice.search(kw);
        }
    }

    //有返回状态信息的查询all
    public List<UserDto> listAll2(){
        List<UserDto> list = new ArrayList<>();
        try{
        ResponsePojo<List<UserDto>> responsePojo = uservice.queryAll2();
        if(null == responsePojo||! ResponseEnum.SUCCESS.getCode().equals(responsePojo.getCode())){
            logger.error("获取用户列表失败，e:{}",responsePojo.getMessage());
            return list;
        }
        else {
            list = responsePojo.getObject();
            return list;
        }
        }
        catch (Exception e){
            logger.error("获取用户列表失败，e:{}",e.getMessage());
            return list;
        }


    }

    //利用bootStrap刷新分页列表数据
    public PageData<UserDto> getPage(UserVo queryVo){
        //PageData<UserDto> pageData = new PageData<>();
        ResponsePojo<List<UserDto>> response = new ResponsePojo<>();
        List<UserDto> list = new ArrayList<>();
        int pageSize = queryVo.getLimit();
        int pageNumber = (queryVo.getOffset()+queryVo.getLimit())/queryVo.getLimit();
        PageData<UserDto> pageData=PageData.createPageData(pageSize,pageNumber);//给pageData赋值页码和每页条数
        try{
            PageHelper.startPage(pageData.getPageNumber(),pageData.getPageSize());//一定要将该方法放在查询操作之前！！
            response = uservice.queryAll2();
            if(null == response||! ResponseEnum.SUCCESS.getCode().equals(response.getCode())){
                logger.error("获取用户列表失败，e:{}",response.getMessage());
                return pageData;
            }
            else {
                list = response.getObject();
                Page<UserDto> page = (Page<UserDto>) list;
                pageData.setRows(list);
                pageData.setTotal(page.getTotal());
                return pageData;
            }
        }catch (Exception e){
            logger.error("获取用户列表失败，e:{}",e.getMessage());
            return pageData;
        }
    }

}
