package test;

import FridgeObjects.Meat;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testFoodEntry {
    private Meat meat;

    @Test
    public void testGetName() throws IOException {
        Meat meat = new Meat("1");
        assertEquals("1", meat.getName());
    }

    @Test
    public void testSetExpiry() {
        Scanner sc = new Scanner(System.in);
        System.out.println("set expiry date, yyyyMMdd: ");
        String expiry = sc.nextLine();
        meat.manualSetExpiry(expiry);

        assertEquals(meat.getExpiryDate(), expiry);
    }

//    @Test
//    public void testGetExpiryDate(){
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        String today = sdf.format(date);
//
//        assertEquals(meat.getExpiryDate(), today);
//    }
}