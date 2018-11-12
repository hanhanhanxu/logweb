package hx.insist.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlUtils {
	
	private static String filepath;
	static {
		filepath = XmlUtils.class.getClassLoader().getResource("users.xml").getPath();//获得目标文件的路径信息
	}
	
	//得到文档
	public static Document getDocument() throws DocumentException {
		//获取文件的document(文档解析器)
		 SAXReader reader = new SAXReader();
	     Document document = reader.read(new File(filepath));
	     return document;
	}
	//写入信息
	public static  void write2Xml(Document document) throws IOException {
		 // Pretty print the document to System.out
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        XMLWriter writer = new XMLWriter(new FileOutputStream(filepath), format);//给一个输出流   写到哪里去    format格式化输出器
        writer.write( document );
        writer.close();
	}
}
