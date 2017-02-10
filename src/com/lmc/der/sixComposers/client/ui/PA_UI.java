package com.lmc.der.sixComposers.client.ui;

import java.util.ArrayList;
import java.util.Arrays;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.der.lib.client.upload.image.UploadableImage;
import com.lmc.der.sixComposers.client.ui.handlers.PA_Handlers;
import com.lmc.der.sixComposers.client.widgets.tables.AMA2TableCitations;
import com.lmc.der.sixComposers.client.widgets.tables.AMA2TableReviewers;
import com.lmc.der.sixComposers.client.widgets.tables.fpa.FPATable5;
import com.lmc.der.sixComposers.client.widgets.tables.mpa.MPATable1;
import com.lmc.der.sixComposers.client.widgets.tables.mpa.MPATable3;
import com.lmc.der.sixComposers.client.widgets.tables.mpa.MPATable4;
import com.lmc.der.sixComposers.client.widgets.tables.mpa.MPATable5;
import com.lmc.der.sixComposers.client.widgets.tables.mpa.MPATable6ClChemistry;
import com.lmc.der.sixComposers.client.widgets.tables.mpa.MPATable6Hormones;
import com.lmc.der.sixComposers.client.widgets.tables.mpa.MPATable7;
import com.lmc.der.sixComposers.client.widgets.tables.mpa.MPATable8;
import com.lmc.der.sixComposers.client.widgets.tables.mpa.MPATableCheckBoxes;
//import com.lmc.der.sixComposers.client.widgets.tables.AMA2TableAttachedFiles;

public class PA_UI extends DER_UI {

	private UiBinder<Widget,PA_UI> UiBi;
	private final TabPanel MMTP;
	private final TabPanel RDTP;
	private final char Gender;
	private final PA_Handlers Handlers;
	
	private final GenderDependantStrings GDStr;
	private final TxtResources res;
	private final ArrayList<String> WidgetPathsList;
	

	@UiTemplate("templates/mpa/GeneralInfo.ui.xml")
	interface GeneralInfoUiBinder extends UiBinder<Widget, PA_UI> {}
//	@UiTemplate("templates/fpa/GeneralInfo.ui.xml")
//	interface GeneralInfoUiBinder extends UiBinder<Widget, PA_UI> {}
	@UiTemplate("templates/mpa/materials/Materials.ui.xml")
	interface MaterialsUiBinder extends UiBinder<Widget, PA_UI> {}
	@UiTemplate("templates/mpa/materials/StudyDesign.ui.xml")
	interface StudyDesignUiBinder extends UiBinder<Widget, PA_UI> {}
	@UiTemplate("templates/mpa/materials/Dose2.ui.xml")
	interface DosageUiBinder extends UiBinder<Widget, PA_UI> {}
	@UiTemplate("templates/mpa/materials/Methods.ui.xml")
	interface MethodsUiBinder extends UiBinder<Widget, PA_UI> {}
	@UiTemplate("templates/mpa/results/Mortality.ui.xml")
	interface MortalityUiBinder extends UiBinder<Widget, PA_UI> {}
	@UiTemplate("templates/mpa/results/GeneralGrowth.ui.xml")
	interface GeneralGrowthUiBinder extends UiBinder<Widget, PA_UI> {}
	@UiTemplate("templates/mpa/results/OrganWeights.ui.xml")
	interface OrganWeightsUiBinder extends UiBinder<Widget, PA_UI> {}
	@UiTemplate("templates/mpa/results/ClinicalChemistry.ui.xml")
	interface ClinicalChemistryUiBinder extends UiBinder<Widget, PA_UI> {}
	@UiTemplate("templates/mpa/results/Histopathology1.ui.xml")
	interface HistopathologyUiBinder extends UiBinder<Widget, PA_UI> {}
	@UiTemplate("templates/mpa/results/Histopathology2.ui.xml")
	interface Histopathology2UiBinder extends UiBinder<Widget, PA_UI> {}	
	@UiTemplate("templates/mpa/DiscussionConclusions.ui.xml")
	interface DiscussionConclusionsUiBinder extends UiBinder<Widget, PA_UI> {}
	
	@UiTemplate("templates/fpa/materials/StudyDesign.ui.xml")
	interface FeStudyDesignUiBinder extends UiBinder<Widget, PA_UI> {}
	@UiTemplate("templates/fpa/materials/Dose.ui.xml")
	interface FeDoseUiBinder extends UiBinder<Widget, PA_UI> {}
	@UiTemplate("templates/fpa/materials/Methods.ui.xml")
	interface FeMethodsUiBinder extends UiBinder<Widget, PA_UI> {}
	@UiTemplate("templates/fpa/results/GeneralGrowth.ui.xml")
	interface FeGeneralGrowthUiBinder extends UiBinder<Widget, PA_UI> {}
	@UiTemplate("templates/fpa/results/OrganWeights.ui.xml")
	interface FeOrganWeightsUiBinder extends UiBinder<Widget, PA_UI> {}
	@UiTemplate("templates/fpa/results/EstrousCyclicity.ui.xml")
	interface FeEstrousCyclicityUiBinder extends UiBinder<Widget, PA_UI> {}
	/*
	interface TxtResources extends ClientBundle {
		@Source("templates/mpa/ExSum.mpa.html") TextResource exSumMale();
		@Source("templates/fpa/ExSum.fpa.html") TextResource exSumFemale();
	}
	abstract class TxtResourcesClass implements TxtResources{
		private char Gender;		
		void setGender(char GenChar){
			Gender = GenChar;
		}		
		TextResource exSum(){
			if (Gender == 'M') return exSumMale();
			else return exSumFemale();
		}
	}*/
	interface TxtResources extends ClientBundle {
		@Source("") TextResource exSum();
		@Source("") TextResource widPaths();
	}
	interface TxtResourcesMale extends TxtResources {
		@Source("templates/mpa/ExSum.mpa.html") TextResource exSum();
		@Source("templates/mpa/WidPaths.mpa.txt") TextResource widPaths();
	}
	interface TxtResourcesFemale extends TxtResources {
		@Source("templates/fpa/ExSum.fpa.html") TextResource exSum();
		@Source("templates/fpa/WidPaths.fpa.txt") TextResource widPaths();
	}
	class GenderDependantStrings{
		String getTable8Cap(){ return (Gender=='M')?"Testes, Epididymides":" Ovaries, Uterus";}
		String getGender(){return (Gender=='M') ? "male" : "female";}
		String getAssay(){return (Gender=='M') ? "MPA" : "FPA";}
		String getPath(){return WidgetPathsList.remove(0);}
	}
	
	public enum MPA_UIButtonName{
		REV_ADD,REV_REM,CIT_ADD,CIT_REM,
//		PAR_ADD,PAR_REM,TIS_ADD,TIS_REM,
		OBS_ADD,OBS_REM,ORG_ADD,ORG_REM,
		HOR_ADD,HOR_REM,CCH_ADD,CCH_REM,OBS8_ADD,OBS8_REM
	}
	public enum MPA_UITableName{
		ELECTRO_TBL,ENZYM_TBL,OTR1_TBL,URO_TBL,OTR2_TBL,URO_F_TBL,EMPTY5x1_TBL,EMPTY5x2_TBL,TBL2,TBL8
	}
	public enum LabelName{
		ONE,TWO,GENDER
	}	
	
	
	public PA_UI(char GenChar){
		Gender = GenChar;
		Handlers = new PA_Handlers(Gender);
		this.addAttachHandler(Handlers);
		
		GDStr = new GenderDependantStrings();		
		if (Gender == 'M') res = GWT.create(TxtResourcesMale.class);
		else res = GWT.create(TxtResourcesFemale.class);
		
		WidgetPathsList = new ArrayList<String>(
				Arrays.asList(res.widPaths().getText().split("\r\n")));
		
		MMTP = new TabPanel();
		RDTP = new TabPanel();
		
		UiBi = GWT.create(GeneralInfoUiBinder.class); 
		this.add(UiBi.createAndBindUi(this)	,"General Info", false);
		this.add(MMTP							,"Materials & Methods", false);
		this.add(RDTP							,"Results", false);		
		
		UiBi = GWT.create(MaterialsUiBinder.class); 
		MMTP.add(UiBi.createAndBindUi(this)		,"Materials", false);
		
		if (Gender == 'M'){
			UiBi = GWT.create(StudyDesignUiBinder.class); 
			MMTP.add(UiBi.createAndBindUi(this)		,"Study Design", false);
			UiBi = GWT.create(DosageUiBinder.class); 
			MMTP.add(UiBi.createAndBindUi(this)		,"Dose", false);
			UiBi = GWT.create(MethodsUiBinder.class); 
			MMTP.add(UiBi.createAndBindUi(this)		,"Methods", false);
			
			UiBi = GWT.create(MortalityUiBinder.class); 
			RDTP.add(UiBi.createAndBindUi(this)		,"Mortality & Clinical Signs of Toxicity", false);
			UiBi = GWT.create(GeneralGrowthUiBinder.class); 
			RDTP.add(UiBi.createAndBindUi(this)		,"General Growth & Preputial Separation", false);
			UiBi = GWT.create(OrganWeightsUiBinder.class); 
			RDTP.add(UiBi.createAndBindUi(this)		,"Organ Weights", false);
			
		}else{
			
			UiBi = GWT.create(FeStudyDesignUiBinder.class); 
			MMTP.add(UiBi.createAndBindUi(this)		,"Study Design", false);
			UiBi = GWT.create(FeDoseUiBinder.class); 
			MMTP.add(UiBi.createAndBindUi(this)		,"Dose", false);
			UiBi = GWT.create(FeMethodsUiBinder.class); 
			MMTP.add(UiBi.createAndBindUi(this)		,"Methods", false);
			
			UiBi = GWT.create(MortalityUiBinder.class); 
			RDTP.add(UiBi.createAndBindUi(this)		,"Mortality & Clinical Signs of Toxicity", false);
			UiBi = GWT.create(FeGeneralGrowthUiBinder.class); 
			RDTP.add(UiBi.createAndBindUi(this)		,"General Growth & Vaginal Opening", false);
			UiBi = GWT.create(FeOrganWeightsUiBinder.class); 
			RDTP.add(UiBi.createAndBindUi(this)		,"Organ Weights", false);
			UiBi = GWT.create(FeEstrousCyclicityUiBinder.class); 
			RDTP.add(UiBi.createAndBindUi(this)		,"Estrous Cyclicity", false);
			
		}
		
		UiBi = GWT.create(ClinicalChemistryUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Clinical Chemistry & Hormone Levels", false);
		UiBi = GWT.create(HistopathologyUiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Histopathology1", false);
		UiBi = GWT.create(Histopathology2UiBinder.class); 
		RDTP.add(UiBi.createAndBindUi(this)		,"Histopathology2", false);
		
		UiBi = GWT.create(DiscussionConclusionsUiBinder.class); 
		this.add(UiBi.createAndBindUi(this)	,"Discussion & Conclusions", false);
		
		this.selectTab(0);
		MMTP.selectTab(0);
		RDTP.selectTab(0);
	}
	
	@UiFactory Button makesButton(MPA_UIButtonName btnName){
		switch(btnName){
		case REV_ADD			:return Handlers.BtnRevAdd;
		case REV_REM			:return Handlers.BtnRevRem;
		case CIT_ADD			:return Handlers.BtnCitAdd;
		case CIT_REM			:return Handlers.BtnCitRem;	
		case OBS_ADD			:return Handlers.BtnObsAdd;
		case OBS_REM			:return Handlers.BtnObsRem;
		case ORG_ADD			:return Handlers.BtnOrgAdd;
		case ORG_REM			:return Handlers.BtnOrgRem;
		case HOR_ADD			:return Handlers.BtnHorAdd;
		case HOR_REM			:return Handlers.BtnHorRem;
		case CCH_ADD			:return Handlers.BtnCChAdd;
		case CCH_REM			:return Handlers.BtnCChRem;
		case OBS8_ADD			:return Handlers.BtnObs8Add;
		case OBS8_REM			:return Handlers.BtnObs8Rem;
		default					:return null;
		}		
	}	
	@UiFactory MPATableCheckBoxes makesMPATableCheckBoxes(MPA_UITableName TblName){
		MPATableCheckBoxes TblForReturn = null;String basePath=null;
		String[] StrArr=null;int CBcolumns=1;int addLines=0;//checkBoxColumns
		switch(TblName){
		case ELECTRO_TBL	:{String[] StrArr1={"ELECTROLYTES","Calcium","Chloride","Magnesium","Phosphorus","Potassium","Sodium"};							
							StrArr = StrArr1;basePath=Gender+"PA||MaterialsAndMethods>>Methods>>ClinicalChemistry>>Electrolytes";break;}
		case ENZYM_TBL		:{String[] StrArr1={"ENZYMES","Alkaline phosphatase (ALK)","Cholinesterase (ChE)",
							"Creatine phosphokinase","Lactic acid dehydrogenase (LDH)","Alanine aminotransferase (ALT/also SGPT)",
							"Aspartate aminotransferase (AST/also SGOT)","Sorbitol dehydrogenase","Gamma glutamyl transferase (GGT)",
							"Glutamate dehydrogenase"};							
							StrArr = StrArr1;basePath=Gender+"PA||MaterialsAndMethods>>Methods>>ClinicalChemistry>>Enzymes";break;}
		case OTR1_TBL		:{String[] StrArr1={"OTHER","Albumin","Creatinine*","Urea nitrogen*","Total cholesterol","Globulins",
							"Glucose","Total bilirubin","Total protein","Triglycerides","Serum protein electrophoresis"};							
							StrArr = StrArr1;basePath=Gender+"PA||MaterialsAndMethods>>Methods>>ClinicalChemistry>>Other";break;}
		case URO_TBL		:{String[] StrArr1={"UROGENITAL","Testes (left and right separately)**","Epididymides (left and right separately)**",
							"Seminal vesicle plus coagulating glands (with and without fluid)*","Ventral prostate*","Dorsolateral prostate*",
							"Levator ani/bulbocavernosus (LABC) muscle complex*","Kidneys (paired)**","Gross lesions and masses*"};
							StrArr = StrArr1;CBcolumns=2;basePath="MPA||MaterialsAndMethods>>Methods>>OrganWeightsHistopathology>>Urogenital";break;}
		case OTR2_TBL		:{String[] StrArr1={"OTHER","Thyroid**","Liver*","Adrenals (paired)*","Pituitary*"};							
							StrArr = StrArr1;CBcolumns=2;basePath=Gender+"PA||MaterialsAndMethods>>Methods>>OrganWeightsHistopathology>>Other";break;}
		case URO_F_TBL		:{String[] StrArr1={"UROGENITAL","Ovaries (paired,without oviducts)**","Uterus*","Kidneys (paired)**",
							"Gross lesions and masses*"};
							basePath="FPA||MaterialsAndMethods>>Methods>>OrganWeightsHistopathology>>Urogenital";StrArr = StrArr1;CBcolumns=2;break;}
		case EMPTY5x1_TBL	:{String[] StrArr1={"OTHER"};StrArr = StrArr1;CBcolumns=1;addLines=5;
							basePath=Gender+"PA||MaterialsAndMethods>>Methods>>ClinicalChemistry>>OtherAddl";break;}
		case EMPTY5x2_TBL	:{String[] StrArr1={"OTHER"};StrArr = StrArr1;CBcolumns=2;addLines=5;
							basePath=Gender+"PA||MaterialsAndMethods>>Methods>>OrganWeightsHistopathology>>OtherAddl";break;}
		default				:
		}
		TblForReturn = new MPATableCheckBoxes(StrArr,CBcolumns,addLines,basePath);//checkBoxColumns
//		FSTRA2EntryPoint.WidList.add(TblForReturn);
		return TblForReturn;
	}
	@UiFactory InlineLabel makesInlineLabel(LabelName lName){
		String lString="";
		switch(lName){
		case ONE	: lString = (Gender=='M') ? "Male Pubertal Assay; OCSPP 890.1500":
												"Female Pubertal Assay; OCSPP 890.1450";break;
		case TWO	: lString = (Gender=='M') ? "Male Pubertal Assay in rats (OCSPP 890.1500)":
												"Female Pubertal Assay in rats (OCSPP 890.1450)";break;
		case GENDER	: lString = (Gender=='M') ? "male" : "female";break;
		}
		return new InlineLabel(lString);
	}/*
	@UiFactory DERListBoxYesNo makesDERListBoxYesNo(){
		DERListBoxYesNo wid = new DERListBoxYesNo();
		wid.setName(WidgetPathsList.remove(0));
		return wid;
	}	
	@UiFactory DERTextBoxLength makesDERTextBox(){
		DERTextBoxLength tb = new DERTextBoxLength();
		tb.setName(WidgetPathsList.remove(0));
		return tb;
	}
	@UiFactory DERRichTextAreaPUT makesAMA2RichTextAreaPUT(){
		DERRichTextAreaPUT rta = new DERRichTextAreaPUT();
//		if (FSTRA2EntryPoint.WidList.size()==13 ){
//			if (Gender=='M')
//				rta.setHTML(((TxtResources)GWT.create(TxtResources.class)).exSumMale().getText());
//			else
//				rta.setHTML(((TxtResources)GWT.create(TxtResources.class)).exSumFemale().getText());
//		}	
		rta.setName(WidgetPathsList.remove(0));
		return rta;
	}*/
	@UiFactory UploadableImage makesUploadableImage(){
		UploadableImage ui = new UploadableImage("Structure file" , Gender + "PA");
		ui.setSendFilenameTo(WidgetPathsList.remove(0));
		return ui;
	}
	@UiFactory AMA2TableReviewers makesAMA2TableReviewers()		{return Handlers.TblRev;}
	@UiFactory AMA2TableCitations makesAMA2TableCitations()		{return Handlers.TblCit;}
	@UiFactory MPATable1 makesMPATable1()						{return Handlers.Tbl1;}	
	@UiFactory MPATable3 makesMPATable3()						{return Handlers.Tbl3;}
	@UiFactory MPATable4 makesMPATable4()						{return new MPATable4();}
	@UiFactory MPATable5 makesMPATable5()						{return Handlers.TblOrg;}
	@UiFactory FPATable5 makesFPATable5()						{return new FPATable5();}
	@UiFactory MPATable6Hormones makesMPATable6Hormones()		{return Handlers.TblHor;}
	@UiFactory MPATable6ClChemistry makesMPATable6ClChemistry()	{return Handlers.TblCCh;}
	@UiFactory MPATable7 makesMPATable7()						{return Handlers.Tbl7;}
	@UiFactory MPATable8 makesMPATable8(MPA_UITableName tblName){return (tblName==MPA_UITableName.TBL8)?Handlers.TblObs8:Handlers.TblObs2;}

	@UiFactory TxtResources makesTxtResourcesClass(){return res;}
	@UiFactory GenderDependantStrings makesGenderDependantStrings(){return GDStr;}
	

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return true;
	}	

}
