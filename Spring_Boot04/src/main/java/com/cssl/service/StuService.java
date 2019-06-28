package com.cssl.service;

import com.cssl.dao.StuDao;
import com.cssl.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StuService {

    public List<Student> selectAll();

}
