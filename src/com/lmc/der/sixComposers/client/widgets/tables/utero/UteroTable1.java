package com.lmc.der.sixComposers.client.widgets.tables.utero;

import com.gwt.der.lib.client.handlers.ValueWidget;
import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2FlexTable;

public class UteroTable1 extends FSTRA2FlexTable {
	
	public UteroTable1(){
		initRows=13;
		columns=3;headerRows=2;headerColumns=1;fixedHeaderColumnsRows=initRows;
		BasePath = "UA||MaterialsAndMethods>>Table1";
		this.setText(0, 0, "Test group");
		this.setHTML(0, 1, "Dose<br/>(mg/kg/day)");
		this.setText(0, 2, "# of Females");
		this.setText(1, 0, "Estrogen Agonist Assay");
		CFormatter.setColSpan(1, 0, 3);
		fillRowTextBoxes( 2,"Vehicle Control");
		fillRowTextBoxes( 3,"Low");
		fillRowTextBoxes( 4,"Mid");
		fillRowTextBoxes( 5,"High");
		fillRowTextBoxes( 6,"17&alpha;-ethynyl estradiol (EE), Reference Estrogen");
		this.setText(7, 0, "Anti-Estrogen Assay");
		CFormatter.setColSpan(7, 0, 3);
		fillRowTextBoxes( 8,"Vehicle Control");
		fillRowTextBoxes( 9,"17&alpha;-ethynyl estradiol (EE), Reference Estrogen");
		fillRowTextBoxes(10,"Low(+EE)");		
		fillRowTextBoxes(11,"Mid(+EE)");
		fillRowTextBoxes(12,"High(+EE)");
		
		RFormatter.addStyleName(0, "centered");RFormatter.addStyleName(0, "bolded");
		RFormatter.addStyleName(1, "centered");RFormatter.addStyleName(1, "bolded");
		RFormatter.addStyleName(7, "centered");RFormatter.addStyleName(7, "bolded");
		
		ValueWidget wid;
		for (int rIndex=headerRows; rIndex<7; rIndex++){
			wid = (ValueWidget)this.getWidget(rIndex, 1);
			wid.setName(correctPath(wid.getName(),rIndex));
			wid = (ValueWidget)this.getWidget(rIndex, 2);
			wid.setName(correctPath(wid.getName(),rIndex));
		}
		for (int rIndex=8; rIndex<initRows; rIndex++){
			wid = (ValueWidget)this.getWidget(rIndex, 1);
			wid.setName(correctPath(wid.getName(),rIndex));
			wid = (ValueWidget)this.getWidget(rIndex, 2);
			wid.setName(correctPath(wid.getName(),rIndex));
		}
	}

	@Override
	protected void fillRow(int rowIndex) {
		// TODO Auto-generated method stub

	}
	
	private String correctPath(String oldPath,int row){
		if (row<7)
			return oldPath.replaceFirst("Row", "EstrogenRow");
		else
			return oldPath.replaceFirst((row-headerRows)+"]Row", (row-8)+"]AntiEstrogenRow");
	}

}
