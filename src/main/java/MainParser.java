import java.io.IOException;
import java.util.Arrays;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.klindziuk.offlinelibrary.controller.util.RequestParser;

public class MainParser {
	
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException{
		String xml = RequestParser.readFile("requests/signin.xml");
		System.out.println(xml);
		System.out.println(RequestParser.getCommand(xml));
		System.out.println(Arrays.toString(RequestParser.getCredentials(xml)));
	}
}
