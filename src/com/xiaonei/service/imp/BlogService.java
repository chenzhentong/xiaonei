package com.xiaonei.service.imp;

import org.springframework.transaction.annotation.Transactional;

import com.xiaonei.basic.BasicService;
import com.xiaonei.service.interfaces.BlogServiceInter;
@Transactional
public class BlogService extends BasicService implements BlogServiceInter {

}
