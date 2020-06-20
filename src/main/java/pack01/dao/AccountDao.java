package pack01.dao;

import pack01.bean.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();

    void save(Account account);

    void deleteById(long l);
}
