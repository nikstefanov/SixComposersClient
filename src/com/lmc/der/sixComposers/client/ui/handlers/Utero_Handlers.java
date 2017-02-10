package com.lmc.der.sixComposers.client.ui.handlers;

import com.google.gwt.event.dom.client.ClickEvent;
import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2FlexTable;
import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2FlexTableButtons2;
import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2TableCitations;
import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2TableReviewers;
import com.lmc.der.sixComposers.client.widgets.tables.utero.UteroTableObservations;
import com.lmc.der.sixComposers.client.widgets.tables.utero.UteroTableParameters;

public class Utero_Handlers extends DER_Handlers {
	
	public final FSTRA2FlexTableButtons2[] TablesButtonsArr;
	public final FSTRA2FlexTableButtons2 TblRevBtn,TblCitBtn;
	public final FSTRA2FlexTable Tbl8,Tbl9;

	public Utero_Handlers() {
		
		
		FSTRA2TableReviewers TblRev = new FSTRA2TableReviewers();TblRev.setBasePath("UA||GeneralInfo>>TableReviewers");
		TblRevBtn = new FSTRA2FlexTableButtons2(TblRev,"Reviewer","UA||InterfaceInfo>>ReviewersNumber");
		FSTRA2TableCitations TblCit = new FSTRA2TableCitations();TblCit.setBasePath("UA||GeneralInfo>>TableCitations");
		TblCitBtn = new FSTRA2FlexTableButtons2(TblCit,"Citation","UA||InterfaceInfo>>CitationsNumber");
		
		TablesButtonsArr = new FSTRA2FlexTableButtons2[14];
		TablesButtonsArr[2] =new FSTRA2FlexTableButtons2(new UteroTableObservations(2),"Row","UA||InterfaceInfo>>Tbl02AddRows");
		TablesButtonsArr[3] =new FSTRA2FlexTableButtons2(new UteroTableObservations(3),"Row","UA||InterfaceInfo>>Tbl03AddRows");
		TablesButtonsArr[4] =new FSTRA2FlexTableButtons2(new UteroTableParameters(4),"Row","UA||InterfaceInfo>>Tbl04AddRows");
		TablesButtonsArr[5] =new FSTRA2FlexTableButtons2(new UteroTableParameters(5),"Row","UA||InterfaceInfo>>Tbl05AddRows");
		TablesButtonsArr[6] =new FSTRA2FlexTableButtons2(new UteroTableParameters(6),"Row","UA||InterfaceInfo>>Tbl06AddRows");
		TablesButtonsArr[7] =new FSTRA2FlexTableButtons2(new UteroTableParameters(7),"Row","UA||InterfaceInfo>>Tbl07AddRows");
		TablesButtonsArr[10] =new FSTRA2FlexTableButtons2(new UteroTableObservations(10),"Row","UA||InterfaceInfo>>Tbl10AddRows");
		TablesButtonsArr[11] =new FSTRA2FlexTableButtons2(new UteroTableObservations(11),"Row","UA||InterfaceInfo>>Tbl11AddRows");
		TablesButtonsArr[12] =new FSTRA2FlexTableButtons2(new UteroTableObservations(12),"Row","UA||InterfaceInfo>>Tbl12AddRows");
		TablesButtonsArr[13] =new FSTRA2FlexTableButtons2(new UteroTableObservations(13),"Row","UA||InterfaceInfo>>Tbl13AddRows");
		
		Tbl8 = new UteroTableParameters(8);
		Tbl9 = new UteroTableParameters(9); 
	}

	@Override
	public void onClick(ClickEvent event) {	}

	@Override
	protected void updateConstants() {
		TblRevBtn.updateConstants();
		TblCitBtn.updateConstants();
		for(FSTRA2FlexTableButtons2 tbl:TablesButtonsArr) if (tbl!=null) tbl.updateConstants();
	}

}
