package cn.demo.service;

import cn.demo.dto.HostRowDTO;
/**
 * @author
 */
public interface HostRowService {

    /**
     * xx
     * @param hostRowDTO
     * @return
     */
    int addHostRow(HostRowDTO hostRowDTO);

    /**
     * xx
     * @throws Exception
     */
    void generateToday() throws Exception;

    /**
     * xx
     * @param url
     * @return
     */
    boolean exists(String url);
}
