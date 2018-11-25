package cn.shuangbofu.demo.repository;

import cn.shuangbofu.demo.entity.HostRow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HostRowRepository extends JpaRepository<HostRow, Long> {

    @Query(value="select * from `excel_tab` where to_days(update_date) = to_days(now());", nativeQuery = true)
    List<HostRow> findToday();

    HostRow findByUrl(String url);
}
