package VitaAsk;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.instance.Account;

import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;




import java.util.ArrayList; 
import java.util.List; 
import org.apache.http.NameValuePair; 
import org.apache.http.message.BasicNameValuePair;

/**
 * Servlet implementation class TwilioReq
 */
@WebServlet("/TwilioReq")
public class VitaAsk extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final String ACCOUNT_SID = "ACd7f12bf28315a149aa20c0f7888957dd";
      public static final String AUTH_TOKEN = "53afb8fd8988436059b29a59d1975fbc";
      public static String body = "";
      public static String From = "";
      public static String To = "";
      public static String responseText = "";

      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // TODO Auto-generated method stub
            body = request.getParameter("Body");
            From = request.getParameter("From");
            To = request.getParameter("To");
            System.out.println("from value: " + From);
            System.out.println("body: " + body);
            doGet(request, response);

            if(body.equals("Vit A"))
            {
                responseText = "Carrots, sweet potatoes, dark leafy greens "
                		+ "Adults: Age 19+:"
                		+ "Males: 900 μg"
                		+ "Females: 700 μg"
                		+ "Infants/children: ( below 18)"
                		+ "boys years : 900 μg"
                		+ "girls years : 700 μg";
            try {
                sendSms();
            } catch (TwilioRestException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            }
            else
            {
                responseText = "I'm sorry, that vitamin is currently not in our database or was misspelt. Please try again. Ex: Vit B23";
                try {
                    sendSms();
                } catch (TwilioRestException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
            }

        }
      public static void sendSms() throws TwilioRestException{
        if(From != null)
        {
      TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
      Account account = client.getAccount();
      System.out.println("from value: " + From);

      MessageFactory messageFactory = account.getMessageFactory();
      List<NameValuePair> params = new ArrayList<NameValuePair>();
      params.add(new BasicNameValuePair("To", "9142991173")); // Replace with a valid phone number for your account.
      params.add(new BasicNameValuePair("From", "9142054512")); // Replace with a valid phone number for your account.
      params.add(new BasicNameValuePair("Body", responseText));
    //  Message sms = messageFactory.create(params);

        }}


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath())       
    }

}