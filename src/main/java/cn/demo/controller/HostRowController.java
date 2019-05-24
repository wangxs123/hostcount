package cn.demo.controller;

import cn.demo.dto.HostRowDTO;
import cn.demo.service.HostRowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 */
@RestController
public class HostRowController {

    @Autowired
    private HostRowService hostRowService;

    @PostMapping("/add")
    public int add(@RequestBody HostRowDTO hostRowDTO) {

        int res = hostRowService.addHostRow(hostRowDTO);

        return res;
    }

    @GetMapping("/generate_today")
    public String generateToday() throws Exception {
       hostRowService.generateToday();
       return "";
    }

    @PostMapping("/exist")
    public boolean HostIsExist(String url) {
        return hostRowService.exists(url);
    }
}
