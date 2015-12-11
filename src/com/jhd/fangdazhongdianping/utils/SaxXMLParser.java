package com.jhd.fangdazhongdianping.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

import com.jhd.fangdazhongdianping.pro.City;


public class SaxXMLParser {  //xml½âÎöÆ÷
	
	
	List<City> list;

	
	public List<City> getListBySaxXMLParser( InputStream in) throws ParserConfigurationException, SAXException, IOException
	{
		SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		
		MyHandler myHandler=new MyHandler();
		
		saxParser.parse(in, myHandler);
		
		return list;
		
	}
	public class MyHandler extends DefaultHandler
	{
		
		StringBuilder sb;
		City c;
		@Override
		public void startDocument() throws SAXException {
			// TODO Auto-generated method stub
			//super.startDocument();
			
			list=new ArrayList<City>();
			sb=	new StringBuilder();
		}
		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			// TODO Auto-generated method stub
			//super.startElement(uri, localName, qName, attributes);
			if(localName.equals("City"))
			{
				c=new City();
			}
			sb.setLength(0);
		}
		@Override
		public void endDocument() throws SAXException {
			// TODO Auto-generated method stub
			super.endDocument();
		}
		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			// TODO Auto-generated method stub
			//super.endElement(uri, localName, qName);
			if (localName.equals("id")) {
				c.setId(Integer.parseInt(sb.toString()));
				Log.e("jhd", ""+c.getId());
			}
			else if(localName.equals("name"))
			{
				c.setName(sb.toString());
				Log.e("jhd", c.getName());
			}
			else if(localName.equals("sortKey"))
			{
				c.setSortKey(sb.toString());
				Log.e("jhd", ""+c.getSortKey());
				
			}
			else if(localName.equals("City"))
			{
				list.add(c);
				Log.e("jhd", c.toString());
			}
		}
		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			// TODO Auto-generated method stub
			//super.characters(ch, start, length);
			sb.append(ch, start, length);
		}
	}
}
