package com.kh.uitest.ex1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NaverLogin {

	public static void main(String[] args) {
		
		// 크롬 드라이버 위치 지정
		System.setProperty("webdriver.chrome.driver", "C:/dev/selenium/chromedriver.exe");
		
		// 웹 드라이버 객체 생성
		WebDriver driver = new ChromeDriver();
		
		// 네이버로 이동
		driver.get("https://www.naver.com");
		
		// 로그인 이동 버튼을 클래스명을 이용해서 얻어오기
		// -> 클래스명 처럼 다수가 선택되는 경우 List로 반환됨
		//List<WebElement> btns = driver.findElements(By.className("link_login"));
		
		// ---------------------------------------------------------------------
		// CSS 선택자로 요소 선택하기
		//List<WebElement> btns 
			// = driver.findElements(By.cssSelector(".link_login"));
			// = driver.findElements(By.cssSelector("a[class='link_login']"));
			// = driver.findElements(By.cssSelector("#account > a"));
		
		// -----------------------------------------------------------------------
		// xpath로 요소 선택하기
		
		List<WebElement> btns
			= driver.findElements(By.xpath("//*[@id=\"account\"]/a"));
		
		// List에 몇개의 요소가 있는지 확인
		System.out.println(btns.size());
		// 요소가 1개밖에 없음 -> 인덱스 0
		
		// 로그인 이동 버튼 클릭
		btns.get(0).click();
		
		// 아이디, 비밀번호, 로그인버튼 요소 얻어오기
		WebElement inputId = driver.findElement(By.id("id"));
		WebElement inputPw = driver.findElement(By.id("pw"));
		WebElement loginBtn = driver.findElement(By.id("log.login"));
		
		inputId.sendKeys("test1234");
		inputPw.sendKeys("1q2w3e4r!");
		loginBtn.click();
		
		// 테스트 종료
		//driver.close();
		
		

	}

}
