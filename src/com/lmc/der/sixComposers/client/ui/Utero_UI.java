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
import com.lmc.der.sixComposers.client.ui.handlers.Utero_Handlers;
import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2FlexTableButtons2;
import com.lmc.der.sixComposers.client.widgets.tables.utero.UteroTableParameters;
//import com.lmc.der.sixComposers.client.widgets.tables.AMA2TableAttachedFiles;


public class Utero_UI extends DER_UI {
	
	private final Utero_Handlers Handlers;	
	
	@UiTemplate("templates/utero/GeneralInfo.ui.xml")
	interface GeneralInfoUiBinder extends UiBinder<Widget, Utero_UI> {}
	@UiTemplate("templates/utero/materials/Materials.ui.xml")
	interface MaterialsUiBinder extends UiBinder<Widget, Utero_UI> {}
	@UiTemplate("templates/utero/materials/StudyDesign.ui.xml")
	interface StudyDesignUiBinder extends UiBinder<Widget, Utero_UI> {}
	@UiTemplate("templates/utero/materials/Dose.ui.xml")
	interface DoseUiBinder extends UiBinder<Widget, Utero_UI> {}
	@UiTemplate("templates/utero/materials/Methods.ui.xml")
	interface MethodsUiBinder extends UiBinder<Widget, Utero_UI> {}
	@UiTemplate("templates/utero/results/Observations.ui.xml")
	interface ObservationsUiBinder extends UiBinder<Widget, Utero_UI> {}
	@UiTemplate("templates/utero/results/Weight.ui.xml")
	interface WeightUiBinder extends UiBinder<Widget, Utero_UI> {}
	@UiTemplate("templates/utero/results/Food.ui.xml")
	interface FoodUiBinder extends UiBinder<Widget, Utero_UI> {}
	@UiTemplate("templates/utero/results/UterineWeights.ui.xml")
	interface UterineWeightsUiBinder extends UiBinder<Widget, Utero_UI> {}
	@UiTemplate("templates/utero/results/VaginaExam.ui.xml")
	interface VaginaExamUiBinder extends UiBinder<Widget, Utero_UI> {}
	@UiTemplate("templates/utero/results/OvariesExam.ui.xml")
	interface OvariesExamUiBinder extends UiBinder<Widget, Utero_UI> {}
	
	
	@UiTemplate("templates/utero/DiscussionConclusions.ui.xml")
	interface DiscussionConclusionsUiBinder extends UiBinder<Widget, Utero_UI> {}
	interface ExSumResources extends ClientBundle {
		@Source("templates/utero/ExSum.html") TextResource exSum();
	}
	
	enum Utero_TableNumber{
		TBL_REV,TBL_CIT,
		TBL2,TBL3,TBL4,TBL5,TBL6,TBL7,TBL8,TBL9,TBL10,TBL11,TBL12,TBL13
		}
	
	public Utero_UI(){		
		Handlers = new Utero_Handlers();
		this.addAttachHandler(Handlers);
		
		UiBinder<Widget,Utero_UI> UiBi;		
		TabPanel MMTP = new TabPanel();
		TabPanel RDTP = new TabPanel();		
		
		UiBi = GWT.create(GeneralInfoUiBinder.class); 
		this.add(UiBi.createAndBindUi(this)	,"General Info", false);
		this.add(MMTP						,"Materials & Methods", false);
		this.add(RDTP						,"Results", false);
		UiBi = GWT.create(MaterialsUiBinder.class); 
		MMTP.add(UiBi.createAndBindUi(this)		,"Materials", false);
		UiBi = GWT.create(StudyDesignUiBinder.class); 
		MMTP.add(UiBi.createAndBindUi(this)		,"Study design", false);
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
		UiBi = GWT.create(UterineWeightsUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Uterine Weight", false);
		UiBi = GWT.create(VaginaExamUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Vagina Exam.", false);
		UiBi = GWT.create(OvariesExamUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Ovaries Exam.", false);		
		UiBi = GWT.create(DiscussionConclusionsUiBinder.class); 
		this.add(UiBi.createAndBindUi(this)	,"Discussion & Conclusions", false);
		
		this.selectTab(0);
		MMTP.selectTab(0);
		RDTP.selectTab(0);
	}	
	/*
	public enum Utero_UIButtonName{
		REV_ADD,REV_REM,CIT_ADD,CIT_REM,
//		PAR_ADD,PAR_REM,TIS_ADD,TIS_REM,
//		OBS_ADD,OBS_REM,ORG_ADD,ORG_REM,
//		HOR_ADD,HOR_REM,CCH_ADD,CCH_REM,OBS8_ADD,OBS8_REM
	}
	@UiFactory AMA2TableReviewers makesAMA2TableReviewers(){
//		FSTRA2EntryPoint.WidList.add(TblRev);
		return TblRev;
	}
	@UiFactory AMA2TableCitations makesAMA2TableCitations(){
//		FSTRA2EntryPoint.WidList.add(TblCit);
		return TblCit;
	}
//	@UiFactory AMA2TableAttachedFiles makesAMA2TableAttachedFiles(){		
//		FSTRA2EntryPoint.WidList.add(TblAttPic);
//		return TblAttPic;
//	}
	@UiFactory AMA2ListBoxYesNoUn makesAMA2ListBoxYesNoUn(){
		AMA2ListBoxYesNoUn wid = new AMA2ListBoxYesNoUn();
		FSTRA2EntryPoint.WidList.add(wid);
		return wid;
	}
	@UiFactory AMA2ListBoxYesNo makesAMA2ListBoxYesNo(){
		AMA2ListBoxYesNo wid = new AMA2ListBoxYesNo();
		FSTRA2EntryPoint.WidList.add(wid);
		return wid;
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
	@UiFactory UteroTable1 makesUteroTable1(){		
//		FSTRA2EntryPoint.WidList.add(Tbl1);
		return Tbl1;
	}
	@Override
	public void onClick(ClickEvent event) {		
		Button BtnSource = (Button)event.getSource();
		if (BtnSource.equals(BtnRevAdd))			{TblRev.addRow(0);addRev++;}
		if (BtnSource.equals(BtnRevRem)&&addRev>0)	{TblRev.remRow(0);addRev--;}
		if (BtnSource.equals(BtnCitAdd))			{TblCit.addRow(0);addCit++;}
		if (BtnSource.equals(BtnCitRem)&&addCit>0)	{TblCit.remRow(0);addCit--;}

	}	
	*/
	@UiFactory FSTRA2FlexTableButtons2 makesFSTRA2FlexTableButtons2(Utero_TableNumber TblName){		
		switch(TblName){
		case TBL_REV:	return Handlers.TblRevBtn;
		case TBL_CIT:	return Handlers.TblCitBtn;
		case TBL2:	return Handlers.TablesButtonsArr[2];
		case TBL3:	return Handlers.TablesButtonsArr[3];
		case TBL4:	return Handlers.TablesButtonsArr[4];
		case TBL5:	return Handlers.TablesButtonsArr[5];
		case TBL6:	return Handlers.TablesButtonsArr[6];
		case TBL7:	return Handlers.TablesButtonsArr[7];
		case TBL10:	return Handlers.TablesButtonsArr[10];
		case TBL11:	return Handlers.TablesButtonsArr[11];
		case TBL12:	return Handlers.TablesButtonsArr[12];
		case TBL13:	return Handlers.TablesButtonsArr[13];
		default:	return null;
		}
	}
	@UiFactory UteroTableParameters makesUteroTableParameters(Utero_TableNumber TblName ){
		if (TblName==Utero_TableNumber.TBL8)
			return (UteroTableParameters)Handlers.Tbl8;
		else
			return (UteroTableParameters)Handlers.Tbl9;	
	}
	@UiFactory UploadableImage makesUploadableImage(){return new UploadableImage("Structure file","UA");}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return true;
	}

}
