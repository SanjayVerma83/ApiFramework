package com.apiframework.payload;

import java.util.HashMap;
import java.util.Map;

import com.apiframework.utils.ExcelUtil;

public class PayloadBuilder {

	public static Map<String, String> createAccountPayload() {

	    Map<String, String> payload = new HashMap<>();

	    payload.put("name", ExcelUtil.getCellData("CreateAccount", 1, 0));
	    payload.put("email", ExcelUtil.getCellData("CreateAccount", 1, 1));
	    payload.put("password", ExcelUtil.getCellData("CreateAccount", 1, 2));
	    payload.put("title", ExcelUtil.getCellData("CreateAccount", 1, 3));

	    payload.put("firstname", ExcelUtil.getCellData("CreateAccount", 1, 4));
	    payload.put("lastname", ExcelUtil.getCellData("CreateAccount", 1, 5));
	    payload.put("company", ExcelUtil.getCellData("CreateAccount", 1, 6));
	    payload.put("address1", ExcelUtil.getCellData("CreateAccount", 1, 7));
	    payload.put("address2", ExcelUtil.getCellData("CreateAccount", 1, 8));
	    payload.put("country", ExcelUtil.getCellData("CreateAccount", 1, 9));
	    payload.put("state", ExcelUtil.getCellData("CreateAccount", 1, 10));
	    payload.put("city", ExcelUtil.getCellData("CreateAccount", 1, 11));
	    payload.put("zipcode", ExcelUtil.getCellData("CreateAccount", 1, 12));
	    payload.put("mobile_number", ExcelUtil.getCellData("CreateAccount", 1, 13));

	    payload.put("birth_date", ExcelUtil.getCellData("CreateAccount", 1, 14));
	    payload.put("birth_month", ExcelUtil.getCellData("CreateAccount", 1, 15));
	    payload.put("birth_year", ExcelUtil.getCellData("CreateAccount", 1, 16));

	    return payload;
	}
}