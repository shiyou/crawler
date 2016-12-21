package until.codeGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	public static void createConfiguration(){ 
		cfg = new Configuration(Configuration.VERSION_2_3_24);
		try {
			cfg.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			cfg.setLogTemplateExceptions(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 生成数据模型
	 * @return
	 */
	public static Map<String, Object> createDataModel(){
		Map<String, Object> root = new HashMap<>();
		List<RawField> rawFields = DataBuilder.getRawFields(); 
		RawObject rawObject = DataBuilder.getRawObject();
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
	 * 生成文件
	 * @param templateName
	 */
	public static void process(String templateName,String fileName){
		createConfiguration();
		Map<String, Object> dataModel = createDataModel();
		Template temp  = getTemplate(templateName);
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream(new File(fileName));
			Writer out = new OutputStreamWriter(outputStream);
			temp.process(dataModel, out);
		} catch (TemplateException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成mapper文件
	 * @param name crawlerInfo
	 * @throws TemplateException
	 * @throws IOException
	 */
	public static void processMapper(String templateName){
		createConfiguration();
		Map<String, Object> dataModel = createDataModel();
		Template temp  = getTemplate(templateName);
		String fileName = PropertyUtil.getPropValue("mapperUrL")+((RawObject)dataModel.get("rawObject")).getName()+"Mapper.xml";
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream(new File(fileName));
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
	public static void processTbl(String templateName){
		createConfiguration();
		Map<String, Object> dataModel = createDataModel();
		Template temp  = getTemplate(templateName);
		String fileName = PropertyUtil.getPropValue("tblUrl")+((RawObject)dataModel.get("rawObject")).getName()+"Tbl.java";
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream(new File(fileName));
			Writer out = new OutputStreamWriter(outputStream);
			temp.process(dataModel, out);
		} catch (TemplateException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成DAO文件
	 * @param templateName
	 */
	public static void processDao(String templateName){
		createConfiguration();
		Map<String, Object> dataModel = createDataModel();
		Template temp  = getTemplate(templateName);
		String fileName = PropertyUtil.getPropValue("tblUrl")+((RawObject)dataModel.get("rawObject")).getName()+"Tbl.java";
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream(new File(fileName));
			Writer out = new OutputStreamWriter(outputStream);
			temp.process(dataModel, out);
		} catch (TemplateException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception{
//		FreeMarkerUtil.processTbl("TBL.ftl");
		FreeMarkerUtil.processMapper("Mapper.ftl");
	}
	
}
