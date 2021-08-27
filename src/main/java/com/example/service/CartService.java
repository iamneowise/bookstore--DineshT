import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.service.ProductService;

@Service
public class CartService{

    @Autowired
	public CartRepository cartRepo;

    @Autowired
	public ProductService productService;

    List<CartModel> findByUserId(String userId){
        return cartRepo.findByUserId(userId);
    }
    public String addToCart(CartModel cart) {
        String message="Product not added into cart";
		 if(checkQty){
         message=cartRepo.save(product) != null?"Product added to cart":message;
         }else{
             message="insufficient stock";
         }

         return message;
	}

    public boolean checkQty(String pName,String quantity){
        ProductModel product=productService.getProductByName(pName);
        int qty=nterger.valueOf(product.quantity);
        int cartQty=Interger.valueOf(quantity);
        if(cartQty>qty){
            return false;
        }else{
            return true;
        }
    }

    public boolean deleteCart(String id) {
		try {
			cartRepo.deleteById(id);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
     public boolean deleteCartAll() {
         //if we need to delete for specific user need to pass user id here to fetch cart data of the user
		try {
            List<CartModel> carts=cartRepo.findAll();
 			cartRepo.deleteAll(carts);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
}