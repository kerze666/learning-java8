import model.Transaction;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Bartek on 17.06.2017.
 */
public class TransactionService {

    private List<Transaction> transactions;

    public TransactionService() {
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transaction> findTransactionsBy(Predicate<Transaction> function){
        return transactions.stream().filter(function).collect(Collectors.toList());
    }
}
