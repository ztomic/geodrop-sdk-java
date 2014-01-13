package com.geodrop.DropPay;

import java.util.HashMap;

import com.geodrop.ContentType;
import com.geodrop.ErrorType;
import com.geodrop.GeodropRequest;
import com.geodrop.HttpMethod;
import com.geodrop.Uri;

/**
 * Request used to unsubscribe a customer to a specific Port
 *
 * @author A-Tono s.r.l.
 * @since 1.0
 *
 */
public class CustomerGoodbye extends GeodropRequest 
{
	/**
	 * DropPay port id
	 */
	private int port;
	/**
	 * Customer phone number in E.164 format (without +)
	 */
	private String msisdn;
	/**
	 * Unique CP request id
	 */
	private String custom;
	/**
	 * Text to send, encoded in UTF-8, up to 160 characters
	 */
	private String text;
	/**
	 * Subscriber id required in subscription payments
	 */
	private int subscriber;
	
	/**
	 * Creates a new <CODE>CustomerGoodbye</CODE> instance
	 * 
	 * @param port The port number
	 * @param msisdn The msisdn
	 * @param text The message text
	 * @param subscriber The subscriber
	 * @param custom The custom ID
	 * @throws Exception If parameters are not validon
	 */
	public CustomerGoodbye(int port,String msisdn,String text,int subscriber,String custom) throws Exception
	{
		this.initialize(port, msisdn, text, subscriber, custom);
	}

	/**
	 * Creates a new <CODE>CustomerGoodbye</CODE> instance
	 * 
	 * @param port The port number
	 * @param msisdn The msisdn
	 * @param text The message text
	 * @param subscriber The subscriber
	 * @throws Exception If parameters are not valid
	 */
	public CustomerGoodbye(int port,String msisdn,String text,int subscriber) throws Exception
	{
		this.initialize(port, msisdn, text, subscriber, "customFromSDK");
	}

	/**
	 * Initialize the request
	 * 
	 * @param port The port number
	 * @param msisdn The msisdn
	 * @param text The message text
	 * @param subscriber The subscriber
	 * @param custom The custom ID
	 * @throws Exception If parameters are not valid
	 */
	private void initialize(int port,String msisdn,String text,int subscriber,String custom) throws Exception
	{
		//set parameters
		this.uri = Uri.PAY_CUSTOMERS_GOODBYE;
		this.httpMethod = HttpMethod.POST;
		this.contentType = ContentType.RAW;
		this.setPort(port);
		this.setMsisdn(msisdn);
		this.setText(text);
		this.setSubscriber(subscriber);
		this.setCustom(custom);
	}
	@Override
	protected boolean decodeResponse(String httpResponse) 
	{
		this.response = new CustomerWelcomeGoodbye_Response();
		return this.response.fillParameters(httpResponse);
	}

	@Override
	protected void createParams() 
	{
		this.params = new HashMap<String, Object>();
		this.params.put("port", this.port);
		this.params.put("msisdn", this.msisdn);
		this.params.put("text", this.text);
		this.params.put("subscriber", this.subscriber);
		this.params.put("custom", this.custom);
	}

	//getters
	/**
	 * @return DropPay port id
	 */
	public int getPort() 
	{
		return this.port;
	}

	/**
	 * @return Customer phone number in E.164 format (without +)
	 */
	public String getMsisdn() 
	{
		return this.msisdn;
	}

	/**
	 * @return Unique CP request id
	 */
	public String getCustom() 
	{
		return this.custom;
	}

	/**
	 * @return Text to send, encoded in UTF-8, up to 160 characters
	 */
	public String getText() 
	{
		return this.text;
	}

	/**
	 * @return Subscriber id required in subscription payments
	 */
	public int getSubscriber() 
	{
		return this.subscriber;
	}

	//setters
	/**
	 * @param port DropPay port id
	 */
	public void setPort(int port) 
	{
		this.port = port;
	}

	/**
	 * @param msisdn Customer phone number in E.164 format (without +)
	 * @throws Exception If parameters are not valid
	 */
	public void setMsisdn(String msisdn) throws Exception 
	{
		//check msisdns format
		if(!this.checkMsisdnE164Format(msisdn,false))
		{
			throw new Exception(ErrorType.MALFORMED_MSISDN);
		}
		this.msisdn = msisdn;
	}

	/**
	 * @param custom Unique CP request id
	 */
	public void setCustom(String custom) 
	{
		this.custom = custom;
	}

	/**
	 * @param text Text to send, encoded in UTF-8, up to 160 characters
	 */
	public void setText(String text) 
	{
		this.text = text;
	}

	/**
	 * @param subscriber Subscriber id required in subscription payments
	 */
	public void setSubscriber(int subscriber) 
	{
		this.subscriber = subscriber;
	}
}
