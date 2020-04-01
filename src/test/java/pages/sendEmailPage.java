package pages;

import challenges.flow.*;
import flow.*;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;


public class sendEmailPage {

    private UserAgent userAgent;
    private EmailApp emailApp;
    private Engine engine;

    public sendEmailPage() {
        this.userAgent = new UserAgent();
        this.emailApp = new EmailApp();

        Map<String, IAdapter> adapters = new HashMap<String, IAdapter>();
        adapters.put("EMAIL", new EmailAdapter());

        this.engine = new Engine(userAgent, adapters, emailApp);

    }

    public void sendEmail(String emailMsg) {
        this.userAgent.writeMsg(emailMsg);
    }

    public void sendEmailToServer() throws Exception {
        try
        {
            this.engine.run();
        } catch (Exception e)
        {
            System.out.println(e.getStackTrace());
            throw e;
        }
    }

    public String getEmailInServer() {
        return this.emailApp.popMessage();
    }
}