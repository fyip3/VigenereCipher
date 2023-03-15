import java.util.ArrayList;
import java.util.Locale;

import static java.lang.Math.abs;

public class VigenereCipher {
    String key;
    String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    ArrayList<Integer> a = new ArrayList<>();

    public VigenereCipher (String key) {
        this.key = key.toLowerCase();
        for (int i = 0; i < key.length(); i++) {
            for (int j = 0; j < alphabet.length(); j++) {
                if (alphabet.charAt(j) == key.charAt(i)) {
                    a.add(i,j);
                }

            }
        }
    }
    public String encode(String str) {
        str = str.toLowerCase();
        String text = "";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(alphabet.contains(String.valueOf(str.charAt(i)))) {
                if(i>(a.size()-1)) {
                    int b = i/a.size();
                    count-=a.size();
                    text += alphabet.charAt((alphabet.indexOf(str.substring(i, i + 1)) + a.get(i-(a.size()*b)))%26);
                    count++;
                }
                else {
                        text += alphabet.charAt((alphabet.indexOf(str.substring(i, i + 1)) + a.get(i))%26);
                        count++;
                    }
            }
            else {
                text+= str.charAt(i);
                count+=2;
            }
        }

        return text.toLowerCase(Locale.ROOT);
    }

    public String decode(String str) {
        str = str.toLowerCase();
        String text = "";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(alphabet.contains(String.valueOf(str.charAt(i)))) {
                if(i>(a.size()-1)) {
                    int b = i/a.size();
                    count-=a.size();
                    text += alphabet.charAt((alphabet.indexOf(str.substring(i, i + 1)) - a.get(i-(a.size()*b))+26)%26);
                    count++;
                }
                else {
                    text += alphabet.charAt((alphabet.indexOf(str.substring(i, i + 1)) - a.get(i)+26)%26);
                    count++;
                }
            }
            else {
                text+= str.charAt(i);
                count+=2;
            }
        }

        return text.toLowerCase(Locale.ROOT);
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }



}