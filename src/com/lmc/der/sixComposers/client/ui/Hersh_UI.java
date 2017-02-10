package com.lmc.der.sixComposers.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.der.lib.client.upload.image.UploadableImage;
import com.lmc.der.sixComposers.client.ui.handlers.Hersh_Handlers;
import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2FlexTableButtons2;
import com.lmc.der.sixComposers.client.widgets.tables.hersh.HershTable1;
import com.lmc.der.sixComposers.client.widgets.tables.hersh.HershTable8;
import com.lmc.der.sixComposers.client.widgets.tables.hersh.HershTable9;
//import com.lmc.der.sixComposers.client.widgets.tables.AMA2TableAttachedFiles;

public class Hersh_UI extends DER_UI {
	
	private final Hersh_Handlers Handlers;	
	
	@UiTemplate("templates/hersh/GeneralInfo.ui.xml")
	interface GeneralInfoUiBinder extends UiBinder<Widget, Hersh_UI> {}
	@UiTemplate("templates/hersh/materials/Materials.ui.xml")
	interface MaterialsUiBinder extends UiBinder<Widget, Hersh_UI> {}
	@UiTemplate("templates/hersh/materials/StudyDesign.ui.xml")
	interface StudyDesignUiBinder extends UiBinder<Widget, Hersh_UI> {}
	@UiTemplate("templates/hersh/materials/Dose.ui.xml")
	interface DoseUiBinder extends UiBinder<Widget, Hersh_UI> {}
	@UiTemplate("templates/hersh/materials/Methods.ui.xml")
	interface MethodsUiBinder extends UiBinder<Widget, Hersh_UI> {}
	@UiTemplate("templates/hersh/results/Observations.ui.xml")
	interface ObservationsUiBinder extends UiBinder<Widget, Hersh_UI> {}
	@UiTemplate("templates/hersh/results/Weight.ui.xml")
	interface WeightUiBinder extends UiBinder<Widget, Hersh_UI> {}
	@UiTemplate("templates/hersh/results/Food.ui.xml")
	interface FoodUiBinder extends UiBinder<Widget, Hersh_UI> {}
	@UiTemplate("templates/hersh/results/Hormones.ui.xml")
	interface HormonesUiBinder extends UiBinder<Widget, Hersh_UI> {}
	@UiTemplate("templates/hersh/results/Organs.ui.xml")
	interface OrgansUiBinder extends UiBinder<Widget, Hersh_UI> {}
	
	@UiTemplate("templates/hersh/DiscussionConclusions.ui.xml")
	interface DiscussionConclusionsUiBinder extends UiBinder<Widget, Hersh_UI> {}
	interface ExSumResources extends ClientBundle {@Source("templates/hersh/ExSum.html") TextResource exSum();}	
	enum Hersh_TableNumber{TBL_REV,TBL_CIT,TBL2,TBL3,TBL4,TBL5,TBL6,TBL7,TBL8,TBL9,TBL10,TBL11}
	
	public Hersh_UI(){
		
		Handlers = new Hersh_Handlers();
		this.addAttachHandler(Handlers);
		
		UiBinder<Widget,Hersh_UI> UiBi;		
		TabPanel MMTP = new TabPanel();
		TabPanel RDTP = new TabPanel();		
		
		UiBi = GWT.create(GeneralInfoUiBinder.class); 
		this.add(UiBi.createAndBindUi(this)	,"General Info", false);
		this.add(MMTP						,"Materials & Methods", false);
		this.add(RDTP						,"Results", false);
		UiBi = GWT.create(MaterialsUiBinder.class); 
		MMTP.add(UiBi.createAndBindUi(this)		,"Materials", false);
		UiBi = GWT.create(StudyDesignUiBinder.class); 
		MMTP.add(UiBi.createAndBindUi(this)		,"Study Design", false);
		UiBi = GWT.create(DoseUiBinder.class); 
		MMTP.add(UiBi.createAndBindUi(this)		,"Dose", false);
		UiBi = GWT.create(MethodsUiBinder.class); 
		MMTP.add(UiBi.createAndBindUi(this)		,"Methods", false);
		UiBi = GWT.create(ObservationsUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Observations", false);
		UiBi = GWT.create(WeightUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Weight", false);
		UiBi = GWT.create(FoodUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Food", false);
		UiBi = GWT.create(HormonesUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Hormones", false);
		UiBi = GWT.create(OrgansUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Organs", false);
		
		UiBi = GWT.create(DiscussionConclusionsUiBinder.class); 
		this.add(UiBi.createAndBindUi(this)	,"Discussion & Conclusions", false);
		
		this.selectTab(0);
		MMTP.selectTab(0);
		RDTP.selectTab(0);
	}
	
	/*
	public enum Hersh_UIButtonName{
		REV_ADD,REV_REM,CIT_ADD,CIT_REM,
		TBL2_ADD,TBL2_REM,TBL3_ADD,TBL3_REM,TBL4_ADD,TBL4_REM
//		OBS_ADD,OBS_REM,ORG_ADD,ORG_REM,
//		HOR_ADD,HOR_REM,CCH_ADD,CCH_REM,OBS8_ADD,OBS8_REM
	}
	
	@UiFactory Button makesButton(Hersh_UIButtonName btnName){
//		System.out.println(btnNames);
		Button BtnForReturn = null;
		switch(btnName){
		case REV_ADD			:BtnForReturn = BtnRevAdd	= new Button("Add Reviewer",	this);break;
		case REV_REM			:BtnForReturn = BtnRevRem	= new Button("Remove Reviewer",	this);break;
		case CIT_ADD			:BtnForReturn = BtnCitAdd	= new Button("Add Citation",	this);break;
		case CIT_REM			:BtnForReturn = BtnCitRem	= new Button("Remove Citation",	this);break;		
		case TBL2_ADD			:BtnForReturn = BtnTbl2Add	= new Button("Add Observation",	this);break;
		case TBL2_REM			:BtnForReturn = BtnTbl2Rem	= new Button("Remove Observation",	this);break;
		case TBL3_ADD			:BtnForReturn = BtnTbl3Add	= new Button("Add Observation",	this);break;
		case TBL3_REM			:BtnForReturn = BtnTbl3Rem	= new Button("Remove Observation",	this);break;
		case TBL4_ADD			:BtnForReturn = BtnTbl4Add	= new Button("Add Row",	this);break;
		case TBL4_REM			:BtnForReturn = BtnTbl4Rem	= new Button("Remove Row",	this);break;
//		case TBL5_ADD			:BtnForReturn = BtnCChAdd	= new Button("Add Parameter",	this);break;
//		case TBL5_REM			:BtnForReturn = BtnCChRem	= new Button("Remove Parameter",	this);break;
//		case OBS8_ADD			:BtnForReturn = BtnObs8Add	= new Button("Add Observation",	this);break;
//		case OBS8_REM			:BtnForReturn = BtnObs8Rem	= new Button("Remove Observation",	this);break;
//		default					:BtnForReturn = new Button();		
		}
		return BtnForReturn;
	}
	@UiFactory DERListBoxYesNo makesAMA2ListBoxYesNo(){
		DERListBoxYesNo wid = new DERListBoxYesNo();
		return wid;
	}
	@UiFactory AMA2TableReviewers makesAMA2TableReviewers(){return TblRev;}
	@UiFactory AMA2TableCitations makesAMA2TableCitations(){return TblCit;}
	@UiFactory AMA2TableAttachedFiles makesAMA2TableAttachedFiles(){		
//		FSTRA2EntryPoint.WidList.add(TblAttPic);
		return TblAttPic;
	}
	@UiFactory HershTable2 makesHershTable2(){		
//		FSTRA2EntryPoint.WidList.add(Tbl2);
		return Tbl2;
	}
	@UiFactory HershTable3 makesHershTable3(){		
//		FSTRA2EntryPoint.WidList.add(Tbl3);
		return Tbl3;
	}
	@UiFactory HershTable4 makesHershTable4(){		
//		FSTRA2EntryPoint.WidList.add(Tbl4);
		return Tbl4;
	}
	@UiFactory AMA2ListBox makesAMA2ListBox(){
		AMA2ListBox wid = new AMA2ListBox();
		FSTRA2EntryPoint.WidList.add(wid);
		return wid;
	}
	@UiFactory AMA2TextBox makesAMA2TextBox(){
		AMA2TextBox tb = new AMA2TextBox();
		FSTRA2EntryPoint.WidList.add(tb);
		return tb;
	}
	@Override
	public void onClick(ClickEvent event) {
		Button BtnSource = (Button)event.getSource();
		if (BtnSource.equals(BtnRevAdd))			{TblRev.addRow(0);addRev++;}
		if (BtnSource.equals(BtnRevRem)&&addRev>0)	{TblRev.remRow(0);addRev--;}
		if (BtnSource.equals(BtnCitAdd))			{TblCit.addRow(0);addCit++;}
		if (BtnSource.equals(BtnCitRem)&&addCit>0)	{TblCit.remRow(0);addCit--;}
		if (BtnSource.equals(BtnTbl2Add))			{Tbl2  .addRow(0);addTbl2++;}
		if (BtnSource.equals(BtnTbl2Rem)&&addTbl2>0){Tbl2  .remRow(0);addTbl2--;}
		if (BtnSource.equals(BtnTbl3Add))			{Tbl3  .addRow(0);addTbl3++;}
		if (BtnSource.equals(BtnTbl3Rem)&&addTbl3>0){Tbl3  .remRow(0);addTbl3--;}
		if (BtnSource.equals(BtnTbl4Add))			{Tbl4  .addRow(0);addTbl4++;}
		if (BtnSource.equals(BtnTbl4Rem)&&addTbl4>0){Tbl4  .remRow(0);addTbl4--;}
	}
	*/
	@UiFactory HershTable1 makesHershTable1(){return Handlers.Tbl1;}
	
	@UiFactory FSTRA2FlexTableButtons2 makesFSTRA2FlexTableButtons2(Hersh_TableNumber TblName){		
		switch(TblName){
		case TBL_REV:return Handlers.TablesButtonsArr[0];
		case TBL_CIT:return Handlers.TablesButtonsArr[1];
		case TBL2:	return Handlers.TablesButtonsArr[2];
		case TBL3:	return Handlers.TablesButtonsArr[3];
		case TBL4:	return Handlers.TablesButtonsArr[4];
		case TBL5:	return Handlers.TablesButtonsArr[5];
		case TBL6:	return Handlers.TablesButtonsArr[6];
		case TBL7:	return Handlers.TablesButtonsArr[7];
		default:	return null;
		}
	}
	@UiFactory HershTable8 makesHershTable8(Hersh_TableNumber tableNumber){
		if (tableNumber==Hersh_TableNumber.TBL8)
			return Handlers.Tbl8;
		else
			return Handlers.Tbl10;
	}
	@UiFactory HershTable9 makesHershTable9(Hersh_TableNumber tableNumber){		
		if (tableNumber==Hersh_TableNumber.TBL9)
			return Handlers.Tbl9;
		else
			return Handlers.Tbl11;
	}
	@UiFactory UploadableImage makesUploadableImage(){return new UploadableImage("Structure file","HA");}
	
	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return true;
	}

}
