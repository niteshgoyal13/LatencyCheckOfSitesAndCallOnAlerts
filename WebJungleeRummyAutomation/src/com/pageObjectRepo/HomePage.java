package com.pageObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	//login elements -------------------------------
	

	
	@FindBy(id="username")
	public static WebElement loginName;
	
	@FindBy(id="password")
	public static WebElement loginPassword;
	
	@FindBy(xpath="/html/body/app-root/jwr-full-page/page-header/div/login/div[1]/div[3]/button")
	public static WebElement submitLogin;
	
	//Forgot password elements --------------------------
	@FindBy (linkText = "Forgot Password?")
	public static WebElement ForgotPassword;
	
	@FindBy (id= "forgotPasswordForm")
	public static WebElement ForgotPasswordPopUp ;
	
	@FindBy (id= "fp-submit")
	public static WebElement FpSubmit ;
	
	// @FindBy (id="email")
	//public static WebElement EnterEmail ;
	
	// @FindBy (xpath="//*[@id='email']")
    // public static WebElement EnterEmail ;
	 
	@FindBy (xpath="//div[contains(@class, 'forgot') and [@id='email']")
    public static WebElement EnterEmail ;
	
	
	//Signup elements --------------------------

	 @FindBy(id="reg-form")
	  public static WebElement RegistrationForm;
	 
	/* @FindBy(id="username1 top")
	  public static WebElement SignUpName;*/
	 @FindBy(xpath="//signup//div[2]//input[1]")
	  public static WebElement SignUpName;
	 
	 /*@FindBy(id="regPassword")
	  public static WebElement SignUpPassword;*/
	 @FindBy(xpath="//signup//div[2]//input[2]")
	  public static WebElement SignUpPassword;
	 
	 /*@FindBy(id="email")
	  public static WebElement SignUpEmail;*/
	 @FindBy(xpath="//signup//div[2]//input[3]")
	  public static WebElement SignUpEmail;
	 
	/* @FindBy(id="play-rummy")
	  public static WebElement ButtonPlayRummyNow;*/
	 
	 @FindBy(xpath="/html/body/app-root/jwr-full-page/jwr-home/div[1]/div[1]/div/div/signup/div[2]/button/h2")
	  public static WebElement ButtonPlayRummyNow;
	 
	 @FindBy(linkText="T&C.")
	  public static WebElement TermsAndConditions;

	//Signup error validations  --------------------------
	 @FindBy(id="username-error")
	  public static WebElement RegusernameError;
	 
	 @FindBy(id="password-error")
	  public static WebElement RegPasswordError;
	 
	 @FindBy(id="email-error")
	  public static WebElement RegEmailError;
	 
	 @FindBy(className="popup-content")
	  public static WebElement ErrorPopUp;
	 
	 @FindBy(xpath="//*[@id='closecontainer']/div[1]")
	  public static WebElement CloseButtonPopUp;
	 
	 @FindBy(xpath="/html/body/app-root/jwr-full-page/jwr-home/div[1]/div[1]/div/div/signup/div[2]/div[1]/div")
	  public static WebElement ValidationCheckOnUserName;
	  
	 
}
