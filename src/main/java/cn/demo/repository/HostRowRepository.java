package cn.demo.repository;

import cn.demo.entity.HostRow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
/**
 * @author
 */
public interface HostRowRepository extends JpaRepository<HostRow, Long> {

    /**
     * xxx
     * @return
     */
    @Query(value="select * from `excel_tab` where to_days(update_date) = to_days(now());", nativeQuery = true)
    List<HostRow> findToday();

    /**
     * xxx
     * @param url
     * @return
     */
    HostRow findByUrl(String url);
}
