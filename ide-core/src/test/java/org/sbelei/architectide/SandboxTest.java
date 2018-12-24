package org.sbelei.architectide;


public class SandboxTest {

    @org.junit.jupiter.api.Test
    public void testName() throws Exception {
//        System.getenv().put("FOO", "BAR");
        System.out.println( System.getenv("RDM_ENV") );
        System.out.println( System.getProperty("RDM_ENV") );
        System.out.println( System.getenv().get("RDM_ENV") );
    }
}
