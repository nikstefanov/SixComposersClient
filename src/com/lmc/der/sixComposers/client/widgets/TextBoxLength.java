package com.lmc.der.sixComposers.client.widgets;

import com.google.gwt.user.client.ui.TextBox;

public class TextBoxLength extends TextBox {

	public TextBoxLength(int visLength){if(visLength>0)setVisibleLength(visLength);}
	public TextBoxLength(){}
	
	public void setWidgetDefaultValue(String str){
//		System.out.println(this.getWidgetValue());
//		super.setWidgetDefaultValue(this.getWidgetValue());
	}
	@Override
	public void setName(String name){
		super.setName(name);
//		super.setWidgetDefaultValue(super.getWidgetValue());
	}
	
	public String getWidgetValue(){
		return getValue();
	}
	
	public void setWidgetValue(String val){
		this.setValue(val);
	}
}
