/**
 * Demonstrasi Exception Handling
 * @author luqmanaru
 */
public class ExceptionDemo {
    
    // Custom Exception
    static class CustomException extends Exception {
        public CustomException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        System.out.println("Contoh ArithmeticException:");
        try {
            int result = 10 / 0;
            System.out.println("Hasil: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nContoh ArrayIndexOutOfBoundsException:");
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index 5 out of bounds for length 3");
        }

        System.out.println("\nContoh CustomException:");
        try {
            checkValue(-5);
        } catch (CustomException e) {
            System.out.println("Error Custom: " + e.getMessage());
        }

        // Try-with-resources
        System.out.println("\nContoh TryWithResources:");
        try (MyResource resource = new MyResource()) {
            resource.doSomething();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void checkValue(int value) throws CustomException {
        if (value < 0) {
            throw new CustomException("Nilai tidak valid");
        }
    }

    static class MyResource implements AutoCloseable {
        void doSomething() {
            System.out.println("Menggunakan resource...");
        }
        
        @Override
        public void close() throws Exception {
            System.out.println("Resource ditutup");
        }
    }
}
