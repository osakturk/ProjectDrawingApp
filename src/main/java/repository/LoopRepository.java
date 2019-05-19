package repository;

import model.Loop;
import model.Point;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import provider.XmlProvider;
import provider.ZoneProvider;

import java.util.ArrayList;
import java.util.List;

public class LoopRepository {

    public List<Loop> getLoopList() {
        ZoneProvider zoneProvider = new ZoneProvider();
        List<Loop> loops = new ArrayList<>();
        //        NodeList nodeList = doc.getElementsByTagName("point");
        NodeList nodeList = XmlProvider.getNodeList("LOCATION_OF_XML_FILE", "point");
        for (int i = 0; i < nodeList.getLength(); i++) {

            Node nNode = nodeList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Loop loop = new Loop();
                List<Point> points = new ArrayList<>();
                Point point = new Point();
                Element eElement = (Element) nNode;
                point.setAddress(eElement.getAttribute("no"));
                point.setLabel(eElement.getAttribute("lang1"));
                point.setLoop(getCharForNumber(Integer.parseInt(eElement.getAttribute("address"))));
                point.setDeviceType(eElement.getElementsByTagName("devtype").item(0).getTextContent());
                point.setZoneInfo(zoneProvider.getZoneInfoById(eElement.getElementsByTagName("zone").item(0).getTextContent()).getZoneInfo());
                points.add(point);
                loop.setLoopNumber(eElement.getAttribute("address"));
                loop.setLoopName(getCharForNumber(Integer.parseInt(eElement.getAttribute("address"))));
                loop.setPoints(points);
                loops.add(loop);
            }
        }


        return loops;
    }

    private String getCharForNumber(int i) {
        return i > -1 && i < 26 ? String.valueOf((char) (i + 65)) : null;
    }
}

