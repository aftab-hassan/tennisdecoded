/*
 * App.java
 * 
 * Copyright (c) 2017 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package ATP;

import java.io.FileNotFoundException;

/**
 * @author aftabhassan
 *
 */
public class App {
    public static void main(String[] args) {
        StatsLibrary obj = new StatsLibrary();
        
        try
        {
            /* get serve stats */
            obj.getServeStats();
            
            /* get names of top 100 players */
            obj.getTop100ByName();
            
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        
    }
}
