package cn.demo.service.impl;
import cn.demo.dto.HostRowDTO;
import cn.demo.entity.HostRow;
import cn.demo.repository.HostRowRepository;
import cn.demo.service.HostRowService;
import cn.demo.util.ExcelHandler;
import cn.demo.util.FilePathUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class HostRowServiceImpl implements HostRowService {

    @Autowired
    private HostRowRepository hostRowRepository;

    @Override
    public int addHostRow(HostRowDTO hostRowDTO) {

        HostRow hostRow = new HostRow();
        BeanUtils.copyProperties(hostRowDTO, hostRow);

        String url = hostRowDTO.getUrl();
        String hostType = url.replaceAll("([a-zA-z]+)://[^\\s]*", "$1");
        String host = url.replaceAll("[a-zA-z]+://([^\\s/$]*)[\\s\\S]*", "$1");
        String regex = url.replaceAll("[a-zA-z]+://[^\\s/$]*([\\s\\S]*)", "$1");
        hostRow.setHost(host);

        hostRow.setHostType(hostType);
        if(hostType.indexOf("s")==-1) {
            hostRow.setRegex(regex.replace("?", "\\?"));
        }
        hostRow.setStatus(1);
        hostRow.setUpdateDate(new Date());

       hostRowRepository.save(hostRow);

       return 1;
    }

    @Override
    public void generateToday() throws Exception {
       Date todayDate = Calendar.getInstance().getTime();
       List<HostRow> hostRowList = hostRowRepository.findToday();
       String fileName = new SimpleDateFormat("YYYYMMdd").format(todayDate);
        System.out.println(fileName);
       ExcelHandler.createExcel(FilePathUtil.getFilePath(fileName), hostRowList);
    }

    @Override
    public boolean exists(String url) {

        if("/".equals(url.substring(url.length()-1, url.length()))) {
            url = url.substring(0, url.length()-1);
        }

        HostRow hostRow = hostRowRepository.findByUrl(url);

        return hostRow!=null;
    }
}
