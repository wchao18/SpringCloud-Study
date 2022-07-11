package com.it;

import com.alibaba.fastjson.JSON;
import com.it.dao.IDeptDAO;
import com.it.vo.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author wangchao
 * @description TODO
 * @date 2019/08/29 16:50
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestApplication {

    @Autowired
    private IDeptDAO deptDAO;

    @Test
    public void testGetList() {
        List<Dept> all = deptDAO.findAll();
        System.out.println(JSON.toJSONString(all));
    }

}
