package com.lmc.der.sixComposers.client.widgets.tables.utero;

import com.lmc.der.sixComposers.client.widgets.DERTextBoxLength;
import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2FlexTable;

public class UteroTableObservations extends FSTRA2FlexTable {
	
	public UteroTableObservations(int tableNumber){
		boolean estrogen = (tableNumber%2==0);
		
		
		initRows =  3;
		columns=11;headerRows=initRows;headerColumns=1;
		fixedHeaderColumnsRows=initRows;
		BasePath = "UA||ResultsAndDiscussion>>Table"+tableNumber;
		
		this.setText(0, 0, "Observations");		
		this.setText(0, 1, "Dose (mg/kg bw/day)");
		CFormatter.setRowSpan(0, 0,  3);
		CFormatter.setColSpan(0, 1, 10);
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");
		this.setText(1, 0, "Vehicle Control");		
		this.setText(1, 1, estrogen?"Low":"EE");
		this.setText(1, 2, estrogen?"Mid":"Low (+EE)");
		this.setText(1, 3, estrogen?"High":"Mid (+EE)");
		this.setText(1, 4, estrogen?"Reference Estrogen EE":"High (+EE)");
		CFormatter.setColSpan(1, 0, 2);
		CFormatter.setColSpan(1, 1, 2);
		CFormatter.setColSpan(1, 2, 2);
		CFormatter.setColSpan(1, 3, 2);
		CFormatter.setColSpan(1, 4, 2);
		RFormatter.addStyleName(1, "centered");
		RFormatter.addStyleName(1, "bolded");
		this.setText(2, 0, "# Observed");
		this.setText(2, 1, "# Examined");
		this.setText(2, 2, "# Observed");
		this.setText(2, 3, "# Examined");
		this.setText(2, 4, "# Observed");
		this.setText(2, 5, "# Examined");
		this.setText(2, 6, "# Observed");
		this.setText(2, 7, "# Examined");
		this.setText(2, 8, "# Observed");
		this.setText(2, 9, "# Examined");
		RFormatter.addStyleName(2, "centered");
		
		if (tableNumber==10||tableNumber==11){
			initRows=5;
			fillRow(3);((DERTextBoxLength)this.getWidget(3,0)).setWidgetDefaultValue("Keratinization");
			fillRow(4);((DERTextBoxLength)this.getWidget(4,0)).setWidgetDefaultValue("Cornification");
		}else if (tableNumber==12||tableNumber==13){
			initRows=4;
			fillRow(3);((DERTextBoxLength)this.getWidget(3,0)).setWidgetDefaultValue("Epithelial cell height");
		}
	}

	@Override
	protected void fillRow(int rowIndex) {
//		fillRowTextBoxes(rowIndex,new String[0],1,"15ex","5ex");
		fillRowTextBoxes(rowIndex);
	}

}
