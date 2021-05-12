package com.xm.fsl.service;

import java.util.Map;

public interface ILogService {

    boolean insert(Map<String, Object> params, String id);

    boolean update(String name, String id);

    boolean delete(String id);

    boolean doError(String id);

}
