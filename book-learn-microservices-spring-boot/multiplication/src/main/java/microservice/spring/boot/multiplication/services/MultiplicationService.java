package microservice.spring.boot.multiplication.services;

import microservice.spring.boot.multiplication.domains.Multiplication;

public interface MultiplicationService {
    Multiplication createRandom();
}
