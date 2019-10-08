package microservice.spring.boot.multiplication.services.impls;

import microservice.spring.boot.multiplication.domains.Multiplication;
import microservice.spring.boot.multiplication.services.MultiplicationService;
import microservice.spring.boot.multiplication.services.RandomGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {

    private RandomGeneratorService randomGeneratorService;

    @Autowired
    public MultiplicationServiceImpl(RandomGeneratorService randomGeneratorService) {
        this.randomGeneratorService = randomGeneratorService;
    }

    @Override
    public Multiplication createRandom() {
        int factorA = randomGeneratorService.generateRandom();
        int factorB = randomGeneratorService.generateRandom();

        return new Multiplication(factorA, factorB);
    }
}
