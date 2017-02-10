package com.lmc.der.sixComposers.client.widgets.tables.ama;


import com.lmc.der.sixComposers.client.widgets.DERTextBoxLength;
import com.lmc.der.sixComposers.client.widgets.tables.AMA2FlexTable;

public class AMA2Table5 extends AMA2FlexTable {
//	private final int initRows = 10; 
	public AMA2Table5(){
		initRows = 10;columns=5/*In fact 6*/;headerRows=1;headerColumns=1;
		BasePath = "AMA||MaterialsAndMethods>>ExposureSystem>>Table5";
		this.addStyleName("double_bordered");
		this.setText(0,0,"Parameter ");
		this.setText(0,1,"Minimum ");
		this.setText(0,2,"Maximum ");
		this.setText(0,3,"Mean ");
		this.setText(0,4,"Measurement Interval");
		this.setText(0,5,"Guideline Recommendations ");			
		RFormatter.addStyleName(0, "centered");
		RFormatter.addStyleName(0, "bolded");
		
		
		fillRow(1,"Hardness(mg/L as CaCO<sub>3</sub>)","EPA recommends hardness 40 to 48 mg/L as CaCO<sub>3</sub>.");
		
		fillRow(2,"pH","EPA recommends pH 7.5 &plusmn; 1, inter-replicate and inter-treatment differentials should not exceed 0.5.");
		
		fillRow(3,"Dissolved oxygen (mg/L)","EPA recommends dissolved oxygen (DO) >3.5 mg/L (>40% air saturation). OECD recommends DO concentration >3.5 mg/L (>40% air saturation).");
		
		fillRow(4,"Temperature &deg;C","EPA recommends temperature 22&plusmn;1&deg;C; inter-replicate and inter-treatment differentials should not exceed 0.5&deg;C.");
		
		fillRow(5,"Iodide (&micro;g/L)","EPA recommends aquatic iodide range 0.5 - 10 &micro;g/L (supplemental iodide should not exceed 2 &micro;g/L).");
		
		fillRow(6,"Ammonia (&micro;g/L)","General recommendations for frequency of measurements: EPA recommends that water quality parameters be measured in a control and at one test item concentration at least weekly. In static renewal systems, water quality parameters, including ammonia, should be measured just "+
				"prior to renewal. In addition, EPA recommends that DO be measured at each concentration at least weekly and that temperature be measured continuously. OECD recommends that DO and temperature be measured at least weekly and that pH and hardness be measured at least at the beginning and end of the test.");
		CFormatter.setRowSpan(6, 5, 4);
		
		fillRow(7,"Fluoride (mg/L)","");

		fillRow(8,"Perchlorate (&micro;g/L)","");
		
		fillRow(9,"Chlorate (&micro;g/L)","");
		
		
		
	}

	@Override
	public void fillRow(int rowIndex,String headerHTML/*,int number*/) {
		fillRow(rowIndex,null,"");
	}

	private void fillRow(int rowIndex,String headerHTML,String footerHTML){
		DERTextBoxLength TextBox;
		if (headerHTML!=null) this.setHTML(rowIndex, 0, headerHTML);
		else{
			TextBox = new DERTextBoxLength();
			TextBox.setName(this.getWidgetPath(rowIndex,0,headerHTML));
			this.setWidget(rowIndex,0,TextBox);
		}
		int cIndex=5;
		while(cIndex-->1){
			TextBox = new DERTextBoxLength();
			TextBox.setName(this.getWidgetPath(rowIndex,cIndex,headerHTML));
			this.setWidget(rowIndex,cIndex,TextBox);
		}
		this.setHTML(rowIndex, 5, footerHTML);
	}
	
	@Override
	protected String getWidgetPath(int rowIndex,int cIndex,String headerHTML){
		if (headerHTML == null)
			return BasePath+">>["+(rowIndex-10)+"]AdditionalParameter>>["+cIndex+"]Col";
		else
		if (headerHTML.equals("Hardness(mg/L as CaCO<sub>3</sub>)"))
			return BasePath+">>Hardness>>["+(cIndex-1)+"]Col";
		else
		if (headerHTML.equals("pH"))
			return BasePath+">>PH>>["+(cIndex-1)+"]Col";
		else
		if (headerHTML.equals("Dissolved oxygen (mg/L)"))
			return BasePath+">>DissolvedOxygen>>["+(cIndex-1)+"]Col";
		else
		if (headerHTML.equals("Temperature &deg;C"))
			return BasePath+">>Temperature>>["+(cIndex-1)+"]Col";
		else
		if (headerHTML.equals("Iodide (&micro;g/L)"))
			return BasePath+">>Iodide>>["+(cIndex-1)+"]Col";
		else
		if (headerHTML.equals("Ammonia (&micro;g/L)"))
			return BasePath+">>Ammonia>>["+(cIndex-1)+"]Col";
		else
		if (headerHTML.equals("Fluoride (mg/L)"))
			return BasePath+">>Fluoride>>["+(cIndex-1)+"]Col";
		else
		if (headerHTML.equals("Perchlorate (&micro;g/L)"))
			return BasePath+">>Perchlorate>>["+(cIndex-1)+"]Col";
		else
		if (headerHTML.equals("Chlorate (&micro;g/L)"))
			return BasePath+">>Chlorate>>["+(cIndex-1)+"]Col";
		else return"";
	}
}
