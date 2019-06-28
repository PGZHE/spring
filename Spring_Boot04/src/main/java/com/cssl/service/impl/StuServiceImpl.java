package com.cssl.service.impl;

import com.cssl.dao.StuDao;
import com.cssl.pojo.Student;
import com.cssl.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuDao sdao;//持有dao层引用

    public List<Student> selectAll(){
        return sdao.selectAll();
    }

}
