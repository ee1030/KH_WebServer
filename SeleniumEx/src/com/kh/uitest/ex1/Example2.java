package com.kh.uitest.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example2 {

	public static void main(String[] args) {
		// 크롬 드라이버 위치 지정 - ** 필수 코드 **
		System.setProperty("webdriver.chrome.driver", "C:/dev/selenium/chromedriver.exe");
		
		// 웹 드라이버 객체 생성
		WebDriver driver = new ChromeDriver();
		
		// 네이버로 이동
		driver.get("https://www.naver.com");
		
		// id 속성 값을 이용하여 요소 찾기
		// findElement(By.id("아이디"))
		// 네이버 검색창 id : query
		WebElement inputSearch = driver.findElement(By.id("query"));
		
		System.out.println(inputSearch);
		
		inputSearch.sendKeys("KH정보교육원");
		
		// id로 검색 버튼 얻어오기
		WebElement searchBtn = driver.findElement(By.id("search_btn"));
		
		// 찾은 검색 버튼 클릭
		searchBtn.click();
		
		// 테스트 종료
		//driver.close();

	}

}
