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
import com.lmc.der.sixComposers.client.ui.handlers.AMA_Handlers;
import com.lmc.der.sixComposers.client.widgets.DERAutoSuggestBox;
import com.lmc.der.sixComposers.client.widgets.DERListBoxYesNoReferenced;
import com.lmc.der.sixComposers.client.widgets.DERTextBoxReferenced;
import com.lmc.der.sixComposers.client.widgets.tables.AMA2TableCitations;
import com.lmc.der.sixComposers.client.widgets.tables.AMA2TableReviewers;
import com.lmc.der.sixComposers.client.widgets.tables.ama.AMA2Table1;
import com.lmc.der.sixComposers.client.widgets.tables.ama.AMA2Table10;
import com.lmc.der.sixComposers.client.widgets.tables.ama.AMA2Table11;
import com.lmc.der.sixComposers.client.widgets.tables.ama.AMA2Table12;
import com.lmc.der.sixComposers.client.widgets.tables.ama.AMA2Table13;
import com.lmc.der.sixComposers.client.widgets.tables.ama.AMA2Table14;
import com.lmc.der.sixComposers.client.widgets.tables.ama.AMA2Table15;
import com.lmc.der.sixComposers.client.widgets.tables.ama.AMA2Table16;
import com.lmc.der.sixComposers.client.widgets.tables.ama.AMA2Table17;
import com.lmc.der.sixComposers.client.widgets.tables.ama.AMA2Table5;
import com.lmc.der.sixComposers.client.widgets.tables.ama.AMA2Table8;
import com.lmc.der.sixComposers.client.widgets.tables.ama.AMA2Table9;

public class AMA_UI extends DER_UI{
	private UiBinder<Widget,AMA_UI> UiBi;
	private final AMA_Handlers Handlers;
	
	public enum AMA_ButtonName{
		REV_ADD,REV_REM,TBL5_ADD,TBL5_REM,TBL8_ADD,TBL8_REM,TYPE_ADD,TYPE_REM,CIT_ADD,CIT_REM,
		TBL13_ADD_COL,TBL13_REM_COL,TBL14_ADD_COL,TBL14_REM_COL,INDEX_PC_BOX
	}
	enum AMASuggestBoxName{
		TOX_OF,EXPOSURE,FOOD_TYPE,DILUTION_SYSTEM,HTC_METHOD,SOURCE,CONC,SOLVENT
	}
	enum AMATextBox{
		TMAT_1,TMAT_2,PUR_1,PUR_2,CAS_1,CAS_2
	}
	@UiTemplate("templates/ama/GeneralInfo.ui.xml")
	interface GeneralInfoUiBinder extends UiBinder<Widget, AMA_UI> {}
	@UiTemplate("templates/ama/materials/Materials.ui.xml")
	interface MaterialsUiBinder extends UiBinder<Widget, AMA_UI> {}
	@UiTemplate("templates/ama/materials/TestOrganism.ui.xml")
	interface TestOrganismUiBinder extends UiBinder<Widget, AMA_UI> {}
	@UiTemplate("templates/ama/materials/ExposureSystem.ui.xml")
	interface ExposureSystemUiBinder extends UiBinder<Widget, AMA_UI> {}
	@UiTemplate("templates/ama/materials/StudyDesign.ui.xml")
	interface StudyDesignUiBinder extends UiBinder<Widget, AMA_UI> {}
	@UiTemplate("templates/ama/materials/Concentrations.ui.xml")
	interface ConcentrationsUiBinder extends UiBinder<Widget, AMA_UI> {}
	@UiTemplate("templates/ama/results/Mortality.ui.xml")
	interface MortalityUiBinder extends UiBinder<Widget, AMA_UI> {}
	@UiTemplate("templates/ama/results/NFStage.ui.xml")
	interface NFStageUiBinder extends UiBinder<Widget, AMA_UI> {}
	@UiTemplate("templates/ama/results/HLL.ui.xml")
	interface HLLUiBinder extends UiBinder<Widget, AMA_UI> {}
	@UiTemplate("templates/ama/results/Growth.ui.xml")
	interface GrowthUiBinder extends UiBinder<Widget, AMA_UI> {}
	@UiTemplate("templates/ama/results/Histopathology.ui.xml")
	interface HistopathologyUiBinder extends UiBinder<Widget, AMA_UI> {}
	@UiTemplate("templates/ama/results/AddlHistopathology.ui.xml")
	interface AddlHistopathologyUiBinder extends UiBinder<Widget, AMA_UI> {}
	@UiTemplate("templates/ama/results/ClinicalSigns.ui.xml")
	interface ClinicalSignsUiBinder extends UiBinder<Widget, AMA_UI> {}
	@UiTemplate("templates/ama/results/Analysis.ui.xml")
	interface AnalysisUiBinder extends UiBinder<Widget, AMA_UI> {}
	@UiTemplate("templates/ama/results/DevelopmentEndpoints.ui.xml")
	interface DevelopmentEndpointsUiBinder extends UiBinder<Widget, AMA_UI> {}
	@UiTemplate("templates/ama/results/GrowthEndpoints.ui.xml")
	interface GrowthEndpointsUiBinder extends UiBinder<Widget, AMA_UI> {}
	@UiTemplate("templates/ama/results/StudyDeficienciesReviewersComments.ui.xml")
	interface SDRCUiBinder extends UiBinder<Widget, AMA_UI> {}	
	@UiTemplate("templates/ama/References.ui.xml")
	interface ReferencesUiBinder extends UiBinder<HTMLPanel, AMA_UI> {}
	interface TxtResources extends ClientBundle {
		@Source("templates/ama/ExecutiveSummary.html") TextResource exSum();
	}
	
	public AMA_UI(){
		
		Handlers = new AMA_Handlers();
		this.addAttachHandler(Handlers);
		
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
		
		UiBi = GWT.create(MortalityUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Mortality", false);
		UiBi = GWT.create(NFStageUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"NF Stage", false);
		UiBi = GWT.create(HLLUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"HLL", false);
		UiBi = GWT.create(GrowthUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Growth", false);
		UiBi = GWT.create(HistopathologyUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Histopathology", false);
		UiBi = GWT.create(AddlHistopathologyUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Addl. Histopathology", false);
		UiBi = GWT.create(ClinicalSignsUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Clinical Signs", false);
		UiBi = GWT.create(AnalysisUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Analysis", false);
		UiBi = GWT.create(DevelopmentEndpointsUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Development Endpoints", false);
		UiBi = GWT.create(GrowthEndpointsUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Growth Endpoints", false);
		UiBi = GWT.create(SDRCUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"St.Deficiencies&Rev.Comments", false);		
		
		UiBi = GWT.create(ReferencesUiBinder.class); 
		this.add(UiBi.createAndBindUi(this)	,"References", false);
		
		this.selectTab(0);
		MMTP.selectTab(0);
		RDTP.selectTab(0);
			
	}	
	
	@UiFactory Button makesButton(AMA_ButtonName btnName){
//		System.out.println(btnNames);
		switch(btnName){
		case REV_ADD			:return Handlers.BtnRevAdd;
		case REV_REM			:return Handlers.BtnRevRem;
		case TBL5_ADD			:return Handlers.Btn5Add;
		case TBL5_REM			:return Handlers.Btn5Rem;
		case TBL8_ADD			:return Handlers.Btn8Add;
		case TBL8_REM			:return Handlers.Btn8Rem;
//		case ATT_ADD			:return Handlers.BtnAttAdd;
//		case ATT_REM			:return Handlers.BtnAttRem;
		case TYPE_ADD			:return Handlers.BtnTypeAdd;
		case TYPE_REM			:return Handlers.BtnTypeRem;
		case CIT_ADD			:return Handlers.BtnCitAdd;
		case CIT_REM			:return Handlers.BtnCitRem;
		case TBL13_ADD_COL		:return Handlers.Btn13Add;
		case TBL13_REM_COL		:return Handlers.Btn13Rem;
		case TBL14_ADD_COL		:return Handlers.Btn14Add;
		case TBL14_REM_COL		:return Handlers.Btn14Rem;
		default					:return null;		
		}
	}
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
		}
		
		DERAutoSuggestBox S = new DERAutoSuggestBox(suggestions,pullListChars,visibleChars);
		if (suggboxName == AMASuggestBoxName.EXPOSURE){
			if (Handlers.ExpoType1 == null){
				Handlers.ExpoType1 = S;
				Handlers.ExpoType1.addValueChangeHandler(Handlers);
				Handlers.ExpoType1.addSelectionHandler(Handlers);
			}else{
				Handlers.ExpoType2 = S;
				Handlers.ExpoType2.addValueChangeHandler(Handlers);
				Handlers.ExpoType2.addSelectionHandler(Handlers);
			}
		}
		return S;
	}
		
	@UiFactory
	DERListBoxYesNoReferenced makesDERListBoxYesNoReferenced(){return Handlers.PositiveControlBox;}
	
	@UiFactory
	DERTextBoxReferenced makesDERTExtBoxReferenced(AMATextBox tbName){
		switch(tbName){
		case TMAT_1: return Handlers.TMat1;
		case TMAT_2: return Handlers.TMat2;
		case PUR_1:	 return Handlers.Pur1;
		case PUR_2:  return Handlers.Pur2;
		case CAS_1:  return Handlers.Cas1;
		case CAS_2:  return Handlers.Cas2;
		default:		return null;
		}
	}
	
	
	@UiFactory AMA2TableReviewers makesAMA2TableReviewers(){return Handlers.TblRev;}
	@UiFactory AMA2TableCitations makesAMA2TableCitations(){return Handlers.TblCit;}	
	@UiFactory AMA2Table1 makesAMA2Table1(){return Handlers.Tbl1;}	
	@UiFactory AMA2Table5 makesAMA2Table5(){return Handlers.Tbl5;}	
	@UiFactory AMA2Table8 makesAMA2Table8(){return Handlers.Tbl8;}
	@UiFactory AMA2Table9 makesAMA2Table9(){return Handlers.Tbl9;}
	@UiFactory AMA2Table10 makesAMA2Table10(){return Handlers.Tbl10;}
	@UiFactory AMA2Table11 makesAMA2Table11(){return Handlers.Tbl11;}
	@UiFactory AMA2Table12 makesAMA2Table12(){return Handlers.Tbl12;}
	@UiFactory AMA2Table13 makesAMA2Table13(){return Handlers.Tbl13;}
	@UiFactory AMA2Table14 makesAMA2Table14(){return Handlers.Tbl14;}
	@UiFactory AMA2Table15 makesAMA2Table15(){return Handlers.Tbl15;}
	@UiFactory AMA2Table16 makesAMA2Table16(){return Handlers.Tbl16;}
	@UiFactory AMA2Table17 makesAMA2Table17(){return Handlers.Tbl17;}	
	

	@Override
	public boolean validate(){		
		return true;
	}	
	
}
