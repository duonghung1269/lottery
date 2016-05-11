
import com.lottery.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SGSCDHDX
 */
public class Test {
    
    @Autowired
    private BuyerService buyerService;
    
    public static void main(String... args) {
        System.out.print(new Test().buyerService);
        System.out.print("hahaa");
    }
}
