package cn.shuangbofu.demo.util;

import cn.shuangbofu.demo.entity.HostRow;
import cn.shuangbofu.demo.repository.HostRowRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ExcelHandlerTest {

    @Autowired
    private HostRowRepository hostRowRepository;

    @Test
    public void createExcelTest() {
        try {
           List<HostRow> rows = hostRowRepository.findAll();

            ExcelHandler.createExcel("C:\\Users\\GUI\\Desktop\\新建文件夹\\out\\out.xls", rows);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readExcelTest() {
        List<HostRow> hostRows = ExcelHandler.readExcel("C:\\Users\\GUI\\Desktop\\host-ynt.xls");
        hostRows.forEach(hostRow -> {
            hostRowRepository.save(hostRow);
        });
    }
}