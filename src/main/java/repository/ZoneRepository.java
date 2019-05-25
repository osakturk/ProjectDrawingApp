package repository;
import model.Zone;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

class ZoneRepository {
    Zone getZoneInfoById(NodeList nodeList, String zoneId) {
        List<Zone> zones = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Zone zone = new Zone();
                Element eElement = (Element) nNode;
                zone.setZoneId(eElement.getAttribute("no"));
                zone.setZoneInfo(eElement.getAttribute("lang1"));
                zones.add(zone);
            }
        }

        for (Zone zone : zones) {
            if (zoneId.equals(zone.getZoneId())) {
                return zone;
            }
        }
        return new Zone();
    }
}