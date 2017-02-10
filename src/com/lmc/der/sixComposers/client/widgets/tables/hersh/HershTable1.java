package com.lmc.der.sixComposers.client.widgets.tables.hersh;

import com.gwt.der.lib.client.handlers.ValueWidget;
import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2FlexTable;

public class HershTable1 extends FSTRA2FlexTable {
	
	public HershTable1(){
		initRows=14;
		columns=3;headerRows=2;headerColumns=1;fixedHeaderColumnsRows=initRows;
		BasePath = "HA||MaterialsAndMethods>>Table1";
		this.setText(0, 0, "Test group");
		this.setHTML(0, 1, "Dose<br/>(mg/kg/day)");
		this.setText(0, 2, "# of Males");
		this.setText(1, 0, "Androgen Agonist Assay");
		CFormatter.setColSpan(1, 0, 3);
		fillRowTextBoxes( 2,"Vehicle Control(negative control)");
		fillRowTextBoxes( 3,"Testosterone propionate (TP)(s.c.), positive control");
		fillRowTextBoxes( 4,"Low");		
		fillRowTextBoxes( 5,"Mid");
		fillRowTextBoxes( 6,"High");		
		this.setText(7, 0, "Anti-Androgen Assay");
		CFormatter.setColSpan(7, 0, 3);
		fillRowTextBoxes( 8,"Vehicle Control");
		fillRowTextBoxes( 9,"Testosterone propionate (TP)(s.c.), negative control");
		fillRowTextBoxes(10,"Flutamide (oral gavage) + TP(s.c.), positive control");
		fillRowTextBoxes(11,"Low(+EE)");		
		fillRowTextBoxes(12,"Mid(+EE)");
		fillRowTextBoxes(13,"High(+EE)");
		
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
			return oldPath.replaceFirst("Row", "AndrogenRow");
		else
			return oldPath.replaceFirst((row-headerRows)+"]Row", (row-8)+"]AntiAndrogenRow");
	}
}
