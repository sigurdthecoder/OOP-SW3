package dialog;

import org.junit.jupiter.api.Test;
import java.io.*;

import payment.MobilePayment;
import payment.PaymentStrategy;
import vendingmachines.HotFoodVendingMachine;


import static org.junit.jupiter.api.Assertions.*;

public class HotFoodVendingMachineDialogTest {

    @Test
    public void ReturnsMobilePaymentWhenAnswerIsThree () {
        InputStream originalSystemIn = System.in;
        try {
            ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
            System.setIn(in);

            HotFoodVendingMachine hotFoodVendingMachine = new HotFoodVendingMachine();

            PaymentStrategy chosenPaymentMethod = hotFoodVendingMachine.getVendingMachineDialog().chooseMethodOfPayment();
            MobilePayment mobilePayment = new MobilePayment();

            assertEquals(mobilePayment.getClass(), chosenPaymentMethod.getClass());

        } finally {
            System.setIn(originalSystemIn);
        }
    }
}