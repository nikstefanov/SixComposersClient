package com.lmc.der.sixComposers.client.ui.handlers;

import com.google.gwt.event.dom.client.ClickEvent;
import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2FlexTable;
import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2FlexTableButtons2;
import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2TableCitations;
import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2TableReviewers;
import com.lmc.der.sixComposers.client.widgets.tables.hersh.HershTable1;
import com.lmc.der.sixComposers.client.widgets.tables.hersh.HershTable2;
import com.lmc.der.sixComposers.client.widgets.tables.hersh.HershTable3;
import com.lmc.der.sixComposers.client.widgets.tables.hersh.HershTable4;
import com.lmc.der.sixComposers.client.widgets.tables.hersh.HershTable5;
import com.lmc.der.sixComposers.client.widgets.tables.hersh.HershTable8;
import com.lmc.der.sixComposers.client.widgets.tables.hersh.HershTable9;

public class Hersh_Handlers extends DER_Handlers {

//	private final AMA2TableAttachedFiles TblAttPic;
	public final HershTable1 Tbl1;
	public final HershTable8 Tbl8;
	public final HershTable9 Tbl9;
	public final HershTable8 Tbl10;
	public final HershTable9 Tbl11;
	public final FSTRA2FlexTableButtons2[] TablesButtonsArr;

	public Hersh_Handlers() {
		FSTRA2FlexTable F2Tbl;
//		TblAttPic = new AMA2TableAttachedFiles(1);
		Tbl1 = new HershTable1();		
		TablesButtonsArr = new FSTRA2FlexTableButtons2[8];
		F2Tbl = new FSTRA2TableReviewers();F2Tbl.setBasePath("HA||GeneralInfo>>TableReviewers");
		TablesButtonsArr[0] =new FSTRA2FlexTableButtons2(F2Tbl,"Reviewer","HA||InterfaceInfo>>ReviewersNumber");
		F2Tbl = new FSTRA2TableCitations();F2Tbl.setBasePath("HA||GeneralInfo>>TableCitations");
		TablesButtonsArr[1] =new FSTRA2FlexTableButtons2(F2Tbl,"Citation","HA||InterfaceInfo>>CitationsNumber");
		F2Tbl = new HershTable2();F2Tbl.setBasePath("HA||ResultsAndDiscussion>>Table2");
		TablesButtonsArr[2] =new FSTRA2FlexTableButtons2(F2Tbl,"Observation","HA||InterfaceInfo>>Tbl02AddRows");
		F2Tbl = new HershTable3();F2Tbl.setBasePath("HA||ResultsAndDiscussion>>Table3");
		TablesButtonsArr[3] =new FSTRA2FlexTableButtons2(F2Tbl,"Observation","HA||InterfaceInfo>>Tbl03AddRows");
		F2Tbl = new HershTable4();F2Tbl.setBasePath("HA||ResultsAndDiscussion>>Table4");
		TablesButtonsArr[4] =new FSTRA2FlexTableButtons2(F2Tbl,"Row","HA||InterfaceInfo>>Tbl04AddRows");
		F2Tbl = new HershTable5();F2Tbl.setBasePath("HA||ResultsAndDiscussion>>Table5");
		TablesButtonsArr[5] =new FSTRA2FlexTableButtons2(F2Tbl,"Row","HA||InterfaceInfo>>Tbl05AddRows");
		F2Tbl = new HershTable4();F2Tbl.setBasePath("HA||ResultsAndDiscussion>>Table6");
		TablesButtonsArr[6] =new FSTRA2FlexTableButtons2(F2Tbl,"Row","HA||InterfaceInfo>>Tbl06AddRows");
		F2Tbl = new HershTable5();F2Tbl.setBasePath("HA||ResultsAndDiscussion>>Table7");
		TablesButtonsArr[7] =new FSTRA2FlexTableButtons2(F2Tbl,"Row","HA||InterfaceInfo>>Tbl07AddRows");
		Tbl8 = new HershTable8(8);
		Tbl9 = new HershTable9(9);
		Tbl10 = new HershTable8(10);
		Tbl11 = new HershTable9(11);
	}

	@Override
	public void onClick(ClickEvent event) {	}

	@Override
	protected void updateConstants() {
		for(FSTRA2FlexTableButtons2 tbl:TablesButtonsArr) tbl.updateConstants();
	}

}
