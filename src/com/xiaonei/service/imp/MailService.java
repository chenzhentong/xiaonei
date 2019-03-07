package com.xiaonei.service.imp;

import org.springframework.transaction.annotation.Transactional;

import com.xiaonei.basic.BasicService;
import com.xiaonei.service.interfaces.MailServiceInter;
@Transactional
public class MailService extends BasicService implements MailServiceInter {

}
