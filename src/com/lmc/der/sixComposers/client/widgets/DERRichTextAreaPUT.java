package com.lmc.der.sixComposers.client.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.sample.showcase.client.content.text.RichTextToolbar;
import com.google.gwt.user.client.ui.DecoratedPopupPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RichTextArea;
import com.gwt.der.lib.client.DERRichTextArea;

public class DERRichTextAreaPUT extends DERRichTextArea {
	
	private static final DecoratedPopupPanel dpp;
	private static final RichTextToolbar rtt;
	private static final EventHandler handler;
	private static final int height;//78
	private static final int width;//510
	private static final HorizontalPanel hp;
	private static final PushButton pbutton;
	private static final ButtonClickHandler bch;
	
	static {
		dpp = new DecoratedPopupPanel();
		rtt = new RichTextToolbar();
		handler = new EventHandler();
		bch = new ButtonClickHandler();
		pbutton = new PushButton("x",bch);
		hp = new HorizontalPanel();
		hp.add(rtt);hp.add(pbutton);
		dpp.setWidget(hp);
		dpp.setAutoHideEnabled(true);
		height = 78;//dpp.getOffsetHeight();
		width = 510;//dpp.getOffsetWidth();		
	}

	public DERRichTextAreaPUT() {
		super.addClickHandler(handler);
	}
	
	@Override
	public void setName(String name){
		super.setName(name);
		super.setWidgetDefaultValue(super.getWidgetValue());
	}
	
	private static class EventHandler implements ClickHandler {
		private RichTextArea rta = null;
		private int PPleftPos = 0,PPtopPos = 0;
		@Override
		public void onClick(ClickEvent clEvent){
//			RichTextAreaPUT.dpp.hide();
			rta = (RichTextArea)clEvent.getSource();
			DERRichTextAreaPUT.rtt.setRichTextArea(rta);		
			
			PPleftPos = rta.getAbsoluteLeft() + (rta.getOffsetWidth() -  DERRichTextAreaPUT.width)/2;
			PPleftPos = (PPleftPos<0)?0:PPleftPos;
			
			PPtopPos = rta.getAbsoluteTop() -  DERRichTextAreaPUT.height;
			PPtopPos = (PPtopPos<0)?rta.getAbsoluteTop() + rta.getOffsetHeight():PPtopPos;
			
			DERRichTextAreaPUT.dpp.setPopupPosition(PPleftPos, PPtopPos);			
			DERRichTextAreaPUT.dpp.show();
//			System.out.println("Height: "+RichTextAreaPUT.dpp.getOffsetHeight());
//			System.out.println("Width: "+RichTextAreaPUT.dpp.getOffsetWidth());
		}
	}
	
	private static class ButtonClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent clEvent){
//			System.out.println(clEvent.getSource().toString());
			DERRichTextAreaPUT.dpp.hide();
		}
	}

}
