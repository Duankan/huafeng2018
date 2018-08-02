package cn.huafeng.controller;

import cn.huafeng.base.PageData;
import cn.huafeng.biz.UserBiz;
import cn.huafeng.dto.UserDto;
import cn.huafeng.dto.UserVo;
import cn.huafeng.po.UserPo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserBiz userBiz;

    @RequestMapping("/list")
    public String list(Model model){
        List<UserDto> dtos = userBiz.listAll();
        model.addAttribute("users",dtos);
        return "list";
    }

    @RequestMapping("/list2")
    public String toList(){
        //ModelAndView view = new ModelAndView("list2_bootstrap");
        return "list2_bootstrap";
    }

    @RequestMapping("/findList")
    @ResponseBody
    public Map<String,Object> queryPage(UserVo queryVo){
        Map<String,Object> map =new HashMap<>();
        try{
            PageData<UserDto> page = userBiz.getPage(queryVo);
            map.put("rows",page.getRows());
            map.put("total",page.getTotal());
            return map;
        }
        catch (Exception e){
            logger.error("查询用户信息失败，e:{}"+e.getMessage(),e);
        }
        return map;
    }

    @RequestMapping("/addUI")
    public ModelAndView addUI(){
        ModelAndView view = new ModelAndView("add");
        return view;
    }
    @RequestMapping("/add")
    public String add(UserPo po,MultipartFile file) throws  Exception{
        //文件为空，不存储
        if(!file.isEmpty()) {
            String pa = new Date().getTime() + file.getOriginalFilename();
            String path = "F:/save/" + pa; //存储路径
            File newFile = new File(path);
            file.transferTo(newFile);
            po.setPic(path);
        }
        userBiz.add(po);
        return "redirect:/user/list2";
    }

    @RequestMapping("/del")
    @ResponseBody
    public Map del(Integer id){
        String res = userBiz.del(id);
        Map map = new HashMap();
        map.put("res",res);
        return map;
    }

    @RequestMapping("/updateUI")
    public String updateUI(Integer id,Model model){
        UserDto dto = userBiz.queryId(id);
        model.addAttribute("user",dto);
        return "updateUI";
    }

    @RequestMapping("/update")
    public  String update(UserDto dto,Model model,MultipartFile file) throws Exception{
      //文件为空没有修改
        if(!file.isEmpty()) {
            String pa = new Date().getTime() + file.getOriginalFilename();
            String path = "F:/save/" + pa; //存储路径
            File newFile = new File(path);
            file.transferTo(newFile);
            //if(dto2.getPic())
            dto.setPic(path);
        }
        userBiz.update(dto);
        return "redirect:/user/list2";
    }

    @RequestMapping("/search")
    @ResponseBody
    public Map search(String kw){
        List<UserDto> dtos = userBiz.search(kw);
        Map map = new HashMap();
        map.put("users",dtos);
        return map;
    }

}
