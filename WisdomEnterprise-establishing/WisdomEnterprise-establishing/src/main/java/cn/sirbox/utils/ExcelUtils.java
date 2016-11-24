package cn.sirbox.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


@SuppressWarnings("rawtypes")
public class ExcelUtils {
	
	private static ExcelUtils excelUtils = new ExcelUtils();
	private ExcelUtils(){};
	public static ExcelUtils getInstance(){
		return excelUtils;
	}
	
	public void export2ExcelByTemplate(Map<String,String> datas,String template,String outPath,List objs,Class clzz,boolean isClassPath){
		
		List<ExcelHeader> headers = getHeaderList(clzz);
		Collections.sort(headers);
		for(ExcelHeader eh:headers){
			System.out.println(eh.getTitle()+"--"+eh.getOrder());
		}
	}
	
	public Workbook handle2Excel(List objs,Class clzz,boolean isXssf){
		Workbook wb = null;
		if(isXssf){
			wb = new XSSFWorkbook();
		}else{
			wb = new HSSFWorkbook();
		}
		List<ExcelHeader> headers = getHeaderList(clzz);
		//创建一页
		Sheet sheet = wb.createSheet();
		Row r = sheet.createRow(0);
		//写标题
		for(int i=0;i<headers.size();i++){
			//创建一行并设值
			r.createCell(i).setCellValue(headers.get(i).getTitle());
		}
		//写数据
		for(int i=0;i<objs.size();i++){
			r = sheet.createRow(i+1);
			for(int j=0;j<headers.size();j++){
				try {
					r.createCell(j).setCellValue(BeanUtils.getProperty(objs.get(i), getMethodName(headers.get(j))));
					
				} catch (IllegalAccessException | InvocationTargetException
						| NoSuchMethodException e) {
					e.printStackTrace();
				}
			}
		}
		return wb;
	}
	
	public void export2Excel(String outPath,List objs,Class clzz,boolean isXssf){
		Workbook wb = handle2Excel(objs,clzz,isXssf);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(outPath);
			wb.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fos!=null)
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	public void export2Excel(OutputStream os,List objs,Class clzz,boolean isXssf){
		Workbook wb = handle2Excel(objs,clzz,isXssf);
		try {
			wb.write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String getMethodName(ExcelHeader eh){
		String mn = eh.getMethodName().substring(3);
		mn = mn.substring(0, 1).toLowerCase()+mn.substring(1);
		return mn;
	}
	
	private List<ExcelHeader> getHeaderList(Class clzz){
		List<ExcelHeader> headers = new ArrayList<ExcelHeader>();
		Method[] method = clzz.getDeclaredMethods();
		for(Method m:method){
			String mn = m.getName();
			if(mn.startsWith("get")){
				if(m.isAnnotationPresent(ExcelResources.class)){
					ExcelResources er = m.getAnnotation(ExcelResources.class);
					headers.add(new ExcelHeader(er.title(),er.order(),mn));
				}
			}
		}
		return headers;
	}
}
