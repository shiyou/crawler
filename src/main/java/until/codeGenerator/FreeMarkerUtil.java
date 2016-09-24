package until.codeGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.asm.Type;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import until.PropertyUtil;

/**
 * @author hjd
 * @date 2016年9月19日
 */
public class FreeMarkerUtil {
	
	private static Configuration cfg;
	
	public void createConfiguration() throws Exception{ 
		cfg = new Configuration(Configuration.VERSION_2_3_24);
		cfg.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		cfg.setLogTemplateExceptions(false);
	}
	
	
	/**
	 * 生成数据模型
	 * @return
	 */
	public static Map<String, Object> createDataModel(){
		Map<String, Object> root = new HashMap<>();
		RawObject rawObject = DataBuilder.getRawObject(DataBuilder.queryTableInfo(PropertyUtil.getPropValue("")));
		List<RawField> rawFields = DataBuilder.getRawFields(DataBuilder.queryColumnInfo(PropertyUtil.getPropValue(""))); 
		root.put("rawObject", rawObject);
		root.put("rawFields", rawFields);
		return root;
	}
	
	
	/**
	 * 获取模板
	 * @param name
	 * @return
	 */
	public static Template getTemplate(String name){
		Template template = null;
		try {
			template = cfg.getTemplate(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return template;
	}
	
	/**
	 * 生成mapper文件
	 * @param name crawlerInfo
	 * @throws TemplateException
	 * @throws IOException
	 */
	public static void processMapper(String templateName){
		Map<String, Object> dataModel = createDataModel();
		Template temp  = getTemplate(templateName);
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream(new File(PropertyUtil.getPropValue("mapperUrL")+((RawObject)dataModel.get("rawObject")).getName()+"Mapper.xml"));
			Writer out = new OutputStreamWriter(outputStream);
			temp.process(dataModel, out);
		} catch (TemplateException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成tbl文件
	 * @param templateName
	 */
	public void processTbl(String templateName){
		Map<String, Object> dataModel = createDataModel();
		Template temp  = getTemplate(templateName);
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream(new File(PropertyUtil.getPropValue("tblUrl")+""+"tbl.java"));
			Writer out = new OutputStreamWriter(outputStream);
			temp.process(dataModel, out);
		} catch (TemplateException | IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		FreeMarkerUtil.processMapper("Mapper.ftl");
	}
	
	
	
	
	
	
}
