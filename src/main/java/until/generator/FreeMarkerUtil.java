package until.generator;

import java.io.File;
import java.io.FileNotFoundException;
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
	public static Map<String, Object> createDataModel(String fileURL){
		Map<String, Object> root = new HashMap<String,Object>();
		List<RawField> rawFields = DataBuilder.getRawFields(); 
		RawObject rawObject = DataBuilder.getRawObject(fileURL);
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
		Map<String, Object> dataModel = createDataModel(templateName);
		Template temp  = getTemplate(templateName);
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream(new File(fileName));
			Writer out = new OutputStreamWriter(outputStream);
			temp.process(dataModel, out);
		} catch (TemplateException  e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成mapper文件
	 * @throws TemplateException
	 * @throws IOException
	 */
	public static void processMapper(String templateName){
		createConfiguration();
		Map<String, Object> dataModel = createDataModel(templateName);
		Template temp  = getTemplate(templateName);
		String fileName = PropertyUtil.getPropValue("mapperUrL")+((RawObject)dataModel.get("rawObject")).getName()+"Mapper.xml";
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream(new File(fileName));
			Writer out = new OutputStreamWriter(outputStream);
			temp.process(dataModel, out);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成tbl文件
	 * @param templateName
	 */
	public static void processTbl(String templateName){
		createConfiguration();
		Map<String, Object> dataModel = createDataModel(templateName);
		Template temp  = getTemplate(templateName);
		String fileName = PropertyUtil.getPropValue("tblUrl")+((RawObject)dataModel.get("rawObject")).getName()+".java";
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream(new File(fileName));
			Writer out = new OutputStreamWriter(outputStream);
			temp.process(dataModel, out);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成PO文件
	 * @param templateName
	 */
	public static void processPo(String templateName){
		createConfiguration();
		Map<String, Object> dataModel = createDataModel(templateName);
		Template temp  = getTemplate(templateName);
		String fileName = PropertyUtil.getPropValue("poUrl")+((RawObject)dataModel.get("rawObject")).getName()+"Po.java";
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream(new File(fileName));
			Writer out = new OutputStreamWriter(outputStream);
			temp.process(dataModel, out);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成DAO文件
	 * @param templateName
	 */
	public static void processDao(String templateName){
		createConfiguration();
		Map<String, Object> dataModel = createDataModel(templateName);
		Template temp  = getTemplate(templateName);
		String fileName = PropertyUtil.getPropValue("daoUrl")+((RawObject)dataModel.get("rawObject")).getName()+"Dao.java";
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream(new File(fileName));
			Writer out = new OutputStreamWriter(outputStream);
			temp.process(dataModel, out);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 共用生成器
	 * @param templateName
	 */
	public static void commonProcess(String templateName){
		createConfiguration();
		Template temp  = getTemplate(templateName);
		String nameSuffix ="";
		if(templateName.toLowerCase().contains("mapper")){
			nameSuffix = templateName.substring(0, 1).toUpperCase().concat(templateName.substring(1,templateName.length()).replace(".ftl", ".xml"));
		}else{
			nameSuffix = templateName.substring(0, 1).toUpperCase().concat(templateName.substring(1,templateName.length()).replace(".ftl", ".java"));
		}
		String fileNameUrl =  PropertyUtil.getPropValue(templateName.replace(".ftl", "Url"));
		Map<String, Object> dataModel = createDataModel(fileNameUrl);
		String fileName = fileNameUrl + ((RawObject)dataModel.get("rawObject")).getName()+nameSuffix;
		System.out.println(PropertyUtil.getPropValue("mapperUrl"));
		OutputStream outputStream;
		try {
			if(fileName.contains("Obj")) {
				fileName = fileName.replace("Obj", "");
			}
			outputStream = new FileOutputStream(new File(fileName));
			Writer out = new OutputStreamWriter(outputStream);
			temp.process(dataModel, out);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
	
	
	public static String getPackageName(String className){
		String pageName  = null;
		try {
			 pageName = Class.forName(className).getPackage().getName();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return pageName;
	}
	
	public static void main(String[] args) throws Exception{
	/*	FreeMarkerUtil.processMapper("mapper.ftl");
//		FreeMarkerUtil.processTbl("tbl.ftl");
//		FreeMarkerUtil.processPo("po.ftl");*/
//		FreeMarkerUtil.commonProcess("mapper.ftl");
//		String[] ftls = {"obj.ftl"};
//		System.out.print(getPackageName("RawObject"));
		String[] ftls = {"mapper.ftl","obj.ftl"};
		for(String ftl:ftls){
			FreeMarkerUtil.commonProcess(ftl);
		}
		
	}
}

