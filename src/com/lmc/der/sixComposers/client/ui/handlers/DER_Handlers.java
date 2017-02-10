package com.lmc.der.sixComposers.client.ui.handlers;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.ui.Button;

public abstract class DER_Handlers implements AttachEvent.Handler, ClickHandler{
	
	@Override
	public void onAttachOrDetach(AttachEvent event) {
		if (event.isAttached()) updateConstants();		
	}
	
	protected abstract void updateConstants();
	
	//Probably this method have to move somewhere else!To be public static!
	public static void setAddValues(int oldVal,int newVal,Button addButton,Button remButton){
		Button forClickButton;
		int clicks = newVal-oldVal;
//		System.out.println(addButton.getHTML()+' '+clicks);
		if (clicks>0) forClickButton=addButton;
		else {forClickButton=remButton;clicks=-clicks;}
		for (;clicks>0;clicks--)
			forClickButton.click();
		}

}
