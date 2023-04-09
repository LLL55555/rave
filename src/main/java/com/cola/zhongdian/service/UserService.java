package com.cola.zhongdian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cola.zhongdian.domain.User;

import java.util.List;

public interface UserService extends IService<User> {
    List getUserListByLambda(Object[] ids);

    List getUserListByLambda02(List<Integer> ids);
}
