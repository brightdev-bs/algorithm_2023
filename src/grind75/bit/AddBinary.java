package grind75.bit;

public class AddBinary {

    public String addBinary(String a, String b) {
        int aIdx = a.length() - 1;
        int bIdx = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(aIdx >= 0 || bIdx >= 0 || carry > 0) {
            if(aIdx >= 0) carry += a.charAt(aIdx--) - '0';
            if(bIdx >= 0) carry += b.charAt(bIdx--) - '0';

            sb.append(carry % 2);
            carry /= 2;
        }

        return sb.reverse().toString();

    }
}
