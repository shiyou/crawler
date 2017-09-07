package until;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.crawler.po.ColumnsPo;
import com.crawler.po.UserPo;
import com.crawler.service.ColumnsService;
import com.crawler.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"../spring-mybatis.xml"})
public class GeneratorUtilTest {

    @Autowired
    private ColumnsService columnService;
    @Autowired
    private UserService userService;

    @Test
    public void getColumn() {
        ColumnsPo columnPo = new ColumnsPo();
        columnPo.setTableSchema("crawler");
        columnPo.setTableName("crawl_info_");
        List<ColumnsPo> columnPos = columnService.list(columnPo);
        for (ColumnsPo po : columnPos) {
            System.out.println(po.toString());
        }
    }

    /**
     * 生成mapper.xml 文件
     */
    public void generateMapper() {

    }

    /**
     * 生成tbl java类文件
     */
    public void generateTbl(String tableName) {
        String path = "../tbl/" + tableName + "Tbl.java";
        File file = new File(path);
        try {
            file.createNewFile();
            OutputStream outputStream = new FileOutputStream(file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //	@Test
    public void getUser() {
        UserPo userPo = userService.getUserById("1");
        System.out.println(userPo.getName());
    }


}
















