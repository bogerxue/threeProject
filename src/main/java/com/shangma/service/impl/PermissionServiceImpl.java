package com.shangma.service.impl;

import com.shangma.entity.Permission;
import com.shangma.service.PermissionService;
import com.shangma.service.base.impl.MyBaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wenbo
 * 2022/7/17
 */
@Service
@Transactional
public class PermissionServiceImpl extends MyBaseServiceImpl<Permission> implements PermissionService {
}
