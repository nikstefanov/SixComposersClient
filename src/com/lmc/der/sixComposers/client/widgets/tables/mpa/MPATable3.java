package com.lmc.der.sixComposers.client.widgets.tables.mpa;

import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2FlexTable;

public class MPATable3 extends FSTRA2FlexTable {
	
	public MPATable3(char Gender){
		columns=18;headerRows=2;headerColumns=2;		
		String PNDvalue;
		String GrowEvent;
		if (Gender=='M'){
			PNDvalue="23";GrowEvent = "PPS";initRows = 14;
			BasePath="MPA||Results>>GeneralGrowth>>Table3";
		}else{
			PNDvalue="22";GrowEvent = "vaginal opening";initRows = 15;
			BasePath="FPA||Results>>GeneralGrowth>>Table3";
		}
		fixedHeaderColumnsRows=initRows;
		this.setText(0, 0, "Parameter Evaluated");		
		this.setText(0, 1, "Vehicle Control");
		this.setText(0, 2, "Low Dose");
		this.setText(0, 3, "Medium Dose");
		this.setText(0, 4, "High Dose");
		CFormatter.setRowSpan(0, 0, 2);
		CFormatter.setColSpan(0, 0, 2);
		CFormatter.setColSpan(0, 1, 4);
		CFormatter.setColSpan(0, 2, 4);
		CFormatter.setColSpan(0, 3, 4);
		CFormatter.setColSpan(0, 4, 4);
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");
		
		this.setText(1, 0, "Number of Animals Examined");
		this.setText(1, 1, "Mean");
		this.setText(1, 2, "SD");
		this.setText(1, 3, "CV");
		this.setText(1, 4, "Number of Animals Examined");
		this.setText(1, 5, "Mean");
		this.setText(1, 6, "SD");
		this.setText(1, 7, "CV");
		this.setText(1, 8, "Number of Animals Examined");
		this.setText(1, 9, "Mean");
		this.setText(1,10, "SD");
		this.setText(1,11, "CV");
		this.setText(1,12, "Number of Animals Examined");
		this.setText(1,13, "Mean");
		this.setText(1,14, "SD");
		this.setText(1,15, "CV");
		RFormatter.addStyleName(1, "centered");
		RFormatter.addStyleName(1, "bolded");
		
		final String[] headerHTML2 = {"Initial body weight (PND "+PNDvalue+"; g)","U"};
		fillRowTextBoxes(2,headerHTML2,2);
		final String[] headerHTML3 = {"A"};
		fillRowTextBoxes(3,headerHTML3,1);
		final String[] headerHTML4 = {"Body weight at "+GrowEvent+" (g)","U"};
		fillRowTextBoxes(4,headerHTML4,2);
		final String[] headerHTML5 = {"A"};
		fillRowTextBoxes(5,headerHTML5,1);
		final String[] headerHTML6 = {"Final body weight(g)","U"};
		fillRowTextBoxes(6,headerHTML6,2);
		final String[] headerHTML7 = {"A"};
		fillRowTextBoxes(7,headerHTML7,1);
		final String[] headerHTML8 = {"Final body weight (% of control)","U"};
		fillRowTextBoxes(8,headerHTML8,2);
		final String[] headerHTML9 = {"A"};
		fillRowTextBoxes(9,headerHTML9,1);
		final String[] headerHTML10 = {"Body weight gain (final - initial; g)","U"};
		fillRowTextBoxes(10,headerHTML10,2);
		final String[] headerHTML11 = {"A"};
		fillRowTextBoxes(11,headerHTML11,1);
		final String[] headerHTML12 = {"Age at "+GrowEvent+" (PND)","U"};
		fillRowTextBoxes(12,headerHTML12,2);
		final String[] headerHTML13 = {"A"};
		fillRowTextBoxes(13,headerHTML13,1);
		
		if (Gender!='M'){
			final String[] headerHTML14 = {"Proportion unopened (#/N)"};
			fillRowTextBoxes(14,headerHTML14,1);
			CFormatter.setColSpan(14, 0, 2);
		}
	}

	@Override
	protected void fillRow(int rowIndex) {
		// TODO Auto-generated method stub

	}

}
