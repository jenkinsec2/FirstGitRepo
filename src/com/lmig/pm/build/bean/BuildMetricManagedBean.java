package com.lmig.pm.build.bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@ManagedBean(name="buildMetricBean")
@ViewScoped
public class BuildMetricManagedBean {

	private static final String EXCEL_CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	private static final String EXCEL_HEADER_CONTENT = "Content-Disposition";
	private static final String EXCEL_HEADER_ATTACHMENT = "attachment; filename=Build_Metrics.xlsx";
	
	//private String buildDate;
	private Date buildDate;
	
	private List<String> list = new ArrayList<String>();
	
	
	@PostConstruct
	public void init(){

	}
	
	public String submit() throws UnsupportedOperationException, IOException{
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.setContentType(EXCEL_CONTENT_TYPE);
		response.setHeader(EXCEL_HEADER_CONTENT, EXCEL_HEADER_ATTACHMENT);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
		String formattedDate = dateFormat.format(getBuildDate());
		
		StringBuilder url= new StringBuilder("http://deploystatus-pm/bld_logs_data/");
		url = url.append("build.data.");
		url = url.append(formattedDate);
		url = url.append(".txt");
		
		BufferedReader rd = null;
		try {
			rd = getBuildDataFromURL(response, url.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet worksheet = workbook.createSheet(formattedDate+ "-Jenkins Build Failures");
		
		
		int rowNum = 0;
		String line = "";
		
		while ((line = rd.readLine()) != null) {
			if(line.startsWith("automerge") || (line.contains("TEST")) || !isPortfolioChosen(getList(), line)){
				continue;
			}
			
			XSSFRow row = worksheet.createRow(rowNum++);
			
			StringTokenizer token = new StringTokenizer(line, ";");
			int cellIndex = 0;
			String failureCde = null;
			while(token.hasMoreElements()){
				XSSFCell cell = row.createCell(cellIndex++);
				String value = (String) token.nextElement();
				cell.setCellValue(value.toString());
				
				//Get the failure texts to print it in excel				
				if(StringUtils.isNumeric(value)){
					failureCde = getFailureTexts(value);
				}
				
				//Get count to add data and failure text at end of the each row
				int count = token.countTokens();
				if(count == 0){
					//Add the start date in the cell
					SimpleDateFormat printDate = new SimpleDateFormat("MM/dd/yyyy");
					cell = row.createCell(cellIndex++);
					cell.setCellValue(printDate.format(getBuildDate()));
					
					//add failure texts at end of the row
					if(failureCde != null){
						cell = row.createCell(cellIndex++);
						cell.setCellValue(failureCde);	
					}
				}
			}
		}
		
		ServletOutputStream out = response.getOutputStream();
		workbook.write(out);
		out.flush();
		out.close();
		
		workbook.close();
		
		FacesContext faces = FacesContext.getCurrentInstance();
		faces.responseComplete();
		return null;
	}

	public BufferedReader getBuildDataFromURL(HttpServletResponse response, String url) throws Exception, IOException{
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet getRequest = new HttpGet(url);
		HttpResponse httpResponse = client.execute(getRequest);
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
		return rd;
	}

	private static boolean isPortfolioChosen(List<String> list, String sentence) {
	    boolean available = false; 
		for (String portfolio : list) {
	       if (sentence.contains(portfolio)) {
	    	   available = true;
	         return available;
	       }
	     }
	return available;
	}
	
	private String getFailureTexts(String failureCode){
		String failureText = null;
		if(failureCode.equals("0")){
			failureText = "Success";
		}else if(failureCode.equals("1")){
			failureText = "Failure   - undetermined cause";
		}else if(failureCode.equals("10")){
			failureText = "Failure   - job initialization phase";
		}else if(failureCode.equals("20")){
			failureText = "Failure   - code checkout phase";
		}else if(failureCode.equals("22")){
			failureText = "Failure   - code merge phase";
		}else if(failureCode.equals("23")){
			failureText = "Failure   - get code changes";
		}else if(failureCode.equals("30")){
			failureText = "Failure   - code build phase";
		}else if(failureCode.equals("33")){
			failureText = "Failure   - code build-compile";
		}else if(failureCode.equals("37")){
			failureText = "Failure   - code build-package";
		}else if(failureCode.equals("40")){
			failureText = "Failure   - baseline creation phase";
		}else if(failureCode.equals("50")){
			failureText = "Failure   - build promotion";
		}else if(failureCode.equals("55")){
			failureText = "Failure   - build promotion-bind";
		}else if(failureCode.equals("60")){
			failureText = "Failure   - build cleanup";
		}
			
		return failureText;
	}
	public String clear(){
		return "buildMetric";
	}
	
	public String cancel(){
		return "main";
	}
	
	public Date getBuildDate() {
		return buildDate;
	}

	public void setBuildDate(Date buildDate) {
		this.buildDate = buildDate;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
}
