import java.io.*;

class AccessArrayApp {
    public static boolean stringCompare(String word, String word2) {
        if (word.equals(word2)) {
            return true;
        }
        return false;
    }

    public static void printStudent(String studentID) throws Exception
    {
        // reading the file and keeping an buffer
        FileReader read = new FileReader("../data/oklist.txt");
        BufferedReader buff = new BufferedReader(read);

        // line to store each array item as one string
        String line;
        String[][] listArray = new String[5000][2];

        // checker to store the name qand surname if its there
        String isThere="";
        Boolean checked;
        int i = 0;
        while ((line = buff.readLine()) != null)
        {
            for (int j = 0; j < listArray[i].length; j++)
            {
                listArray[i][j] = line;
            }

            // compare arg to words in the list
            String firstWord;
            String[] wordChecker = line.split(" ", 0);
            firstWord = wordChecker[0];

            if (stringCompare(studentID, firstWord)) {

                // print full name if found
                isThere = wordChecker[1] + " " + wordChecker[2];
                checked = true;
                break;
                //System.out.println(isThere);
            }
            else
            {
                checked = false;
                isThere = "Access Denied";
                //System.out.println("Access denied");
            }

            i++;
        }
        System.out.println(isThere);

        /*if (checked = true)
        {
            System.out.println(isThere);
        }
        else if (checked = false)
        {
            //System.out.println(isThere);
            System.out.println("Access denied");
        }*/
        System.exit(0);
        read.close();
    }

    public static void printAllStudents ()throws Exception
    {
        FileReader read = new FileReader("../data/oklist.txt");
        BufferedReader buff = new BufferedReader(read);

        // line to store each array item as one string
        String line;
        String[][] listArray = new String[5000][2];
        int i = 0;
        while ((line = buff.readLine()) != null)
        {
            for (int j = 0; j < listArray[i].length; j++) {
                listArray[i][j] = line;
            }
            // printing out everything
            System.out.println(line);
            i++;
        }
        System.exit(0);
        read.close();

    }



    public static void main(String[] args) throws Exception
    {

        if (args.length == 0)
        {
            // printing out all students
            printAllStudents ();
        }
        else
        {
            //printing out the name of one student or access denied
            String word = args[0];
            printStudent(word);
        }
    }
}


