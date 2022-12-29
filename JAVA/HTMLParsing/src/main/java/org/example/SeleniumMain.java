package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumMain {
    public static void main(String[] args){
        // 드라이버 위치 설정
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
        //브라우저를 띄우지 않고 진행할 경우
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
        // 드라이버 로드
//        WebDriver driver = new ChromeDriver(options);
        WebDriver driver = new ChromeDriver();

        // 사이트 접속
        driver.get("https://nid.naver.com/nidlogin.login");

        // js 실행
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript(
                "document.getElementsByName('id')[0].value=\'"
        + "idwritingtest"+"\'");
        js.executeScript(
                "document.getElementsByName('pw')[0].value=\'"
                        + "pwwritingtest"+"\'");

        //로그인 버튼 실행
        driver.findElement(By.xpath("//*[@id=\"log.login\"]")).click();
        // 소스코드 가져오기
        System.out.println(driver.getPageSource());
    }
}
