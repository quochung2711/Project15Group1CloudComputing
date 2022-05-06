package com.tntb.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;

import com.amazonaws.services.rds.auth.GetIamAuthTokenRequest;
import com.amazonaws.services.rds.auth.RdsIamAuthTokenGenerator;
public class DBConnect {
	
	public static Connection getConnect(){
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://productdatabase.cluster-chqkcwcq83qc.us-east-1.rds.amazonaws.com:3306/ProductDATABASE","admin","21052711");
			System.out.println("Kết nối thành công!");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Kết nối thất bại!"+e.getMessage());
		}
		return connection;
	}
	public static void main(String[] args) {
		System.out.println(getConnect());
	}
	 static String generateAuthToken(String region, String hostName, String port, String username) {

		    RdsIamAuthTokenGenerator generator = RdsIamAuthTokenGenerator.builder()
			    .credentials(new DefaultAWSCredentialsProviderChain())
			    .region(region)
			    .build();

		    String authToken = generator.getAuthToken(
			    GetIamAuthTokenRequest.builder()
			    .hostname(hostName)
			    .port(Integer.parseInt(port))
			    .userName(username)
			    .build());
		    
		    return authToken;
	    }
}
