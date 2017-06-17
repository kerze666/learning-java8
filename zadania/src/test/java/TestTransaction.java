import model.Person;
import model.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Bartek on 17.06.2017.
 */

public class TestTransaction {

    private Person majka = new Person("Majka", "Zagajka", LocalDate.of(1996, 05, 11));
    private Person tomek = new Person("Tomasz", "Zagajkowski", LocalDate.of(1980, 05, 11));
    private Person romek = new Person("Romek", "Zagajka", LocalDate.of(1996, 01, 1));
    private Person anna = new Person("Anna", "Kowalska", LocalDate.of(1940, 04, 13));

    List<Transaction> transactions;

    TransactionService transactionService;

    @Before
    public void prepareSetup() {
        transactionService = new TransactionService();
        transactions = new LinkedList<>(Arrays.asList(
                new Transaction(majka, BigDecimal.valueOf(20.30), LocalDate.now().minusMonths(1)),
                new Transaction(majka, BigDecimal.valueOf(400.00), LocalDate.now().minusMonths(2)),
                new Transaction(tomek, BigDecimal.valueOf(201.32), LocalDate.now().minusDays(1)),
                new Transaction(tomek, BigDecimal.valueOf(300.30)),
                new Transaction(tomek, BigDecimal.valueOf(3320.30)),
                new Transaction(romek, BigDecimal.valueOf(322.30)),
                new Transaction(romek, BigDecimal.valueOf(321.40), LocalDate.now().minusWeeks(3)),
                new Transaction(romek, BigDecimal.valueOf(327.10)),
                new Transaction(anna, BigDecimal.valueOf(2.30)),
                new Transaction(anna, BigDecimal.valueOf(24.30)),
                new Transaction(anna, BigDecimal.valueOf(5000.30)),
                new Transaction(anna, BigDecimal.valueOf(12.30))
        ));
        transactionService.setTransactions(transactions);
    }

    @Test
    public void countAllMajkaTransations() {
        int countOfTranstaions = transactions.stream()
                .filter(transaction -> transaction.getPerson().getName().equals("Majka"))
                .mapToInt(value -> 1)
                .sum();
        Assert.assertEquals(2, countOfTranstaions);
    }

    @Test
    public void findTheHighestTransationAmount() {
        Optional<BigDecimal> max = transactions.stream()
                .map(transaction -> transaction.getAmount())
                .max((o1, o2) -> o1.compareTo(o2));

        Assert.assertEquals(BigDecimal.valueOf(5000.3), max.get());
    }

    @Test
    public void findPersonWithTheTransations() {
        Map<Person, List<Transaction>> map = transactions.stream().collect(Collectors.groupingBy(Transaction::getPerson));

        Assert.assertTrue(map.keySet().containsAll(Arrays.asList(majka, tomek, romek, anna)));
    }

    @Test
    public void sumAllMajkaTransacionsAmount() {
        BigDecimal sumOfAmount = transactions.stream().filter(trans -> trans.getPerson().equals(majka))
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, (bigDecimal1, bigDecimal2) -> bigDecimal1.add(bigDecimal2));

        Assert.assertEquals(BigDecimal.valueOf(420.30), sumOfAmount);
    }

    @Test
    public void findPersonWithHighestAmount() {
        Optional<Transaction> collect = transactions.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Transaction::getAmount)));

        Assert.assertEquals(BigDecimal.valueOf(5000.30), collect.get().getAmount());
    }

    @Test
    public void findTransationsWithAmountHighterThan300(){
        List<Transaction> amountHigherThen300 = transactionService.findTransactionsBy(t -> t.getAmount().compareTo(BigDecimal.valueOf(300)) == 1);
        Assert.assertEquals(7,amountHigherThen300.size());
    }
}
