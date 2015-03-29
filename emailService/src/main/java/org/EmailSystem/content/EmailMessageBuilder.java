package org.EmailSystem.content;

public class EmailMessageBuilder {
	

	public String getWelcomeSubject()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Welcome to awesomeness");
		return sb.toString();
	}

	
	public String getWelcomeBody(String firstName, String lastName){
		StringBuilder sb = new StringBuilder();
		sb.append("Hey");
		sb.append(" " +firstName+" "+lastName);
		sb.append("\n"+"\n"+ "Cheers to joining us!");
		sb.append("\n"+"\n" + "Regards");
		sb.append("\n");
		sb.append("Awesomeness Team");
		
		return sb.toString();
	}

}
