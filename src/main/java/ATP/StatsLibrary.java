/*
 * Top100Ranking.java
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
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author aftabhassan
 *
 */
public class StatsLibrary {
    
    public void getServeStats() throws FileNotFoundException
    {
        Scanner filein = new Scanner(new FileReader("src/main/resources/servestats"));
        int count = 0;
        
        String contents = "Player,firstServePercentage,firstServePointsWonPercentage,secondServePointsWonPercentage,serviceGamesWonPercentage,averageAcesPerMatch,averageDoubleFaultsPerMatch\n";
        while(filein.hasNext())
        {
            String line = filein.nextLine();
            
            switch(count%3)
            {
                case 1:
                {
                    contents += line;
                    break;
                }
                
                case 2:
                {
                    /*
                     * SERVE STANDING©
                        PLAYER
                        SERVE RATING©
                        % 1ST SERVE
                        % 1ST SERVE POINTS WON
                        % 2ND SERVE POINTS WON
                        % SERVICE GAMES WON
                        AVG. ACES/ MATCH
                        AVG. DOUBLE FAULTS/MATCH
                     */

                    line = line.replace("%", "");
                    String[] stats = line.split("\t");
                    double firstServePercentage = Double.valueOf(stats[1]);
                    double firstServePointsWonPercentage = Double.valueOf(stats[2]);
                    double secondServePointsWonPercentage = Double.valueOf(stats[3]);
                    double serviceGamesWonPercentage = Double.valueOf(stats[4]);
                    double averageAcesPerMatch = Double.valueOf(stats[5]);
                    double averageDoubleFaultsPerMatch = Double.valueOf(stats[6]);
                    contents += "," + firstServePercentage + "," + firstServePointsWonPercentage + "," + secondServePointsWonPercentage + "," + serviceGamesWonPercentage + "," + averageAcesPerMatch + "," + averageDoubleFaultsPerMatch + "\n";
                    break;
                }
          
                default:
            } 
            
            count++;
        }
        
        writeContentsToCSV("servestats.csv", contents);
    }
    
    public void getTop100ByName()
    {
        try
        {
            Scanner filein = new Scanner(new FileReader("src/main/resources/top100"));
            
            /*
             * 1        
                GBR 
                Andy Murray
                29  12,040  18  45  0
             */
            String contents = "Ranking,Player\n";
            int count = 0;
            while(filein.hasNext())
            {
                String line = filein.nextLine();
                line = line.replace("\t","");
                
                switch(count%4)
                {
                    case 0:
                        String num = "";
                        for(int i = 0;i<line.length();i++)
                        {
                            if(!(line.charAt(i) >= '0' && line.charAt(i)<='9'))
                            {
                                break;
                            }
                            num += line.charAt(i);
                        }
                        contents += num;
                        break;
                        
                    case 2:
                        contents += "," + line + "\n";
                        break;
                    
                    default:
                        break;
                }
                
                count++;
            }
            
            writeContentsToCSV("top100.csv", contents);
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
       
    }
    
    public void writeContentsToCSV( String filename, String contents )
    {
        try {
            FileWriter fWriter = new FileWriter("output/" + filename);
            
            fWriter.write(contents);
            
            fWriter.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
