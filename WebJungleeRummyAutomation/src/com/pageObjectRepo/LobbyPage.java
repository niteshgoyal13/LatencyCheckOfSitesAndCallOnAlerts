package com.pageObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LobbyPage {
	
	//@FindBy(id= "skip_tour")
//	public static WebElement skipTour;
	
	@FindBy(linkText= "Skip")
	public static WebElement skipTour;
	
	
	@FindBy(id= "intro_start_close")
	public static WebElement introStartClose;
	
	@FindBy(id= "fancybox-close")
	public static WebElement fancyBoxClose;
	
	@FindBy(className= "intro-close-btn")
	public static WebElement introCloseBtn;
	
	@FindBy(id= "logout-btn")
	public static WebElement logOutButton;
	

}
