package cn.huafeng.biz.test;

import cn.huafeng.baseTset.BaseTest;
import cn.huafeng.biz.UserBiz;
import cn.huafeng.dto.UserDto;
import cn.huafeng.enums.ResponseEnum;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


public class ResponseTest extends BaseTest {

    @Autowired
    UserBiz userBiz;
    @Test
    public void test(){
        System.out.println("响应码："+ ResponseEnum.SUCCESS.getCode());
    }

    @Test
    public void test2(){
        PageHelper.startPage(1,5);
        List<UserDto> dtos = userBiz.listAll2();
//        PageInfo<UserDto> pageInfo = new PageInfo<>();
//        System.out.println(pageInfo);
        Page<UserDto> page = (Page<UserDto>) dtos;
        long total = page.getTotal();
        System.out.println(page);
        for (UserDto dto:dtos){
            System.out.println(dto.getName()+dto.getPic());
        }
    }
}
