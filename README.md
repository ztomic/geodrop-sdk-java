geodrop-sdk-java
===============

[Geodrop](https://geodrop.com/) is a provider of services and applications for the mobile market.
You can use the Geodrop API to send and receive SMS from web or from your application and to build new Premium Service with your digital content.
This JAVA SDK allows you to easily use Geodrop SMS services.
Except as otherwise noted, it is licensed under the [Apache Licence, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html).  

Usage
-----
Import the jar files: 
* [geodropSDKjava_1.0.jar] (...)
```
The [examples](...) are a good place to start.
To create a new session you must import:
```java
import geodropSDKjava.*;
```
Then you can create a session:
```java
GeodropSession session = 
	SessionFactory.buildSession_ResourceOwnerPasswordCredentials(applicationId, applicationSecret, username, password);
```
To send an SMS:
```java
import geodropSDKjava.dropOut.SMSSend;
...
SMSSend requestSMSSend = new SMSSend(vectorOfMsisdns,"message text","sender");
session.runMethod(requestSMSSend);
System.out.println("Response: " + requestSMSSend.getResponse().toString());
```
To challenge a customer to confirm the telephone number in content provider initiated transaction
and to charge the customer:

```java
import geodropSDKjava.dropPay.PortChallenge;
import geodropSDKjava.dropPay.PortChallenge_Response;
import geodropSDKjava.dropPay.PortChargeOnDemandPurchases;
...
PortChallenge requestPortChallenge = new PortChallenge(port, msisdn, "PortChallenge: pin: $$PIN$$");
if(session.runMethod(requestPortChallenge))
{
	String order = ((PortChallenge_Response)requestPortChallenge.getResponse()).getOrder();
	System.out.println("Insert pin: ");
	String pin = ""; /*retrieve the pin*/
	PortChargeOnDemandPurchases requestPortChargeOnDemandPurchases = new PortChargeOnDemandPurchases(port,msisdn,"message text",order,pin);
	session.runMethod(requestPortChargeOnDemandPurchases);
	System.out.println("Response: " + requestPortChargeOnDemandPurchases.getResponse().toString());
}
```

Documentation
-----
The documentation is available in the [doc folder](...).

Versioning
-----
The [semantic versioning](http://semver.org/) is used.
The format of the version number is MAJOR.MINOR.PATCH, where:
* MAJOR is incremented when incompatible API changes are done;
* MINOR is incremented when functionality in a backwards-compatible manner are added;
* PATCH is incremented when backwards-compatible bug fixes are done.  

Additional labels for pre-release and build metadata are available as extensions to the MAJOR.MINOR.PATCH format.  

Bug report
-----
If you find a bug [open an issue](...) and report the problem.