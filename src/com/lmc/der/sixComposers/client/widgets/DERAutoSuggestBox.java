package com.lmc.der.sixComposers.client.widgets;

import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBox;
import com.gwt.der.lib.client.handlers.WidgetSelectionHandler;

public class DERAutoSuggestBox extends SuggestBox implements FocusHandler {
	
	private final static SuggestBox.DefaultSuggestionDisplay DSdisplay =
			new SuggestBox.DefaultSuggestionDisplay();
	/*
	public DERAutoSuggestBox() {
		// TODO Auto-generated constructor stub
	}

	public DERAutoSuggestBox(SuggestOracle oracle) {
		super(oracle);
		// TODO Auto-generated constructor stub
	}

	public DERAutoSuggestBox(SuggestOracle oracle, ValueBoxBase<String> box) {
		super(oracle, box);
		// TODO Auto-generated constructor stub
	}

	public DERAutoSuggestBox(SuggestOracle oracle, ValueBoxBase<String> box,
			SuggestionDisplay suggestDisplay) {
		super(oracle, box, suggestDisplay);
		// TODO Auto-generated constructor stub
	}
	*/
	public DERAutoSuggestBox(String []suggestions,String pullListChars,int visChars){		
		super(new FSTRA2SuggestOracle(suggestions,pullListChars),new DERTextBoxLength(),DSdisplay);
		this.getValueBox().addFocusHandler(this);
		if(visChars>0)((TextBox)this.getValueBox()).setVisibleLength(visChars); 
		this.addSelectionHandler(new WidgetSelectionHandler());// Could be a static handler. Would be better acording to me.
	}

	@Override
	public void onFocus(FocusEvent event) {
		this.showSuggestionList();
	}	
	
	public void setName(String name){
		this.getValueBox().setName(name);
		((DERTextBoxLength)this.getValueBox()).setWidgetDefaultValue(this.getValueBox().getValue());
	}
	
	public String getName(){
		return this.getValueBox().getName();
	}
	
}
