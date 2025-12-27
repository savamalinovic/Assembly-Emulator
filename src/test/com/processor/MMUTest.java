package com.processor;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MMUTest {

    private MMU mmu;

    @BeforeEach
    void setUp() {
        mmu = new MMU();  
        mmu.getPageTable().clear();  
    }

    @Test
    void testPutLongInAddress() {
        String address = "0x0000000000001000";
        long valueToWrite = 1234567890123456789L; 

        mmu.putLongInAddress(address, valueToWrite);

        long result = mmu.getLongFromAddress(address);

        assertEquals(valueToWrite, result, "The value read from memory should be the same as the written value.");
    }

    @Test
    void testPutLongInAddressNewPage() {
        String address = "0x0000000000002000"; 
        long valueToWrite = 987654321012345678L; 

        mmu.putLongInAddress(address, valueToWrite);

        long result = mmu.getLongFromAddress(address);

        assertEquals(valueToWrite, result, "The value read from memory should be the same as the written value.");
    }
}
