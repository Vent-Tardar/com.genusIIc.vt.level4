package com.genusIIc.vt;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ComparisonDocTest {
    ClassLoader classLoader = getClass().getClassLoader();

    @Test
    public void pathTest() throws NullPointerException{
        Throwable thrown = assertThrows(NullPointerException.class, () -> {
            File test_file_1 = new File(classLoader.getResource("test3.txt").getFile());
            String absolutePath_1 = test_file_1.getAbsolutePath();
            File test_file_2 = new File(classLoader.getResource("test2.txt").getFile());
            String absolutePath_2 = test_file_2.getAbsolutePath();
        });
        assertNull(thrown.getMessage());
    }

    @Test
    public void filecomparisonTest() throws Exception {
        File test_file_1 = new File(classLoader.getResource("test1.txt").getFile());
        String absolutePath_1 = test_file_1.getAbsolutePath();
        File test_file_2 = new File(classLoader.getResource("test1.txt").getFile());
        String absolutePath_2 = test_file_2.getAbsolutePath();
        try{
            if (!(absolutePath_1.equals(absolutePath_2))){
                fail("Expected IOException");
            }
        }catch (Exception e) {
            assertNotEquals("", e.getMessage());
        }
    }

   @Test
    void compareTest(){
       File test_file_1 = new File(classLoader.getResource("test1.txt").getFile());
       String absolutePath_1 = test_file_1.getAbsolutePath();
       File test_file_2 = new File(classLoader.getResource("test2.txt").getFile());
       String absolutePath_2 = test_file_2.getAbsolutePath();
       ComparisonDoc cd = new ComparisonDoc();
       List lst = new ArrayList();
       lst = cd.compare(absolutePath_1, absolutePath_2);
       assertEquals(8, lst.size());
   }
}
