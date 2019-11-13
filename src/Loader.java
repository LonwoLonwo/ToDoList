import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Loader {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> todoList = new ArrayList<>();

        while(true) {
            String str = reader.readLine();
            if(str.equals("EXIT")){
                break;
            }
            if (str.contains(" ")) {
                String firstWord = str.substring(0, str.indexOf(" "));
                String withoutFirstWord = str.substring(str.indexOf(" ")).trim();
                if (firstWord.equals("ADD")) {
                    if(withoutFirstWord.contains(" ")) {
                        String secondWord = withoutFirstWord.substring(0, withoutFirstWord.indexOf(" "));
                        try {
                            int indexArray = Integer.parseInt(secondWord);
                            String deal = withoutFirstWord.substring(withoutFirstWord.lastIndexOf(secondWord) + 1).trim();
                            if (indexArray < todoList.size()) {
                                todoList.add(indexArray, deal);
                            } else {
                                todoList.add(deal);
                            }
                        } catch (NumberFormatException e) {
                            todoList.add(withoutFirstWord);
                        }
                    }
                    else{
                        todoList.add(withoutFirstWord);
                    }
                }
                else if(firstWord.equals("EDIT")){
                    String secondWord = withoutFirstWord.substring(0, withoutFirstWord.indexOf(" "));
                    try{
                        int indexArray = Integer.parseInt(secondWord);
                        String deal = withoutFirstWord.substring(withoutFirstWord.lastIndexOf(secondWord) + 1).trim();
                        if (indexArray < todoList.size()) {
                            todoList.set(indexArray, deal);
                        } else {
                            System.out.println("Number of List is incorrect");
                        }
                    }
                    catch(NumberFormatException e){
                        System.out.println("Add correct number");
                    }
                }
                else if(firstWord.equals("DELETE")){
                    try{
                        int indexArray = Integer.parseInt(withoutFirstWord);
                        if (indexArray < todoList.size()) {
                            todoList.remove(indexArray);
                        } else {
                            System.out.println("Number of List is incorrect");
                        }
                    }
                    catch(NumberFormatException e){
                        System.out.println("Add correct number");
                    }
                }
            }
            else if(str.equals("LIST")){
                for(int i = 0; i < todoList.size(); i++){
                    System.out.println(i + " " + todoList.get(i));
                }
            }
        }
        reader.close();
    }
}
