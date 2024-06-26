package lab2;

public class IntegerArray implements Comparable<Object> {
    
    public int[] digits;
    private boolean negative = false; 

    public IntegerArray(String number) {
        if (number.charAt(0) == '-'){
            this.negative = true;
            number = number.substring(1);
            }
        if (number.charAt(0) == '0') {
            int startIndex = 0;
            for (int j = 0; j < number.length(); j++) {
                if (number.charAt(j) != '0'){
                    startIndex = j;
                    break;
                }
            }
            number = number.substring(startIndex); // taking out '0's
        }
        int length = number.length();
    
        digits = new int[length]; 
        for (int i = 0; i < digits.length; i++) {
            digits[i] = Integer.parseInt(number.substring(i, i+1));
        }
    }

    public int numberOfDigits() {
        return digits.length;
    }

    public int MID() {
        return digits[0];
    }

    public int LID() {
        return digits[digits.length-1];
    }

    public boolean getNegative() {
        return negative;
    }

    public int getDigit(int index) {
        int[] tmp = new int[digits.length];
        int reverse_index = 0;
        for (int i = tmp.length-1; i >= 0; i--) {
            tmp[i] = digits[reverse_index];
            reverse_index++;
        }
        return tmp[index];
    }

    public IntegerArray add(IntegerArray other) {
        IntegerArray tmp;
        int length;
        int this_length = this.numberOfDigits();
        int other_length = other.numberOfDigits();
        boolean splitter;
        boolean new_digit;

        

        if (this.negative && !other.negative) {
            IntegerArray temp_arr = copyIntArr(this);
            temp_arr.negative = false;
            return other.substract(temp_arr);
        }
        else if (!this.negative && other.negative) {
            IntegerArray temp_arr = copyIntArr(other);
            temp_arr.negative = false;
            return this.substract(temp_arr);
        }

        else {
            if (this_length >= other_length){
                length = this_length;
                splitter = true;
            }    
            else {
                length = other_length;
                splitter = false;
            }

            if (this.digits[0] + other.digits[0] >= 10){
                tmp = new IntegerArray("0".repeat(length+1));
                new_digit = true; 
            }    
            else {
                tmp = new IntegerArray("0".repeat(length)); 
                new_digit = false;
            }

            if (other.negative && this.negative)
                tmp.negative = true;

            for (int i = length-1; i >= 0; i--) {
                if (new_digit) {
                    if (splitter && other_length > 0) 
                        tmp.digits[i+1] = this.digits[--this_length] + other.digits[--other_length];

                    else if (!splitter && this_length > 0) 
                        tmp.digits[i+1] = this.digits[--this_length] + other.digits[--other_length];

                    else if (splitter && other_length == 0 && this_length != 0)
                        tmp.digits[i+1] = this.digits[--this_length];

                    else if (!splitter && this_length == 0 && other_length != 0)    
                        tmp.digits[i+1] = other.digits[--other_length];
                    else 
                        break;
                }
                else {
                    if (splitter && other_length > 0) 
                        tmp.digits[i] = this.digits[--this_length] + other.digits[--other_length];

                    else if (!splitter && this_length > 0) 
                        tmp.digits[i] = this.digits[--this_length] + other.digits[--other_length];

                    else if (splitter && other_length == 0 && this_length != 0)
                        tmp.digits[i] = this.digits[--this_length];

                    else if (!splitter && this_length == 0 && other_length != 0)    
                        tmp.digits[i] = other.digits[--other_length];
                    else 
                        break;
                }
            }

            

            for (int i = tmp.digits.length-1; i > 0 ; i--) {
                if (tmp.digits[i] >= 10) {
                    tmp.digits[i-1] += 1;
                    tmp.digits[i] %= 10;
            
                }
            }

            if (tmp.digits[0] != 0){
                if (tmp.digits[0] >= 10) {
                    IntegerArray tmp2 = new IntegerArray("0".repeat(tmp.digits.length + 1));
                    if (other.negative && this.negative)
                        tmp2.negative = true;
                    tmp2.digits[0] = 1;
                    tmp2.digits[1] = tmp.digits[0] % 10;
                    for (int i = 2; i < tmp2.digits.length; i++) {
                        tmp2.digits[i] = tmp.digits[i-1];  
                    }
                    return tmp2;
                }
                return tmp;
            }
            else {
                IntegerArray tmp2 = new IntegerArray("0".repeat(tmp.digits.length - 1));
                if (other.negative && this.negative)
                        tmp2.negative = true;
                for (int i = 0; i < tmp2.digits.length; i++) {
                    tmp2.digits[i] = tmp.digits[i+1];
                }
                return tmp2;
            }
        }
        
    }

    public IntegerArray substract(IntegerArray other) {
        IntegerArray tmp;
        int length;
        int this_length = this.numberOfDigits();
        int other_length = other.numberOfDigits();
        boolean negativity;

        

        if (this.equals(other)) {
            return new IntegerArray("0");
        }

        if (this_length > other_length){
            length = this_length;
        }    
        else {
            length = other_length;
        }

        tmp = new IntegerArray("0".repeat(length));

        if (this.negative && !other.negative) {
            negativity = true;
            IntegerArray temp_arr = copyIntArr(this);
            temp_arr.negative = false;
            IntegerArray x = other.add(temp_arr);
            x.negative = true;
            return x;
        }

        else if (!this.negative && other.negative) {
            negativity = false;
            IntegerArray temp_arr = copyIntArr(other);
            temp_arr.negative = false;
            return this.add(temp_arr);
        }
        
        else if (this.negative && other.negative) {
            IntegerArray temp_arr = copyIntArr(this);
            IntegerArray temp_arr2 = copyIntArr(other);
            temp_arr.negative = false;
            temp_arr2.negative = false;
            return temp_arr2.substract(temp_arr);
        }

        else {
            for (int i = length-1; i >= 0; i--) {
                if (other_length > 0 && this_length > 0){
                    tmp.digits[i] = this.digits[--this_length] - other.digits[--other_length];
                }
                else if (other_length == 0 && this_length > 0) {
                    tmp.digits[i] = this.digits[--this_length];
                }
                else if (other_length > 0 && this_length == 0) {
                    tmp.digits[i] = -other.digits[--other_length];
                }           
            }

            // negative test
            for (int i = 0; i < length-1; i++) {
                if (tmp.digits[i] != 0 && tmp.digits[i] > 0) {
                    break;
                }
                if (tmp.digits[i] == 0 && tmp.digits[i+1] < 0) {
                    tmp.negative = true;
                    break;
                }
                else if (tmp.digits[0] < 0){
                    tmp.negative = true;
                    break;
                }

            }
            if (this.compareTo(other) < 0)
                negativity = false;
            else 
                negativity = true;

            if (tmp.negative) {
                int total = 0;
                int power = 0;
                for (int i = length-1; i >= 0; i--) {
                    total += tmp.digits[i] * Math.pow(10, power++);
                }
                IntegerArray tmp2 = new IntegerArray(String.valueOf(-total));
                if (negativity) {
                    tmp2.negative = true;
                }
                tmp2.negative = true;
                return tmp2;
            }

            

            for (int i = length-1; i >= 0; i--) {
                if (tmp.digits[i] < 0) {
                    tmp.digits[i] += 10;
                    tmp.digits[i-1] -= 1;
                }
            }

            if (tmp.digits[0] != 0)
                return tmp;
            else {
                int zero_counter = 0;
                for (int i = 0; i < tmp.digits.length; i++) {
                    if (tmp.digits[i] == 0) {
                        zero_counter++;
                    }
                    else {
                        break;
                    }
                }
                IntegerArray tmp2 = new IntegerArray("0".repeat(tmp.digits.length-zero_counter));
                if (negativity) {
                    tmp2.negative =true;
                }
                for (int i = 0; i < tmp2.digits.length; i++) {
                    tmp2.digits[i] = tmp.digits[zero_counter++];
                }      
                return tmp2;
            }
        }
    }

    @Override
    public int compareTo(Object o) {
        IntegerArray other = (IntegerArray) o;
        if (this.equals(other))
            return 0;
        if (this.numberOfDigits() == other.numberOfDigits()) {
            for (int i = 0; i < numberOfDigits(); i++) {
                if (this.digits[i] > other.digits[i]){
                    return 1;
                }
                else if (this.digits[i] < other.digits[1]){
                    return -1;
                }
            }
        }
        if (this.numberOfDigits() > other.numberOfDigits()) 
            return 1;
        return -1;
    }

    public boolean equals(Object o) {
        IntegerArray other = (IntegerArray) o;
        boolean breaker = false;

        if (this.numberOfDigits() != other.numberOfDigits())
            return false;

        for (int i = 0; i < this.numberOfDigits(); i++) {
            if (this.digits[i] == other.digits[i])
                breaker = true;
            else {
                breaker = false;
                return breaker;
            }
        }
        return breaker;
    }

    public IntegerArray copyIntArr(IntegerArray main) {
        String result = "";

        for (int i = 0; i < main.numberOfDigits(); i++) {
            result += main.digits[i];
        }
        IntegerArray tmp = new IntegerArray(result);
        tmp.negative = main.negative;
        return tmp;
    }


    
    



    


     
    
}