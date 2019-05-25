package repository;

import model.Panel;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import provider.XmlProvider;

import java.util.ArrayList;
import java.util.List;

public class PanelRepository {
    public List<Panel> getPanels() {
        List<Panel> panelList = new ArrayList<>();
        LoopRepository loopRepository = new LoopRepository();
        NodeList nodeList = XmlProvider.getNodeList("SCHNEIDER ELECTRIC PROFILE P805D-230419_HA.xml", "node");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Panel panel = new Panel();
            Node nNode = nodeList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;
                panel.setNodeType(Integer.parseInt(element.getElementsByTagName("nodetype").item(0).getTextContent()));
                if (panel.getNodeType() == 2){
                    panel.setName(element.getAttribute("lang1"));
                    panel.setNumber(Integer.parseInt(element.getAttribute("no")));
                    panel.setLoopList(loopRepository.getLoopList(element.getElementsByTagName("point"),element.getElementsByTagName("zone")));
                }
            }
            panelList.add(panel);
        }

        return panelList;
    }
}
