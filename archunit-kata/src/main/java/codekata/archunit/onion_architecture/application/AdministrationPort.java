package codekata.archunit.onion_architecture.application;

public interface AdministrationPort {
    <T> T getInstanceOf(Class<T> type);
}
