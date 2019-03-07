package com.xiaonei.service.imp;

import org.springframework.transaction.annotation.Transactional;

import com.xiaonei.basic.BasicService;
import com.xiaonei.service.interfaces.UserServiceInter;

@Transactional
public class UserService extends BasicService implements UserServiceInter {

}
