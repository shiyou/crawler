package study.designModel;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputTest {

	public static void main(String[] args) throws IOException{
		int c;
		InputStream inputStream = new LowerCaseInputstream(new BufferedInputStream(
				new FileInputStream("E:\\Code\\crawler\\target\\classes\\study\\designModel/test.txt")));
		
		while((c=inputStream.read())>=0){
			System.out.print((char)c);
		}
		inputStream.close();
	}
}
