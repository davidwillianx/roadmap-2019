package microservice.spring.boot.multiplication.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class Multiplication {

    private int factorA;
    private  int factorB;

    private int result;

    public Multiplication(int factorA, int factorB) {
        this.factorA = factorA;
        this.factorB = factorB;
        this.result = this.factorA * this.factorB;
    }
}
