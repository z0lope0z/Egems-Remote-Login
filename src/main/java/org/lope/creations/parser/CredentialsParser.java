package org.lope.creations.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lope.creations.model.EgemsUser;

import au.com.bytecode.opencsv.CSVReader;

public class CredentialsParser {

	public static List<EgemsUser> getCredentialsCSVList(String path) throws FileNotFoundException{
		List<EgemsUser> egemsUserList = new ArrayList<EgemsUser>();
		CSVReader reader = new CSVReader(new FileReader(path));
	    String [] nextLine;
	    try {
			while ((nextLine = reader.readNext()) != null) {
			    System.out.println("Reading Line : " + nextLine[0] + nextLine[1] + "etc...");
			    EgemsUser egemsUser = new EgemsUser(nextLine[0], nextLine[1]);
			    egemsUserList.add(egemsUser);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return egemsUserList;
	}
}
