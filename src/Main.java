import java.util.Scanner;

public class Main {

    public static void poll()
    {
        System.out.println("=================POLL=================");
        System.out.println(" The begin timestamp (format:\n" +
                "YYYY-MM-DDTHH:MM:SS.ssssss+/-hh:mm) for the poll\n" +
                " request. Defaults to none.(optional)");
        System.out.println(" The end timestamp (format:\n" +
                "YYYY-MM-DDTHH:MM:SS.ssssss+/-hh:mm) for the poll\n" +
                "request. Defaults to none.(optional)");
        System.out.println("Data Collection to poll. Defaults to 'default'.(optional)");
        System.out.println(" REQUIRED. The URL of the TAXII service provider" +
                "to connect to. (e.g http://taxiitest.mitre.org:80/service/discovery/. (optional)");
        System.out.println("Username to authenticate with(optional):");
        System.out.println("password to authenticate with(optional):");
        System.out.println("A proxy to use(optional):");


    }

    public static void inbox()
    {
        System.out.println("=================INBOX=================");
        System.out.println(" Content binding of the Content\n" +
                "Block to send. Defaults to\n" +
                "urn:stix.mitre.org:xml:1.1.1'");
        System.out.println("The subtype of the Content Binding.Defaults to none");
        System.out.println("REQUIRED. File containing the\n" +
                "content of the Content Block to send.");
        System.out.println(" The Destination Collection Name for\n" +
                "this Inbox Message. Defaults to\n" +
                "none.(optional)");
        System.out.println(" REQUIRED. The URL of the TAXII service provider" +
                "to connect to. (e.g http://taxiitest.mitre.org:80/service/discovery/. (optional)");
        System.out.println("Username to authenticate with(optional):");
        System.out.println("password to authenticate with(optional):");
        System.out.println("A proxy to use(optional):");


    }

    //method for feeinfo,discovery,collectionifno
    public static void other()
    {
        System.out.println("=================DISCOVER=================");
        System.out.println(" REQUIRED. The URL of the TAXII service provider" +
                "to connect to. (e.g http://taxiitest.mitre.org:80/service/discovery/. (optional)");
        System.out.println("Username to authenticate with(optional):");
        System.out.println("password to authenticate with(optional):");
        System.out.println("A proxy to use(optional):");
    }

    public static void fullfilment()
    {
        System.out.println("=================DISCOVER=================");
        System.out.println("Data Collection that this Fulfillment request\n" +
                "applies to. Defaults to 'default'.");
        System.out.println("The result_id being requested.");
        System.out.println("The part number being requested. Defaults to '1'.");
        System.out.println(" REQUIRED. The URL of the TAXII service provider" +
                "to connect to. (e.g http://taxiitest.mitre.org:80/service/discovery/. (optional)");
        System.out.println("Username to authenticate with(optional):");
        System.out.println("password to authenticate with(optional):");
        System.out.println("A proxy to use(optional):");
    }





    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("=================TAXII CLIENT=================");
        System.out.println("1.POLL \n2.INBOX \n3.DISCOVER \n4.COLLECTION INFO \n" +
                "5.FEED INFO \n6.FULLFILMENT \n7.HELP");



        /*
        String[] table = new String[6];
        table[0] = "-content_file";
        table[1] = "content.xml";
        table[2] = "-dcn";
        table[3] =  "collection-C";
        table[4] = "-u";
        table[5] = "http://83.212.99.255:9000/services/inbox-a";
       // InboxClient.main(table);
       */
    }
}
