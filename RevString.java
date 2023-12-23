public class RevString {
    public static void main(String[] args) {
        String str = "Geeks", output = "";
        char ch;

        System.out.print("Original word: ");
        System.out.println("Geeks"); // Example word

        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i); // extracts each character
            output = ch + output; // adds each character in front of the existing string
        }
        System.out.println("Reversed word: " + output);
    }
}
