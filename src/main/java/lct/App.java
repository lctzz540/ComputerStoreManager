package lct;
/**
 * Main
 */
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import lct.store.models.Keyboard;
import lct.store.models.Laptop;
import lct.store.services.Services;

public class App {
    /**
     * @param args
     */
    public static void main(String[] args) {
        LinkedList<Laptop> laptopList = new LinkedList<Laptop>();
        LinkedList<Keyboard> keyboardList = new LinkedList<Keyboard>();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("./example_data.json"));
            JSONArray jsonArray = (JSONArray) obj;
            final Iterator iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                JSONObject jsonObject = (JSONObject) iterator.next();
                String kind = (String) jsonObject.get("kind");
                if (kind.compareTo("Laptop") == 0) {
                    laptopList.add(new Laptop(
                            (String) jsonObject.get("Model"),
                            (String) jsonObject.get("BrandName"),
                            (String) jsonObject.get("CPU"),
                            (String) jsonObject.get("RAM"),
                            (String) jsonObject.get("ROM"),
                            (String) jsonObject.get("VGA"),
                            (String) jsonObject.get("MONITOR_SIZE"),
                            (String) jsonObject.get("MONITOR_RESOLUTION"),
                            (Long) jsonObject.get("price"),
                            (Long) jsonObject.get("amount")));
                }
                if (kind.compareTo("Keyboard") == 0){
                    keyboardList.add(new Keyboard(
                        (String) jsonObject.get("Model"),
                        (String) jsonObject.get("BrandName"),
                        (Long) jsonObject.get("Type"),
                        (String) jsonObject.get("Switch"),
                        (String) jsonObject.get("Keycap"),
                        (Boolean) jsonObject.get("Hotswap"),
                        (Long) jsonObject.get("amount"),
                        (Long) jsonObject.get("price")
                    ));                 
                }
            }
            System.out.print("Already added " + laptopList.size() + " Laptop\n");
            System.out.print("Already added " + keyboardList.size() + " KeyBoard\n");
            Services.showMenuServices(laptopList, keyboardList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
