@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    
    @Query("SELECT t FROM Transaction t WHERE t.customerId = :customerId AND MONTH(t.transactionDate) = :month")
    List<Transaction> findByCustomerIdAndMonth(@Param("customerId") int customerId, @Param("month") int month);
    
}
