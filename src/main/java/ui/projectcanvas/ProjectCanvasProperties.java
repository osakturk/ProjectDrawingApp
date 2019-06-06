package ui.projectcanvas;

import model.Project;
import ui.UIComponent;

public class ProjectCanvasProperties extends UIComponent {

    public ProjectCanvasProperties(){
        loadFXML("pce_project_canvas_properties");
    }

    public ProjectCanvasProperties( Project project ){
        loadFXML("pce_project_canvas_properties");
    }

}
