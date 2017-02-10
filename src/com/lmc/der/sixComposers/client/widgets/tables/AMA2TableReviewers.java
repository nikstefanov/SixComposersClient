package com.lmc.der.sixComposers.client.widgets.tables;

import com.lmc.der.sixComposers.client.widgets.DERAutoSuggestBox;
import com.lmc.der.sixComposers.client.widgets.DERListBoxSC;
import com.lmc.der.sixComposers.client.widgets.DERTextBoxLength;

public class AMA2TableReviewers extends AMA2FlexTable {

	private final String [] suggestions={"EPA","OECD","PMRA","Other"};
	private final String pullListChars=",";
	
	public AMA2TableReviewers(){
		initRows = 1;columns=5;headerRows=1;headerColumns=0;
		BasePath = "AMA||GeneralInfo>>TableReviewers";
		this.addStyleName("double_bordered");
		
		this.setHTML(0, 0, "Reviewer");
		this.setHTML(0, 1, "Name");
		this.setHTML(0, 2, "Job Title");
		this.setHTML(0, 3, "Date");
		this.setHTML(0, 4, "Affiliation");
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");		
	}

	@Override
	public void fillRow(int rowIndex,String headerHTML/*,int number*/) {
		DERListBoxSC ReviewerListBox = new DERListBoxSC();		
		ReviewerListBox.addItem("Primary");ReviewerListBox.addItem("Secondary");
		ReviewerListBox.setName(getWidgetPath(rowIndex,0,null));
		this.setWidget(rowIndex,0,ReviewerListBox);
		DERTextBoxLength TextBox;
		TextBox = new DERTextBoxLength();TextBox.setName(getWidgetPath(rowIndex,1,null));
		this.setWidget(rowIndex,1,TextBox);
		TextBox = new DERTextBoxLength();TextBox.setName(getWidgetPath(rowIndex,2,null));
		this.setWidget(rowIndex,2,TextBox);
		TextBox = new DERTextBoxLength();TextBox.setName(getWidgetPath(rowIndex,3,null));
		this.setWidget(rowIndex,3,TextBox);
		DERAutoSuggestBox SuggBox = new DERAutoSuggestBox(suggestions,pullListChars,4);
		SuggBox.setName(getWidgetPath(rowIndex,4,null));
		this.setWidget(rowIndex,4,SuggBox);		
	}

}
