package dialog;

import org.junit.jupiter.api.Test;
import payment.CreditCardPayment;
import payment.PaymentStrategy;
import vendingmachines.MedicalVendingMachine;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class MedicalVendingMachineDialogTest {

    @Test
    public void returnsCreditCardPaymentWhenAnswerIsOne() {

        InputStream originalSystemIn = System.in;
        try {
            ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
            System.setIn(in);

            MedicalVendingMachine medicalVendingMachine = new MedicalVendingMachine();

            PaymentStrategy chosenPaymentMethod = medicalVendingMachine.getVendingMachineDialog().chooseMethodOfPayment();
            CreditCardPayment creditCardPayment = new CreditCardPayment();

            assertEquals(creditCardPayment.getClass(), chosenPaymentMethod.getClass());
        } finally {
            System.setIn(originalSystemIn);
        }
    }
}
