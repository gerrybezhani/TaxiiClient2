import org.mitre.taxii.client.example.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void poll()
    {
        ArrayList<String> tmpAr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("=================POLL=================");
        System.out.println(" The begin timestamp (format:\n" +
                "YYYY-MM-DDTHH:MM:SS.ssssss+/-hh:mm) for the poll\n" +
                " request. Defaults to none.(optional)");
        String btime = sc.nextLine();
        if(!btime.isEmpty())
        {
            tmpAr.add("-begin_timestamp");
            tmpAr.add(btime);
        }

        System.out.println(" The end timestamp (format:\n" +
                "YYYY-MM-DDTHH:MM:SS.ssssss+/-hh:mm) for the poll\n" +
                "request. Defaults to none.(optional)");

        String etime = sc.nextLine();
        if(!etime.isEmpty())
        {
            tmpAr.add("-end_timestamp");
            tmpAr.add(etime);
        }

        System.out.println("Data Collection to poll. Defaults to 'default'.(optional)");

        String collection = sc.nextLine();
        if(!collection.isEmpty())
        {
            tmpAr.add("-collection");
            tmpAr.add(collection);
        }

        System.out.println(" REQUIRED. The URL of the TAXII service provider" +
                "to connect to. (e.g http://taxiitest.mitre.org:80/service/discovery/. (optional)");

        String  url;
        do{
            url = sc.nextLine();
        }while (url.isEmpty() );
        tmpAr.add("-u");
        tmpAr.add(url);

        System.out.println("Username to authenticate with(optional):");
        String uname = sc.nextLine();
        if(!uname.isEmpty())
        {
            tmpAr.add("-username");
            tmpAr.add(uname);
        }


        System.out.println("password to authenticate with(optional):");

        String pass = sc.nextLine();
        if(!pass.isEmpty())
        {
            tmpAr.add("-pass");
            tmpAr.add(pass);
        }
        System.out.println("A proxy to use(optional):");

        String proxy = sc.nextLine();
        if(!proxy.isEmpty())
        {
            tmpAr.add("-proxy");
            tmpAr.add(proxy);
        }

        String[] argsAr = new String[tmpAr.size()];
        for (int i = 0; i < tmpAr.size(); i++) {
            argsAr[i] = tmpAr.get(i);
        }

        PollClient.main(argsAr);

    }

    public static void inbox()
    {
        ArrayList<String> tmpAr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("=================INBOX=================");
        System.out.println(" Content binding of the Content\n" +
                "Block to send. Defaults to\n" +
                "urn:stix.mitre.org:xml:1.1.1'");

        String cbind = sc.nextLine();
        if(!cbind.isEmpty())
        {
            tmpAr.add("-content_binding");
            tmpAr.add(cbind);
        }

        System.out.println("The subtype of the Content Binding.Defaults to none");
        String subtype = sc.nextLine();
        if(!subtype.isEmpty())
        {
            tmpAr.add("-subtype");
            tmpAr.add(subtype);
        }
        System.out.println("REQUIRED. File containing the\n" +
                "content of the Content Block to send.");

        String  file;
        do{
            file = sc.nextLine();
        }while (file.isEmpty() );
        tmpAr.add("-content_file");
        tmpAr.add(file);


        System.out.println(" The Destination Collection Name for\n" +
                "this Inbox Message. Defaults to\n" +
                "none.(optional)");
        String dcn = sc.nextLine();
        if(!dcn.isEmpty())
        {
            tmpAr.add("-dcn");
            tmpAr.add(dcn);
        }

        System.out.println(" REQUIRED. The URL of the TAXII service provider" +
                "to connect to. (e.g http://taxiitest.mitre.org:80/service/discovery/. (optional)");
        String  url;
        do{
            url = sc.nextLine();
        }while (url.isEmpty() );
        tmpAr.add("-u");
        tmpAr.add(url);

        System.out.println("Username to authenticate with(optional):");
        String uname = sc.nextLine();
        if(!uname.isEmpty())
        {
            tmpAr.add("-username");
            tmpAr.add(uname);
        }


        System.out.println("password to authenticate with(optional):");

        String pass = sc.nextLine();
        if(!pass.isEmpty())
        {
            tmpAr.add("-pass");
            tmpAr.add(pass);
        }
        System.out.println("A proxy to use(optional):");

        String proxy = sc.nextLine();
        if(!proxy.isEmpty())
        {
            tmpAr.add("-proxy");
            tmpAr.add(proxy);
        }

        String[] argsAr = new String[tmpAr.size()];
        for (int i = 0; i < tmpAr.size(); i++) {
            argsAr[i] = tmpAr.get(i);
        }

        InboxClient.main(argsAr);




    }

    //method for feedinfo,discovery,collectionifno
    public static void other(String method)
    {
        ArrayList<String> tmpAr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("=================DISCOVER=================");
        System.out.println(" REQUIRED. The URL of the TAXII service provider" +
                "to connect to. (e.g http://taxiitest.mitre.org:80/service/discovery/. (optional)");
        String  url;
        do{
            url = sc.nextLine();
        }while (url.isEmpty() );
        tmpAr.add("-u");
        tmpAr.add(url);

        System.out.println("Username to authenticate with(optional):");
        String uname = sc.nextLine();
        if(!uname.isEmpty())
        {
            tmpAr.add("-username");
            tmpAr.add(uname);
        }


        System.out.println("password to authenticate with(optional):");

        String pass = sc.nextLine();
        if(!pass.isEmpty())
        {
            tmpAr.add("-pass");
            tmpAr.add(pass);
        }
        System.out.println("A proxy to use(optional):");

        String proxy = sc.nextLine();
        if(!proxy.isEmpty())
        {
            tmpAr.add("-proxy");
            tmpAr.add(proxy);
        }

        String[] argsAr = new String[tmpAr.size()];
        for (int i = 0; i < tmpAr.size(); i++) {
            argsAr[i] = tmpAr.get(i);
        }


        if(method.equals("DISCOVER"))
        {
            DiscoveryClient.main(argsAr);
        }
        else if(method.equals("COLLECTION INFO"))
        {
            CollectionInformationClient.main(argsAr);
        }
        else if(method.equals("FEED INFO"))
        {
            FeedInformationClient10.main(argsAr);
        }
    }

    public static void fullfilment()
    {
        ArrayList<String> tmpAr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("=================DISCOVER=================");
        System.out.println("Data Collection that this Fulfillment request\n" +
                "applies to. Defaults to 'default'.");
        String dcn = sc.nextLine();
        if(!dcn.isEmpty())
        {
            tmpAr.add("-collection");
            tmpAr.add(dcn);
        }

        System.out.println("The result_id being requested.");
        String rid = sc.nextLine();
        if(!rid.isEmpty())
        {
            tmpAr.add("-result_id");
            tmpAr.add(rid);
        }
        System.out.println("The part number being requested. Defaults to '1'.");
        String pnumber = sc.nextLine();

        if(!pnumber.isEmpty())
        {
            tmpAr.add("-result_part_number");
            tmpAr.add(pnumber);
        }
        System.out.println(" REQUIRED. The URL of the TAXII service provider" +
                "to connect to. (e.g http://taxiitest.mitre.org:80/service/discovery/. (optional)");
        String  url;
        do{
            url = sc.nextLine();
        }while (url.isEmpty() );
        tmpAr.add("-u");
        tmpAr.add(url);

        System.out.println("Username to authenticate with(optional):");
        String uname = sc.nextLine();
        if(!uname.isEmpty())
        {
            tmpAr.add("-username");
            tmpAr.add(uname);
        }


        System.out.println("password to authenticate with(optional):");

        String pass = sc.nextLine();
        if(!pass.isEmpty())
        {
            tmpAr.add("-pass");
            tmpAr.add(pass);
        }
        System.out.println("A proxy to use(optional):");

        String proxy = sc.nextLine();
        if(!proxy.isEmpty())
        {
            tmpAr.add("-proxy");
            tmpAr.add(proxy);
        }

        String[] argsAr = new String[tmpAr.size()];
        for (int i = 0; i < tmpAr.size(); i++) {
            argsAr[i] = tmpAr.get(i);
        }

        FulfillmentClient.main(argsAr);
    }

    public static void help()
    {
        //help to be completed
    }





    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("=================TAXII CLIENT=================");
        System.out.println("1.POLL \n2.INBOX \n3.DISCOVER \n4.COLLECTION INFO \n" +
                "5.FEED INFO \n6.FULLFILMENT \n7.HELP");

        int choice = sc.nextInt();

        switch (choice){
            case 1:
                poll();
                break;
            case 2:
                inbox();
                break;
            case 3:
                other("DISCOVER");
                break;
            case 4:
                other("COLLECTION INFO");
                break;
            case 5:
                other("FEED INFO");
                break;
            case 6:
                fullfilment();
            case 7:
                help();
                break;
            default:
                System.out.println("Wrong choice !!");
        }




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
