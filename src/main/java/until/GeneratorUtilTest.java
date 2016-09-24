package until;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
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
	private ColumnsService columnsService;
	@Autowired
	private UserService userService;
	
	@Test
	public List<ColumnsPo> getColumns(){
		ColumnsPo columnsPo = new ColumnsPo();
		columnsPo.setTableSchema("crawler");
		columnsPo.setTableName("crawl_info");
		List<ColumnsPo> columnPos = columnsService.list(columnsPo);
		return columnPos;
	/*	for(ColumnPo po:columnPos){
			System.out.println(po.toString());
		}*/
	}
	
	public List<Field> buildField(){
		List<ColumnsPo> columnPos = getColumns();
		List<Field> fields = new ArrayList<>();
		for(ColumnsPo columnPo:columnPos){
			Field field = new Field();
			field.setColumnName(columnPo.getColumnName());
			field.setColumnType(columnPo.getColumnType());
		}
		return fields;
	}
	
	/**
	 * 生成mapper.xml 文件
	 */
	public void generateMapper(){
		
	}
	
	/**
	 * 生成tbl java类文件
	 */
	public void generateTbl(String tableName){
		String path = "../tbl/"+tableName+"Tbl.java";
		File file = new File(path);
		try {
			file.createNewFile();
			OutputStream outputStream = new FileOutputStream(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 生成po
	 */
	public void generatePo(){
		
	}
	
	/**
	 * 生成dao
	 */
	public void generateDao(){
		
	}
	
	/**
	 * 生成Service
	 */
	public void generateService(){
		
	}
	
//	@Test
	public void getUser(){
		UserPo userPo =userService.getUserById("1");
		System.out.println(userPo.getName());
	}
	
	
	
	
	
	
	
	
	
	

}
















