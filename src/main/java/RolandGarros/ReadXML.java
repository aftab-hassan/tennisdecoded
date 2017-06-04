/*
 * ReadXML.java
 * 
 * Copyright (c) 2017 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package RolandGarros;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author aftabhassan
 *
 */
public class ReadXML {
    public static void main(String[] args) {
        
        ReadXML obj = new ReadXML();
        obj.read();
    }
    
    public void read()
    {
        try{    
//            String pre_apiURL = "http://www.rolandgarros.com/en_FR/xml/gen/scores/extrastats/aces_ms.xml";
//            String pre_apiURL = "http://www.rolandgarros.com/en_FR/xml/gen/scores/extrastats/speed_ms.xml";
//            String pre_apiURL = "http://www.rolandgarros.com/en_FR/xml/gen/scores/extrastats/double_ms.xml";
//            String pre_apiURL = "http://www.rolandgarros.com/en_FR/xml/gen/scores/extrastats/f_srv_pct_ms.xml";
//            String pre_apiURL = "http://www.rolandgarros.com/en_FR/xml/gen/scores/extrastats/f_srv_pts_won_ms.xml";
//            String pre_apiURL = "http://www.rolandgarros.com/en_FR/xml/gen/scores/extrastats/s_srv_pts_won_ms.xml";
//            String pre_apiURL = "http://www.rolandgarros.com/en_FR/xml/gen/scores/extrastats/f_srv_ret_won_ms.xml";
//            String pre_apiURL = "http://www.rolandgarros.com/en_FR/xml/gen/scores/extrastats/s_srv_ret_won_ms.xml";
//            String pre_apiURL = "http://www.rolandgarros.com/en_FR/xml/gen/scores/extrastats/brk_pts_won_ms.xml";
//            String pre_apiURL = "http://www.rolandgarros.com/en_FR/xml/gen/scores/extrastats/brk_pts_con_ms.xml";
            String pre_apiURL = "http://www.rolandgarros.com/en_FR/xml/gen/scores/extrastats/rally_count_ms.xml";
            URL url = new URL(pre_apiURL);

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(url.openStream());
            
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("dataRow");

            String data = "serial,playerName,country,matches,doubleFaults\n";
            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    String serial = eElement.getElementsByTagName("data_1").item(0).getTextContent();
                    String playerName = eElement.getElementsByTagName("data_2").item(0).getTextContent();
                    String country = eElement.getElementsByTagName("data_3").item(0).getTextContent();
                    String matches = eElement.getElementsByTagName("data_4").item(0).getTextContent();
                    String aces = eElement.getElementsByTagName("data_5").item(0).getTextContent();

                    data += serial +"," + playerName + ","+ country +"," + matches +"," + aces + "\n";
                }
            }
            
            System.out.println(data);
            
        }catch(Exception e){}
    }
    
    public static void printDocument(Document doc, OutputStream out) throws IOException, TransformerException {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        transformer.transform(new DOMSource(doc), 
             new StreamResult(new OutputStreamWriter(out, "UTF-8")));
    }
}
