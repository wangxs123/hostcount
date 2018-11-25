package cn.shuangbofu.demo.service;

import cn.shuangbofu.demo.dto.HostRowDTO;

public interface HostRowService {

    int addHostRow(HostRowDTO hostRowDTO);

    void generateToday() throws Exception;

    boolean exists(String url);
}
