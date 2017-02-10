package com.lmc.der.sixComposers.client.widgets.tables.mpa;

import com.lmc.der.sixComposers.client.widgets.TextBoxLength;
import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2FlexTable;

public class MPATable1 extends FSTRA2FlexTable {

	public MPATable1(char Gender){
		String GenStr;
		if (Gender=='M'){
			GenStr = "Males";BasePath="MPA||MaterialsAndMethods>>StudyDesign>>Table1";			
		}else{
			GenStr = "Females";BasePath="FPA||MaterialsAndMethods>>StudyDesign>>Table1";
		}
		initRows = 5;columns=3;headerRows=1;headerColumns=1;
		fixedHeaderColumnsRows=initRows;
		RowFormatter RFormatter = this.getRowFormatter();
		this.addStyleName("double_bordered");
		
		this.setText(0, 0, "Test group");
		this.setHTML(0, 1, "Dose<br/>(mg/kg bw/day)");
		this.setHTML(0, 2, "# of<br/>"+GenStr);		
		
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");				
		
		
		fillRowTextBoxes(1, "Vehicle control");
		fillRowTextBoxes(2, "Low");
		fillRowTextBoxes(3, "Medium");
		fillRowTextBoxes(4, "High");
	}
	
//	@Override
//	public void fillRow(int rowIndex, String headerHTML) {
//		fillRowTextBoxes(rowIndex,headerHTML);		
//	}
	
	public boolean mediumDoseFilled(){
		return !((TextBoxLength)this.getWidget(3,1)).getWidgetValue().trim().isEmpty();
	}

	@Override
	protected void fillRow(int rowIndex) {
				
	}

}
