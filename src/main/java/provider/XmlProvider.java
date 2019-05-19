package provider;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlProvider {

    public static NodeList getNodeList(String xmlLocation, String elementGroupTagName){
        NodeList nodeList = null;
        // todo how can we find xml file ?? actually where is import location
        try {
            File fXmlFile = new File(xmlLocation);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            nodeList = doc.getElementsByTagName(elementGroupTagName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return nodeList;
    }
}
