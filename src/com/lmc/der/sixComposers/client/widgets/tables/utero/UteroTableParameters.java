package com.lmc.der.sixComposers.client.widgets.tables.utero;

import com.lmc.der.sixComposers.client.widgets.DERTextBoxLength;
import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2FlexTable;

public class UteroTableParameters extends FSTRA2FlexTable {
	
	public UteroTableParameters(int tableNumber){
		boolean estrogen = (tableNumber%2==0);
		
		initRows = 3;
		columns=16;headerRows=initRows;headerColumns=1;
		fixedHeaderColumnsRows=initRows;
		BasePath = "UA||ResultsAndDiscussion>>Table"+tableNumber;
		
		this.setText(0, 0, tableNumber<8?"Study Day #":"Parameter");		
		this.setText(0, 1, "Dose (mg/kg bw/day)");
		CFormatter.setRowSpan(0, 0,  3);
		CFormatter.setColSpan(0, 1, 15);
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");
		this.setText(1, 0, "Vehicle Control");		
		this.setText(1, 1, estrogen?"Low":"EE");
		this.setText(1, 2, estrogen?"Mid":"Low (+EE)");
		this.setText(1, 3, estrogen?"High":"Mid (+EE)");
		this.setText(1, 4, estrogen?"Reference Estrogen EE":"High (+EE)");
		CFormatter.setColSpan(1, 0, 3);
		CFormatter.setColSpan(1, 1, 3);
		CFormatter.setColSpan(1, 2, 3);
		CFormatter.setColSpan(1, 3, 3);
		CFormatter.setColSpan(1, 4, 3);
		RFormatter.addStyleName(1, "centered");
		RFormatter.addStyleName(1, "bolded");
		this.setText(2, 0, "N");
		this.setText(2, 1, "Mean");
		this.setText(2, 2, "SD");
		this.setText(2, 3, "N");
		this.setText(2, 4, "Mean");
		this.setText(2, 5, "SD");
		this.setText(2, 6, "N");
		this.setText(2, 7, "Mean");
		this.setText(2, 8, "SD");
		this.setText(2, 9, "N");
		this.setText(2,10, "Mean");
		this.setText(2,11, "SD");
		this.setText(2,12, "N");
		this.setText(2,13, "Mean");
		this.setText(2,14, "SD");
		RFormatter.addStyleName(2, "centered");
		
		
		if (tableNumber==9 ||tableNumber==8){
			initRows=8;	
			fillRow(3);((DERTextBoxLength)this.getWidget(3,0)).setWidgetDefaultValue("Terminal BW");
			fillRow(4);((DERTextBoxLength)this.getWidget(4,0)).setWidgetDefaultValue("Wet, absolute (mg)");
			fillRow(5);((DERTextBoxLength)this.getWidget(5,0)).setWidgetDefaultValue("Wet, relative (%)");
			fillRow(6);((DERTextBoxLength)this.getWidget(6,0)).setWidgetDefaultValue("Blotted, absolute (mg)");
			fillRow(7);((DERTextBoxLength)this.getWidget(7,0)).setWidgetDefaultValue("Blotted, relative (%)");
			
		}
	}

	@Override
	protected void fillRow(int rowIndex) {
		fillRowTextBoxes(rowIndex,new String[0],1,"15ex","5ex");
//		fillRowTextBoxes(rowIndex);
	}
	
}
