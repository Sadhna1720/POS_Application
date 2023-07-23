package service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import org.apache.poi.hssf.usermodel.*;

public class DBConnection {

	Connection connection = null;
	PreparedStatement preparedStatement;
	ResultSet resultSet = null;

	// this method use to establish connection
	public Connection connectionMethod() {
		System.out.println("Connection Requested here..........");
		String username = "student", pass = "student", url = "jdbc:mysql://localhost:3306/pos_db";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, pass);
		} catch (Exception e) {
			System.out.println("DB connection exception.....");
			System.out.println(e);
		}
		System.out.println("Connection object returning here..........");
		return connection;
	}

	// this method use for login purpose
	public ResultSet resultData(String query) {
		System.out.println("Resultset object requested here..........");
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

		} catch (Exception e) {
			System.out.println("DB resultSet exception.....");
			e.printStackTrace();
		}
		System.out.println("returning resultset here..........");
		return resultSet;
	}

	// this method use to store data in DB
	public Boolean resultProductAdd(VariableService variableService, String query) {
		System.out.println("Resultset object requested here..........");
		Boolean flag = false;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, variableService.getName());
			preparedStatement.setString(2, variableService.getProductId());
			preparedStatement.setString(3, variableService.getSellingPrice());
			preparedStatement.setString(4, variableService.getTax());
			preparedStatement.setString(5, variableService.getCategory());
			if (preparedStatement.executeUpdate() == 1)
				flag = true;
		} catch (Exception e) {
			System.out.println("DB resultProductAdd exception.....");
			e.printStackTrace();
			flag = false;
		}
		System.out.println("returning resultProductAdd here..........");
		return flag;
	}

	// this method use to store data in DB
	public Boolean resulttAdd(VariableService variableService, String query) {

		Boolean flag = false;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, variableService.getName());
			preparedStatement.setString(2, variableService.getContact());
			preparedStatement.setString(3, variableService.getAddress());
			if (preparedStatement.executeUpdate() == 1)
				flag = true;
		} catch (Exception e) {
			System.out.println("DB resultsupplierAdd exception.....");
			e.printStackTrace();
			flag = false;
		}
		System.out.println("DB returning resultsupplierAdd here..........");
		return flag;
	}

	public List<VariableService> SPreportData(String query, String tableName) {
		List<VariableService> productList = new ArrayList<VariableService>();
		List<VariableService> productList2 = new ArrayList<VariableService>();
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			int row = 0, row2 = 0;
			while (resultSet.next()) {
				VariableService variableService = new VariableService();
				variableService.setBillNumber(resultSet.getString("bill_number"));
				variableService.setName(resultSet.getString("product_name"));
				if(tableName.equals("purchasereport")) {
					variableService.setSupplierName(resultSet.getString("supplier_name"));
				}
				variableService.setSellingPrice(resultSet.getString("payable_price"));
				productList.add(variableService);
				row++;
			}
			row2 = row;
			String products = "";
			int count = 0, count2 = 0;
			String sNew = productList.get(count).getBillNumber(), sPrevious = productList.get(count).getBillNumber();
			do {
				row = row2;
				while (sPrevious.equals(sNew) && row > 0) {
					products += productList.get(count).getName();
					sPrevious = sNew;
					sNew = productList.get(count).getBillNumber();
					count++;
					row--;
					if (row != 0) {
						products += ", ";
					}
				}
				VariableService variableService = new VariableService();
				variableService.setBillNumber(sNew);
				variableService.setName(products);
				if(tableName.equals("purchasereport")) {
					variableService.setSupplierName(productList.get(count2).getSupplierName());
				}
				variableService.setSellingPrice(productList.get(count2).getSellingPrice());
				productList2.add(variableService);
				products = "";
				count2++;
				sPrevious = sNew;
				if (row != 0) {
					sNew = productList.get(count).getBillNumber();
				}
				count++;
				sPrevious = sNew;
			} while (row != 0);
		} catch (Exception e) {
			System.out.println("Exception in DBConnection/salesReportData ");
			e.printStackTrace();
		}
		return productList2;
	}

	// generalized method for export report to Excel
	public void exportExcel(HttpServletRequest request, HttpServletResponse response, String tableName)
			throws ServletException, IOException {
		System.out.println("exportExcel db method executed............");
		// Set response headers
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=database.xls");
		OutputStream outputStream = new FileOutputStream("C:\\Users\\Dell\\Desktop\\BankStatement.xls");
		
		// Get database data
		connectionMethod();
		try {
			preparedStatement = connection.prepareStatement("select * from "+tableName);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		// Create workbook and sheet
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Database");

		// Create header row
		int i=0;
		HSSFRow headerRow = sheet.createRow(0);
		headerRow.createCell(i).setCellValue("Bill Number");
		if(tableName.equals("salesreport")) {
			headerRow.createCell(++i).setCellValue("Customer Name");
			headerRow.createCell(++i).setCellValue("Contact");
			headerRow.createCell(++i).setCellValue("Payment Method");
		}
		headerRow.createCell(++i).setCellValue("Products");
		if(tableName.equals("purchasereport")) {
			headerRow.createCell(++i).setCellValue("Suplier Name");
			headerRow.createCell(++i).setCellValue("Suplier Contact");
			headerRow.createCell(++i).setCellValue("Suplier Address");
		}
		headerRow.createCell(++i).setCellValue("Purchase Date");
		headerRow.createCell(++i).setCellValue("Price");
		headerRow.createCell(++i).setCellValue("Total Tax");
		headerRow.createCell(++i).setCellValue("Payable Price");
		if(tableName.equals("salesreport")) {
			headerRow.createCell(++i).setCellValue("Discount");
		}
		
//	        String product=productName();
		
		int rowNum = 1;i=0;
		try {
			while (resultSet.next()) {
				HSSFRow row = sheet.createRow(rowNum++);
				row.createCell(i).setCellValue(resultSet.getString("bill_number"));
				if(tableName.equals("salesreport")) {
					row.createCell(++i).setCellValue(resultSet.getString("customer_name"));
					row.createCell(++i).setCellValue(resultSet.getString("customer_contact"));
					row.createCell(++i).setCellValue(resultSet.getString("payment_method"));
				}
		        row.createCell(++i).setCellValue("");   // add productName from 'productList2' list
				if(tableName.equals("purchasereport")) {
					row.createCell(++i).setCellValue(resultSet.getString("supplier_name"));
					row.createCell(++i).setCellValue(resultSet.getString("supplier_contact"));
					row.createCell(++i).setCellValue(resultSet.getString("supplier_address"));
				}
				row.createCell(++i).setCellValue(resultSet.getString("purchase_date"));
				row.createCell(++i).setCellValue(resultSet.getString("price"));
				row.createCell(++i).setCellValue(resultSet.getString("total_tax"));
				row.createCell(++i).setCellValue(resultSet.getString("payable_price"));
				if(tableName.equals("salesreport")) {
					row.createCell(++i).setCellValue(resultSet.getString("discount"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Write workbook to response output stream
		workbook.write(outputStream);
		workbook.close();
	}


	// in salesService for retrieve list of created products
	public List<VariableService> reportData() {
		List<VariableService> productList = new ArrayList<VariableService>();
		try {
			preparedStatement = connection.prepareStatement("select * from posproduct");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				VariableService variableService = new VariableService();
				variableService.setName(resultSet.getString("product_name"));
				variableService.setProductId(resultSet.getString("product_Id"));
				variableService.setSupplierName(resultSet.getString("supplier_name"));
				variableService.setCategory(resultSet.getString("category"));
				variableService.setCostPrice(resultSet.getString("cost_price"));
				variableService.setSellingPrice(resultSet.getString("selling_price"));
				variableService.setQty(resultSet.getString("qty"));
				variableService.setTax(resultSet.getString("tax"));
				productList.add(variableService);
			}
		} catch (SQLException e) {
			System.out.println("ReportService/ReportPurchaseServ/catch......exception.........");
			e.printStackTrace();
		}
		return productList;
	}

	public List<VariableService> retreiveList(ResultSet resultSet, String column) throws SQLException {
		List<VariableService> productList = new ArrayList<VariableService>();
		while (resultSet.next()) {
			VariableService variableService = new VariableService();
			variableService.setName(resultSet.getString(column));
			productList.add(variableService);
		}
		return productList;
	}
}
