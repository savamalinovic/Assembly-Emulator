package com.processor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class ALUTest {

    private ALU alu;

    @BeforeEach
    public void setUp() {
        alu = new ALU();
    }

    // Test aritmetickih operacija
    @Test
    public void testAdd() {
        assertEquals(15, alu.executeArithmetic("ADD", 10, 5));
    }

    @Test
    public void testSub() {
        assertEquals(5, alu.executeArithmetic("SUB", 10, 5));
    }

    @Test
    public void testMul() {
        assertEquals(50, alu.executeArithmetic("MUL", 10, 5));
    }

    @Test
    public void testDiv() {
        assertEquals(2, alu.executeArithmetic("DIV", 10, 5));
    }

    @Test
    public void testDivByZero() {
        assertThrows(ArithmeticException.class, () -> alu.executeArithmetic("DIV", 10, 0));
    }

    // Test logickih bitskih operacija
    @Test
    public void testAnd() {
        assertEquals(0x00, alu.executeLogic("AND", Arrays.asList("0xF0", "0x0F")));
    }

    @Test
    public void testOr() {
        assertEquals(0xFF, alu.executeLogic("OR", Arrays.asList("0xF0", "0x0F")));
    }

    @Test
    public void testNot() {
        long result = alu.executeLogic("NOT", Arrays.asList("0xF0"));
        
        assertEquals(-241, result); // ~0xF0 = 0xFFFFFFFFFFFFFF0F, to je -241
    }

    @Test
    public void testXor() {
        assertEquals(0xFF, alu.executeLogic("XOR", Arrays.asList("0xF0", "0x0F")));
    }
}
