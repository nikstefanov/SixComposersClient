package com.lmc.der.sixComposers.client.widgets;

import com.gwt.der.lib.client.DERTextBox;

public class DERTextBoxLength extends DERTextBox {
	
	public DERTextBoxLength(int visLength,String name){if(visLength>0)setVisibleLength(visLength);this.setName(name);}
	public DERTextBoxLength(int visLength){if(visLength>0)setVisibleLength(visLength);}
	public DERTextBoxLength(){}
	
	@Override
	public void setName(String name){
		super.setName(name);
		super.setWidgetDefaultValue(super.getWidgetValue());
	}
	
}
