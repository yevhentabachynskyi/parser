package setting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class LoaderSettings {
	private String [] proxySetting=new String[2];
	private  void checkProxy() throws IOException {
		 BufferedReader reader = new BufferedReader(new FileReader("./setting.ini"));
		 String line;
		 int count=0;
		 if ((line = reader.readLine()) != null) {
			 line=line.replaceFirst("proxy:", "");
			 proxySetting[0]=line;
		 }
		 if ((line = reader.readLine()) != null) {
			 line=line.replaceFirst("port:", "");
			 proxySetting[1]=line;
		 }
		 reader.close();
	 }
	
	public String getProxyServer() throws IOException {
		checkProxy();
		return proxySetting[0];
		}
	public String getPortServer() throws IOException {
		checkProxy();
		return proxySetting[1];
		}
	// Trusting all certificate 
	 public void doTrustToCertificates()  {
		 TrustManager[] trustAllCerts = new TrustManager[]{
			        new X509TrustManager() {

			            public java.security.cert.X509Certificate[] getAcceptedIssuers()
			            {
			                return null;
			            }
			            public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
			            {
			                //No need to implement.
			            }
			            public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
			            {
			                //No need to implement.
			            }
			        }
			};

			// Install the all-trusting trust manager
			try 
			{
			    SSLContext sc = SSLContext.getInstance("SSL");
			    sc.init(null, trustAllCerts, new java.security.SecureRandom());
			    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			} 
			catch (Exception e) 
			{
			    System.out.println(e);
			}
	 }
}
