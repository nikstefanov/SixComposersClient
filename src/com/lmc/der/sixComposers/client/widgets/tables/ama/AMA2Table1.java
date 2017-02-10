package com.lmc.der.sixComposers.client.widgets.tables.ama;

import com.lmc.der.sixComposers.client.widgets.DERListBoxYesNo;
import com.lmc.der.sixComposers.client.widgets.tables.AMA2FlexTable;

public class AMA2Table1 extends AMA2FlexTable {
//	private final int initRows = 2;
	public AMA2Table1(){
		initRows = 2;columns=8;headerRows=2;headerColumns=1;
		BasePath="AMA||GeneralInfo>>Table1";
		this.addStyleName("double_bordered");
		this.setHTML(0, 0, "Treatment (mg a.i../L)<br/>[measured]");
		this.setHTML(0, 1, "NF Developmental<br/>Stage ");
		this.setHTML(0, 2, "Hind Limb<br/>Length<sup>3</sup>");
		this.setHTML(0, 3, "Asynchronous<br/>Development ");
		this.setHTML(0, 4, "Thyroid Gross and<br/>Histopathology ");		
		CFormatter.setRowSpan(0, 0, 2);
		CFormatter.setColSpan(0, 1, 2);
		CFormatter.setColSpan(0, 2, 2);
		CFormatter.setColSpan(0, 3, 2);		
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");
		
		this.setText(1, 0, "Day7");
		this.setText(1, 1, "Day21");
		this.setText(1, 2, "Day7");
		this.setText(1, 3, "Day21");
		this.setText(1, 4, "Day7");
		this.setText(1, 5, "Day21");
		this.setText(1, 6, "Day21");
		RFormatter.addStyleName(1, "centered");
		RFormatter.addStyleName(1, "bolded");
		
	}
	
	public void fillRow(int rowIndex,String headerHTML/*,int number*/){
//		String headerHTML = (number==0)?"Positive control":"Test Concentration "+number;		
		this.setHTML  (rowIndex, 0, headerHTML);
		DERListBoxYesNo LB;
		for(int cIndex = 1; cIndex < 8; cIndex++){
			LB =  new DERListBoxYesNo();
			LB.setName(this.getWidgetPath(rowIndex,cIndex,headerHTML));
			this.setWidget(rowIndex, cIndex,LB);
		}
	}
}
