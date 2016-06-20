package crawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class PDFReader {
	
	static String pdfPath ="c:\\Redis in Action.pdf";
	static String textPath ="c:\\words.txt";
	static String cet4Path = "C:\\cet4.txt";
	public static List<String> readPDF() throws Exception{
		Writer outputStream =null;
		PDDocument document =null;
		String[] wordArrys = null;
		List<String> wordList = new ArrayList<String>();
		Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
		try {
			outputStream = new OutputStreamWriter(new FileOutputStream(new File(textPath)));
			document = PDDocument.load(new File(pdfPath));
			document.getClass();
			if(!document.isEncrypted()){
				PDFTextStripperByArea stripperByArea = new PDFTextStripperByArea();
				stripperByArea.setSortByPosition(true);
				PDFTextStripper stripper = new PDFTextStripper();
				stripper.setStartPage(1);
				stripper.setEndPage(8);
				stripper.writeText(document, outputStream);
				String st = stripper.getText(document);
				wordArrys = st.split("\\s+");
				for(String word:wordArrys){
					if(pattern.matcher(word).matches() && word.length()>3 && word.length()<10) {
						if(word.endsWith("ing")) word =word.replace("ing", "");
						if(word.endsWith("ed")) word =word.replace("ed", "");
							wordList.add(word.toLowerCase());
					}
				}
				return wordList;
//				System.out.println("text:"+st);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(outputStream!=null) {outputStream.flush();outputStream.close();}
			if(document!=null) document.close();
		}
		return null;
	}
	
	public static List<String> filterWords() throws Exception{
		Reader reader  =null;
		BufferedReader bufferedReader=null;
		Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
		List<String> cetList  = new ArrayList<String>();
		try {
			reader = new InputStreamReader(new FileInputStream(new File(cet4Path)), "GBK");
			bufferedReader = new BufferedReader(reader);
			String line = null;
			String word = "";
			while((line=bufferedReader.readLine())!=null){
				word = line.trim().split("\\s+")[0];
				if(pattern.matcher(word).matches() && word.length()>2 && word.length()<10) cetList.add(word.toLowerCase());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(bufferedReader!=null) bufferedReader.close();
			if(reader!=null) reader.close();
		}
		return cetList;
	}
	
	public static void main(String[] args) throws Exception{
		List<String> wordList = readPDF();
		System.out.println("befor:"+wordList.size());
		if(wordList!=null && wordList.size()>0){
			wordList.removeAll(filterWords());
		}
		System.out.println("数量："+wordList.size());
		for(String s:wordList) System.out.println(s);
//		filterWords();
	}
	

}
