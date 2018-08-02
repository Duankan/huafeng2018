package cn.huafeng.biz.test;

import cn.huafeng.base.PageData;
import cn.huafeng.baseTset.BaseTest;
import cn.huafeng.biz.UserBiz;
import cn.huafeng.dto.UserDto;
import cn.huafeng.dto.UserVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PageDataTest extends BaseTest {

    @Autowired
    UserBiz userBiz;
    //测试分页
    @Test
    public void test(){
        UserVo queryVo = new UserVo();
        queryVo.setOffset(4);
        queryVo.setLimit(2);
        PageData<UserDto> pageData = new PageData<>();
        pageData = userBiz.getPage(queryVo);
        List<UserDto> dtos = pageData.getRows();
        for (UserDto dto:dtos){
            System.out.println(dto.getName()+"->"+dto.getPic());
        }
    }
}
