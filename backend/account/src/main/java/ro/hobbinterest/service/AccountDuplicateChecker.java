package ro.hobbinterest.service;

@FunctionalInterface
public interface AccountDuplicateChecker<T,S> {

    boolean checkDuplicate(T uniqueValue, S entityId);

}
