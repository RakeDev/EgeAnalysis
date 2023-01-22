package org.example;

import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class InMemoryScanTest {
    static InMemoryScanEge inMemoryScanEge;
    static Dao dao;

    @Test
   void scanInfoShouldPass() throws FileNotFoundException {
       List<Dao> list = inMemoryScanEge.getStats();
        Assert.assertTrue(list.size()>0);
   }
   @BeforeAll
     static void init(){
        inMemoryScanEge = new InMemoryScanEge();
        dao = new Dao();
   }
   @Test
   void FindFileTestShouldThrowException(){
       RuntimeException runtimeException = Assertions.assertThrows(RuntimeException.class,()->{inMemoryScanEge.getStats();});
       Assertions.assertEquals(RuntimeException.class,runtimeException.getClass());
   }
}
