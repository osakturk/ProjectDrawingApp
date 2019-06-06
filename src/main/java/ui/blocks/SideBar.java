package ui.blocks;

import ui.UIComponent;

@Deprecated
public class SideBar extends UIComponent {


    public SideBar(){

    }

    public void initUI(){
        loadFXML("side_bar");
    }

}