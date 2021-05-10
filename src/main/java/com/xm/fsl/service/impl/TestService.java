package com.xm.fsl.service.impl;

import com.xm.fsl.annotation.ServiceLog;
import com.xm.fsl.service.ILogService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TestService implements ILogService {


    @ServiceLog(operation = "新增用户信息测试操作")
    @Override
    public boolean insert(Map<String, Object> params, String id) {
        System.out.println("id: "+id);
        System.out.println("新增用户信息测试操作");
        return false;
    }

    @ServiceLog(operation = "更新用户信息操作....")
    @Override
    public boolean update(String name, String id) {
        System.out.println("更新用户信息操作");
        return false;
    }

    @ServiceLog(operation = "删除操作。。。。")
    @Override
    public boolean delete(String id) {
        System.out.println("删除操作");
        return false;
    }

    @ServiceLog(operation = "异常操作测试",level = ServiceLog.LogType.ERROR)
    @Override
    public boolean doError(String id) {
        System.out.println("异常操作测试");
        return false;
    }
}
