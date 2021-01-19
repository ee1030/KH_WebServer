package com.kh.uitest.ex2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class seleniumPractice2 {

	public static void main(String[] args) {
		// 크롬 드라이버 위치 지정(필수)
		System.setProperty("webdriver.chrome.driver", "C:/dev/selenium/chromedriver.exe");
		
		// 드라이버 객체 생성(필수)
		WebDriver driver = new ChromeDriver();
		
		// 자바 스크립트 함수를 호출 할 수 있도록 준비
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.get("https://iei.or.kr/login/login.kh");
		
		WebElement inputId = driver.findElement(By.id("id"));
		WebElement inputPw = driver.findElement(By.id("password"));
		
		inputId.sendKeys("ee1030");
		inputPw.sendKeys("dbdudwo1!!");
		
		exe.executeScript("javascript:fnLogin()");
		
		wait.until(ExpectedConditions.titleContains("KH정보교육원 - 수강생 평가"));
		
		exe.executeScript("javascript:location.href='/login/currBoard.kh'");
		
		wait.until(ExpectedConditions.titleContains("우리반 게시판"));
		
		exe.executeScript("fnSelect('19213')");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("comment_area")));
		
		WebElement comment = driver.findElement(By.id("comment_area"));
		
		comment.sendKeys("응애개발자가 다녀갑니다.");
		
		exe.executeScript("javascript:fnComment(19213)");
		
		driver.switchTo().alert().accept();
	}

}
