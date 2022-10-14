/* 
import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    int num = 0;

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("Number: %d", num);
        } else if (url.getPath().equals("/increment")) {
            num += 1;
            return String.format("Number incremented!");
        } else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("count")) {
                    num += Integer.parseInt(parameters[1]);
                    return String.format("Number increased by %s! It's now %d", parameters[1], num);
                }
            }
            return "404 Not Found!";
        }
    }
}

class NumberServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
 */


import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
//import java.util.Arrays;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    int input = 0;
    //String inputString = new String; 
    ArrayList<String> arrayList = new ArrayList<>(); 

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("Output: %d", input);
        } else {
            System.out.println("Path: " + url.getPath());

            if (url.getPath().contains("/add"))
            {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s"))
                {
                    arrayList.add(parameters[1]);
                    return String.format("Input added by %s! It's now %s", parameters[1], arrayList.toString());
                }



                if (url.getPath().contains("/search"))
                {
                
                    String[] parameter = url.getQuery().split("=");
                    if (parameter[0].equals("s"))
                    {
                        //ArrayList<String> arrayC = new ArrayList<>();

                        if (arrayList.contains(parameter[1]))
                        {
                            //String s = new String(parameters[0]);

                            //return String.format("Input added by %s! It's now %s", parameters[1], arrayList.toString());
                            //return Arrays.stream(parameters).anyMatch(ArrayList::contains);
                            for (String element: arrayList)
                            {
                                if(element.contains(parameter[1]))
                                {
                                    System.out.println(element);
                                }
                            }
                        }
                        arrayList.add(parameter[1]);
                        //return String.format(arrayList.contains(parameters[0]);
                    }
            }
        }
            
            return "404 Not Found!";
        }
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
