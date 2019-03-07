package com.xiaonei.service.imp;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xiaonei.basic.BasicService;
import com.xiaonei.service.interfaces.CountryServiceInter;
@Transactional
public class CountryService  extends BasicService implements CountryServiceInter {
}
