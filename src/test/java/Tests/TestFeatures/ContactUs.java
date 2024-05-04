package Tests.TestFeatures;

import Tests.Browser.SetUp_Website;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.ContactUs.ContactUsForm;
import pages.ContactUs.ContactUsPage;
import pages.RegisterUser.HomePage;

public class ContactUs extends SetUp_Website {
    @Description("Test Case 6: Contact Us Form")
    @Test
    public void VerifyingContactUsForm() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.openUrl(website);

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.getContactUsPage();
        contactUsPage.assertContactUsPage();

        ContactUsForm contactUsForm = new ContactUsForm(driver);
        contactUsForm.contactForm();
       String message = contactUsForm.ContactUsFormMessage();
       if (message.contains("successfully"))
       {
           System.out.println("Your form have been submitted successfully!!");
       }
       else {
           System.out.println("Your form have not been submitted successfully!!");
       }
        contactUsForm.returnToHomePage();
    }
}
