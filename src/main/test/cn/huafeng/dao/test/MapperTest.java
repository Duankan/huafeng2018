package cn.huafeng.dao.test;

import cn.huafeng.baseTset.BaseTest;
import cn.huafeng.dao.UserPoMapper;
import cn.huafeng.dto.UserDto;
import cn.huafeng.po.UserPo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 *测试逆向工程的Mapper是否没有问题
 */
public class MapperTest extends BaseTest{

    @Resource
    UserPoMapper userPoMapper;
    //测试mapper能否由容器生成
    @Test
    public void mapperBean(){
        System.out.println(userPoMapper);   //√√√
    }

    //测试mapper操作数据库的增删查改
    @Test
    public void mapperCRUD(){
        //insert
//        UserPo po = new UserPo();
//        po.setName("段康1");
//        po.setAge(25);
//        po.setAddr("湖北荆州1");
//        po.setPic("/user/photo");
//        userPoMapper.insertSelective(po);   //√√√

        //查所有
//        List<UserDto> userDtos = userPoMapper.query();
//        for(UserDto dto:userDtos){
//            System.out.println(dto.getName());
//        }                           //√√√
//        //根据id查
//        UserDto dto = userPoMapper.selectByPrimaryKey(1);
//        System.out.println(dto.getName());    //√√√

        //删
        //userPoMapper.deleteByPrimaryKey(2);     //√√√

        //更新
        UserDto dto = new UserDto();
        dto.setId(1);
        dto.setName("李青青");
        userPoMapper.updateByPrimaryKeySelective(dto);
    }

    @Test
    public void test(){
        String kw = "荆";
        List<UserDto> dtos=userPoMapper.search(kw);
        System.out.println(dtos.size());
    }

    //Mybatis分页插件PageHelper
    @Test
    public void test2(){
        PageHelper.startPage(3,2);
        List<UserDto> dtos = userPoMapper.query();
        Page<UserDto> page = (Page<UserDto>) dtos;
        long total = page.getTotal();
        System.out.println(total);
        for (UserDto dto:dtos){
            System.out.println(dto.getName()+"---"+dto.getPic());
        }
    }



}
