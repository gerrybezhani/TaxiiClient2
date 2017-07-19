
public class Main {

    public static void poll()
    {
        System.out.println("=================POLL=================");
        System.out.println(" The begin timestamp (format:\n" +
                "YYYY-MM-DDTHH:MM:SS.ssssss+/-hh:mm) for the poll\n" +
                " request. Defaults to none.(optional)");
        System.out.println(" Data Collection to poll. Defaults to 'default'.(optional)");
        System.out.println();


    }

    public static void main(String[] args) {

        System.out.println("=================TAXII CLIENT=================");
        System.out.println("1.POLL \n2.INBOX \n3.DISCOVER \n4.COLLECTION INFO \n" +
                "5.FEED INFO \n6.FULLFILMENT \n7.HELP");

        String[] table = new String[6];
        table[0] = "-content_file";
        table[1] = "content.xml";
        table[2] = "-dcn";
        table[3] =  "collection-C";
        table[4] = "-u";
        table[5] = "http://83.212.99.255:9000/services/inbox-a";
       // InboxClient.main(table);
    }
}
