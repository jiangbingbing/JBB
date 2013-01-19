package douban.pro;
/*
 * ���ݴ���
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import douban.myclass.Book;
public class AnalysisData {
	public String getApiData(String api_url) throws IOException{//��api��ȡ����
		URL url=new URL(api_url);
		HttpURLConnection url_conn=(HttpURLConnection)url.openConnection();
		url_conn.connect();
		BufferedReader in=new BufferedReader(new InputStreamReader(url_conn.getInputStream(),"utf-8"));
		String line=null;
		StringBuffer sb=new StringBuffer();
		while((line=in.readLine())!=null){
				sb.append(line);
		}
		in.close();
		url_conn.disconnect();
		return sb.toString();
	}
	public Book GetBookInfo(String json_str) throws JSONException{//������ȡ��������
		Book bookInfo=new Book();
		JSONObject jsonObject=new JSONObject(json_str);
		bookInfo.setAuthor(jsonObject.get("author").toString());
		bookInfo.setId(jsonObject.get("id").toString());
		bookInfo.setImage(jsonObject.get("image").toString());
		bookInfo.setIsbn10(jsonObject.get("isbn10").toString());
		bookInfo.setIsbn13(jsonObject.get("isbn13").toString());
		bookInfo.setPages(jsonObject.get("pages").toString());
		bookInfo.setPrice(jsonObject.get("price").toString());
		bookInfo.setPublisher(jsonObject.get("publisher").toString());
		bookInfo.setSummary(jsonObject.get("summary").toString());
		bookInfo.setTitle(jsonObject.get("title").toString());
		return bookInfo;
	}
}
