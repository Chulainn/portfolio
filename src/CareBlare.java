public class CareBlare
{
  public CareBlare (boolean isFail)
  {
    if (isFail) {
      System.out.println ("Lol Blare is fail.  :P");
    }
  }
  
  public static void main (String[] args) {
    CareBlare failBlare = new CareBlare (true);
  }
}