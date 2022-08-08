import java.net.URL;
public class Library {

    public static void main(String[] args) throws Exception {
        var d = new URL("https://medium.com");
var f = d.openConnection();
var h = f.getInputStream();
h.close();
    }
}
