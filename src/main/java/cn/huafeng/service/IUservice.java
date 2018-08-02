package cn.huafeng.service;

import cn.huafeng.base.ResponsePojo;
import cn.huafeng.dto.UserDto;
import cn.huafeng.po.UserPo;


import java.util.List;

public interface IUservice {

    //增
    public void insert(UserPo userPo);
    //删：根据id
    public void deleteById(Integer id);
    //查：all
    public List<UserDto> queryAll();
    //查：by id
    public UserDto queryById(Integer id);
    //改
    public void update(UserDto dto);
    //模糊查询
    public  List<UserDto> search(String kw);
    //有状态信息的query all
    public ResponsePojo<List<UserDto>> queryAll2();
}
