package com.lmc.der.sixComposers.client.widgets;

import com.gwt.der.lib.client.DERCheckBox;

public class DERCheckBoxSC extends DERCheckBox {
	public DERCheckBoxSC(){}
	public DERCheckBoxSC(String path){setName(path);}
	@Override public void setName(String name){
		super.setName(name);
		super.setWidgetDefaultValue("false");
	}
}
