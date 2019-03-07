package com.xiaonei.service.imp;

import org.springframework.transaction.annotation.Transactional;

import com.xiaonei.basic.BasicService;
import com.xiaonei.service.interfaces.MessageServiceInter;
@Transactional
public class MessageService extends BasicService implements MessageServiceInter {

}
