package cn.huafeng.service.test;

import cn.huafeng.baseTset.BaseTest;
import cn.huafeng.dto.UserDto;
import cn.huafeng.po.UserPo;
import cn.huafeng.service.IUservice;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceTest extends BaseTest {

    @Autowired
    IUservice uservice;
    //测试service CRUD
    @Test
    public void serviceCRUD(){
        //insert
        UserPo po = new UserPo();
        po.setName("华风电子");
        po.setAge(17);
        po.setAddr("汤逊湖北路");
        po.setPic("d:/photo");
        uservice.insert(po);
        //query
        List<UserDto> dtos = uservice.queryAll();
        //query:id
        UserDto dto = uservice.queryById(1);
        //删
        uservice.deleteById(3);
        //改
        UserDto dto1 = new UserDto();
        dto1.setId(3);
        dto1.setName("武汉华风电子");
    }
}
