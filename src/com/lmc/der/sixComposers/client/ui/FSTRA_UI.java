package com.lmc.der.sixComposers.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.Widget;
import com.lmc.der.sixComposers.client.ui.handlers.FSTRA_Handlers;
import com.lmc.der.sixComposers.client.widgets.DERAutoSuggestBox;
import com.lmc.der.sixComposers.client.widgets.DERListBoxYesNoReferenced;
import com.lmc.der.sixComposers.client.widgets.tables.AMA2TableCitations;
import com.lmc.der.sixComposers.client.widgets.tables.AMA2TableReviewers;
import com.lmc.der.sixComposers.client.widgets.tables.ama.AMA2Table8;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable1;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable10;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable11;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable12;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable13;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable14;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable15;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable16;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable17;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable18;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable19;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable20;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable21;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable22;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable23;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable24;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable5;
import com.lmc.der.sixComposers.client.widgets.tables.fstra.FSTRATable9;


public class FSTRA_UI extends DER_UI{	
	
	private final FSTRA_Handlers Handlers;	
	
	@UiTemplate("templates/fstra/GeneralInfo.ui.xml")
	interface GeneralInfoUiBinder extends UiBinder<Widget, FSTRA_UI> {}
	@UiTemplate("templates/fstra/materials/Materials.ui.xml")
	interface MaterialsUiBinder extends UiBinder<Widget, FSTRA_UI> {}
	@UiTemplate("templates/fstra/materials/TestOrganism.ui.xml")
	interface TestOrganismUiBinder extends UiBinder<Widget, FSTRA_UI> {}
	@UiTemplate("templates/fstra/materials/ExposureSystem.ui.xml")
	interface ExposureSystemUiBinder extends UiBinder<Widget, FSTRA_UI> {}
	@UiTemplate("templates/fstra/materials/StudyDesign.ui.xml")
	interface StudyDesignUiBinder extends UiBinder<Widget, FSTRA_UI> {}
	@UiTemplate("templates/fstra/materials/Concentrations.ui.xml")
	interface ConcentrationsUiBinder extends UiBinder<Widget, FSTRA_UI> {}
//	@Ui--Template("templates/fstra/results/Results.ui.xml")
//	interface ResultsUiBinder extends UiBinder<Widget, FSTRA_UI> {}
	@UiTemplate("templates/fstra/results/Survival.ui.xml")
	interface SurvivalyUiBinder extends UiBinder<Widget, FSTRA_UI> {}
	@UiTemplate("templates/fstra/results/Growth.ui.xml")
	interface GrowthUiBinder extends UiBinder<Widget, FSTRA_UI> {}
	@UiTemplate("templates/fstra/results/Fecundity.ui.xml")
	interface FecundityUiBinder extends UiBinder<Widget, FSTRA_UI> {}
	@UiTemplate("templates/fstra/results/NTS.ui.xml")
	interface NTSUiBinder extends UiBinder<Widget, FSTRA_UI> {}	
	@UiTemplate("templates/fstra/results/GSI.ui.xml")
	interface GSIUiBinder extends UiBinder<Widget, FSTRA_UI> {}
	@UiTemplate("templates/fstra/results/GondalStage.ui.xml")
	interface GondalStageUiBinder extends UiBinder<Widget, FSTRA_UI> {}
	@UiTemplate("templates/fstra/results/MaleHistopatology.ui.xml")
	interface MaleHistopatologyUiBinder extends UiBinder<Widget, FSTRA_UI> {}
	@UiTemplate("templates/fstra/results/AddlMaleHistopatology.ui.xml")
	interface AddlMaleHistopatologyUiBinder extends UiBinder<Widget, FSTRA_UI> {}
	@UiTemplate("templates/fstra/results/FemaleHistopatology.ui.xml")
	interface FemaleHistopatologyUiBinder extends UiBinder<Widget, FSTRA_UI> {}
	@UiTemplate("templates/fstra/results/AddlFemaleHistopatology.ui.xml")
	interface AddlFemaleHistopatologyUiBinder extends UiBinder<Widget, FSTRA_UI> {}
	@UiTemplate("templates/fstra/results/VTG.ui.xml")
	interface VTGUiBinder extends UiBinder<Widget, FSTRA_UI> {}
	@UiTemplate("templates/fstra/results/PlasmaSexSteroids.ui.xml")
	interface PlasmaSexSteroidsUiBinder extends UiBinder<Widget, FSTRA_UI> {}
	@UiTemplate("templates/fstra/results/ClinicalSigns.ui.xml")
	interface ClinicalSignsUiBinder extends UiBinder<Widget, FSTRA_UI> {}	
	@UiTemplate("templates/fstra/results/Analysis.ui.xml")
	interface AnalysisUiBinder extends UiBinder<Widget, FSTRA_UI> {}
	@UiTemplate("templates/fstra/results/MaleHPGEndpoints.ui.xml")
	interface MaleHPGEndpointsUiBinder extends UiBinder<Widget, FSTRA_UI> {}
	@UiTemplate("templates/fstra/results/FemaleHPGEndpoints.ui.xml")
	interface FemaleHPGEndpointsUiBinder extends UiBinder<Widget, FSTRA_UI> {}
	@UiTemplate("templates/fstra/results/GrowthEndpoints.ui.xml")
	interface GrowthEndpointsUiBinder extends UiBinder<Widget, FSTRA_UI> {}
	@UiTemplate("templates/fstra/results/StDeficienciesRevComments.ui.xml")
	interface SDRCUiBinder extends UiBinder<Widget, FSTRA_UI> {}	
	@UiTemplate("templates/fstra/References.ui.xml")
	interface ReferencesUiBinder extends UiBinder<HTMLPanel, FSTRA_UI> {}
	interface TxtResources extends ClientBundle {
		@Source("templates/fstra/ExSum1.html") TextResource exSum();
	}
	public enum FSTRA_UIButtonName{
		REV_ADD,REV_REM,CIT_ADD,CIT_REM,PAR_ADD,PAR_REM,TC_ADD,TC_REM,TYPE_ADD,TYPE_REM
	}
	enum AMASuggestBoxName{
		TOX_OF,EXPOSURE,FOOD_TYPE,DILUTION_SYSTEM,HTC_METHOD,SOURCE,CONC,SOLVENT,SUB_MAT
	}
	
	public FSTRA_UI(){		
		Handlers = new FSTRA_Handlers();
		this.addAttachHandler(Handlers);
		
		UiBinder<Widget,FSTRA_UI> UiBi;
		
		TabPanel MMTP = new TabPanel();
		TabPanel RDTP = new TabPanel();
		UiBi = GWT.create(GeneralInfoUiBinder.class); 
		this.add(UiBi.createAndBindUi(this)	,"General Info", false);
		this.add(MMTP							,"Materials & Methods", false);
		this.add(RDTP							,"Results & Discussion", false);
		
		UiBi = GWT.create(MaterialsUiBinder.class); 
		MMTP.add(UiBi.createAndBindUi(this)		,"Materials", false);
		UiBi = GWT.create(TestOrganismUiBinder.class); 
		MMTP.add(UiBi.createAndBindUi(this)		,"Test Organism", false);
		UiBi = GWT.create(ExposureSystemUiBinder.class); 
		MMTP.add(UiBi.createAndBindUi(this)		,"Exposure System", false);
		UiBi = GWT.create(StudyDesignUiBinder.class); 
		MMTP.add(UiBi.createAndBindUi(this)		,"Study Design & Conditions", false);
		UiBi = GWT.create(ConcentrationsUiBinder.class); 
		MMTP.add(UiBi.createAndBindUi(this)		,"Concentrations & Endpoints", false);
		
//		UiBi = GWT.create(ResultsUiBinder.class); 
//		RDTP.add(UiBi.createAndBindUi(this)		,"Results", false);
		UiBi = GWT.create(SurvivalyUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Survival", false);
		UiBi = GWT.create(GrowthUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Growth", false);
		UiBi = GWT.create(FecundityUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"FFS", false);
		UiBi = GWT.create(NTSUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"NTS", false);		
		UiBi = GWT.create(GSIUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"GSI", false);
		UiBi = GWT.create(GondalStageUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Gondal<br/>Stage", true);
		UiBi = GWT.create(MaleHistopatologyUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Male Histo<br/>patology", true);
		UiBi = GWT.create(AddlMaleHistopatologyUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Addl. Male<br/>Histopatology", true);
		UiBi = GWT.create(FemaleHistopatologyUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Female Hi<br/>stopatology", true);
		UiBi = GWT.create(AddlFemaleHistopatologyUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Addl. Female<br/>Histopatology", true);
		UiBi = GWT.create(VTGUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"VTG", false);
		UiBi = GWT.create(PlasmaSexSteroidsUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Plasma Sex<br/>Steroids", true);
		UiBi = GWT.create(ClinicalSignsUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Clinical<br/>Signs", true);
		UiBi = GWT.create(AnalysisUiBinder.class);		
		RDTP.add(UiBi.createAndBindUi(this)		,"Analysis", false);
		UiBi = GWT.create(MaleHPGEndpointsUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Male HPG<br/>Endpoints", true);
		UiBi = GWT.create(FemaleHPGEndpointsUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Female HPG<br/>Endpoints", true);
		UiBi = GWT.create(GrowthEndpointsUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Growth<br/>Endpoints", true);
		UiBi = GWT.create(SDRCUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"St.Deficiencies<br/>Rev.Comments", true);		
		
		UiBi = GWT.create(ReferencesUiBinder.class); 
		this.add(UiBi.createAndBindUi(this)	,"References", false);
		
		this.selectTab(0);
		MMTP.selectTab(0);
		RDTP.selectTab(0);
//		MMTP.setWidth("20em");
	}
	
	@UiFactory Button makesButton(AMA_UI.AMA_ButtonName btnName){
//		System.out.println(btnNames);
		switch(btnName){
		case REV_ADD			:return Handlers.BtnRevAdd;
		case REV_REM			:return Handlers.BtnRevRem;
		case CIT_ADD			:return Handlers.BtnCitAdd;
		case CIT_REM			:return Handlers.BtnCitRem;
		case TBL5_ADD			:return Handlers.BtnParAdd;
		case TBL5_REM			:return Handlers.BtnParRem;
		case TBL8_ADD			:return Handlers.BtnTCAdd;
		case TBL8_REM			:return Handlers.BtnTCRem;
		case TYPE_ADD			:return Handlers.BtnTypeAdd;
		case TYPE_REM			:return Handlers.BtnTypeRem;
		default					:return null;		
		}
	}
	/*
	private AMA2TextBox makesAMA2TextBoxLength(int visChars){
		AMA2TextBox tb;
		if (visChars==0)
			tb = new AMA2TextBox();
		else
			tb = new AMA2TextBox(visChars);
		if (FSTRA2EntryPoint.WidList.size()==0) tb.addChangeHandler(this);	
		if (FSTRA2EntryPoint.WidList.size()==27)tb.addChangeHandler(this);
		
		if (FSTRA2EntryPoint.WidList.size()==1) tb.addChangeHandler(this);	
		if (FSTRA2EntryPoint.WidList.size()==39)tb.addChangeHandler(this);
		
		if (FSTRA2EntryPoint.WidList.size()==9) tb.addChangeHandler(this);	
		if (FSTRA2EntryPoint.WidList.size()==28)tb.addChangeHandler(this);
		
		if (FSTRA2EntryPoint.WidList.size()==11)tb.setValidationExpresion("\\d{0,6}");//PC Code
		if (FSTRA2EntryPoint.WidList.size()==3)	tb.setValidationExpresion("\\d{0,6}");//DP Barcode
		if (FSTRA2EntryPoint.WidList.size()==5)	tb.setValidationExpresion("\\d{0,8}");//MRID
		FSTRA2EntryPoint.WidList.add(tb);
		return tb;
	}*/	
	
	@UiFactory AMA2TableReviewers makesAMA2TableReviewers(){return Handlers.TblRev;}
	@UiFactory AMA2TableCitations makesAMA2TableCitations(){return Handlers.TblCit;}
	@UiFactory FSTRATable1 makesFSTRATable1(){return Handlers.Tbl1;}
	@UiFactory FSTRATable5 makesFSTRATable5(){return Handlers.Tbl5;}
	@UiFactory AMA2Table8 makesAMA2Table8(){return Handlers.Tbl8;}
	@UiFactory FSTRATable9 makesFSTRATable9(){return Handlers.Tbl9;}
	@UiFactory FSTRATable10 makesFSTRATable10(){return Handlers.Tbl10;}
	@UiFactory FSTRATable11 makesFSTRATable11(){return Handlers.Tbl11;}
	@UiFactory FSTRATable12 makesFSTRATable12(){return Handlers.Tbl12;}
	@UiFactory FSTRATable13 makesFSTRATable13(){return Handlers.Tbl13;}
	@UiFactory FSTRATable14 makesFSTRATable14(){return Handlers.Tbl14;}
	@UiFactory FSTRATable15 makesFSTRATable15(){return Handlers.Tbl15;}
	@UiFactory FSTRATable16 makesFSTRATable16(){return Handlers.Tbl16;}
	@UiFactory FSTRATable17 makesFSTRATable17(){return Handlers.Tbl17;}
	@UiFactory FSTRATable18 makesFSTRATable18(){return Handlers.Tbl18;}
	@UiFactory FSTRATable19 makesFSTRATable19(){return Handlers.Tbl19;}
	@UiFactory FSTRATable20 makesFSTRATable20(){return Handlers.Tbl20;}
	@UiFactory FSTRATable21 makesFSTRATable21(){return Handlers.Tbl21;}
	@UiFactory FSTRATable22 makesFSTRATable22(){return Handlers.Tbl22;}
	@UiFactory FSTRATable23 makesFSTRATable23(){return Handlers.Tbl23;}
	@UiFactory FSTRATable24 makesFSTRATable24(){return Handlers.Tbl24;}
	
	@UiFactory DERAutoSuggestBox makesAutoOpenSuggestBox(AMASuggestBoxName suggboxName){
		String [] suggestions=null;
		String pullListChars=",";
		int visibleChars=4;
		switch(suggboxName){
		case TOX_OF:			suggestions = new String [3];
								suggestions[0] = "TGAI";suggestions[1] = "EP";suggestions[2] = "Other";
								visibleChars=3;break;
		case EXPOSURE:			suggestions = new String [3];
								suggestions[0] = "Flow-through";suggestions[1] = "Static Renewal";suggestions[2] = "Other";
								visibleChars=0;break;
		case FOOD_TYPE:			suggestions = new String [2];
								suggestions[0] = "Sera Micron®";suggestions[1] = "Other";
								visibleChars=0;break;
		case DILUTION_SYSTEM:	suggestions = new String [3];
								suggestions[0] = "Continuous flow serial diluters";
								suggestions[1] = "Intermittent flow proportional diluters";
								suggestions[2] = "Other";
								visibleChars=0;break;
		case HTC_METHOD:		suggestions = new String [4];
								suggestions[0] = "100 mg/L";
								suggestions[1] = "Evidence of toxicity";
								suggestions[2] = "Solubility limit of test compound";
								suggestions[3] = "Other";
								pullListChars=",";
								visibleChars=20;break;
		case SOLVENT:			suggestions = new String [3];
								suggestions[0] = "acetone";
								suggestions[1] = "DMF";
								suggestions[2] = "Other";
								visibleChars=0;break;
		case CONC:				suggestions = new String [3];
								suggestions[0] = "geometric mean";
								suggestions[1] = "time-weighted average";
								suggestions[2] = "Other";
								visibleChars=0;break;
		case SOURCE:			suggestions = new String [3];
								suggestions[0] = "natural water";
								suggestions[1] = "reconstituted water";
								suggestions[2] = "Other";
								visibleChars=0;break;
		case SUB_MAT:			suggestions = new String [4];
								suggestions[0] = "aged PVC";
								suggestions[1] = "glass";
								suggestions[2] = "stainless steel";
								suggestions[3] = "other";
								visibleChars=0;break;						
		}
		
		DERAutoSuggestBox S = new DERAutoSuggestBox(suggestions,pullListChars,visibleChars);
		
//		if (FSTRA2EntryPoint.WidList.size()==24 || FSTRA2EntryPoint.WidList.size()==96)
//			{S.addValueChangeHandler(this);S.addSelectionHandler(this);}
		return S;
	}
	
	@UiFactory
	DERListBoxYesNoReferenced makesDERListBoxYesNoReferenced(){
		return Handlers.PositiveControlBox;
	}

	
	@Override
	public boolean validate(){		
		return true;		
	}
	
}
