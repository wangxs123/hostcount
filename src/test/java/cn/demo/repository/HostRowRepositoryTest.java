package cn.demo.repository;

import cn.demo.entity.HostRow;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HostRowRepositoryTest {

    @Autowired
    private HostRowRepository hostRowRepository;

    @Test
    public void testHostRowRepositoryTest() {
        hostRowRepository.save(new HostRow());
        List<HostRow> hostRowList = hostRowRepository.findAll();
        System.out.println(hostRowList);
    }

    @Test
    public void findAllByUpdateDateTest() {
        List<HostRow> hostRows = hostRowRepository.findToday();
        System.out.println(hostRows.size());
    }

}