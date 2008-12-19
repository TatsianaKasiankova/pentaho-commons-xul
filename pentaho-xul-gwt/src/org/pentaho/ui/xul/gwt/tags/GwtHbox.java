package org.pentaho.ui.xul.gwt.tags;

import org.pentaho.ui.xul.XulComponent;
import org.pentaho.ui.xul.containers.XulHbox;
import org.pentaho.ui.xul.dom.Element;
import org.pentaho.ui.xul.gwt.AbstractGwtXulComponent;
import org.pentaho.ui.xul.gwt.AbstractGwtXulContainer;
import org.pentaho.ui.xul.gwt.GwtXulHandler;
import org.pentaho.ui.xul.gwt.GwtXulParser;
import org.pentaho.ui.xul.util.Align;
import org.pentaho.ui.xul.util.Orient;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant;

public class GwtHbox extends AbstractGwtXulContainer implements XulHbox {

  static final String ELEMENT_NAME = "hbox"; //$NON-NLS-1$
  
  public static void register() {
    GwtXulParser.registerHandler(ELEMENT_NAME, 
    new GwtXulHandler() {
      public Element newInstance() {
        return new GwtHbox();
      }
    });
  }
  
  Align alignment;
  
  public GwtHbox() {
    super(ELEMENT_NAME);
    this.orientation = Orient.HORIZONTAL;
    managedObject = container = new HorizontalPanel();
  }
  
  public void init(com.google.gwt.xml.client.Element srcEle) {
    super.init(srcEle);
    setAlign(srcEle.getAttribute("align"));
  }
  
  public void adoptAttributes(XulComponent component) {

  }

  @Override
  public void setHeight(int height) {
    super.setHeight(height);
    container.setHeight(height+"px");
  }

  @Override
  public void setWidth(int width) {
    super.setWidth(width);
    container.setWidth(width+"px");
  }
  
  public void layout() {
    super.layout();
  }
  
  public void setAlign(String align) {
    try{
      this.alignment = Align.valueOf(align.toUpperCase());
    } catch(Exception e){
      System.out.println("Cannot parse ["+align+"] as Align value");
      
    }
  }
  
  public Align getAlign(){
    return this.alignment;
  }
  
}
