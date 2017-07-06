import java.io.IOException;

import com.klindziuk.offlinelibrary.controller.Controller;
import com.klindziuk.offlinelibrary.controller.util.RequestParser;
import com.klindziuk.offlinelibrary.dao.exception.DAOException;
import com.klindziuk.offlinelibrary.dao.impl.SQLBookDAO;
import com.klindziuk.offlinelibrary.dao.impl.SQLUserDAO;

public class AdminMain {
	static SQLUserDAO admin = new SQLUserDAO();	
	static SQLBookDAO book = new SQLBookDAO();	

	public static void main(String[] args) throws DAOException, IOException {
			
		String request = RequestParser.readFile("requests/adminservice/getallusers.xml"); 
		System.out.println(new Controller().executeAdminTask(request));
		
		String request1 = RequestParser.readFile("requests/adminservice/getuserbooks.xml"); 
		System.out.println(new Controller().executeAdminTask(request1));
		
		String request2 = RequestParser.readFile("requests/adminservice/findbyname.xml"); 
		System.out.println(new Controller().executeAdminTask(request2));
		
		String request3 = RequestParser.readFile("requests/adminservice/findbyauthor.xml"); 
		System.out.println(new Controller().executeAdminTask(request3));
		
		String request4 = RequestParser.readFile("requests/adminservice/getallbooks.xml"); 
		System.out.println(new Controller().executeAdminTask(request4));
		
//		String request5 = Parser.readFile("requests/adminservice/addbook.xml"); 
//		System.out.println(new Controller().executeAdminTask(request5));
		
		System.out.println(new Controller().executeAdminTask(request4));
		
		String request6 = RequestParser.readFile("requests/adminservice/setbookdeprecated.xml"); 
		System.out.println(new Controller().executeAdminTask(request6));
		
		System.out.println(new Controller().executeAdminTask(request4));
		
		String request7 = RequestParser.readFile("requests/adminservice/deletebookbyid.xml"); 
		System.out.println(new Controller().executeAdminTask(request7));
		
		System.out.println(new Controller().executeAdminTask(request4));
		
		String request8 = RequestParser.readFile("requests/adminservice/deletebook.xml"); 
		System.out.println(new Controller().executeAdminTask(request8));
		
		System.out.println(new Controller().executeAdminTask(request4));
		
		System.out.println(new Controller().executeAdminTask(request));
		
		String request9 = RequestParser.readFile("requests/adminservice/banuser.xml"); 
		System.out.println(new Controller().executeAdminTask(request9));
		
		System.out.println(new Controller().executeAdminTask(request));
		
		String request10 = RequestParser.readFile("requests/adminservice/unbanuser.xml"); 
		System.out.println(new Controller().executeAdminTask(request10));
		
		System.out.println(new Controller().executeAdminTask(request));
		
		String request11 = RequestParser.readFile("requests/adminservice/giveadminrole.xml"); 
		System.out.println(new Controller().executeAdminTask(request11));
		
		System.out.println(new Controller().executeAdminTask(request));
		
		String request12 = RequestParser.readFile("requests/adminservice/removeadminrole.xml"); 
		System.out.println(new Controller().executeAdminTask(request12));
		
		System.out.println(new Controller().executeAdminTask(request));
		
		System.out.println(new Controller().executeAdminTask(request4));
		String request13 = RequestParser.readFile("requests/adminservice/updatebookdescription.xml"); 
		System.out.println(new Controller().executeAdminTask(request13));
		System.out.println(new Controller().executeAdminTask(request4));
		
		
		String request14 = RequestParser.readFile("requests/adminservice/getallsubscriptions.xml"); 
		System.out.println(new Controller().executeAdminTask(request14));
		
		String request15 = RequestParser.readFile("requests/adminservice/markissuance.xml");
		System.out.println(new Controller().executeAdminTask(request15));
		
//		String request16 = Parser.readFile("requests/adminservice/markreturn.xml");
//		System.out.println(new Controller().executeAdminTask(request16));
		
		System.out.println(new Controller().executeAdminTask(request14));
}
}

	
	
     
	

