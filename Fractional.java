public class Fractional {
    public final long nominator;
    public final long denominator;
    public static final String NotANumber = "Not a Number";
    public static final String PositiveInfinity = "+Infinity";
    public static final String NegativeInfinity = "-Infinity";

    Fractional(long nominator, long denominator) {
        // student code
        this.nominator = (long) nominator;
        this.denominator = (long) denominator;
    }

    Fractional simplify() {
        // student code
        long gcd = getGcd();
        return new Fractional(this.nominator / gcd, this.denominator / gcd);


    }
    // My method for GCD
    public long getGcd() {
        if( nominator == 0 || denominator == 0) return 1;

        long a;
        long b;
        long gcd;
        if (Math.abs(this.nominator) > Math.abs(this.denominator)) {
            a = Math.abs(this.nominator);
            b = Math.abs(this.denominator);
        } else {
            a = Math.abs(this.denominator);
            b = Math.abs(this.nominator);
        }

        if (a%b == 0) {
            gcd =  b;
            return gcd;
        } else {
            gcd = new Fractional(b, a%b).getGcd();
            return gcd;
        }

    }


    // Not a Number (NaN)
    boolean isNaN() {
        // student code
        if(nominator == 0 && denominator == 0){
            return true;
        }else{
            return false;
        }
    }

    boolean isInfinity() {
        // student code
        if(nominator != 0 && denominator == 0 ){
            return true;
        }else{
            return false;
        }
    }

    static int sign(long nominator, long denominator) throws ArithmeticException{
        // student code
        //0 means positive
        //1 means negative
        if(nominator == 0 && denominator == 0){
            throw new ArithmeticException();
        }
        if(nominator == 0){
            if(denominator > 0) return 0;
            else return 1;
        }
        if( denominator == 0){
            if(nominator > 0 ) return 0;
            else return 1;
        }
        if((nominator > 0 && denominator > 0) || (nominator < 0 && denominator < 0)) return 0;
        else return 1;
    }

    int sign() throws ArithmeticException{
        // student code
        //0 means positive
        //1 means negative
        if(isNaN()){
            throw new ArithmeticException("0/0 does not have a sign");
        }
        if(nominator == 0){
            if(denominator > 0) return 0;
            else return 1;
        }
        if( denominator == 0){
            if(nominator > 0 ) return 0;
            else return 1;
        }
        if((nominator > 0 && denominator > 0) || (nominator < 0 && denominator < 0)) return 0;
        else return 1;
    }

    double getValue() {
        return (double) nominator / denominator;
    }

    @Override
    public boolean equals(Object obj) {
        // student code
        if(obj instanceof Fractional){
            if(((Fractional) obj).getValue() == this.getValue()){
                return true;
            }
            else return false;
        }
        else if (obj instanceof Integer){
            if (((Integer)obj).doubleValue() == this.getValue()){
                return true;
            }
            else return false;
        }
        else if(obj instanceof Double){
            if(((Double) obj).doubleValue() == this.getValue()){
                return true;
            }
            else return false;
        }
        else return false;
    }

    @Override
    public String toString(){
        // student code
        if(isNaN()) return NotANumber;
        if(isInfinity()){
            int sign;
            try {
                sign = sign();
                if (sign == 0) return PositiveInfinity;
                else return NegativeInfinity;
            }catch (Exception e){}
        }
        if(denominator ==1) return ""+nominator;
        if(nominator == 0) return "0";
        return this.nominator + "/" + this.denominator;
    }
}
