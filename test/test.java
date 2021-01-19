public class test {
	public static void main(String[] args) {
		System.out.println(wow("pacman", 2));
	}
public static String wow(String s, int pos) {
   if (pos > s.length()) {
      return s.substring(0, s.length() / 2);
   } else {
      // substring(int index) is inclusive to end
      return s + wow(s.substring(pos), pos + 1);
   }
}
}
