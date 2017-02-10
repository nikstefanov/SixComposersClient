package com.lmc.der.sixComposers.client.widgets.tables.hersh;

import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2FlexTable;

public class HershTable9 extends FSTRA2FlexTable {
	
	public HershTable9(int tableNumber){
		initRows =  8;columns=25;headerRows=3;headerColumns=1;
		BasePath = "HA||ResultsAndDiscussion";
		this.setText(0, 0, "Hormone");		
		this.setText(0, 1, "Dose (mg/kg bw/day)");
		CFormatter.setRowSpan(0, 0,  3);
		CFormatter.setColSpan(0, 1, 24);
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");
		this.setText(1, 0, "Vehicle Control");
		this.setText(1, 1, "TP Negative Control");
		this.setText(1, 2, "TP + FT Positive Control");
		this.setText(1, 3, "Low");
		this.setText(1, 4, "Mid");
		this.setText(1, 5, "High");
		CFormatter.setColSpan(1, 0, 4);
		CFormatter.setColSpan(1, 1, 4);
		CFormatter.setColSpan(1, 2, 4);
		CFormatter.setColSpan(1, 3, 4);
		CFormatter.setColSpan(1, 4, 4);
		CFormatter.setColSpan(1, 5, 4);
		RFormatter.addStyleName(1, "centered");
		RFormatter.addStyleName(1, "bolded");
		this.setText(2, 0, "N");
		this.setText(2, 1, "Mean");
		this.setText(2, 2, "SD");
		this.setText(2, 3, "CV");
		this.setText(2, 4, "N");
		this.setText(2, 5, "Mean");
		this.setText(2, 6, "SD");
		this.setText(2, 7, "CV");
		this.setText(2, 8, "N");
		this.setText(2, 9, "Mean");
		this.setText(2,10, "SD");
		this.setText(2,11, "CV");
		this.setText(2,12, "N");
		this.setText(2,13, "Mean");
		this.setText(2,14, "SD");
		this.setText(2,15, "CV");
		this.setText(2,16, "N");
		this.setText(2,17, "Mean");
		this.setText(2,18, "SD");
		this.setText(2,19, "CV");
		this.setText(2,20, "N");
		this.setText(2,21, "Mean");
		this.setText(2,22, "SD");
		this.setText(2,23, "CV");
		RFormatter.addStyleName(2, "centered");		
		if (tableNumber==9){
			BasePath += ">>Table9";
			fixedHeaderColumnsRows=initRows-2;
			String[] header3 = {"Serum T (ng/mL)"};
			fillRowTextBoxes(3,header3,1,"15ex","5ex");
			String[] header4 = {"Serum LH (ng/mL)"};
			fillRowTextBoxes(4,header4,1,"15ex","5ex");
			String[] header5 = {"Serum FSH (ng/mL)"};
			fillRowTextBoxes(5,header5,1,"15ex","5ex");
			fillRowTextBoxes(6,new String[0],1,"10ex","5ex");
			fillRowTextBoxes(7,new String[0],1,"10ex","5ex");
		}else{
			BasePath += ">>Table11";
			fixedHeaderColumnsRows=initRows;
			String[] header3 = {"Seminal vesicles"};
			fillRowTextBoxes(3,header3,1,"15ex","5ex");
			String[] header4 = {"Ventral prostate"};
			fillRowTextBoxes(4,header4,1,"15ex","5ex");
			String[] header5 = {"LABC"};
			fillRowTextBoxes(5,header5,1,"15ex","5ex");
			String[] header6 = {"Cowper's glands"};
			fillRowTextBoxes(6,header6,1,"15ex","5ex");
			String[] header7 = {"Glans penis"};
			fillRowTextBoxes(7,header7,1,"15ex","5ex");
		}			
	}

	@Override
	protected void fillRow(int rowIndex) {
		// TODO Auto-generated method stub

	}

}
