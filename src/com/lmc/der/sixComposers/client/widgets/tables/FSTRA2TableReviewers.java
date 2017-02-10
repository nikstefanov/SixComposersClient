package com.lmc.der.sixComposers.client.widgets.tables;

import com.lmc.der.sixComposers.client.widgets.DERAutoSuggestBox;
import com.lmc.der.sixComposers.client.widgets.DERListBoxSC;
import com.lmc.der.sixComposers.client.widgets.DERTextBoxLength;

public class FSTRA2TableReviewers extends FSTRA2FlexTable {
	
	private final String [] suggestions={"EPA","OECD","PMRA","Other"};
	private final String pullListChars=",";

	public FSTRA2TableReviewers() {
		initRows = 1;columns=5;headerRows=1;headerColumns=0;
		fixedHeaderColumnsRows=initRows;
		
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
	protected void fillRow(int rowIndex) {
		DERListBoxSC ReviewerListBox = new DERListBoxSC();		
		ReviewerListBox.addItem("Primary");ReviewerListBox.addItem("Secondary");
		ReviewerListBox.setName(BasePath+">>["+(rowIndex - headerRows) + "]Row>>[0]Col");
		this.setWidget(rowIndex,0,ReviewerListBox);
//		DERTextBoxLength TextBox;
//		TextBox = new DERTextBoxLength();
		this.setWidget(rowIndex,1,new DERTextBoxLength(0,BasePath+">>["+(rowIndex - headerRows) + "]Row>>[1]Col"));
//		TextBox = new DERTextBoxLength();
		this.setWidget(rowIndex,2,new DERTextBoxLength(0,BasePath+">>["+(rowIndex - headerRows) + "]Row>>[2]Col"));
//		TextBox = new DERTextBoxLength();
		this.setWidget(rowIndex,3,new DERTextBoxLength(0,BasePath+">>["+(rowIndex - headerRows) + "]Row>>[3]Col"));
		DERAutoSuggestBox SuggBox = new DERAutoSuggestBox(suggestions,pullListChars,4);
		SuggBox.setName(BasePath+">>["+(rowIndex - headerRows) + "]Row>>[4]Col");
		this.setWidget(rowIndex,4,SuggBox);

	}

}
