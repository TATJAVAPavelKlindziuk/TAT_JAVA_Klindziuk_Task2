package com.klindziuk.offlinelibrary.controller.command;

import java.util.HashMap;

import javax.naming.OperationNotSupportedException;

import com.klindziuk.offlinelibrary.controller.Command;
import com.klindziuk.offlinelibrary.controller.command.admin.impl.AddBook;
import com.klindziuk.offlinelibrary.controller.command.admin.impl.BanUser;
import com.klindziuk.offlinelibrary.controller.command.admin.impl.DeleteBook;
import com.klindziuk.offlinelibrary.controller.command.admin.impl.DeleteBookById;
import com.klindziuk.offlinelibrary.controller.command.admin.impl.GetAllBooks;
import com.klindziuk.offlinelibrary.controller.command.admin.impl.GetAllSubscriptions;
import com.klindziuk.offlinelibrary.controller.command.admin.impl.GetAllUsers;
import com.klindziuk.offlinelibrary.controller.command.admin.impl.GetUser;
import com.klindziuk.offlinelibrary.controller.command.admin.impl.GiveAdminRole;
import com.klindziuk.offlinelibrary.controller.command.admin.impl.MarkIssuance;
import com.klindziuk.offlinelibrary.controller.command.admin.impl.MarkReturn;
import com.klindziuk.offlinelibrary.controller.command.admin.impl.RemoveAdminRole;
import com.klindziuk.offlinelibrary.controller.command.admin.impl.SetBookDeprecated;
import com.klindziuk.offlinelibrary.controller.command.admin.impl.UnBanUser;
import com.klindziuk.offlinelibrary.controller.command.admin.impl.UpdateBookDescription;
import com.klindziuk.offlinelibrary.controller.command.library.impl.FindByAuthor;
import com.klindziuk.offlinelibrary.controller.command.library.impl.FindByName;
import com.klindziuk.offlinelibrary.controller.command.library.impl.GetBook;
import com.klindziuk.offlinelibrary.controller.command.library.impl.GetUserBooks;

public enum AdminCommandName {	

		ADDBOOK(new AddBook()),
		SETBOOKDEPRECATED(new SetBookDeprecated()),
		DELETEBOOK(new DeleteBook()),
		DELETEBOOKBYID(new DeleteBookById ()),
		GIVEADMINROLE(new GiveAdminRole()),
		REMOVEADMINROLE(new RemoveAdminRole()),
		BANUSER(new BanUser()),
		UNBANUSER(new UnBanUser()),
		MARKISSUANCE(new MarkIssuance()),
		MARKRETURN(new MarkReturn()),
		UPDATEBOOKDESCRIPTION(new UpdateBookDescription()),
		GETBOOK(new GetBook()),
	    GETALLBOOKS(new GetAllBooks()),
	    GETUSERBOOKS(new GetUserBooks()),
	    FINDBYNAME(new FindByName()),
	    FINDBYAUTHOR(new FindByAuthor()),
		GETUSER(new GetUser()),
		GETALLUSERS(new GetAllUsers()),
		GETALLSUBSCRIPTIONS(new GetAllSubscriptions());
	    
		private static final String UNSUPPORTED_OPERATION_MESSAGE = " - this command unfortunately unsupported.";
		private Command command;
	    private static HashMap<String, Command> adminCommandMap;

	    static {
	        adminCommandMap = new HashMap<>();
	        for (AdminCommandName s : AdminCommandName.values())
	            adminCommandMap.put(s.name().toUpperCase(), s.command);
	    }

	    AdminCommandName(Command command) {
	        this.command = command;
	    }

	    public static Command getCommandByName(String name) throws OperationNotSupportedException {
	    	if(!adminCommandMap.containsKey(name.toUpperCase()) || name.isEmpty())  {
	        	 throw new OperationNotSupportedException(name + UNSUPPORTED_OPERATION_MESSAGE );
	        }
	        return adminCommandMap.get(name.toUpperCase());
	    }
	}


