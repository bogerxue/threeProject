package com.shangma.service.impl;

import com.shangma.entity.PermissionRole;
import com.shangma.service.PermissionRoleService;
import com.shangma.service.base.impl.MyBaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wenbo
 * 2022/7/18
 */
@Service
@Transactional
public class PermissionRoleServiceImpl extends MyBaseServiceImpl<PermissionRole> implements PermissionRoleService {
}
