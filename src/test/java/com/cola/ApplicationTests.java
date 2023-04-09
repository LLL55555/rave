package com.cola;


import com.cola.zhongdian.Application;
import com.cola.zhongdian.service.AddressService;
import com.cola.zhongdian.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application.class)
public class ApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;


    @Test
    public void testAddress() {
        System.out.println(addressService.list());
    }

    @Test
    public  void testWrapper(String a) {

        boolean notEmpty = StringUtils.isNotEmpty(a);
//
//        this.addressService.
//                        Wrappers.lambdaUpdate(Address.class).;
//        Wrappers.lambdaQuery(Address.class)
//                .in()
//                .eq()
//                .select()
//                .likeRight()
//                .like()
//                .having()
//                .gt()
//                .ge()
//                .orderByDesc()
//                .eq()
//                .orderByDesc()


    }


}
