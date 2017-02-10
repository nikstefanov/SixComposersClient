package com.lmc.der.sixComposers.client.widgets.tables.fstra;


import com.lmc.der.sixComposers.client.widgets.DERTextBoxLength;
import com.lmc.der.sixComposers.client.widgets.tables.AMA2FlexTable;

public class FSTRATable5 extends AMA2FlexTable {
//	private final int initRows = 10; 
	public FSTRATable5(){
		initRows = 9;columns=5/*In fact 6*/;headerRows=1;headerColumns=1;
		BasePath="FSTRA||MaterialsAndMethods>>ExposureSystem>>Table5";
//		FlexCellFormatter T5CellFormatter = this.getFlexCellFormatter();
		RowFormatter T1RFormatter = this.getRowFormatter();
		ColumnFormatter CFormatter = this.getColumnFormatter();
		T1RFormatter.addStyleName(0, "centered");
		T1RFormatter.addStyleName(0, "bolded");
		CFormatter.setWidth(0, "20%");
//		CFormatter.setWidth(1, "15%");
//		CFormatter.setWidth(2, "15%");
//		CFormatter.setWidth(3, "15%");
//		CFormatter.setWidth(4, "15%");
		CFormatter.setWidth(5, "40%");
		this.addStyleName("double_bordered");
		this.setText(0,0,"Parameter ");
		this.setText(0,1,"Minimum ");
		this.setText(0,2,"Maximum ");
		this.setText(0,3,"Mean ");
		this.setHTML(0,4,"Measurement<br/>Interval");
		this.setText(0,5,"Guideline Recommendations");			
		
		
		 fillRow(1,"Temperature (&deg;C)",
				 "EPA recommends temperature 25&plusmn;1&deg;C; inter-replicate and inter-treatment differentials should not exceed 1&deg;C.");
		 fillRow(2,"pH",
				 "EPA recommends pH 6.5 to 9.0.");
		 fillRow(3,"Dissolved oxygen (mg/L)",
				 "EPA recommends dissolved oxygen (DO) &ge;4.9 mg/L (>60% air saturation)");
		 fillRow(4,"Total alkalinity (mg/L as CaCO<sub>3</sub>)",
				 "EPA recommends total alkalinity > 20 mg/L as CaCO<sub>3</sub>.");
		 fillRow(5,"Hardness (mg/L as CaCO<sub>3</sub>)",
				 "");
		 fillRow(6,"Total organic carbon (mg/L)",
				 "EPA recommends that total organic carbon in dilution water be &le; 2 mg/L.");
		 fillRow(7,"Unionized ammonia (&micro;g/L)",
				 "EPA recommends that unionized ammonia in the dilution water be &le; 1 &micro;g/L.");
		 fillRow(8,"Residual chlorine (&micro;g/L)",
				 "EPA recommends that residual chlorine in dilution water be < 10 &micro;g/L.");
		 
	}

	@Override
	public void fillRow(int rowIndex,String headerHTML/*,int number*/) {
//		headerHTML=="Positive control"
//		int rowIndex = this.insertRow(this.getRowCount());
		this.setWidget(rowIndex,0,new DERTextBoxLength(14,getWidgetPath(rowIndex,0,null)));
		this.setWidget(rowIndex,1,new DERTextBoxLength( 7,getWidgetPath(rowIndex,1,null)));
		this.setWidget(rowIndex,2,new DERTextBoxLength( 7,getWidgetPath(rowIndex,2,null)));
		this.setWidget(rowIndex,3,new DERTextBoxLength( 7,getWidgetPath(rowIndex,3,null)));
		this.setWidget(rowIndex,4,new DERTextBoxLength( 7,getWidgetPath(rowIndex,4,null)));
		this.setText(rowIndex,5,"");
	}
	public void fillRow(int rowIndex,String headerHTML,String footerHTML) {
//		int rowIndex = this.insertRow(this.getRowCount());
//		System.out.println(headerHTML);
		this.setHTML(rowIndex,0,headerHTML);
		this.setWidget(rowIndex,1,new DERTextBoxLength(7,getWidgetPath(rowIndex,1,headerHTML)));
		this.setWidget(rowIndex,2,new DERTextBoxLength(7,getWidgetPath(rowIndex,2,headerHTML)));
		this.setWidget(rowIndex,3,new DERTextBoxLength(7,getWidgetPath(rowIndex,3,headerHTML)));
		this.setWidget(rowIndex,4,new DERTextBoxLength(7,getWidgetPath(rowIndex,4,headerHTML)));
		this.setHTML(rowIndex,5,footerHTML);
	}
	
	@Override
	protected String getWidgetPath(int rowIndex,int cIndex,String headerHTML){
		if (headerHTML == null)
			return BasePath+">>["+(rowIndex-9)+"]AdditionalParameter>>["+cIndex+"]Col";
		else
		if (headerHTML.equals("Temperature (&deg;C)"))
			return BasePath+">>Temperature>>["+(cIndex-1)+"]Col";
		else
		if (headerHTML.equals("pH"))
			return BasePath+">>PH>>["+(cIndex-1)+"]Col";
		else
		if (headerHTML.equals("Dissolved oxygen (mg/L)"))
			return BasePath+">>DissolvedOxygen>>["+(cIndex-1)+"]Col";
		else
		if (headerHTML.equals("Total alkalinity (mg/L as CaCO<sub>3</sub>)"))
			return BasePath+">>TotalAlkalinity>>["+(cIndex-1)+"]Col";
		else
		if (headerHTML.equals("Hardness (mg/L as CaCO<sub>3</sub>)"))
			return BasePath+">>Hardness>>["+(cIndex-1)+"]Col";
		else
		if (headerHTML.equals("Total organic carbon (mg/L)"))
			return BasePath+">>TotalOrganicCarbon>>["+(cIndex-1)+"]Col";
		else				
		if (headerHTML.equals("Unionized ammonia (&micro;g/L)"))
			return BasePath+">>UnionizedAmmonia>>["+(cIndex-1)+"]Col";
		else
		if (headerHTML.equals("Residual chlorine (&micro;g/L)"))
			return BasePath+">>ResidualChlorine>>["+(cIndex-1)+"]Col";
		else
			return"";
	}
}
