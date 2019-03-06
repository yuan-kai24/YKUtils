package yk.fileutil;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jdom.input.SAXBuilder;

/**
 * XML各种解析转换封装
 * @author YK
 */
public class XMLAnalysisUtils {

    //解析流
    public static String getElementValue(InputStream in, String key){
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(in);
        }catch (Exception e){
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        List<Element> childElements = root.elements();
        for (Element e :
                childElements) {
            System.out.println(e.getName() + ":" + e.getStringValue());
            if(key != null && key.equals(e.getName())){
                return e.getStringValue();
            }
        }
        return null;
    }

    // 返回全部信息
    public static Map<String, String> getElementValue(InputStream in){
        Map<String, String> map = new HashMap<>();
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(in);
        }catch (Exception e){
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        List<Element> childElements = root.elements();
        for (Element e :
                childElements) {
            System.out.println(e.getName() + ":" + e.getStringValue());
            map.put(e.getName(), e.getStringValue());
        }
        return map;
    }

//    传入xml字符串，转换为map
    public static Map<String, Object> xmlToMap(String xml) {
        Map<String, Object> map = new HashMap<>();
        Element root;
        try {
            Document doc = DocumentHelper.parseText(xml);
            root = doc.getRootElement();
            Iterator it = root.elementIterator();
            while (it.hasNext()) {
                Element e = (Element) it.next();
                map.put(e.getName(), e.getTextTrim());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return map;

    }

}
