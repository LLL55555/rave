package com.cola.zhongdian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cola.zhongdian.domain.User;
import com.cola.zhongdian.mapper.UserMapper;
import com.cola.zhongdian.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    @Override
    public List getUserListByLambda(Object[] ids) {

        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery(User.class).in(User::getId, ids);
        List<User> list = this.list(wrapper);
        return list;
    }

    @Override
    public List getUserListByLambda02(List<Integer> ids) {
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery(User.class).in(User::getId, ids);
        List<User> list = this.list(wrapper);
        return list;
    }
}
