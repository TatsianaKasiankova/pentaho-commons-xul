package org.pentaho.ui.xul.binding;

import org.pentaho.ui.xul.dom.Document;

public class DefaultBindingFactory implements BindingFactory {
  
  private Document document;
  
  private Binding.Type type = Binding.Type.BI_DIRECTIONAL;

  public void setDocument(Document document) {
    this.document = document;
  }
  
  public void setBindingType(Binding.Type type) {
    this.type = type;
  }
  
  private Binding applyBinding(Binding b, BindingConvertor... converters) {
    b.setBindingType(type);
    if(converters != null && converters.length > 0){
      b.setConversion(converters[0]);
    }
    b.initialize();
    document.addInitializedBinding(b);
    return b;
  }
  
  public Binding createBinding(String sourceId, String sourceAttr, String targetId, String targetAttr, BindingConvertor... converters) {
    Binding b = new Binding(document.getElementById(sourceId), sourceAttr, document.getElementById(targetId), targetAttr);
    return applyBinding(b);
  }

  public Binding createBinding(Object source, String sourceAttr, String targetId, String targetAttr, BindingConvertor... converters) {
    Binding b = new Binding(source, sourceAttr, document.getElementById(targetId), targetAttr);
    return applyBinding(b);
  }

  public Binding createBinding(String sourceId, String sourceAttr, Object target, String targetAttr, BindingConvertor... converters) {
    Binding b = new Binding(document.getElementById(sourceId), sourceAttr, target, targetAttr);
    return applyBinding(b);
  }
  
  public Binding createBinding(Object source, String sourceAttr, Object target, String targetAttr, BindingConvertor... converters) {
    Binding b = new Binding(source, sourceAttr, target, targetAttr);
    return applyBinding(b);
  }

}
