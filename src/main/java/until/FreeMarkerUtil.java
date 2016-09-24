package until;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
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
	
	public void createConfiguration() throws Exception{ 
		cfg = new Configuration(Configuration.VERSION_2_3_24);
		cfg.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		cfg.setLogTemplateExceptions(false);
	}
	
	public List<Field> getFields(){
		List<Field> fields = new ArrayList<>();
		Field field1 = new Field();
		field1.setName("logNr");
		field1.setType("Integer");
		Field field2 = new Field();
		field2.setName("type");
		field2.setType("String");
		fields.add(field1);
		fields.add(field2);
		return fields;
	}

	public Map<String, Object> createDataModel(){
		Map<String, Object> root = new HashMap<>();
		
		root.put("className", "actEvtLog");
		root.put("fields", getFields());
		return root;
	}
	
	public Map<String, Object> createMapperModel(){
		Map<String, Object> root = new HashMap<>();
		
		root.put("tableName", "ACT_EVT_LOG");
		root.put("fields", getFields());
		return root;
	}
	
	public Template getTemplate(){
		Template template = null;
		try {
			template = cfg.getTemplate("TBL.ftl");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return template;
	}
	
	
	public void process() throws TemplateException, IOException{
		Map<String, Object> dataModel = createDataModel();
		Template temp  = getTemplate();
		OutputStream  outputStream = new FileOutputStream(new File("src/main/resources/templates/actEvtLog.java"));
		Writer out = new OutputStreamWriter(outputStream);
		temp.process(dataModel, out);
	}
	
	
	public static void main(String[] args) throws Exception{
		File directory = new File("");
		System.out.println(directory.getCanonicalPath());
		System.out.println(System.getProperty("user.dir"));
		new FreeMarkerUtil().createConfiguration();
		new FreeMarkerUtil().process();
	}
	
	
	
	
	
	
}
