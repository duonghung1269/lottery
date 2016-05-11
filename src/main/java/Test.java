
import com.lottery.gui.MainLotteryForm;
import com.lottery.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
//        this is not under spring context
        String[] contextPaths = new String[]{"/applicationContext.xml"};
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(contextPaths);

        System.out.println(1);

        BuyerService bs = ctx.getBean(BuyerService.class);

        //now you get the injecttion here
        // thanks boss, tmr need your help to explain me :'(
        //ok
        System.out.println(1);
        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new MainLotteryForm().setVisible(true);
//            }
//        });
    }
}
