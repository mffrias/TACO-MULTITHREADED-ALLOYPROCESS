package ar.edu.taco;


import ar.uba.dc.rfm.dynalloy.analyzer.AlloyAnalysisResult;

public class TacoAnalysisResult {

	private AlloyAnalysisResult alloy_analysis_result;
	
	public TacoAnalysisResult(AlloyAnalysisResult alloy_analysis_result) {
		this.alloy_analysis_result = alloy_analysis_result;

	}

	public TacoAnalysisResult() {
		// TODO Auto-generated constructor stub
	}

	public AlloyAnalysisResult get_alloy_analysis_result() {
		return alloy_analysis_result;
	}
	
	
	public void setAlloyAnalysisResult(AlloyAnalysisResult alloy_analysis_result) {
		this.alloy_analysis_result = alloy_analysis_result;
		
	}

}
