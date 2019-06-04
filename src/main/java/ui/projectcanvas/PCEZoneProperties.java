package ui.projectcanvas;

import model.Zone;
import ui.UIComponent;

public class PCEZoneProperties extends UIComponent {


    public PCEZoneProperties(){
        loadFXML("pce_zone_properties");
    }

    public PCEZoneProperties( Zone zone ){
        loadFXML("pce_zone_properties");
        ((PCEZonePropertiesController) controller).fillForm( zone ); // @todo parameters
    }

}
