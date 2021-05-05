import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class jdbcConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/?locale=in");
		
		String host = "localhost";
		String port = "3306";

		Connection con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/Qadbt", "root", "Maa@12345");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from Employeeinfo where name = 'ram'");
		
		while(rs.next())
		{
		System.out.println(rs.getString("location"));
		driver.findElement(By.id("username")).sendKeys(rs.getString("location"));
		System.out.println(rs.getString("gender"));
		driver.findElement(By.id("password")).sendKeys(rs.getString("gender"));
		System.out.println(rs.getInt("age"));
		System.out.println(rs.getInt("id"));
		
		}	
		
		driver.findElement(By.id("Login")).click();
	}

}
