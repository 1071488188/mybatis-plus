package com.sourceprogram.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sourceprogram.controller.base.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.sourceprogram.service.UserService;
import com.sourceprogram.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONObject;
import com.sourceprogram.util.ErrorCode;
import com.sourceprogram.util.RespMessage;
import org.springframework.web.bind.annotation.*;

/**
 *code is far away from bug with the animal protecting
 *
 *   @description : User 控制器
 *   ---------------------------------
 *      @author jiangjunjie
 *   @since 2017-10-20
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController extends AbstractController {
@Autowired
public UserService userService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : jiangjunjie
 * @since : Create in 2017-10-20
 */
@RequestMapping(value = "/getUserList", method = RequestMethod.POST)
public JSONObject getUserList(@RequestBody User param,@RequestParam(value = "pageSize") Integer pageSize,@RequestParam(value = "page") Integer page){
        JSONObject json=new JSONObject();
        RespMessage respMessage=new RespMessage();
        Integer pageNo=getPageNo(page,pageSize);
        Page<User> pager=new Page<User>(pageNo,pageSize);
    userService.selectPage(pager,new EntityWrapper<User>(param));
        json.put("totalCount",pager.getTotal());
        json.put("list",pager.getRecords());
        return new RespMessage(ErrorCode.E00000000.CODE,ErrorCode.E00000000.MSG,json).getRespMessage();
        }

/**
 * @description : 通过id获取User
 * ---------------------------------
 * @author : jiangjunjie
 * @since : Create in 2017-10-20
 */
@RequestMapping(value = "/getUserById", method = RequestMethod.GET)
public Object getUserById(String id){
        RespMessage respMessage=new RespMessage();
    User param= userService.selectById(id);
        return new RespMessage(ErrorCode.E00000000.CODE,ErrorCode.E00000000.MSG,param).getRespMessage();
        }

/**
 * @description : 通过id删除User
 * ---------------------------------
 * @author : jiangjunjie
 * @since : Create in 2017-10-20
 */
@RequestMapping(value = "/deleteUserById", method = RequestMethod.GET)
public Object deleteUserById(String id){
    userService.deleteById(id);
        return new RespMessage(ErrorCode.E00000000.CODE,ErrorCode.E00000000.MSG,null).getRespMessage();
        }

/**
 * @description : 通过id更新User
 * ---------------------------------
 * @author : jiangjunjie
 * @since : Create in 2017-10-20
 */
@RequestMapping(value = "/updateUserById", method = RequestMethod.POST)
public Object updateUserById(User param){
    userService.updateById(param);
        return new RespMessage(ErrorCode.E00000000.CODE,ErrorCode.E00000000.MSG,null).getRespMessage();
        }

/**
 * @description : 添加User
 * ---------------------------------
 * @author : jiangjunjie
 * @since : Create in 2017-10-20
 */
@RequestMapping(value = "/addUser", method = RequestMethod.POST)
public Object addUser(User param){
    userService.insert(param);
        return new RespMessage(ErrorCode.E00000000.CODE,ErrorCode.E00000000.MSG,null).getRespMessage();
        }
        }