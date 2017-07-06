import java.io.IOException;

import com.klindziuk.offlinelibrary.controller.Controller;
import com.klindziuk.offlinelibrary.controller.util.RequestParser;
import com.klindziuk.offlinelibrary.dao.exception.DAOException;
import com.klindziuk.offlinelibrary.service.exception.ServiceException;

public class LibServiceMain {

	public static void main(String[] args) throws ServiceException, DAOException, IOException {

//	String request = RequestParser.readFile("requests/clientservice/signin.xml"); 
//	System.out.println(new Controller().executeClientTask(request));
//	
////	String request1 = Parser.readFile("requests/clientservice/registration.xml"); 
////	System.out.println(new Controller().executeClientTask(request1));
//	
//	String request2 = RequestParser.readFile("requests/clientservice/getallbooks.xml");
//	System.out.println(new Controller().executeClientTask(request2));
//	
	String request3 = RequestParser.readFile("requests/libraryservice/addbooktowishlist.xml");
	System.out.println(new Controller().executeLibraryTask(request3));
	
	String request4 = RequestParser.readFile("requests/libraryservice/removebookfromwishlist.xml");
	System.out.println(new Controller().executeLibraryTask(request4));
	
	String request5 = RequestParser.readFile("requests/libraryservice/updateprofile.xml");
	System.out.println(new Controller().executeLibraryTask(request5));
	
	String request6 = RequestParser.readFile("requests/libraryservice/getbook.xml");
	System.out.println(new Controller().executeLibraryTask(request6));
	
	String request7 = RequestParser.readFile("requests/libraryservice/getallbooks.xml");
	System.out.println(new Controller().executeLibraryTask(request7));
	
	String request8 = RequestParser.readFile("requests/libraryservice/getuserbooks.xml");
	System.out.println(new Controller().executeLibraryTask(request8));
	
	String request9 = RequestParser.readFile("requests/libraryservice/findbyname.xml");
	System.out.println(new Controller().executeLibraryTask(request9));
	
	String request10 = RequestParser.readFile("requests/libraryservice/findbyauthor.xml");
	System.out.println(new Controller().executeLibraryTask(request10));
	
	String request11 = RequestParser.readFile("requests/libraryservice/emptycommand.xml");
	System.out.println(new Controller().executeLibraryTask(request11));
	}
}

