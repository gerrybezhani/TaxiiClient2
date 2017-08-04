package main.java;
import org.w3c.dom.Document;

import javax.xml.namespace.NamespaceContext;
import java.util.Iterator;

/**
 * Created by gerry on 8/2/2017.
 * the purpose of this class is to resolve the namespace "stix" in the xml document
 */
public class NamespaceResolver implements NamespaceContext {

    private Document sourceDocument;

    public NamespaceResolver(Document document) {
        sourceDocument = document;
    }

    @Override
    public String getNamespaceURI(String prefix) {
        if (prefix.equals("stix")) {
            return "http://stix.mitre.org/stix-1";
        } else {
            return sourceDocument.lookupNamespaceURI(prefix);
        }
    }

    @Override
    public String getPrefix(String namespaceURI) {
        return sourceDocument.lookupPrefix(namespaceURI);
    }

    @Override

    public Iterator getPrefixes(String namespaceURI) {
        return null;
    }
}
