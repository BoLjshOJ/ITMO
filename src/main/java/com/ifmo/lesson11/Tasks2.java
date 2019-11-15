package com.ifmo.lesson11;

import com.ifmo.lesson11.inner.Message;
import com.ifmo.lesson11.inner.MessageGenerator;
import com.ifmo.lesson11.inner.MessagePriority;
import com.ifmo.lesson11.inner.User;

import java.util.*;

import static com.ifmo.lesson11.inner.UserGenerator.generate;

/**
 * Created by xmitya on 20.10.16.
 */
public class Tasks2 {
    public static void main(String[] args) {
        MessageGenerator generator = new MessageGenerator();

        List<Message> messages = generator.generate(10);
        List<User> users = generate(10);
        System.out.println(users);
        System.out.println("======");
        System.out.println(sortedByCompanyAndName(users));
    }

    private static void sortByPriority(List<Message> messages, MessagePriority priority) {
        messages.sort(Comparator.comparing(Message::getPriority));
    }

    private static NavigableSet<User> sortedByCompanyAndName(List<User> users) {
        Collections.sort(users, Comparator.comparing(o -> (o.getCompany() + o.getName())));
        return new TreeSet<>(users);
    }

    private static NavigableSet<User> sortedBySalaryAndName(List<User> users) {

        return Collections.emptyNavigableSet();
    }

    private static NavigableSet<User> sortedBySalaryAgeCompanyAndName(List<User> users) {

        return Collections.emptyNavigableSet();
    }

    private static <T> Iterator<T> viewIterator(Iterable<T> it1, Iterable<T> it2) {

        return null;
    }


}
