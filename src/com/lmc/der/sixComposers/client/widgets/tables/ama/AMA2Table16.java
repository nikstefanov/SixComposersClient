package com.lmc.der.sixComposers.client.widgets.tables.ama;

import com.lmc.der.sixComposers.client.widgets.DERTextBoxLength;
import com.lmc.der.sixComposers.client.widgets.DERListBoxYesNo;
import com.lmc.der.sixComposers.client.widgets.tables.AMA2FlexTable;

public class AMA2Table16 extends AMA2FlexTable {	
	
	public AMA2Table16(){
		initRows = 6;columns=14;headerRows=3;headerColumns=1;
		BasePath = "AMA||ResultsAndDiscussion>>DevelopmentEndpoints>>EndpointsTable";
//		ColumnFormatter ColFormatter = this.getColumnFormatter(); 
		this.addStyleName("double_bordered");
		
		this.setHTML(0, 0, "Treatment (mg a.i../L)<br/>[measured]");
		this.setText(0, 1, "NF Developmental Stage");
		this.setHTML(0, 2, "Hind Limb Length<sup>3</sup>");
		this.setText(0, 3, "Asynchronous Development");
		this.setHTML(0, 4, "Thyroid Gross<br/>and Histopathology");
		
		this.setText(1, 0, "Day 7");
		this.setText(1, 1, "Day 21");
		this.setText(1, 2, "Day 7");
		this.setText(1, 3, "Day 21");
		this.setText(1, 4, "Day 7");
		this.setText(1, 5, "Day 21");
		this.setText(1, 6, "Day 21");
		
		this.setText(2, 0, "Median");
		this.setText(2, 1, "p");
		this.setText(2, 2, "Median");	
		this.setText(2, 3, "p");
		this.setText(2, 4, "% Diff.");
		this.setText(2, 5, "p");
		this.setText(2, 6, "% Diff.");	
		this.setText(2, 7, "p");
		this.setText(2, 8, "% Diff.");
		this.setText(2, 9, "p");
		this.setText(2,10, "% Diff.");
		this.setText(2,11, "p");
		this.setHTML(2,12, "Treatment-Related<br/>Effects?");
		
		
		CFormatter.setRowSpan(0, 0, 3);
		CFormatter.setColSpan(0, 1, 4);
		CFormatter.setColSpan(0, 2, 4);
		CFormatter.setColSpan(0, 3, 4);
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");
		CFormatter.setColSpan(1, 0, 2);
		CFormatter.setColSpan(1, 1, 2);
		CFormatter.setColSpan(1, 2, 2);
		CFormatter.setColSpan(1, 3, 2);
		CFormatter.setColSpan(1, 4, 2);
		CFormatter.setColSpan(1, 5, 2);
		RFormatter.addStyleName(1, "centered");
		RFormatter.addStyleName(1, "bolded");
		RFormatter.addStyleName(2, "centered");
		RFormatter.addStyleName(2, "bolded");
//		ColFormatter.addStyleName(13, "centered");
		
		
		fillRow(3, "Control (dilution water only), if used");
		fillRow(4, "Solvent control, if used");
		fillRow(5, "Statistical Test for Significant Differences");
		
		
		
	}	

	@Override
	public void fillRow(int rowIndex, String headerHTML) {		
		this.setHTML	(rowIndex, 0, headerHTML);
		int col;
		DERTextBoxLength TextBox;
		if (headerHTML.length() == 44){//Statistical Test row I mean.
			col = columns / 2;
			TextBox = new DERTextBoxLength(4);
			TextBox.setName(this.getWidgetPath(rowIndex, col, headerHTML));
			this.setWidget(rowIndex, col, TextBox);
			CFormatter.addStyleName(rowIndex, col, "centered");
			while(col-->1){
				TextBox = new DERTextBoxLength(16);
				TextBox.setName(this.getWidgetPath(rowIndex, col, headerHTML));
				this.setWidget(rowIndex, col, TextBox);
				CFormatter.setColSpan(rowIndex, col, 2);
				CFormatter.addStyleName(rowIndex, col, "centered");
			}
		}
		else{
			col  = columns - 1;
			DERListBoxYesNo ListBox =  new DERListBoxYesNo();
			ListBox.setName(this.getWidgetPath(rowIndex, col, headerHTML));
			this.setWidget(rowIndex, col, ListBox);
			CFormatter.addStyleName(rowIndex, col, "centered");
			while(col-->1){
				TextBox = new DERTextBoxLength(4);
				TextBox.setName(this.getWidgetPath(rowIndex, col, headerHTML));
				this.setWidget(rowIndex, col, TextBox);				
			}
		}		
	}

}
