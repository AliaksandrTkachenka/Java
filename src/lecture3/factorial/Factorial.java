package lecture3.factorial;

public class Factorial {
    int count(int n) {
        if(n == 0 || n == 1){
            return 1;
        }
        else if (n < 0){
            System.out.println("Incorrect input");
            return 0;
        }
        int result;
        result = count(n - 1) * n;
        return result;
    }
}
