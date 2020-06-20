package pack01.dao;

import pack01.bean.Account;

import java.util.List;
import java.util.Map;

public interface AccountDao {
    List<Account> findAll();

    void save(Account account);

    void deleteById(long l);

    void update(Account account);

    void search(Map<String, Object> map);

    void deleteByIds(List<Long> ids);
}
