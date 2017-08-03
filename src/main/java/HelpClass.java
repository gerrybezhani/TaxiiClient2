package main.java;
import net.sf.saxon.om.NamespaceResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;
import java.io.*;

/**
 * Created by gerry on 8/2/2017.
 */
public class HelpClass {

    public static void saveToSeperateFiles(String fileName,String path) {
        try {
            FileInputStream file = new FileInputStream(new File(fileName));

            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            builderFactory.setNamespaceAware(true);

            DocumentBuilder builder = builderFactory.newDocumentBuilder();


            Document xmlDocument = builder.parse(file);

            //printDocument(xmlDocument,System.out);

            XPath xPath = XPathFactory.newInstance().newXPath();
            xPath.setNamespaceContext(new main.java.NamespaceResolver(xmlDocument));

            String expression = "/ns2:Poll_Response/ns2:Content_Block/ns2:Content/stix:STIX_Package";
            String expression2 = "/*//stix:STIX_Package";
            System.out.println(expression2);
            XPathExpression expr =  xPath.compile(expression2);


            NodeList stixCont = (NodeList) expr.evaluate(xmlDocument, XPathConstants.NODESET);

            for (int i = 0; i < stixCont.getLength() ; i++) {
                String content  = nodeToString(stixCont.item(i));
                String id = getID(content);
                String[] id2 = id.split(":");
                PrintWriter out = new PrintWriter(path+"/"+id2[1]+".xml");
                out.println(content);
                out.close();
            }


        } catch (SAXException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }

    public static void printDocument(Document doc, OutputStream out) throws IOException, TransformerException {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        transformer.transform(new DOMSource(doc),
                new StreamResult(new OutputStreamWriter(out, "UTF-8")));
    }

    private static String nodeToString(Node node)
            throws TransformerException
    {
        StringWriter buf = new StringWriter();
        Transformer xform = TransformerFactory.newInstance().newTransformer();
        xform.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        xform.transform(new DOMSource(node), new StreamResult(buf));
        return(buf.toString());
    }

    private static String getID(String content)
    {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        builderFactory.setNamespaceAware(true);

        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(new InputSource(new StringReader(content)));

            //printDocument(xmlDocument,System.out);

            XPath xPath = XPathFactory.newInstance().newXPath();
            xPath.setNamespaceContext(new main.java.NamespaceResolver(xmlDocument));

            String expression2 = "/stix:STIX_Package/@id";
            System.out.println(expression2);
            XPathExpression expr =  xPath.compile(expression2);


            String  id = (String) expr.evaluate(xmlDocument, XPathConstants.STRING);

            return id;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return null;
    }
}
