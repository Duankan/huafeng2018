package cn.huafeng.service.impl;

import cn.huafeng.base.ResponsePojo;
import cn.huafeng.dao.UserPoMapper;
import cn.huafeng.dto.UserDto;
import cn.huafeng.enums.ResponseEnum;
import cn.huafeng.po.UserPo;
import cn.huafeng.service.IUservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUservice {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    UserPoMapper userPoMapper;
    @Override
    public void insert(UserPo userPo) {
        userPoMapper.insertSelective(userPo);
    }
    @Override
    public void deleteById(Integer id) {
        userPoMapper.deleteByPrimaryKey(id);
    }
    @Override
    public List<UserDto> queryAll() {
        return userPoMapper.query();
    }
    @Override
    public UserDto queryById(Integer id) {
        return userPoMapper.selectByPrimaryKey(id);
    }
    @Override
    public void update(UserDto dto) {
        userPoMapper.updateByPrimaryKeySelective(dto);
    }
    @Override
    public List<UserDto> search(String kw) {
        return userPoMapper.search(kw);
    }

    @Override
    public ResponsePojo<List<UserDto>> queryAll2() {
        ResponsePojo<List<UserDto>> response = new ResponsePojo();
        List<UserDto> list = new ArrayList<>();
        try{
            list = userPoMapper.query();
            response.setCode(ResponseEnum.SUCCESS.getCode());
            response.setMessage(ResponseEnum.SUCCESS.getDisplayName());
            response.setObject(list);
            return response;
        }
        catch (Exception e){
            logger.error("查询失败",e);
            response.setCode(ResponseEnum.FAIL.getCode());
            response.setMessage(ResponseEnum.FAIL.getDisplayName());
            return response;
        }
        //response.setCode(ResponseEnum.FAIL.getCode());
        //response.setMessage(ResponseEnum.FAIL.getDisplayName());
        //return response;
    }
}
