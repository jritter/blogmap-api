package io.riju;

import org.jboss.logging.Logger;


public class TestService {

    private static final Logger LOG = Logger.getLogger(TestService.class);

    public void doSomething(){

        LOG.info("doSomething()");
        try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}