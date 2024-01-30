package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class rmgYantraValidation {

	public static void main(String[] args) throws Throwable {
		
		Connection con=null;
		Random ran=new Random();
		int ranNum = ran.nextInt(100);
		String proj_name = "PROJ_ZEELSHOPEE"+ranNum;
		try {
			
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Projects")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		
		//enter project details
		driver.findElement(By.name("projectName")).sendKeys( proj_name);
		driver.findElement(By.name("createdBy")).sendKeys("priya");
		WebElement status = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		
		Select sel = new Select(status);
		sel.selectByVisibleText("Created");
       
		driver.findElement(By.xpath("//input[@value=\"Add Project\"]")).click();
	
		//validate the data
		//step1:register the driver
		Driver dbdriver = new Driver();
		DriverManager.registerDriver(dbdriver);
		
		//step2:connect to DB
		 con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		
		//create statement
		Statement stmt = con.createStatement();
		String query = "select * from project where lower(project_name)='"+proj_name+"';";
       System.out.println("--- query executed---");
       
       ResultSet result = stmt.executeQuery(query);
       boolean flag = false;
       while (result.next()) {
    	   String actual = result.getString(4);
    	   if (actual.equalsIgnoreCase(proj_name)) {
			flag=true;
			break;
		} 
    	   System.out.println("it is true");
       }
       
    	   if(flag==true)
    	   {
    		   System.out.println("project created successfully");
    	   }
    	   else {
    		   System.out.println("prjct not added");
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			con.close();
			System.out.println("DB closed");
		}

	}
}


