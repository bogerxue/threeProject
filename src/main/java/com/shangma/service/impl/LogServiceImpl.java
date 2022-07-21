package com.shangma.service.impl;

import com.shangma.entity.LogEntity;
import com.shangma.service.LogService;
import com.shangma.service.base.impl.MyBaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author BOGEY
 * 2022/7/21  10:19
 */
@Service
@Transactional
public class LogServiceImpl extends MyBaseServiceImpl<LogEntity> implements LogService {
}
