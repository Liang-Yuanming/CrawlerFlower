import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Download {
	public boolean doPost(String sURL,String data,String cookie,String referer,String charset){
		boolean doSuccess = false; 
		BufferedWriter wr = null;
		 try {
			URL url = new URL(sURL);
			HttpURLConnection URLConn = (HttpURLConnection) url.openConnection(); 
			URLConn.setDoOutput(true); 
		    URLConn.setDoInput(true);
		    ((HttpURLConnection) URLConn).setRequestMethod("POST");
		    URLConn.setUseCaches(false); 
		    URLConn.setAllowUserInteraction(true);
		    HttpURLConnection.setFollowRedirects(true); 
		    URLConn.setInstanceFollowRedirects(true); 
		    URLConn 
	          .setRequestProperty( 
	              "User-agent", 
	              "Mozilla/5.0 (Windows; U; Windows NT 6.0; zh-TW; rv:1.9.1.2) " 
	                  + "Gecko/20090729 Firefox/3.5.2 GTB5 (.NET CLR 3.5.30729)");
		    URLConn 
	          .setRequestProperty("Accept", 
	              "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"); 
		    URLConn.setRequestProperty("Accept-Language", 
		          "zh-tw,en-us;q=0.7,en;q=0.3"); 
		    URLConn.setRequestProperty("Accept-Charse", 
		          "Big5,utf-8;q=0.7,*;q=0.7"); 
		    if (cookie != null) 
		        URLConn.setRequestProperty("Cookie", cookie); 
		    if (referer != null) 
		        URLConn.setRequestProperty("Referer", referer);
		    URLConn.setRequestProperty("Content-Type", 
		            "application/x-www-form-urlencoded"); 
		    URLConn.setRequestProperty("Content-Length", String.valueOf(data 
		            .getBytes().length)); 
		    DataOutputStream dos = new DataOutputStream(URLConn 
		            .getOutputStream());
		    dos.writeBytes(data);
		    BufferedReader rd = new BufferedReader( 
		            new InputStreamReader(URLConn.getInputStream(), 
		                charset)); 
		    String line; 
		    while ((line = rd.readLine()) != null) { 
		        System.out.println(line); 
		     } 
		    rd.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return doSuccess;
	}
	public static boolean download(final File output, final String source,ConvertDate ss) {
	    try {
	        if (!output.createNewFile()) {
	            throw new RuntimeException("Could not create new file!");
	        }
	        URL url = new URL(source);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        // Comment in the code in the following line in case the endpoint redirects instead of it being a direct link
	        // connection.setInstanceFollowRedirects(true);
	        connection.setRequestMethod("POST");
	        connection.setDoOutput(true); 
	        connection.setDoInput(true);
	        connection 
	          .setRequestProperty( 
	              "User-agent", 
	              "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0");
	        connection 
	          .setRequestProperty("Accept", 
	              "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"); 
	        connection.setRequestProperty("Accept-Language", 
			          "zh-TW,zh;q=0.8,en-US;q=0.5,en;q=0.3"); 
	        connection.setRequestProperty("Accept-Encoding", 
			          "gzip, deflate"); 
	        connection.setRequestProperty("Referer", 
			          "http://amis.afa.gov.tw/flower/FlowerProdDayTransInfo.aspx"); 
	        connection.setRequestProperty("Cookie", 
			          "ASP.NET_SessionId=pwacjbpkoqz13qe2qsmpoc44"); 
	        connection.setRequestProperty("Connection", 
			          "keep-alive"); 
	        connection.setRequestProperty("Upgrade-Insecure-Requests", 
			          "1"); 
	        String urlParameters="ctl00%24contentPlaceHolder%24ucDateScope%24rblDateScope=P&ctl00%24contentPlaceHolder%24txtProductNo=&ctl00%24contentPlaceHolder%24ucSolarLunar%24radlSolarLunar=S&ctl00%24contentPlaceHolder%24txtSTransDate="+ss.getYear1()+"%2F"+ss.getMonth1()+"%2F"+ss.getDay1()+"&ctl00%24contentPlaceHolder%24txtETransDate="+ss.getYear1()+"%2F"+ss.getMonth2()+"%2F"+ss.getDay2()+"&ctl00%24contentPlaceHolder%24txtMarket=%E5%85%A8%E9%83%A8%E5%B8%82%E5%A0%B4&ctl00%24contentPlaceHolder%24hfldMarketNo=ALL&ctl00%24contentPlaceHolder%24txtProduct=FS000+%E9%A6%99%E6%B0%B4%E7%99%BE%E5%90%88%2C+FS001+%E9%A6%99%E6%B0%B4%E7%99%BE%E5%90%88+%E5%96%AE%E6%9C%B5&ctl00%24contentPlaceHolder%24hfldProductNo=FH293%2CFH298%2CFH364%2CFH630%2CFH631%2CFH633%2CFH634%2CFH636%2CFH661%2CFK410%2CFK411%2CFK412%2CFK413%2CFK419%2CFK420%2CFK422%2CFK423%2CFK429%2CFK433%2CFK442%2CFK443%2CFK449%2CFR602%2CFS000%2CFS002%2CFS003%2CFS009%2CFS010%2CFS012%2CFS013%2CFS019%2CFS030%2CFS031%2CFS032%2CFS033%2CFS039%2CFS040%2CFS041%2CFS042%2CFS043%2CFS049%2CFS060%2CFS130%2CFS132%2CFS133%2CFS139%2CFS230%2CFS231%2CFS232%2CFS233%2CFS239%2CFS350%2CFS351%2CFS352%2CFS353%2CFS359%2CFS360%2CFS361%2CFS362%2CFS363%2CFS369%2CFS410%2CFS411%2CFS412%2CFS413%2CFS419%2CFS430%2CFS431%2CFS432%2CFS433%2CFS439%2CFS440%2CFS441%2CFS442%2CFS443%2CFS449%2CFS450%2CFS451%2CFS452%2CFS453%2CFS459%2CFS460%2CFS461%2CFS462%2CFS463%2CFS469%2CFS539%2CFS560%2CFS562%2CFS563%2CFS569%2CFS570%2CFS571%2CFS572%2CFS573%2CFS579%2CFS590%2CFS591%2CFS592%2CFS593%2CFS599%2CFS600%2CFS601%2CFS602%2CFS603%2CFS609%2CFS620%2CFS622%2CFS623%2CFS629%2CFS630%2CFS631%2CFS632%2CFS633%2CFS639%2CFS660%2CFS661%2CFS662%2CFS663%2CFS669%2CFS670%2CFS671%2CFS672%2CFS673%2CFS679%2CFS680%2CFS681%2CFS682%2CFS683%2CFS689%2CFS690%2CFS691%2CFS692%2CFS693%2CFS700%2CFS702%2CFS703%2CFS710%2CFS712%2CFS713%2CFS719%2CFS720%2CFS722%2CFS723%2CFS729%2CFS730%2CFS732%2CFS733%2CFS739%2CFS750%2CFS752%2CFS753%2CFS759%2CFS770%2CFS771%2CFS772%2CFS773%2CFS779%2CFS830%2CFS831%2CFS832%2CFS833%2CFS839%2CFS880%2CFS881%2CFS882%2CFS883%2CFS890%2CFS892%2CFS893%2CFS899%2CFT660%2CFT661%2CFT662%2CFT663%2CFT669&ctl00%24contentPlaceHolder%24hfldProductType=S&ctl00%24contentPlaceHolder%24btnXls=%E4%B8%8B%E8%BC%89Excel&__EVENTTARGET=&__EVENTARGUMENT=&__VIEWSTATE=%2FwEPDwUJNTA1OTkxMTAzD2QWAmYPZBYCAgMPZBYCAgsPZBYOAgEPDxYCHgRUZXh0BRXnlKLlk4Hml6XkuqTmmJPooYzmg4VkZAIJDw8WAh8ABQkxMDYvMDQvMDFkZAILDw9kFgIeBXN0eWxlBQ1kaXNwbGF5Om5vbmU7ZAINDw8WAh8ABQkxMDYvMDQvMTIWAh8BBQ1kaXNwbGF5Om5vbmU7ZAIPDw8WAh8ABQzlhajpg6jluILloLRkZAIVDw8WAh8ABS1GUzAwMCDpppnmsLTnmb7lkIgsIEZTMDAxIOmmmeawtOeZvuWQiCDllq7mnLVkZAIjD2QWAmYPZBYCAgEPDxYCHgdWaXNpYmxlZ2QWDGYPDxYCHwAFFeeUouWTgeaXpeS6pOaYk%2BihjOaDhWRkAgEPDxYCHwAFNDEwNi8wNC8wMSB%2BIDEwNi8wNC8xMiAo6L6y5puGOjEwNi8wMy8wNSB%2BIDEwNi8wMy8xNilkZAICDw8WAh8ABRIxMDYvMDQvMTIgMTU6MzE6MjZkZAIDDw8WAh8ABQzlhajpg6jluILloLRkZAIEDw8WAh8ABS1GUzAwMCDpppnmsLTnmb7lkIgsIEZTMDAxIOmmmeawtOeZvuWQiCDllq7mnLVkZAIFDxQrAAIPFgYeEUl0ZW1QbGFjZWhvbGRlcklEBRhteUxheW91dCRpdGVtUGxhY2Vob2xkZXIeC18hRGF0YUJvdW5kZx4LXyFJdGVtQ291bnQCIWRkFgJmD2QWAmYPZBZIAgEPDxYCHwAFBDg5LjhkZAIDDw8WAh8ABQUxLDA5OGRkAgUPDxYCHwAFATBkZAIHD2QWAmYPZBYCZg8WAh4FY2xhc3MFCW1haW5fbWFpbhYYZg9kFgJmDxUBCTEwNi8wNC8wMWQCAQ9kFgJmDxUBEDQwMCDlj7DkuK3luILloLRkAgIPZBYCZg8VARNGUzAwMCDpppnmsLTnmb7lkIggZAIDD2QWAmYPFQECOTZkAgQPZBYCZg8VAQI4OWQCBQ9kFgJmDxUBAjU5ZAIGD2QWAmYPFQECMzVkAgcPZBYCZg8VAgltYWluX2JsdWUENjAuMGQCCA9kFgJmDxUCCW1haW5fYmx1ZQUgLSAgNWQCCQ9kFgJmDxUCCW1haW5fYmx1ZQMxMDVkAgoPZBYCZg8VAgltYWluX2JsdWUFIC0gIDVkAgsPZBYCZg8VAQEwZAIID2QWAmYPZBYCZg8WAh8GBQxtYWluX21haW5fMDIWGGYPZBYCZg8VAQkxMDYvMDQvMDJkAgEPZBYCZg8VARA0MDAg5Y%2Bw5Lit5biC5aC0ZAICD2QWAmYPFQETRlMwMDAg6aaZ5rC055m%2B5ZCIIGQCAw9kFgJmDxUBAjM1ZAIED2QWAmYPFQECMzVkAgUPZBYCZg8VAQIzNWQCBg9kFgJmDxUBAjM1ZAIHD2QWAmYPFQIJbWFpbl9ibHVlBDM1LjBkAggPZBYCZg8VAgltYWluX2JsdWUFIC0gNDJkAgkPZBYCZg8VAgltYWluX2JsdWUCMjJkAgoPZBYCZg8VAgltYWluX2JsdWUFIC0gNzlkAgsPZBYCZg8VAQEwZAIJD2QWAmYPZBYCZg8WAh8GBQltYWluX21haW4WGGYPZBYCZg8VAQkxMDYvMDQvMDJkAgEPZBYCZg8VARA1MTQg5b2w5YyW5biC5aC0ZAICD2QWAmYPFQETRlMwMDAg6aaZ5rC055m%2B5ZCIIGQCAw9kFgJmDxUBAjY3ZAIED2QWAmYPFQECNjdkAgUPZBYCZg8VAQI2MWQCBg9kFgJmDxUBAjQ5ZAIHD2QWAmYPFCsCAmQFBDYwLjBkAggPZBYCZg8UKwICZAUFICAtICBkAgkPZBYCZg8UKwICZAUCNDdkAgoPZBYCZg8UKwICZAUFICAtICBkAgsPZBYCZg8VAQEwZAIKD2QWAmYPZBYCZg8WAh8GBQxtYWluX21haW5fMDIWGGYPZBYCZg8VAQkxMDYvMDQvMDJkAgEPZBYCZg8VARA3MDAg5Y%2Bw5Y2X5biC5aC0ZAICD2QWAmYPFQETRlMwMDAg6aaZ5rC055m%2B5ZCIIGQCAw9kFgJmDxUBAjgwZAIED2QWAmYPFQECODBkAgUPZBYCZg8VAQI4MGQCBg9kFgJmDxUBAjgwZAIHD2QWAmYPFCsCAmQFBDgwLjBkAggPZBYCZg8UKwICZAUFICAtICBkAgkPZBYCZg8UKwICZAUCMTJkAgoPZBYCZg8UKwICZAUFICAtICBkAgsPZBYCZg8VAQEwZAILD2QWAmYPZBYCZg8WAh8GBQltYWluX21haW4WGGYPZBYCZg8VAQkxMDYvMDQvMDJkAgEPZBYCZg8VARAxMDUg5Y%2Bw5YyX6Iqx5biCZAICD2QWAmYPFQEZRlMwMDEg6aaZ5rC055m%2B5ZCIIOWWruactWQCAw9kFgJmDxUBAzEzNWQCBA9kFgJmDxUBAzEzNWQCBQ9kFgJmDxUBAzEyN2QCBg9kFgJmDxUBAzExMmQCBw9kFgJmDxQrAgJkBQUxMjUuOWQCCA9kFgJmDxQrAgJkBQUgIC0gIGQCCQ9kFgJmDxQrAgJkBQI4M2QCCg9kFgJmDxQrAgJkBQUgIC0gIGQCCw9kFgJmDxUBATBkAgwPZBYCZg9kFgJmDxYCHwYFDG1haW5fbWFpbl8wMhYYZg9kFgJmDxUBCTEwNi8wNC8wMmQCAQ9kFgJmDxUBEDUxNCDlvbDljJbluILloLRkAgIPZBYCZg8VARlGUzAwMSDpppnmsLTnmb7lkIgg5Zau5py1ZAIDD2QWAmYPFQECNTBkAgQPZBYCZg8VAQI1MGQCBQ9kFgJmDxUBAjUwZAIGD2QWAmYPFQECNTBkAgcPZBYCZg8UKwICZAUENTAuMGQCCA9kFgJmDxQrAgJkBQUgIC0gIGQCCQ9kFgJmDxQrAgJkBQIxOWQCCg9kFgJmDxQrAgJkBQUgIC0gIGQCCw9kFgJmDxUBATBkAg0PZBYCZg9kFgJmDxYCHwYFCW1haW5fbWFpbhYYZg9kFgJmDxUBCTEwNi8wNC8wM2QCAQ9kFgJmDxUBEDUxNCDlvbDljJbluILloLRkAgIPZBYCZg8VARNGUzAwMCDpppnmsLTnmb7lkIggZAIDD2QWAmYPFQEDMTAxZAIED2QWAmYPFQEDMTAxZAIFD2QWAmYPFQEDMTAxZAIGD2QWAmYPFQEDMTAxZAIHD2QWAmYPFQIIbWFpbl9yZWQFMTAxLjBkAggPZBYCZg8VAghtYWluX3JlZAUgKyA2OGQCCQ9kFgJmDxUCCW1haW5fYmx1ZQIxNGQCCg9kFgJmDxUCCW1haW5fYmx1ZQUgLSA3MGQCCw9kFgJmDxUBATBkAg4PZBYCZg9kFgJmDxYCHwYFDG1haW5fbWFpbl8wMhYYZg9kFgJmDxUBCTEwNi8wNC8wNWQCAQ9kFgJmDxUBEDUxNCDlvbDljJbluILloLRkAgIPZBYCZg8VARNGUzAwMCDpppnmsLTnmb7lkIggZAIDD2QWAmYPFQEDMTc2ZAIED2QWAmYPFQEDMTc2ZAIFD2QWAmYPFQEDMTc2ZAIGD2QWAmYPFQEDMTc2ZAIHD2QWAmYPFQIIbWFpbl9yZWQFMTc2LjBkAggPZBYCZg8VAghtYWluX3JlZAUgKyA3NGQCCQ9kFgJmDxUCCW1haW5fYmx1ZQE1ZAIKD2QWAmYPFQIJbWFpbl9ibHVlBSAtIDY0ZAILD2QWAmYPFQEBMGQCDw9kFgJmD2QWAmYPFgIfBgUJbWFpbl9tYWluFhhmD2QWAmYPFQEJMTA2LzA0LzA1ZAIBD2QWAmYPFQEQNzAwIOWPsOWNl%2BW4guWgtGQCAg9kFgJmDxUBE0ZTMDAwIOmmmeawtOeZvuWQiCBkAgMPZBYCZg8VAQI4M2QCBA9kFgJmDxUBAjgzZAIFD2QWAmYPFQECNjFkAgYPZBYCZg8VAQI0OWQCBw9kFgJmDxQrAgJkBQQ2My4wZAIID2QWAmYPFCsCAmQFBSAgLSAgZAIJD2QWAmYPFCsCAmQFAzEwMmQCCg9kFgJmDxQrAgJkBQUgIC0gIGQCCw9kFgJmDxUBATBkAhAPZBYCZg9kFgJmDxYCHwYFDG1haW5fbWFpbl8wMhYYZg9kFgJmDxUBCTEwNi8wNC8wNWQCAQ9kFgJmDxUBEDUxNCDlvbDljJbluILloLRkAgIPZBYCZg8VARlGUzAwMSDpppnmsLTnmb7lkIgg5Zau5py1ZAIDD2QWAmYPFQECNDdkAgQPZBYCZg8VAQI0N2QCBQ9kFgJmDxUBAjQ3ZAIGD2QWAmYPFQECNDdkAgcPZBYCZg8UKwICZAUENDcuMGQCCA9kFgJmDxQrAgJkBQUgIC0gIGQCCQ9kFgJmDxQrAgJkBQIxOGQCCg9kFgJmDxQrAgJkBQUgIC0gIGQCCw9kFgJmDxUBATBkAhEPZBYCZg9kFgJmDxYCHwYFCW1haW5fbWFpbhYYZg9kFgJmDxUBCTEwNi8wNC8wNmQCAQ9kFgJmDxUBEDEwNSDlj7DljJfoirHluIJkAgIPZBYCZg8VARNGUzAwMCDpppnmsLTnmb7lkIggZAIDD2QWAmYPFQEDMjcwZAIED2QWAmYPFQEDMjcwZAIFD2QWAmYPFQEDMjEzZAIGD2QWAmYPFQEDMTY0ZAIHD2QWAmYPFCsCAmQFBTIxMi4yZAIID2QWAmYPFCsCAmQFBSAgLSAgZAIJD2QWAmYPFCsCAmQFAjIyZAIKD2QWAmYPFCsCAmQFBSAgLSAgZAILD2QWAmYPFQEBMGQCEg9kFgJmD2QWAmYPFgIfBgUMbWFpbl9tYWluXzAyFhhmD2QWAmYPFQEJMTA2LzA0LzA2ZAIBD2QWAmYPFQEQNDAwIOWPsOS4reW4guWgtGQCAg9kFgJmDxUBE0ZTMDAwIOmmmeawtOeZvuWQiCBkAgMPZBYCZg8VAQI3NWQCBA9kFgJmDxUBAjc1ZAIFD2QWAmYPFQECNzFkAgYPZBYCZg8VAQI2OWQCBw9kFgJmDxQrAgJkBQQ3MS4wZAIID2QWAmYPFCsCAmQFBSAgLSAgZAIJD2QWAmYPFCsCAmQFAjMyZAIKD2QWAmYPFCsCAmQFBSAgLSAgZAILD2QWAmYPFQEBMGQCEw9kFgJmD2QWAmYPFgIfBgUJbWFpbl9tYWluFhhmD2QWAmYPFQEJMTA2LzA0LzA2ZAIBD2QWAmYPFQEQMTA1IOWPsOWMl%2BiKseW4gmQCAg9kFgJmDxUBGUZTMDAxIOmmmeawtOeZvuWQiCDllq7mnLVkAgMPZBYCZg8VAQMxNzlkAgQPZBYCZg8VAQMxNzlkAgUPZBYCZg8VAQMxNzlkAgYPZBYCZg8VAQMxNzlkAgcPZBYCZg8UKwICZAUFMTc5LjBkAggPZBYCZg8UKwICZAUFICAtICBkAgkPZBYCZg8UKwICZAUCMTVkAgoPZBYCZg8UKwICZAUFICAtICBkAgsPZBYCZg8VAQEwZAIUD2QWAmYPZBYCZg8WAh8GBQxtYWluX21haW5fMDIWGGYPZBYCZg8VAQkxMDYvMDQvMDdkAgEPZBYCZg8VARAxMDUg5Y%2Bw5YyX6Iqx5biCZAICD2QWAmYPFQETRlMwMDAg6aaZ5rC055m%2B5ZCIIGQCAw9kFgJmDxUBAzMwMGQCBA9kFgJmDxUBAzMwMGQCBQ9kFgJmDxUBAzMwMGQCBg9kFgJmDxUBAzMwMGQCBw9kFgJmDxUCCG1haW5fcmVkBTMwMC4wZAIID2QWAmYPFQIIbWFpbl9yZWQFICsgNDFkAgkPZBYCZg8VAgltYWluX2JsdWUBN2QCCg9kFgJmDxUCCW1haW5fYmx1ZQUgLSA2OGQCCw9kFgJmDxUBATBkAhUPZBYCZg9kFgJmDxYCHwYFCW1haW5fbWFpbhYYZg9kFgJmDxUBCTEwNi8wNC8wN2QCAQ9kFgJmDxUBEDQwMCDlj7DkuK3luILloLRkAgIPZBYCZg8VARNGUzAwMCDpppnmsLTnmb7lkIggZAIDD2QWAmYPFQECNjhkAgQPZBYCZg8VAQI2OGQCBQ9kFgJmDxUBAjYxZAIGD2QWAmYPFQECNThkAgcPZBYCZg8VAgltYWluX2JsdWUENjIuMGQCCA9kFgJmDxUCCW1haW5fYmx1ZQUgLSAxM2QCCQ9kFgJmDxUCCG1haW5fcmVkAjU5ZAIKD2QWAmYPFQIIbWFpbl9yZWQFICsgODRkAgsPZBYCZg8VAQEwZAIWD2QWAmYPZBYCZg8WAh8GBQxtYWluX21haW5fMDIWGGYPZBYCZg8VAQkxMDYvMDQvMDdkAgEPZBYCZg8VARA1MTQg5b2w5YyW5biC5aC0ZAICD2QWAmYPFQETRlMwMDAg6aaZ5rC055m%2B5ZCIIGQCAw9kFgJmDxUBAzE2OGQCBA9kFgJmDxUBAzE2OGQCBQ9kFgJmDxUBAzExM2QCBg9kFgJmDxUBAjc3ZAIHD2QWAmYPFCsCAmQFBTExNy4wZAIID2QWAmYPFCsCAmQFBSAgLSAgZAIJD2QWAmYPFCsCAmQFAjI1ZAIKD2QWAmYPFCsCAmQFBSAgLSAgZAILD2QWAmYPFQEBMGQCFw9kFgJmD2QWAmYPFgIfBgUJbWFpbl9tYWluFhhmD2QWAmYPFQEJMTA2LzA0LzA3ZAIBD2QWAmYPFQEQNzAwIOWPsOWNl%2BW4guWgtGQCAg9kFgJmDxUBE0ZTMDAwIOmmmeawtOeZvuWQiCBkAgMPZBYCZg8VAQI1NGQCBA9kFgJmDxUBAjU0ZAIFD2QWAmYPFQECNDJkAgYPZBYCZg8VAQIzMGQCBw9kFgJmDxQrAgJkBQQ0Mi4wZAIID2QWAmYPFCsCAmQFBSAgLSAgZAIJD2QWAmYPFCsCAmQFAjMyZAIKD2QWAmYPFCsCAmQFBSAgLSAgZAILD2QWAmYPFQEBMGQCGA9kFgJmD2QWAmYPFgIfBgUMbWFpbl9tYWluXzAyFhhmD2QWAmYPFQEJMTA2LzA0LzA3ZAIBD2QWAmYPFQEQMTA1IOWPsOWMl%2BiKseW4gmQCAg9kFgJmDxUBGUZTMDAxIOmmmeawtOeZvuWQiCDllq7mnLVkAgMPZBYCZg8VAQMxODNkAgQPZBYCZg8VAQMxODNkAgUPZBYCZg8VAQMxNzdkAgYPZBYCZg8VAQMxNzJkAgcPZBYCZg8VAgltYWluX2JsdWUFMTc3LjJkAggPZBYCZg8VAgltYWluX2JsdWUFIC0gIDFkAgkPZBYCZg8VAghtYWluX3JlZAIzMmQCCg9kFgJmDxUCCG1haW5fcmVkBSArMTEzZAILD2QWAmYPFQEBMGQCGQ9kFgJmD2QWAmYPFgIfBgUJbWFpbl9tYWluFhhmD2QWAmYPFQEJMTA2LzA0LzA4ZAIBD2QWAmYPFQEQMTA1IOWPsOWMl%2BiKseW4gmQCAg9kFgJmDxUBE0ZTMDAwIOmmmeawtOeZvuWQiCBkAgMPZBYCZg8VAQMxOTBkAgQPZBYCZg8VAQMxOTBkAgUPZBYCZg8VAQMxOTBkAgYPZBYCZg8VAQMxOTBkAgcPZBYCZg8VAgltYWluX2JsdWUFMTkwLjBkAggPZBYCZg8VAgltYWluX2JsdWUFIC0gMzdkAgkPZBYCZg8VAgltYWluX2JsdWUBNmQCCg9kFgJmDxUCCW1haW5fYmx1ZQUgLSAxNGQCCw9kFgJmDxUBATBkAhoPZBYCZg9kFgJmDxYCHwYFDG1haW5fbWFpbl8wMhYYZg9kFgJmDxUBCTEwNi8wNC8wOGQCAQ9kFgJmDxUBEDQwMCDlj7DkuK3luILloLRkAgIPZBYCZg8VARNGUzAwMCDpppnmsLTnmb7lkIggZAIDD2QWAmYPFQECNzJkAgQPZBYCZg8VAQI2OGQCBQ9kFgJmDxUBAjUxZAIGD2QWAmYPFQECMzZkAgcPZBYCZg8VAgltYWluX2JsdWUENTEuMGQCCA9kFgJmDxUCCW1haW5fYmx1ZQUgLSAxOGQCCQ9kFgJmDxUCCG1haW5fcmVkAjg1ZAIKD2QWAmYPFQIIbWFpbl9yZWQFICsgNDRkAgsPZBYCZg8VAQEwZAIbD2QWAmYPZBYCZg8WAh8GBQltYWluX21haW4WGGYPZBYCZg8VAQkxMDYvMDQvMDhkAgEPZBYCZg8VARA1MTQg5b2w5YyW5biC5aC0ZAICD2QWAmYPFQETRlMwMDAg6aaZ5rC055m%2B5ZCIIGQCAw9kFgJmDxUBAzE2MWQCBA9kFgJmDxUBAzE2MWQCBQ9kFgJmDxUBAzEwNmQCBg9kFgJmDxUBAjcyZAIHD2QWAmYPFQIJbWFpbl9ibHVlBTExMS4wZAIID2QWAmYPFQIJbWFpbl9ibHVlBSAtICA1ZAIJD2QWAmYPFQIJbWFpbl9ibHVlAjIzZAIKD2QWAmYPFQIJbWFpbl9ibHVlBSAtICA4ZAILD2QWAmYPFQEBMGQCHA9kFgJmD2QWAmYPFgIfBgUMbWFpbl9tYWluXzAyFhhmD2QWAmYPFQEJMTA2LzA0LzA4ZAIBD2QWAmYPFQEQMTA1IOWPsOWMl%2BiKseW4gmQCAg9kFgJmDxUBGUZTMDAxIOmmmeawtOeZvuWQiCDllq7mnLVkAgMPZBYCZg8VAQMxNzlkAgQPZBYCZg8VAQMxNzlkAgUPZBYCZg8VAQMxNjRkAgYPZBYCZg8VAQMxNTBkAgcPZBYCZg8VAgltYWluX2JsdWUFMTYzLjlkAggPZBYCZg8VAgltYWluX2JsdWUFIC0gIDhkAgkPZBYCZg8VAgltYWluX2JsdWUCMjVkAgoPZBYCZg8VAgltYWluX2JsdWUFIC0gMjJkAgsPZBYCZg8VAQEwZAIdD2QWAmYPZBYCZg8WAh8GBQltYWluX21haW4WGGYPZBYCZg8VAQkxMDYvMDQvMDhkAgEPZBYCZg8VARA0MDAg5Y%2Bw5Lit5biC5aC0ZAICD2QWAmYPFQEZRlMwMDEg6aaZ5rC055m%2B5ZCIIOWWruactWQCAw9kFgJmDxUBAjU5ZAIED2QWAmYPFQECNTlkAgUPZBYCZg8VAQI1OWQCBg9kFgJmDxUBAjU5ZAIHD2QWAmYPFCsCAmQFBDU5LjBkAggPZBYCZg8UKwICZAUFICAtICBkAgkPZBYCZg8UKwICZAUCMTBkAgoPZBYCZg8UKwICZAUFICAtICBkAgsPZBYCZg8VAQEwZAIeD2QWAmYPZBYCZg8WAh8GBQxtYWluX21haW5fMDIWGGYPZBYCZg8VAQkxMDYvMDQvMDlkAgEPZBYCZg8VARA0MDAg5Y%2Bw5Lit5biC5aC0ZAICD2QWAmYPFQETRlMwMDAg6aaZ5rC055m%2B5ZCIIGQCAw9kFgJmDxUBAzEzNWQCBA9kFgJmDxUBAzEzNWQCBQ9kFgJmDxUBAzExN2QCBg9kFgJmDxUBAjY1ZAIHD2QWAmYPFQIIbWFpbl9yZWQFMTEwLjBkAggPZBYCZg8VAghtYWluX3JlZAUgKzExNmQCCQ9kFgJmDxUCCW1haW5fYmx1ZQIzN2QCCg9kFgJmDxUCCW1haW5fYmx1ZQUgLSA1NmQCCw9kFgJmDxUBATBkAh8PZBYCZg9kFgJmDxYCHwYFCW1haW5fbWFpbhYYZg9kFgJmDxUBCTEwNi8wNC8xMGQCAQ9kFgJmDxUBEDEwNSDlj7DljJfoirHluIJkAgIPZBYCZg8VARNGUzAwMCDpppnmsLTnmb7lkIggZAIDD2QWAmYPFQECNTRkAgQPZBYCZg8VAQI1NGQCBQ9kFgJmDxUBAjUyZAIGD2QWAmYPFQECNTBkAgcPZBYCZg8VAgltYWluX2JsdWUENTEuN2QCCA9kFgJmDxUCCW1haW5fYmx1ZQUgLSA3M2QCCQ9kFgJmDxUCCG1haW5fcmVkAjQ0ZAIKD2QWAmYPFQIIbWFpbl9yZWQFICs2MzNkAgsPZBYCZg8VAQEwZAIgD2QWAmYPZBYCZg8WAh8GBQxtYWluX21haW5fMDIWGGYPZBYCZg8VAQkxMDYvMDQvMTBkAgEPZBYCZg8VARA0MDAg5Y%2Bw5Lit5biC5aC0ZAICD2QWAmYPFQETRlMwMDAg6aaZ5rC055m%2B5ZCIIGQCAw9kFgJmDxUBAjQ3ZAIED2QWAmYPFQECNDdkAgUPZBYCZg8VAQI0N2QCBg9kFgJmDxUBAjQ3ZAIHD2QWAmYPFQIJbWFpbl9ibHVlBDQ3LjBkAggPZBYCZg8VAgltYWluX2JsdWUFIC0gNTdkAgkPZBYCZg8VAgltYWluX2JsdWUCMjBkAgoPZBYCZg8VAgltYWluX2JsdWUFIC0gNDZkAgsPZBYCZg8VAQEwZAIhD2QWAmYPZBYCZg8WAh8GBQltYWluX21haW4WGGYPZBYCZg8VAQkxMDYvMDQvMTBkAgEPZBYCZg8VARAxMDUg5Y%2Bw5YyX6Iqx5biCZAICD2QWAmYPFQEZRlMwMDEg6aaZ5rC055m%2B5ZCIIOWWruactWQCAw9kFgJmDxUBAzE0OGQCBA9kFgJmDxUBAzE0OGQCBQ9kFgJmDxUBAzEzMGQCBg9kFgJmDxUBAzExOWQCBw9kFgJmDxUCCW1haW5fYmx1ZQUxMzEuM2QCCA9kFgJmDxUCCW1haW5fYmx1ZQUgLSAyMGQCCQ9kFgJmDxUCCG1haW5fcmVkAjQ5ZAIKD2QWAmYPFQIIbWFpbl9yZWQFICsgOTZkAgsPZBYCZg8VAQEwZAIiD2QWAmYPZBYCZg8WAh8GBQxtYWluX21haW5fMDIWGGYPZBYCZg8VAQkxMDYvMDQvMTFkAgEPZBYCZg8VARAxMDUg5Y%2Bw5YyX6Iqx5biCZAICD2QWAmYPFQETRlMwMDAg6aaZ5rC055m%2B5ZCIIGQCAw9kFgJmDxUBAzIxNmQCBA9kFgJmDxUBAzIxNmQCBQ9kFgJmDxUBAjc1ZAIGD2QWAmYPFQECNTFkAgcPZBYCZg8VAghtYWluX3JlZAUxMDEuMmQCCA9kFgJmDxUCCG1haW5fcmVkBSArIDk2ZAIJD2QWAmYPFQIJbWFpbl9ibHVlAjIzZAIKD2QWAmYPFQIJbWFpbl9ibHVlBSAtIDQ4ZAILD2QWAmYPFQEBMGQCIw9kFgJmD2QWAmYPFgIfBgUJbWFpbl9tYWluFhhmD2QWAmYPFQEJMTA2LzA0LzExZAIBD2QWAmYPFQEQNTE0IOW9sOWMluW4guWgtGQCAg9kFgJmDxUBE0ZTMDAwIOmmmeawtOeZvuWQiCBkAgMPZBYCZg8VAQMxNjRkAgQPZBYCZg8VAQMxNjRkAgUPZBYCZg8VAQMxNjRkAgYPZBYCZg8VAQMxNjRkAgcPZBYCZg8UKwICZAUFMTY0LjBkAggPZBYCZg8UKwICZAUFICAtICBkAgkPZBYCZg8UKwICZAUCMTJkAgoPZBYCZg8UKwICZAUFICAtICBkAgsPZBYCZg8VAQEwZAIkD2QWAmYPZBYCZg8WAh8GBQxtYWluX21haW5fMDIWGGYPZBYCZg8VAQkxMDYvMDQvMTFkAgEPZBYCZg8VARA3MDAg5Y%2Bw5Y2X5biC5aC0ZAICD2QWAmYPFQETRlMwMDAg6aaZ5rC055m%2B5ZCIIGQCAw9kFgJmDxUBAjY1ZAIED2QWAmYPFQECNjVkAgUPZBYCZg8VAQI2NWQCBg9kFgJmDxUBAjY1ZAIHD2QWAmYPFCsCAmQFBDY1LjBkAggPZBYCZg8UKwICZAUFICAtICBkAgkPZBYCZg8UKwICZAUCMTZkAgoPZBYCZg8UKwICZAUFICAtICBkAgsPZBYCZg8VAQEwZAIlD2QWAmYPZBYCZg8WAh8GBQltYWluX21haW4WGGYPZBYCZg8VAQkxMDYvMDQvMTFkAgEPZBYCZg8VARAxMDUg5Y%2Bw5YyX6Iqx5biCZAICD2QWAmYPFQEZRlMwMDEg6aaZ5rC055m%2B5ZCIIOWWruactWQCAw9kFgJmDxUBAzExNWQCBA9kFgJmDxUBAzExNWQCBQ9kFgJmDxUBAzExMmQCBg9kFgJmDxUBAzEwMWQCBw9kFgJmDxUCCW1haW5fYmx1ZQUxMTAuMWQCCA9kFgJmDxUCCW1haW5fYmx1ZQUgLSAxNmQCCQ9kFgJmDxUCCG1haW5fcmVkAjY2ZAIKD2QWAmYPFQIIbWFpbl9yZWQFICsgMzVkAgsPZBYCZg8VAQEwZAImD2QWAmYPZBYCZg8WAh8GBQxtYWluX21haW5fMDIWGGYPZBYCZg8VAQkxMDYvMDQvMTFkAgEPZBYCZg8VARA3MDAg5Y%2Bw5Y2X5biC5aC0ZAICD2QWAmYPFQEZRlMwMDEg6aaZ5rC055m%2B5ZCIIOWWruactWQCAw9kFgJmDxUBAzE1NWQCBA9kFgJmDxUBAzE1NWQCBQ9kFgJmDxUBAjkwZAIGD2QWAmYPFQECNDdkAgcPZBYCZg8UKwICZAUEOTUuMGQCCA9kFgJmDxQrAgJkBQUgIC0gIGQCCQ9kFgJmDxQrAgJkBQIxOGQCCg9kFgJmDxQrAgJkBQUgIC0gIGQCCw9kFgJmDxUBATBkAicPZBYCZg9kFgJmDxYCHwYFCW1haW5fbWFpbhYYZg9kFgJmDxUBCTEwNi8wNC8xMmQCAQ9kFgJmDxUBEDEwNSDlj7DljJfoirHluIJkAgIPZBYCZg8VARNGUzAwMCDpppnmsLTnmb7lkIggZAIDD2QWAmYPFQECNTdkAgQPZBYCZg8VAQI1N2QCBQ9kFgJmDxUBAjU3ZAIGD2QWAmYPFQECNTdkAgcPZBYCZg8VAgltYWluX2JsdWUENTcuMGQCCA9kFgJmDxUCCW1haW5fYmx1ZQUgLSA0NGQCCQ9kFgJmDxUCCW1haW5fYmx1ZQIxM2QCCg9kFgJmDxUCCW1haW5fYmx1ZQUgLSA0M2QCCw9kFgJmDxUBATBkGAEFIWN0bDAwJGNvbnRlbnRQbGFjZUhvbGRlciRsaXN0Vmlldw8UKwAOZGRkZGRkZDwrACEAAiFkZGRmAv%2F%2F%2F%2F8PZNBLw86MGrMEgTSWnwfWnbN1StMRZOtRnd3tj66tSDqj&__VIEWSTATEGENERATOR=EE0FA235&__EVENTVALIDATION=%2FwEdABF2Ynn65yAXFnAsdtKdep%2BMQlnRBSjq2R0LFBhqvIaYOdWbMM2%2FDWJrZzd7rAbCDCMbHYsHDbD1wmtGXihvmsnJpgCj6jXubMjZiX40qlRgEfAZWU2DqbXLbzwJz6%2FcuSyaMlAmweTkw3OcmUUUNjxJpL3ydGK0oh1Pv6F8gb9lYa5CYy4rUIxenj7Zhm14i6yMxy6pj975n4QaOIogWGzgDMVF0nj6IgG1tNwHpPN5RDjS%2F%2BKgYAT38f0WZZ5RivBdrqzFxWSVBFRoqGkBDfMAHMNvjdc8K8khhbdaOmOueDXStC1Dxv7vmWIF8rO0OTM0ZramY6%2B3B3bLbmUTczYqLB6jOMCDSMYK36VECc7%2FYJU8rqQofRfoHyK2KG574Aq%2BOnyFzGNwibkkBOdk8M87";
	        DataOutputStream wr = new DataOutputStream (
	                  connection.getOutputStream ());
		      wr.writeBytes (urlParameters);
		      wr.flush ();
		      wr.close ();
	        //connection.setRequestProperty("AUTH-KEY-PROPERTY-NAME", "yourAuthKey");
	        final ReadableByteChannel rbc = Channels.newChannel(connection.getInputStream());
	        final FileOutputStream fos = new FileOutputStream(output);
	        fos.getChannel().transferFrom(rbc, 0, 1 << 24);
	        fos.close();
	        return true;
	    } catch (final Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	public static void main(String [] args){
		
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
		try {
			
			Date date1=df.parse("20070701");
			Date date2=df.parse("20071231");
			Date date3=df.parse("20170630");
			
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(date1);
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(date2);
			Calendar cal3 = Calendar.getInstance();
			cal3.setTime(date3);
			ConvertDate s;
			while(cal2.getTimeInMillis()<=cal3.getTimeInMillis()){
				s=new ConvertDate(df.format(cal1.getTime()),df.format(cal2.getTime()));
				System.out.println("download file = "+s.getDate()+ "  ......");
				System.out.println(" loading ..........");
				String filename=s.getDate();
				File file=new File("C:\\Users\\Administrator\\Desktop\\file\\"+filename);
				if(file.exists())
					file.delete();
				download(file, "http://amis.afa.gov.tw/flower/FlowerProdDayTransInfo.aspx",s);
				System.out.println("----------------- finished download-------------");
				cal1.add(Calendar.MONTH, +6);
				cal2.add(Calendar.MONTH, +6);
				cal2.set(Calendar.DATE, cal2.getActualMaximum(Calendar.DATE));
			}

			
		
			
			
			//System.out.println(s.getDate());
			//cal1.add(Calendar.MONTH, +6);
			//cal2.add(Calendar.MONTH, +6);
			//s=new ConvertDate(df.format(cal1.getTime()),df.format(cal2.getTime()));
			
			//System.out.println(s.getDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		File file=new File("C:\\Users\\Administrator\\Desktop\\file\\output1.xls");
//		if(file.exists())
//			file.delete();
//		download(file, "http://amis.afa.gov.tw/flower/FlowerProdDayTransInfo.aspx");
	}
	
}
class ConvertDate
{
    String date = "";
    String yearStart="";
    String yearEnd="";
    String month1="";
    String month2="";
    String day1="";
    String day2="";
    public String getDate()
    {
        return date;
    }

    public String getYear1() {
		return yearStart;
	}

	public String getYear2() {
		return yearEnd;
	}

	public String getMonth1() {
		return month1;
	}

	public String getMonth2() {
		return month2;
	}

	public String getDay1() {
		return day1;
	}

	public String getDay2() {
		return day2;
	}

	public ConvertDate(String Sdate,String Edate)
    {
        StringBuilder sb = new StringBuilder();

        if (!Sdate.equals("") && !Edate.equals(""))
        {
            int year1 = 0;
            year1 = Integer.parseInt(Sdate.substring(0, 4)) - 1911;
            int year2 = 0;
            year2 = Integer.parseInt(Edate.substring(0, 4)) - 1911;
            if(year1<100){
            	this.date = "0"+year1 + Sdate.substring(4);
            	this.yearStart="0"+year1 ;
            }else{
            	this.date = year1 + Sdate.substring(4);
            	this.yearStart=year1+"";
            }
            this.date+="-";
            if(year2<100){
            	this.date += "0"+year2 + Edate.substring(4);
            	this.yearEnd="0"+year2;
            }else{
            	this.date += year2 + Edate.substring(4);
            	this.yearEnd=year2+"";
            }
            
            this.month1=Sdate.substring(4, 6);
            this.day1=Sdate.substring(6, 8);
            this.month2=Edate.substring(4, 6);
            this.day2=Edate.substring(6, 8);
            this.date+=".xls";
        }
    }
}