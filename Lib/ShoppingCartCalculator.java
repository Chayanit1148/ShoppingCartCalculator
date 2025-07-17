
import java.util.ArrayList;

public class ShoppingCartCalculator {

 
    public static double calculateTotalPrice(ArrayList<CartItem> items) {
        if(items == null||items.isEmpty()){
            return 0.0;
        }
        float sumPrice = 0;
        for (CartItem item : items) {
            if(item.price() < 0||item.quantity() < 0){ //ถ้าพบว่ามันน้อยกว่า 0
                return 0.0;
            }

            if(item.sku().equals("NORMAL")){
               sumPrice += item.price() * item.quantity();
            }
            else if(item.sku().equals("BOGO")){
                sumPrice += ((int)item.quantity()/2 + (int)item.quantity()%2) * item.price();
            }
            else if(item.sku().equals("BULK")){
                if(item.quantity() >= 6){
                    sumPrice += item.price() * item.quantity() * 0.9;
                }
                else sumPrice += item.price() * item.quantity();
            }
            else {return 0.0;} //ถ้าไม่ใช่ skuที่มีอยู่ให้
        }
        return sumPrice;
    }
}
