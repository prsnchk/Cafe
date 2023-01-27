package service;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomParserService {

    public void start(){
        try {
            File inputFile = new File("src/main/resources/order_delivery.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("order_delivery");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("id: "
                            + eElement.getAttribute("id"));
                    System.out.println("Price : "
                            + eElement
                            .getElementsByTagName("price")
                            .item(0)
                            .getTextContent());
                }
            }

            NodeList nList1 = doc.getElementsByTagName("customer");
            for (int temp = 0; temp < nList1.getLength(); temp++) {
                Node nNode = nList1.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Customer id: "
                            + eElement.getAttribute("id"));
                    System.out.println("First Name : "
                            + eElement
                            .getElementsByTagName("first_name")
                            .item(0)
                            .getTextContent());
                    System.out.println("Second Name : "
                            + eElement
                            .getElementsByTagName("second_name")
                            .item(0)
                            .getTextContent());
                    System.out.println("Phone : "
                            + eElement
                            .getElementsByTagName("phone")
                            .item(0)
                            .getTextContent());
                    System.out.println("Mail : "
                            + eElement
                            .getElementsByTagName("email")
                            .item(0)
                            .getTextContent());
                }
            }

            NodeList nList2 = doc.getElementsByTagName("courier");
            for (int temp = 0; temp < nList2.getLength(); temp++) {
                Node nNode = nList2.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Courier id: "
                            + eElement.getAttribute("id"));
                    System.out.println("First Name : "
                            + eElement
                            .getElementsByTagName("first_name")
                            .item(0)
                            .getTextContent());
                    System.out.println("Second Name : "
                            + eElement
                            .getElementsByTagName("last_name")
                            .item(0)
                            .getTextContent());
                }
            }

            NodeList nList3 = doc.getElementsByTagName("cafe");
            for (int temp = 0; temp < nList3.getLength(); temp++) {
                Node nNode = nList3.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Cafe id: "
                            + eElement.getAttribute("id"));
                    System.out.println("Cafe Name : "
                            + eElement
                            .getElementsByTagName("cafe_name")
                            .item(0)
                            .getTextContent());
                }
            }

            NodeList nList4 = doc.getElementsByTagName("delivery_provider");
            for (int temp = 0; temp < nList4.getLength(); temp++) {
                Node nNode = nList4.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Delivery_provider id: "
                            + eElement.getAttribute("id"));
                    System.out.println("Delivery provider name : "
                            + eElement
                            .getElementsByTagName("provider_name")
                            .item(0)
                            .getTextContent());
                }
            }

            NodeList nList5 = doc.getElementsByTagName("payment_type");
            for (int temp = 0; temp < nList5.getLength(); temp++) {
                Node nNode = nList5.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Payment type id: "
                            + eElement.getAttribute("id"));
                    System.out.println("Payment type : "
                            + eElement
                            .getElementsByTagName("name")
                            .item(0)
                            .getTextContent());
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
