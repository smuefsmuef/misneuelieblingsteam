package ip12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SetupTest {
    @Test
    public void testSetup(){
        //given
        int a = 1;
        int b = 1;

        //when
        int sum = a + b;

        //then
        assertEquals(2, sum);
    }
}
