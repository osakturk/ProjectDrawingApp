package ui.projectcanvas;

import model.Sensor;
import ui.UIComponent;

public class PCESensorProperties extends UIComponent {

    public PCESensorProperties(){
        loadFXML("pce_sensor_properties");
    }

    public PCESensorProperties( Sensor sensor ){

    }

}
