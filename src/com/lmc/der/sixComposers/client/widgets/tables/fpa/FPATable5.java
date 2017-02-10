package com.lmc.der.sixComposers.client.widgets.tables.fpa;

import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2FlexTable;

public class FPATable5 extends FSTRA2FlexTable {
	
	public FPATable5(){
		initRows = 6;columns=10;headerRows=2;headerColumns=1;
		fixedHeaderColumnsRows=initRows;
		BasePath="FPA||Results>>EstrousCyclicity>>Table5";
		this.setHTML(0, 0, "Dose Level<br/>(mg/kg bw/day)");		
		this.setHTML(0, 1, "Number of<br/>Animals<br/>(N)");
		this.setHTML(0, 2, "Mean Age at<br/>First Vaginal<br/>Estrus (PND)");
		this.setHTML(0, 3, "Mean Cy-<br/>cle Length<br/>(days)");
		this.setHTML(0, 4, "Cycling<br/>(%)");
		this.setHTML(0, 5, "Regularly<br/>Cycling<br/>(%)");
		this.setHTML(0, 6, "Cycle Status at Necropsy (# Females)");
		CFormatter.setRowSpan(0, 0, 2);
		CFormatter.setRowSpan(0, 1, 2);
		CFormatter.setRowSpan(0, 2, 2);
		CFormatter.setRowSpan(0, 3, 2);
		CFormatter.setRowSpan(0, 4, 2);
		CFormatter.setRowSpan(0, 5, 2);
		CFormatter.setColSpan(0, 6, 4);
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");
		
		this.setHTML(1, 0, "Diestrus");		
		this.setHTML(1, 1, "Proestrus");
		this.setHTML(1, 2, "Estrus");
		this.setHTML(1, 3, "Not<br/>Cycling");
		RFormatter.addStyleName(1, "centered");
		RFormatter.addStyleName(1, "bolded");
		
		final String[] headerHTML2 = {"Vehicle Control"};
		fillRowTextBoxes(2,headerHTML2,1);
		final String[] headerHTML3 = {"Low Dose"};
		fillRowTextBoxes(3,headerHTML3,1);
		final String[] headerHTML4 = {"Midium Dose"};
		fillRowTextBoxes(4,headerHTML4,1);
		final String[] headerHTML5 = {"High Dose"};
		fillRowTextBoxes(5,headerHTML5,1);
	}

	@Override
	protected void fillRow(int rowIndex) {
		// TODO Auto-generated method stub

	}

}
