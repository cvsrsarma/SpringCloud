package com.claimvantage.Style;
 
import java.io.*;
import java.util.*;
 
public class UserManager {
    private HashMap<String, String> fullNames;
    
    private int initialCapacity =0;
 
    public UserManager(final int InitialCapacity) {
        super();
        this.fullNames = new HashMap<String, String>(InitialCapacity);
        this.initialCapacity= InitialCapacity;
    }
 
    public void add(final String username, final String fullName) {
    	if(fullNames.size()<initialCapacity)
    		this.fullNames.put(username, fullName);
    	else
    		System.out.println("You cant add another user. Map initial capacity maxed out");
        
    }
 
    public boolean hasUser(final String username) {
        if (this.fullNames.containsKey(username)) {
            return true;
        }
        else {
            return false;
        }
    }
 
    public void printUsernamesToFile(final File file) {
        try {
            final Writer writer = new FileWriter(file);
 
            Iterator<String> usernames = this.fullNames.keySet().iterator();
            while (usernames.hasNext()) {
                final String username = usernames.next();
                writer.write(username);
            }
 
            writer.close();
        }
        catch (IOException e) {
        }
    }
 
    public boolean equals(Object o) {
        if (o == null) {
        return false;
        }
 
        if (!(o instanceof UserManager)) {
            return false;
        }
 
        final UserManager n = (UserManager) o;
        return this.fullNames.equals(n.fullNames);
    }
    
    public static void main(String rags[]) {
    	
    	UserManager um = new UserManager(5);
    	um.add("a", "a1");
    	um.add("a1","a1");
    	um.add("a", "a2");
    	um.add("a3","a3");
    	um.add("a2","a3");
    	um.add("a5","a3");
      	um.add("a6","a3");
    	um.hasUser("a3");
    	File file = new File("test.txt");
    	um.printUsernamesToFile(file);
    	
    }
}

