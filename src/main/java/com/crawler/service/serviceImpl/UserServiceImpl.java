package com.crawler.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crawler.dao.UserDao;
import com.crawler.po.UserPo;
import com.crawler.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    public UserPo getUserById(String id) {
        return this.userDao.getUserById(id);
    }

    public List<UserPo> getUser() {
        return this.userDao.getUser();
    }

    public int add(UserPo userPo) {
        return this.userDao.add(userPo);
    }

}
