package repository;

import model.Loop;
import model.Point;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

class LoopRepository {

    List<Loop> getLoopList(NodeList pointList, NodeList zoneList) {
        ZoneRepository zoneRepository = new ZoneRepository();
        List<Loop> loops = new ArrayList<>();
        for (int j = 0; j < pointList.getLength(); j++) {
            Loop loop = new Loop();
            List<Point> points = new ArrayList<>();
            Point point = new Point();
            Node node = pointList.item(j);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element1 = (Element) node;
                point.setAddress(element1.getAttribute("no"));
                point.setLabel(element1.getAttribute("lang1"));
                point.setLoop("LOOP" + element1.getAttribute("address"));
                point.setDeviceType(element1.getElementsByTagName("devtype").item(0).getTextContent());
                point.setZoneInfo(zoneRepository.getZoneInfoById(zoneList, element1.getElementsByTagName("zone").item(0).getTextContent()).getZoneInfo());
                points.add(point);
                loop.setLoopNumber(element1.getAttribute("address"));
                loop.setPoints(points);
                if (Integer.parseInt(element1.getAttribute("category")) == 0
                        && Integer.parseInt(element1.getElementsByTagName("zone").item(0).getTextContent()) != 0) {
                    loops.add(loop);
                }
            }
        }
        return loops;
    }
}

