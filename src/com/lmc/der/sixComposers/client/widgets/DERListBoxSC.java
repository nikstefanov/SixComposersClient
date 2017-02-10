package com.lmc.der.sixComposers.client.widgets;

import com.google.gwt.dom.client.Element;
import com.gwt.der.lib.client.DERListBox;

public class DERListBoxSC extends DERListBox {

	public DERListBoxSC() {}
	public DERListBoxSC(boolean isMultipleSelect) {super(isMultipleSelect);}
	public DERListBoxSC(Element element) {super(element);}
	
	@Override
	public void setName(String name){
		super.setName(name);
		super.setWidgetDefaultValue(this.getItemText(0));
	}

}
