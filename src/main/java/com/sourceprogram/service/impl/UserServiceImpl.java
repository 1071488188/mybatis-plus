package com.sourceprogram.service.impl;

import com.sourceprogram.entity.User;
import com.sourceprogram.mapper.UserMapper;
import com.sourceprogram.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jiangjunjie
 * @since 2017-10-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	
}
