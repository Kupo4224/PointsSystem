@Service
public class TransactionService {
    
    @Autowired
    private TransactionRepository transactionRepository;
    
    public int calculateRewardsPoints(int customerId, int month) {
        List<Transaction> transactions = transactionRepository.findByCustomerIdAndMonth(customerId, month);
        
        int rewardsPoints = 0;
        for ( Transaction transaction : transactions ) {
            double transactionAmount = transaction.getTransactionAmount();
              
              
            if ( transactionAmount > 100.0 ) {
                rewardsPoints += (int) (( transactionAmount - 100.0) * 2 + 50);
            } else if ( transactionAmount >= 50.0 && transactionAmount <= 100.0 ) {
                rewardsPoints += ( int ) ( transactionAmount - 50.0 );
            }
        }
        
        return rewardsPoints;
    }
}
