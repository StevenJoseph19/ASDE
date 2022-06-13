package concurrency.issues;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DispatchTxPromoWorkerTransactions {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);

        SynchronizedBankAccount account = new SynchronizedBankAccount(450);
        // Retrieve TxPromoWorker instances

        TxWorker[] workers = {new TxPromoWorker(account, 'd', 150), new TxPromoWorker(account, 'w', 300),};
        for (TxWorker worker : workers)
            es.submit(worker);

        // Shutdown es and wait
        try {
            es.shutdown();
            es.awaitTermination(60, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
