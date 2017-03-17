package com.apea.training.ecourse.homework4.task22;

import org.junit.Assert;
import org.junit.Test;

public class ObserverPatternTest {

    private PostDepartment department = new PostDepartment();
    private Publisher publisher1 = Publisher.createPublisher("AAA", department);
    private Subscriber[] subscribers1 = new Subscriber[]{
            Subscriber.createSubscriber(publisher1),
            Subscriber.createSubscriber(publisher1)
    };
    private Publisher publisher2 = Publisher.createPublisher("BBB", department);
    private Subscriber[] subscribers2 = new Subscriber[]{
            Subscriber.createSubscriber(publisher2),
            Subscriber.createSubscriber(publisher2)
    };
    private Magazine[] magazines1 = new Magazine[2];
    private Magazine[] magazines2 = new Magazine[2];

    public ObserverPatternTest() {
        publisher1.register(subscribers1[0]);
        publisher1.register(subscribers1[1]);
        publisher2.register(subscribers2[0]);
        publisher2.register(subscribers2[1]);
        publisher1.sendFreshMagazine();
        publisher2.sendFreshMagazine();

        magazines1[0] = subscribers1[0].getMyMagazine();
        magazines1[1] = subscribers1[1].getMyMagazine();

        magazines2[0] = subscribers2[0].getMyMagazine();
        magazines2[1] = subscribers2[1].getMyMagazine();
    }

    @Test
    public void sameMagazinesTest() {
        Assert.assertSame(magazines1[0], magazines1[1]);
        Assert.assertSame(magazines2[0], magazines2[1]);
    }

    @Test
    public void samePublisherTest() {
        Assert.assertTrue(magazines1[0].getName().startsWith(publisher1.getLogo()));
        Assert.assertTrue(magazines2[0].getName().startsWith(publisher2.getLogo()));
    }
}
