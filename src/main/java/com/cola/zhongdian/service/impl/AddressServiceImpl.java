package com.cola.zhongdian.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cola.zhongdian.domain.Address;
import com.cola.zhongdian.mapper.AddressMapper;
import com.cola.zhongdian.service.AddressService;
import org.springframework.stereotype.Service;


@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {

}
